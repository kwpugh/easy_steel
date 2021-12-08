package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class EasySteelPlacedFeature
{
    // Declare placed feature variables
    public static PlacedFeature ORE_CASSITERITE_OVERWORLD;
    public static PlacedFeature ORE_RUTILE_OVERWORLD;
    public static PlacedFeature ORE_WOLFRAMITE_OVERWORLD;

    public static PlacedFeature ORE_CASSITERITE_OVERWORLD_DEEPSLATE;
    public static PlacedFeature ORE_RUTILE_OVERWORLD_DEEPSLATE;
    public static PlacedFeature ORE_WOLFRAMITE_OVERWORLD_DEEPSLATE;


    public static void registerPlacedFeatures()
    {
        // Add configured features and placement details to placed features
        ORE_CASSITERITE_OVERWORLD = EasySteelConfiguredFeature.ORE_CASSITERITE
                .placed(commonOrePlacement(GeneralModConfig.CASSITERITE_ORE_CHANCE.get(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.CASSITERITE_ORE_MIN_HEIGHT.get()),
                VerticalAnchor.absolute(GeneralModConfig.CASSITERITE_ORE_MAX_HEIGHT.get()))));

        ORE_RUTILE_OVERWORLD = EasySteelConfiguredFeature.ORE_RUTILE
                .placed(commonOrePlacement(GeneralModConfig.RUTILE_ORE_CHANCE.get(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.RUTILE_ORE_MIN_HEIGHT.get()),
                VerticalAnchor.absolute(GeneralModConfig.RUTILE_ORE_MAX_HEIGHT.get()))));

        ORE_WOLFRAMITE_OVERWORLD = EasySteelConfiguredFeature.ORE_WOLFRAMITE
                .placed(commonOrePlacement(GeneralModConfig.WOLFRAMITE_ORE_CHANCE.get(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.WOLFRAMITE_ORE_MIN_HEIGHT.get()),
                VerticalAnchor.absolute(GeneralModConfig.WOLFRAMITE_ORE_MAX_HEIGHT.get()))));

        ORE_CASSITERITE_OVERWORLD_DEEPSLATE = EasySteelConfiguredFeature.ORE_CASSITERITE_DEEPSLATE
                .placed(commonOrePlacement(GeneralModConfig.CASSITERITE_ORE_DEEPSLATE_CHANCE.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.CASSITERITE_ORE_DEEPSLATE_MIN_HEIGHT.get()),
                                VerticalAnchor.absolute(GeneralModConfig.CASSITERITE_ORE_DEEPSLATE_MAX_HEIGHT.get()))));

        ORE_RUTILE_OVERWORLD_DEEPSLATE = EasySteelConfiguredFeature.ORE_RUTILE
                .placed(commonOrePlacement(GeneralModConfig.RUTILE_ORE_DEEPSLATE_CHANCE.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.RUTILE_ORE_DEEPSLATE_MIN_HEIGHT.get()),
                                VerticalAnchor.absolute(GeneralModConfig.RUTILE_ORE_DEEPSLATE_MAX_HEIGHT.get()))));

        ORE_WOLFRAMITE_OVERWORLD_DEEPSLATE = EasySteelConfiguredFeature.ORE_WOLFRAMITE_DEEPSLATE
                .placed(commonOrePlacement(GeneralModConfig.WOLFRAMITE_ORE_DEEPSLATE_CHANCE.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(GeneralModConfig.WOLFRAMITE_ORE_DEEPSLATE_MIN_HEIGHT.get()),
                                VerticalAnchor.absolute(GeneralModConfig.WOLFRAMITE_ORE_DEEPSLATE_MAX_HEIGHT.get()))));


        // Register placed features
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore"), ORE_CASSITERITE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore"), ORE_RUTILE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore"), ORE_WOLFRAMITE_OVERWORLD);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "cassiterite_ore_deepslate"), ORE_CASSITERITE_OVERWORLD_DEEPSLATE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "rutile_ore_deepslate"), ORE_RUTILE_OVERWORLD_DEEPSLATE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(EasySteel.modid, "wolframite_ore_deepslate"), ORE_WOLFRAMITE_OVERWORLD_DEEPSLATE);

    }

    @SubscribeEvent
    public static void registerBiomeModification(final BiomeLoadingEvent event)
    {
        // Add features to be inserted into biome generation
		if(GeneralModConfig.CASSITERITE_ORE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_CASSITERITE_OVERWORLD);
        }

		if(GeneralModConfig.RUTILE_ORE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_RUTILE_OVERWORLD);
        }
		if(GeneralModConfig.WOLFRAMITE_ORE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_WOLFRAMITE_OVERWORLD);
        }

		if(GeneralModConfig.CASSITERITE_ORE_DEEPSLATE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_CASSITERITE_OVERWORLD_DEEPSLATE);
        }

		if(GeneralModConfig.RUTILE_ORE_DEEPSLATE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_RUTILE_OVERWORLD_DEEPSLATE);
        }

		if(GeneralModConfig.WOLFRAMITE_ORE_DEEPSLATE_GENERATION.get())
        {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> ORE_WOLFRAMITE_OVERWORLD_DEEPSLATE);
        }

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_)
    {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_)
    {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_)
    {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
