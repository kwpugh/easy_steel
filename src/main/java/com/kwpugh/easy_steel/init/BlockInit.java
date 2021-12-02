package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.blocks.OreCassiterite;
import com.kwpugh.easy_steel.blocks.OreRutile;
import com.kwpugh.easy_steel.blocks.OreWolframite;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EasySteel.modid);

	public static final RegistryObject<Block> CASSITERITE_ORE = BLOCKS.register("cassiterite_ore", () -> new OreCassiterite(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> CASSITERITE_ORE_DEEPSLATE = BLOCKS.register("cassiterite_ore_deepslate", () -> new OreCassiterite(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

	public static final RegistryObject<Block> WOLFRAMITE_ORE = BLOCKS.register("wolframite_ore", () -> new OreWolframite(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> WOLFRAMITE_ORE_DEEPSLATE = BLOCKS.register("wolframite_ore_deepslate", () -> new OreWolframite(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

	public static final RegistryObject<Block> RUTILE_ORE = BLOCKS.register("rutile_ore", () -> new OreRutile(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> RUTILE_ORE_DEEPSLATE = BLOCKS.register("rutile_ore_deepslate", () -> new OreRutile(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("tungsten_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> HARDENED_STEEL_BLOCK = BLOCKS.register("hardened_steel_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> TUNGSTEN_CARBIDE_BLOCK = BLOCKS.register("tungsten_carbide_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
}
