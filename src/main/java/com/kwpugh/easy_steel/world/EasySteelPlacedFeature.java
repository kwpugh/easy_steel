package com.kwpugh.easy_steel.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
    public static Holder<PlacedFeature> ORE_CASSITERITE_PLACED;
    public static Holder<PlacedFeature> ORE_RUTILE_PLACED;
    public static Holder<PlacedFeature> ORE_WOLFRAMITE_PLACED;

    public static void registerPlacedFeatures()
    {
        ORE_CASSITERITE_PLACED = PlacementUtils.register("ore_cassiterite",
                EasySteelConfiguredFeature.ORE_CASSITERITE_CONFIGED, commonOrePlacement(35,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(380))));
        ORE_RUTILE_PLACED = PlacementUtils.register("ore_rutile",
                EasySteelConfiguredFeature.ORE_RUTILE_CONFIGED, commonOrePlacement(19,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40))));
        ORE_WOLFRAMITE_PLACED = PlacementUtils.register("ore_wolframite",
                EasySteelConfiguredFeature.ORE_WOLFRAMITE_CONFIGED, commonOrePlacement(16,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(10))));
    }


    @SubscribeEvent
    public static void registerBiomeModification(final BiomeLoadingEvent event)
    {
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(ORE_CASSITERITE_PLACED.value()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(ORE_RUTILE_PLACED.value()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(ORE_WOLFRAMITE_PLACED.value()));
    }


    // Just here because the vanilla ones are private
    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
