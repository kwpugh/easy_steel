package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.blocks.OreBornite;
import com.kwpugh.easy_steel.blocks.OreCassiterite;
import com.kwpugh.easy_steel.blocks.OreRutile;
import com.kwpugh.easy_steel.blocks.OreWolframite;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EasySteel.modid);

	public static final RegistryObject<Block> BORNITE_ORE = BLOCKS.register("bornite_ore", () -> new OreBornite(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CASSITERITE_ORE = BLOCKS.register("cassiterite_ore", () -> new OreCassiterite(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> WOLFRAMITE_ORE = BLOCKS.register("wolframite_ore", () -> new OreWolframite(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> RUTILE_ORE = BLOCKS.register("rutile_ore", () -> new OreRutile(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HARDENED_STEEL_BLOCK = BLOCKS.register("hardened_steel_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));
	public static final RegistryObject<Block> TUNGSTEN_CARBIDE_BLOCK = BLOCKS.register("tungsten_carbide_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.0F).lightValue(1).sound(SoundType.METAL)));	
}
