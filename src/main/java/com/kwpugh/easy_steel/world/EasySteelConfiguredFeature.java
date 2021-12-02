package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class EasySteelConfiguredFeature
{
	// Create target block lists
	public static List<OreConfiguration.TargetBlockState> ORE_RUTILE_TARGET_LIST;
	public static List<OreConfiguration.TargetBlockState> ORE_CASSITERITE_TARGET_LIST;
	public static List<OreConfiguration.TargetBlockState> ORE_WOLFRAMITE_TARGET_LIST;


	// Declare configured feature variables
	public static ConfiguredFeature<?,?> ORE_CASSITERITE;
	public static ConfiguredFeature<?,?> ORE_RUTILE;
	public static ConfiguredFeature<?,?> ORE_WOLFRAMITE;

	public static ConfiguredFeature<?,?> ORE_CASSITERITE_DEEPSLATE;
	public static ConfiguredFeature<?,?> ORE_RUTILE_DEEPSLATE;
	public static ConfiguredFeature<?,?> ORE_WOLFRAMITE_DEEPSLATE;



	public static void registerConfiguredFeatures()
	{
		// Assemble target block lists
		ORE_CASSITERITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.CASSITERITE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.CASSITERITE_ORE_DEEPSLATE.get().defaultBlockState()));
		ORE_RUTILE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.RUTILE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.RUTILE_ORE_DEEPSLATE.get().defaultBlockState()));
		ORE_WOLFRAMITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.WOLFRAMITE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.WOLFRAMITE_ORE_DEEPSLATE.get().defaultBlockState()));


		// Add target blocks to configured features
		ORE_CASSITERITE = Feature.ORE.configured(new OreConfiguration(ORE_CASSITERITE_TARGET_LIST, GeneralModConfig.CASSITERITE_ORE_SIZE.get()));
		ORE_RUTILE = Feature.ORE.configured(new OreConfiguration(ORE_RUTILE_TARGET_LIST, GeneralModConfig.RUTILE_ORE_SIZE.get()));
		ORE_WOLFRAMITE = Feature.ORE.configured(new OreConfiguration(ORE_WOLFRAMITE_TARGET_LIST, GeneralModConfig.WOLFRAMITE_ORE_SIZE.get()));

		ORE_CASSITERITE_DEEPSLATE = Feature.ORE.configured(new OreConfiguration(ORE_CASSITERITE_TARGET_LIST, GeneralModConfig.CASSITERITE_ORE_SIZE.get()));
		ORE_RUTILE_DEEPSLATE = Feature.ORE.configured(new OreConfiguration(ORE_RUTILE_TARGET_LIST, GeneralModConfig.RUTILE_ORE_SIZE.get()));
		ORE_WOLFRAMITE_DEEPSLATE = Feature.ORE.configured(new OreConfiguration(ORE_WOLFRAMITE_TARGET_LIST, GeneralModConfig.WOLFRAMITE_ORE_SIZE.get()));


		// Register the configured features
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore"), ORE_CASSITERITE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore"), ORE_RUTILE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore"), ORE_WOLFRAMITE);

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore_deepslate"), ORE_CASSITERITE_DEEPSLATE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore_deepslate"), ORE_RUTILE_DEEPSLATE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore_deepslate"), ORE_WOLFRAMITE_DEEPSLATE);
	}
}