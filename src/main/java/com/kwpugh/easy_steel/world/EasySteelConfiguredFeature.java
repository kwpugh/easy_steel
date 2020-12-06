package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.BlockInit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class EasySteelConfiguredFeature 
{
	public static String modID = EasySteel.modid;

	public static ConfiguredFeature<?, ?> BORNITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
			BlockInit.BORNITE_ORE.get().getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
			new TopSolidRangeConfig(0, 0, GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()))).square().func_242731_b(GeneralModConfig.BORNITE_ORE_CHANCE.get());
	
	public static ConfiguredFeature<?, ?> CASSITERITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
			BlockInit.CASSITERITE_ORE.get().getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
			new TopSolidRangeConfig(0, 0, GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))).square().func_242731_b(GeneralModConfig.CASSITERITE_ORE_CHANCE.get());
	
	public static ConfiguredFeature<?, ?> RUTILE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
			BlockInit.RUTILE_ORE.get().getDefaultState(), GeneralModConfig.RUTILE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
			new TopSolidRangeConfig(0, 0, GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()))).square().func_242731_b(GeneralModConfig.RUTILE_ORE_CHANCE.get());
	
	public static ConfiguredFeature<?, ?> WOLFRAMITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
			BlockInit.WOLFRAMITE_ORE.get().getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
			new TopSolidRangeConfig(0, 0, GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get()))).square().func_242731_b(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get());
	
	public static void initModFeatures() 
	{
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(modID, "bornite_ore"), BORNITE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(modID, "cassiterite_ore"), CASSITERITE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(modID, "rutile_ore"), RUTILE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(modID, "wolframite_ore"), WOLFRAMITE_ORE);
		
	}
}