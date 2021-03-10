package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.BlockInit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGenerator 
{
	public static ConfiguredFeature<?, ?> BORNITE_ORE;
	public static ConfiguredFeature<?, ?> CASSITERITE_ORE;
	public static ConfiguredFeature<?, ?> RUTILE_ORE;
	public static ConfiguredFeature<?, ?> WOLFRAMITE_ORE;
	
	public static void ores() 
	{
		BORNITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.BORNITE_ORE.get().getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
				new TopSolidRangeConfig(0, 0, GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()))).square().count(GeneralModConfig.BORNITE_ORE_CHANCE.get());
				
		CASSITERITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.CASSITERITE_ORE.get().getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
				new TopSolidRangeConfig(0, 0, GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))).square().count(GeneralModConfig.CASSITERITE_ORE_CHANCE.get());
		
		RUTILE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.RUTILE_ORE.get().getDefaultState(), GeneralModConfig.RUTILE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
				new TopSolidRangeConfig(0, 0, GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()))).square().count(GeneralModConfig.RUTILE_ORE_CHANCE.get());
		
		WOLFRAMITE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.WOLFRAMITE_ORE.get().getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).withPlacement(Placement.RANGE.configure(
				new TopSolidRangeConfig(0, 0, GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get()))).square().count(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get());
		
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "bornite_ore"), BORNITE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore"), CASSITERITE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore"), RUTILE_ORE);
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore"), WOLFRAMITE_ORE);
	}
	
	@SubscribeEvent
	public static void biomeModification(final BiomeLoadingEvent event) 
	{ 
		ores();		
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> BORNITE_ORE);
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> CASSITERITE_ORE);
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> RUTILE_ORE);
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> WOLFRAMITE_ORE);
	}
}