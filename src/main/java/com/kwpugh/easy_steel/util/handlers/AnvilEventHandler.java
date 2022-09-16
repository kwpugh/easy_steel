package com.kwpugh.easy_steel.util.handlers;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
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
			output.enchant(Enchantments.SILK_TOUCH, 1);
			output.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
			output.setHoverName(Component.translatable("Improved Tungsten-Carbide Pickaxe"));
			event.setCost(10);
			event.setOutput(output);
		}
	}
}
