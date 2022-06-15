package com.kwpugh.easy_steel.items.powders;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

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
		list.add(Component.translatable(ChatFormatting.BLUE + "Used for crafting and also a fuel"));
		list.add(Component.translatable(ChatFormatting.YELLOW + "Burntime: 600"));
	} 
}