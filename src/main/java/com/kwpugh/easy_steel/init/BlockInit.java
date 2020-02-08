package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.blocks.OreBornite;
import com.kwpugh.easy_steel.blocks.OreCassiterite;
import com.kwpugh.easy_steel.blocks.OreRutile;
import com.kwpugh.easy_steel.blocks.OreWolframite;
import com.kwpugh.easy_steel.lists.BlockList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlockInit
{
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.bornite_ore = new OreBornite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("bornite_ore")),
				BlockList.cassiterite_ore = new OreCassiterite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("cassiterite_ore")),
				BlockList.wolframite_ore = new OreWolframite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("wolframite_ore")),
				BlockList.rutile_ore = new OreRutile(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("rutile_ore")),
				
				BlockList.bronze_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("bronze_block")),
				BlockList.steel_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
				BlockList.titanium_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("titanium_block")),
				BlockList.hardened_steel_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("hardened_steel_block")),
				BlockList.tungsten_carbide_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("tungsten_carbide_block"))
				
			);
			EasySteel.logger.info("Easy Steel blocks registered.");			
		}
	}
	
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(EasySteel.modid, name);
	}	
}
