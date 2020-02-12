package com.kwpugh.easy_steel.group;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupEasySteel extends ItemGroup
{
	public GroupEasySteel() 
	{
		super("easy_steel");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemInit.STEEL_INGOT.get());
	}	
}
