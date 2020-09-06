package com.kwpugh.easy_steel.world;

//import com.kwpugh.easy_steel.init.BlockInit;
//import com.kwpugh.easy_steel.util.GeneralModConfig;
//
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.OreFeatureConfig;
//
//import net.minecraft.world.gen.placement.Placement;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class OreGenerator
//{
//    public static void setupOregen()
//    {
//        for(Biome biome : ForgeRegistries.BIOMES)
//        {	 
//        	if(GeneralModConfig.BORNITE_ORE_GENERATION.get())
//	    	  	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.BORNITE_ORE.get().getDefaultState(), GeneralModConfig.BORNITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.BORNITE_ORE_CHANCE.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.BORNITE_ORE_MAX_HEIGHT.get()))));
//    
//    	    if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
//				 biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.CASSITERITE_ORE.get().getDefaultState(), GeneralModConfig.CASSITERITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.CASSITERITE_ORE_CHANCE.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))));  
//        
//    	    if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
//    	    	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.WOLFRAMITE_ORE.get().getDefaultState(), GeneralModConfig.WOLFRAMITE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get(), GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get())))); 
//            
//    	    if(GeneralModConfig.RUTILE_ORE_GENERATION.get())
//            	biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BlockInit.RUTILE_ORE.get().getDefaultState(), GeneralModConfig.RUTILE_ORE_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(GeneralModConfig.RUTILE_ORE_CHANCE.get(), GeneralModConfig.RUTILE_ORE_MIN_HEIGHT.get(), GeneralModConfig.RUTILE_ORE_MIN_HEIGHT.get(), GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()))));
//        }
//    }
//}


