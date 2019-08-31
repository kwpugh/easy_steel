package com.kwpugh.easy_steel.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class FlintHoe extends HoeItem
{

	public FlintHoe(IItemTier tier, float attackSpeedIn, Properties builder)
	{
		super(tier, attackSpeedIn, builder);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.GREEN + "A primitive tool for gardening"));
	} 
}
