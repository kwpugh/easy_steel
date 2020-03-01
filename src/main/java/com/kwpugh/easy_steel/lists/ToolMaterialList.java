package com.kwpugh.easy_steel.lists;

import java.util.function.Supplier;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;


//   Vanilla Material Reference:
//    GOLD(0, 32, 12.0F, 0.0F, 22)
//    WOOD(0, 59, 2.0F, 0.0F, 15)
//    STONE(1, 131, 4.0F, 1.0F, 5)
//    IRON(2, 250, 6.0F, 2.0F, 14)
//    DIAMOND(3, 1561, 8.0F, 3.0F, 10)
  

//All material harvest levels are under diamond level 3
public enum ToolMaterialList implements IItemTier
{
    FLINT(1.0F, 5.5f, 145, 1, 5, () -> {
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
	
//	flint(1.0F, 5.5f, 145, 1, 5, ItemInit.SHARP_FLINT.get()),
//	bronze(0.5F, 6.5f, 225, 2, 10, ItemInit.BRONZE_INGOT.get()),
//	steel(0.5F, 6.5f, 482, 2, 8, ItemInit.STEEL_INGOT.get()),
//	titanium(0.5F, 6.5f, 625, 2, 8, ItemInit.TITANIUM_INGOT.get()),   
//	hardened_steel(0.5F, 6.5f, 816, 2, 8, ItemInit.HARDENED_STEEL_INGOT.get()),
//	tungsten_carbide(0.75F, 6.5f, 1023, 2, 8, ItemInit.TUNGSTEN_CARBIDE_INGOT.get());

	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	final LazyValue<Ingredient> repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
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
