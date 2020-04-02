package com.kwpugh.easy_steel.items.tungstencarbide;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.items.toolclasses.HammerBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class TungstenCarbideHammer extends HammerBase
{
	public TungstenCarbideHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.TUNGSTEN_CARBIDE_INGOT.get();
	}
}
