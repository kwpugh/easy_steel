package com.kwpugh.easy_steel.items.misc;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class SharpFlint extends Item
{
	public SharpFlint(Properties properties)
	{
		super(properties);
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslatableComponent("item.easy_steel.sharp_flint.line1").withStyle(ChatFormatting.GREEN)));
		tooltip.add((new TranslatableComponent("item.easy_steel.sharp_flint.line2").withStyle(ChatFormatting.AQUA)));
	}
}
