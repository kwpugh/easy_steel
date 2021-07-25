package com.kwpugh.easy_steel.items.bronze;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.items.toolclasses.ExcavatorBase;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class BronzeExcavator extends ExcavatorBase
{
	public BronzeExcavator(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
    
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.BRONZE_INGOT.get();
	}
}

