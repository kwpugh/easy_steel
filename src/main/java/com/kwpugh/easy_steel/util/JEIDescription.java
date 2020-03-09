package com.kwpugh.easy_steel.util;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.init.ItemInit;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIDescription implements IModPlugin
{
	static ResourceLocation plugin = new ResourceLocation(EasySteel.modid, "plugin");

	@Override
	public ResourceLocation getPluginUid()
	{
		return plugin;
	}

	@Override
	public void registerRecipes(IRecipeRegistration registry)
	{
		registry.addIngredientInfo(new ItemStack(ItemInit.CRACK_HAMMER.get()), VanillaTypes.ITEM, 
				"item.easy_steel.crack_hammer.jei.line1",
				" ",
				"item.easy_steel.crack_hammer.jei.line2");

		registry.addIngredientInfo(new ItemStack(ItemInit.HAND_SHOVEL.get()), VanillaTypes.ITEM, 
				" ",
				"item.easy_steel.hand_shovel.jei.line1",
				" ",
				"item.easy_steel.hand_shovel.jei.line2",
				" ",
				"item.easy_steel.hand_shovel.jei.line3");
				
		registry.addIngredientInfo(new ItemStack(ItemInit.SHARP_FLINT.get()), VanillaTypes.ITEM, 
				"item.easy_steel.sharp_flint.jei.line1",
				" ",
				"item.easy_steel.sharp_flint.jei.line2",
				" ",
				"item.easy_steel.sharp_flint.jei.line3");
	}
}
