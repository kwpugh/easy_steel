package com.kwpugh.easy_steel.world;

import com.google.common.collect.ImmutableList;
import java.util.stream.Collectors;
import java.util.function.Supplier;
import java.util.List;

import com.google.common.collect.Lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.init.BlockInit;
import com.kwpugh.easy_steel.util.GeneralModConfig;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EasySteel.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGenerator
{
	public static ConfiguredFeature<?, ?> ORE_CASSITERITE;
	public static ConfiguredFeature<?, ?> ORE_BORNITE;
	public static ConfiguredFeature<?, ?> ORE_WOLFRAMITEE;
	public static ConfiguredFeature<?, ?> ORE_RUTILE;

	@SuppressWarnings("deprecation")
	public static void addFeatures()
	{
		OreGenerator.ORE_CASSITERITE = configuredFeature("ore_cassiterite", Feature.ORE.withConfiguration(new OreFeatureConfig
				(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.CASSITERITE_ORE.get().getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).func_242733_d(GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()).func_242728_a().func_242731_b(GeneralModConfig.CASSITERITE_ORE_CHANCE.get()));
		OreGenerator.ORE_BORNITE = configuredFeature("ore_boornite", Feature.ORE.withConfiguration(new OreFeatureConfig
				(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.BORNITE_ORE.get().getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).func_242733_d(GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()).func_242728_a().func_242731_b(GeneralModConfig.BORNITE_ORE_CHANCE.get()));
		OreGenerator.ORE_RUTILE = configuredFeature("ore_rutile", Feature.ORE.withConfiguration(new OreFeatureConfig
				(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.RUTILE_ORE.get().getDefaultState(), GeneralModConfig.RUTILE_ORE_SIZE.get())).func_242733_d(GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()).func_242728_a().func_242731_b(GeneralModConfig.RUTILE_ORE_CHANCE.get()));
		OreGenerator.ORE_WOLFRAMITEE = configuredFeature("ore_wolframite", Feature.ORE.withConfiguration(new OreFeatureConfig
				(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.WOLFRAMITE_ORE.get().getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).func_242733_d(GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get()).func_242728_a().func_242731_b(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get()));
				
        for (final Biome biome : WorldGenRegistries.field_243657_i) 
        {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) 
        	{
            	if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, OreGenerator.ORE_CASSITERITE); 
            	}
            	
            	if(GeneralModConfig.BORNITE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, OreGenerator.ORE_BORNITE); 
            	}
            		
            	if(GeneralModConfig.RUTILE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, OreGenerator.ORE_RUTILE);
            	}
            	
            	if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, OreGenerator.ORE_WOLFRAMITEE); 
            	}
        	}
        }
    }

	public static ConfiguredFeature<?, ?> configuredFeature(final String registryName, final ConfiguredFeature<?, ?> configuredFeature) 
	{
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation("easy_steel", registryName), configuredFeature);
        return configuredFeature;
    }
    
	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) 
	{
        ConvertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.func_242440_e().field_242484_f;
        while (biomeFeatures.size() <= feature.ordinal()) 
        {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }
    
    private static void ConvertImmutableFeatures(final Biome biome)
    {
        if (biome.func_242440_e().field_242484_f instanceof ImmutableList)
        {
            biome.func_242440_e().field_242484_f = biome.func_242440_e().field_242484_f.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    } 
}
