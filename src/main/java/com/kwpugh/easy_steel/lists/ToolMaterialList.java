package com.kwpugh.easy_steel.lists;

import java.util.function.Supplier;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.util.GeneralModConfig;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

//All material harvest levels are under diamond level 3
//Something in Forge seems to add 1 to whatever attack damage you send it
public enum ToolMaterialList implements IItemTier
{
	//Bad Iron is used only to give Crack Hammer iron durability and harvest level 0
	BAD_IRON(0.5F, 5.5f, 250, 0, 25, () -> {
        return Ingredient.fromItems(ItemInit.SHARP_FLINT.get());
    }),
	
	FLINT(0.5F, 5.5f, 145, 1, 5, () -> {
        return Ingredient.fromItems(ItemInit.SHARP_FLINT.get());
    }),
    
    BRONZE(0.5F, 6.5f, 225, 2, 10, () -> {
        return Ingredient.fromItems(ItemInit.BRONZE_INGOT.get());
    }),
    
    STEEL(0.5F, 6.5f, 482, 2, 8, () -> {
        return Ingredient.fromItems(ItemInit.STEEL_INGOT.get());
    }),
    
    TITANIUM(0.5F, 6.5f, 625, 2, 8, () -> {
        return Ingredient.fromItems(ItemInit.TITANIUM_INGOT.get());
    }),
    
    HARDENED_STEEL(0.5F, 6.5f, 816, 2, 8, () -> {
        return Ingredient.fromItems(ItemInit.HARDENED_STEEL_INGOT.get());
    }),
    
    TUNGSTEN_CARBIDE(0.75F, 6.5f, 1023, 2, 8, () -> {
        return Ingredient.fromItems(ItemInit.TUNGSTEN_CARBIDE_INGOT.get());
    });

	private double attackMultiplierFromConfig = GeneralModConfig.ATTACK_DAMAGE_MODIFIER.get();
	private float attackMultiplier = (float) attackMultiplierFromConfig;

	private int durabilityMultiplierFromConfig = GeneralModConfig.DURABILITY_MODIFIER.get();
	
	private float attackDamage;
	private float efficiency;
	private int durability;
	private int harvestLevel, enchantability;
	final LazyValue<Ingredient> repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial)
	{
		this.attackDamage = attackDamage * attackMultiplier;
		this.efficiency = efficiency;
		this.durability = durability * durabilityMultiplierFromConfig;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}
	
	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}
	   
	@Override
	public Ingredient getRepairMaterial() 
	{
		return this.repairMaterial.getValue();
	}
}
