package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.blocks.OreBornite;
import com.kwpugh.easy_steel.blocks.OreCassiterite;
import com.kwpugh.easy_steel.blocks.OreRutile;
import com.kwpugh.easy_steel.blocks.OreWolframite;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EasySteel.modid);
	
	public static final RegistryObject<Block> BORNITE_ORE = BLOCKS.register("bornite_ore", () -> new OreBornite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CASSITERITE_ORE = BLOCKS.register("cassiterite_ore", () -> new OreCassiterite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> WOLFRAMITE_ORE = BLOCKS.register("wolframite_ore", () -> new OreWolframite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> RUTILE_ORE = BLOCKS.register("rutile_ore", () -> new OreRutile(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HARDENED_STEEL_BLOCK = BLOCKS.register("hardened_steel_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> TUNGSTEN_CARBIDE_BLOCK = BLOCKS.register("tungsten_carbide_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)));
	

	
	
//	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//	public static class RegistryEvents
//	{
//		@SubscribeEvent
//		public static void registerBlocks(final RegistryEvent.Register<Block> event)
//		{
//			event.getRegistry().registerAll
//			(
//				BlockList.bornite_ore = new OreBornite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("bornite_ore")),
//				BlockList.cassiterite_ore = new OreCassiterite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("cassiterite_ore")),
//				BlockList.wolframite_ore = new OreWolframite(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("wolframite_ore")),
//				BlockList.rutile_ore = new OreRutile(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("rutile_ore")),
//				
//				BlockList.bronze_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("bronze_block")),
//				BlockList.steel_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
//				BlockList.titanium_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("titanium_block")),
//				BlockList.hardened_steel_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("hardened_steel_block")),
//				BlockList.tungsten_carbide_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("tungsten_carbide_block"))
//				
//			);
//			EasySteel.logger.info("Easy Steel blocks registered.");			
//		}
//	}
//	
//	private static ResourceLocation location(String name)
//	{
//		return new ResourceLocation(EasySteel.modid, name);
//	}	
}
