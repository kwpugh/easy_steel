package com.kwpugh.easy_steel.items.hardenedsteel;

import java.util.Set;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.items.toolclasses.PaxelBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class HardenedSteelPaxel extends PaxelBase
{
	public HardenedSteelPaxel(float attackDamageIn, float attackSpeedIn, Tier tier, Set<Block> effectiveBlocksIn,
			Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder);	
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.HARDENED_STEEL_INGOT.get();
	}
}
