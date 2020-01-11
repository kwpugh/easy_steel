package com.kwpugh.easy_steel.items.powders;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class Carbon extends Item
{	
	private int burnTime;
	
	public Carbon(Properties p_i48487_1_, String name, int burnTime)
	{
	    super(p_i48487_1_);
	    this.setRegistryName(name);
	    this.burnTime = 600;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
	    return this.burnTime;
	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Used for crafting and also a fuel"));
		list.add(new StringTextComponent(TextFormatting.YELLOW + "Burntime: 600"));
	} 
}