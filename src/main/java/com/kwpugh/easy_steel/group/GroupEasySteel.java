package com.kwpugh.easy_steel.group;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GroupEasySteel extends CreativeModeTab
{
	public GroupEasySteel() 
	{
		super("easy_steel");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return new ItemStack(ItemInit.STEEL_INGOT.get());
	}	
}
