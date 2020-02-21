package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.lists.BlockList;
import com.kwpugh.easy_steel.util.GeneralModConfig;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;


public class OreGenerator
{
    public static void setupOregen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {  
//        	if(NewConfig.Server.bornite_ore_generation)
//            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.bornite_ore.getDefaultState(), NewConfig.Server.bornite_ore_size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(NewConfig.Server.bornite_ore_chance, NewConfig.Server.bornite_ore_min_height, NewConfig.Server.bornite_ore_min_height, NewConfig.Server.bornite_ore_max_height))));
//                      
//            if(NewConfig.Server.cassiterite_ore_generation)
//        		 biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.cassiterite_ore.getDefaultState(), NewConfig.Server.bornite_ore_size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(NewConfig.Server.cassiterite_ore_chance, NewConfig.Server.cassiterite_min_height, NewConfig.Server.cassiterite_min_height, NewConfig.Server.cassiterite_max_height))));  
//
//            if(NewConfig.Server.wolframite_ore_generation)
//            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.wolframite_ore.getDefaultState(), NewConfig.Server.wolframite_ore_size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(NewConfig.Server.wolframite_ore_chance, NewConfig.Server.wolframite_min_height, NewConfig.Server.wolframite_min_height, NewConfig.Server.wolframite_max_height))));
//
//            if(NewConfig.Server.rutile_ore_generation)
//            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.rutile_ore.getDefaultState(), NewConfig.Server.rutile_ore_size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(NewConfig.Server.rutile_ore_chance, NewConfig.Server.rutile_min_height, NewConfig.Server.rutile_min_height, NewConfig.Server.rutile_max_height))));
//      
//            
        	if(GeneralModConfig.BORNITE_ORE_GENERATION.get())
	    	  	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.bornite_ore.getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.BORNITE_ORE_CHANCE.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()))));
    
    	    if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
				 biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.cassiterite_ore.getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.CASSITERITE_ORE_CHANCE.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))));  
        
    	    if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
    	    	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.wolframite_ore.getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get())))); 
            
    	    if(GeneralModConfig.RUTILE_ORE_GENERATION.get())
            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.rutile_ore.getDefaultState(), GeneralModConfig.RUTILE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.RUTILE_ORE_CHANCE.get(), GeneralModConfig.RUTILE_ORE_MIN_HEIGHT.get(), GeneralModConfig.RUTILE_ORE_MIN_HEIGHT.get(), GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()))));
  
        }
    }
}