package com.kwpugh.easy_steel.lists;

import java.util.function.Supplier;

import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;

//All material harvest levels are under diamond level 3
//Something in Forge seems to add 1 to whatever attack damage you send it
public enum ToolMaterialList implements Tier
{
	MYWOOD(0.5F, 5.5f, 145, 1, 5, () -> {
        return Ingredient.of(Items.OAK_PLANKS);
    }),
	
	FLINT(0.5F, 5.5f, 145, 1, 5, () -> {
        return Ingredient.of(ItemInit.SHARP_FLINT.get());
    }),
    
    BRONZE(0.5F, 6.5f, 225, 2, 10, () -> {
        return Ingredient.of(ItemInit.BRONZE_INGOT.get());
    }),
    
    STEEL(0.5F, 6.5f, 482, 2, 8, () -> {
        return Ingredient.of(ItemInit.STEEL_INGOT.get());
    }),
    
    TITANIUM(0.5F, 6.5f, 625, 2, 8, () -> {
        return Ingredient.of(ItemInit.TITANIUM_INGOT.get());
    }),
    
    HARDENED_STEEL(0.5F, 6.5f, 816, 2, 8, () -> {
        return Ingredient.of(ItemInit.HARDENED_STEEL_INGOT.get());
    }),
    
    TUNGSTEN_CARBIDE(0.75F, 6.5f, 1023, 2, 8, () -> {
        return Ingredient.of(ItemInit.TUNGSTEN_CARBIDE_INGOT.get());
    });

	private double attackMultiplierFromConfig = GeneralModConfig.ATTACK_DAMAGE_MODIFIER.get();
	private float attackMultiplier = (float) attackMultiplierFromConfig;

	private int durabilityMultiplierFromConfig = GeneralModConfig.DURABILITY_MODIFIER.get();
	
	private float attackDamage;
	private float efficiency;
	private int durability;
	private int harvestLevel, enchantability;
	final LazyLoadedValue<Ingredient> repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial)
	{
		this.attackDamage = attackDamage * attackMultiplier;
		this.efficiency = efficiency;
		this.durability = durability * durabilityMultiplierFromConfig;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
	}
	
	@Override
	public float getAttackDamageBonus() 
	{
		return this.attackDamage;
	}

	@Override
	public float getSpeed() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantmentValue() 
	{
		return this.enchantability;
	}

	@Override
	public int getLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getUses() 
	{
		return this.durability;
	}
	   
	@Override
	public Ingredient getRepairIngredient() 
	{
		return this.repairMaterial.get();
	}
}
