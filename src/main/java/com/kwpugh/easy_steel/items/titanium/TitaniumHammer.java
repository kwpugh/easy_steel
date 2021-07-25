package com.kwpugh.easy_steel.items.titanium;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.items.toolclasses.HammerBase;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class TitaniumHammer extends HammerBase
{
	public TitaniumHammer(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
    
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.TITANIUM_INGOT.get();
	}
}
