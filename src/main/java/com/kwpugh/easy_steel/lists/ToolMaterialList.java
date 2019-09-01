package com.kwpugh.easy_steel.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;


public enum ToolMaterialList implements IItemTier
{	
	/*
	 * Durability:
	 * Wood = 59
	 * Stone = 131
	 * Iron = 250
	 * Diamond = 1561
	 * Gold = 32
	 * 
	 */
	flint(1.0F, 5.5f, 145, 1, 10, Items.FLINT),
	bronze(0.5F, 6.5f, 225, 2, 10, ItemList.bronze_ingot),
	steel(0.5F, 7.5f, 575, 3, 8, ItemList.steel_ingot),
	hardened_steel(0.5F, 7.5f, 700, 4, 8, ItemList.hardened_steel_ingot),
	tungsten_carbide(0.75F, 9.0f, 1350, 4, 8, ItemList.tungsten_carbide_ingot);
	

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
