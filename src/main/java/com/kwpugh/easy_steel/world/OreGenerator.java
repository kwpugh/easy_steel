package com.kwpugh.easy_steel.world;

import com.google.common.collect.ImmutableList;
import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.BlockInit;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGenerator 
{
	public static ImmutableList<OreConfiguration.TargetBlockState> ORE_CASSITERITE_TARGET_LIST;
	public static ImmutableList<OreConfiguration.TargetBlockState> ORE_RUTILE_TARGET_LIST;
	public static ImmutableList<OreConfiguration.TargetBlockState> ORE_WOLFRAMITE_TARGET_LIST;

	public static ConfiguredFeature<?, ?> ORE_CASSITERITE;
	public static ConfiguredFeature<?, ?> ORE_RUTILE;
	public static ConfiguredFeature<?, ?> ORE_WOLFRAMITE;
	
	public static void registerConfiguredFeatures()
	{
		// Build target lists of blocks to replace with ores
		ORE_CASSITERITE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockInit.CASSITERITE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BlockInit.CASSITERITE_ORE.get().defaultBlockState()));
		ORE_RUTILE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockInit.RUTILE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BlockInit.RUTILE_ORE.get().defaultBlockState()));
		ORE_WOLFRAMITE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockInit.WOLFRAMITE_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BlockInit.WOLFRAMITE_ORE.get().defaultBlockState()));


		// Set Y levels and chance counts for spawning
		ORE_CASSITERITE = Feature.ORE.configured(new OreConfiguration(ORE_CASSITERITE_TARGET_LIST,
				GeneralModConfig.CASSITERITE_ORE_SIZE.get()))
				.rangeUniform(VerticalAnchor.bottom(),
				VerticalAnchor.aboveBottom(GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get())).squared()
				.count(GeneralModConfig.CASSITERITE_ORE_CHANCE.get());
		ORE_RUTILE = Feature.ORE.configured(new OreConfiguration(ORE_RUTILE_TARGET_LIST,
				GeneralModConfig.RUTILE_ORE_SIZE.get()))
				.rangeUniform(VerticalAnchor.bottom(),
				VerticalAnchor.aboveBottom(GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get())).squared()
				.count(GeneralModConfig.RUTILE_ORE_CHANCE.get());
		ORE_WOLFRAMITE = Feature.ORE.configured(new OreConfiguration(ORE_WOLFRAMITE_TARGET_LIST,
				GeneralModConfig.WOLFRAMITE_ORE_SIZE.get()))
				.rangeUniform(VerticalAnchor.bottom(),
				VerticalAnchor.aboveBottom(GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get())).squared()
				.count(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get());


		// Register the configured feature
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore"), ORE_CASSITERITE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore"), ORE_RUTILE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore"), ORE_WOLFRAMITE);
	}
	
	@SubscribeEvent
	public static void registerBiomeModification(final BiomeLoadingEvent event)
	{ 
		registerConfiguredFeatures();
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_CASSITERITE);
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_RUTILE);
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_WOLFRAMITE);
	}
}