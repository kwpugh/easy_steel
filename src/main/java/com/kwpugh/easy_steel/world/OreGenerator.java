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
            if(GeneralModConfig.BORNITE_ORE_GENERATION.get())
            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.bornite_ore.getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(GeneralModConfig.BORNITE_ORE_CHANCE.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()))));
            
            if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
        		 biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.cassiterite_ore.getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(GeneralModConfig.CASSITERITE_ORE_CHANCE.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))));  
            
            if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.wolframite_ore.getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get()))));
        }
    }
}