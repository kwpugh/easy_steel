package com.kwpugh.easy_steel.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.kwpugh.easy_steel.config.GeneralModConfig;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class EasySteelOreGen 
{
	@SuppressWarnings("deprecation")
	public static void setupOreGenerator()
    {
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.BIOME.getEntries()) {

            if (!biome.getValue().getCategory().equals(Biome.Category.NETHER) && !biome.getValue().getCategory().equals(Biome.Category.THEEND))
            {
              	if(GeneralModConfig.BORNITE_ORE_GENERATION.get())
            	{
              		addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, EasySteelConfiguredFeature.BORNITE_ORE);
            	}
            	if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, EasySteelConfiguredFeature.CASSITERITE_ORE);           	
            	}
            	if(GeneralModConfig.RUTILE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, EasySteelConfiguredFeature.RUTILE_ORE);
            	}
            	if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
            	{
            		addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, EasySteelConfiguredFeature.WOLFRAMITE_ORE);	
            	}  	
            }
            
            if(biome.getValue().getCategory().equals(Biome.Category.NETHER)) 
            {
            	// TBD
            }
            
            if(biome.getValue().getCategory().equals(Biome.Category.THEEND)) 
            {
            	// TBD
            }
        }
    }
	
	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration,
			ConfiguredFeature<?, ?> configuredFeature) {
		List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
				biome.getGenerationSettings().getFeatures());
		while (biomeFeatures.size() <= decoration.ordinal()) {
			biomeFeatures.add(Lists.newArrayList());
		}
		List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
		features.add(() -> configuredFeature);
		biomeFeatures.set(decoration.ordinal(), features);

		ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures,
				"field_242484_f");
	}
}