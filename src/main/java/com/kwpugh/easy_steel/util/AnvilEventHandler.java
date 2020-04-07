package com.kwpugh.easy_steel.util;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = EasySteel.modid, bus = EventBusSubscriber.Bus.FORGE )
public class AnvilEventHandler
{
	@SubscribeEvent
	public static void upgradeSomeTools(AnvilUpdateEvent event)
	{
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		
		if(left.isEmpty() || right.isEmpty())
		{
			return;
		}

		if(left.getItem().equals(ItemInit.TUNGSTEN_CARBIDE_PICKAXE.get()) && right.getItem().equals(Items.EMERALD))
		{			
			ItemStack output = new ItemStack(ItemInit.TUNGSTEN_CARBIDE_PICKAXE.get());
			output.addEnchantment(Enchantments.SILK_TOUCH, 1);
			output.addEnchantment(Enchantments.EFFICIENCY, 3);
			output.setDisplayName(new StringTextComponent("Improved Tungsten-Carbide Pickaxe"));
			event.setCost(10);
			event.setOutput(output);
		}
	}
}
