package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class EasySteelConfiguredFeature
{
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_CASSITERITE_CONFIGED;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUTILE_CONFIGED;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_WOLFRAMITE_CONFIGED;


	public static void registerConfiguredFeatures()
	{
		ORE_CASSITERITE_CONFIGED = FeatureUtils.register("ore_cassiterite",
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
						BlockInit.CASSITERITE_ORE.get().defaultBlockState()),
						OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
						BlockInit.CASSITERITE_ORE_DEEPSLATE.get().defaultBlockState())),
						GeneralModConfig.CASSITERITE_ORE_SIZE.get()));
		ORE_RUTILE_CONFIGED = FeatureUtils.register("ore_rutile",
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
						BlockInit.RUTILE_ORE.get().defaultBlockState()),
						OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
						BlockInit.RUTILE_ORE_DEEPSLATE.get().defaultBlockState())),
						GeneralModConfig.RUTILE_ORE_SIZE.get()));
		ORE_WOLFRAMITE_CONFIGED = FeatureUtils.register("ore_wolframite",
				Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
						BlockInit.WOLFRAMITE_ORE.get().defaultBlockState()),
						OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
						BlockInit.WOLFRAMITE_ORE_DEEPSLATE.get().defaultBlockState())),
						GeneralModConfig.WOLFRAMITE_ORE_SIZE.get()));
	}
}