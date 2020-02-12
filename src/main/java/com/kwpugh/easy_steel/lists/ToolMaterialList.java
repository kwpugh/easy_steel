package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;


//   Vanilla Material Reference:
//    GOLD(0, 32, 12.0F, 0.0F, 22)
//    WOOD(0, 59, 2.0F, 0.0F, 15)
//    STONE(1, 131, 4.0F, 1.0F, 5)
//    IRON(2, 250, 6.0F, 2.0F, 14)
//    DIAMOND(3, 1561, 8.0F, 3.0F, 10)
  

public enum ToolMaterialList implements IItemTier
{	
	flint(1.0F, 5.5f, 145, 1, 5, ItemInit.SHARP_FLINT.get()),
	bronze(0.5F, 6.5f, 225, 2, 10, ItemInit.BRONZE_INGOT.get()),
	steel(0.5F, 6.5f, 482, 3, 8, ItemInit.STEEL_INGOT.get()),
	titanium(0.5F, 6.5f, 625, 4, 8, ItemInit.TITANIUM_INGOT.get()),   
	hardened_steel(0.5F, 6.5f, 816, 4, 8, ItemInit.HARDENED_STEEL_INGOT.get()),
	tungsten_carbide(0.75F, 6.5f, 1023, 4, 8, ItemInit.TUNGSTEN_CARBIDE_INGOT.get());
	

	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
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
		return Ingredient.fromItems(this.repairMaterial);
	}
}
