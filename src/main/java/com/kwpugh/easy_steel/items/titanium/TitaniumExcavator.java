package com.kwpugh.easy_steel.items.titanium;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.items.toolclasses.ExcavatorBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class TitaniumExcavator extends ExcavatorBase
{
	public TitaniumExcavator(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.TITANIUM_INGOT.get();
	}
}

