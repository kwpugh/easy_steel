package com.kwpugh.easy_steel.items.powders;

import java.util.List;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class Carbon extends Item
{	
	private int burnTime;
	
	public Carbon(Properties settings)
	{
	    super(settings);
	    this.burnTime = 600;
	}

	@Override
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
	{
		return this.burnTime;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);				
		list.add(new TextComponent(ChatFormatting.BLUE + "Used for crafting and also a fuel"));
		list.add(new TextComponent(ChatFormatting.YELLOW + "Burntime: 600"));
	} 
}