package com.kwpugh.easy_steel;

import com.kwpugh.easy_steel.lists.ItemList;

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
		return new ItemStack(ItemList.steel_ingot);
	}	
}
