package com.kwpugh.easy_steel.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;


public record EasySteelBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier
{
    @Override
    public void modify(Holder<Biome> biome, Phase phase, Builder builder)
    {
        if (phase == Phase.ADD && biomes.contains(biome))
        {
            builder.getGenerationSettings().addFeature(Decoration.UNDERGROUND_ORES, feature);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec()
    {
        return EasySteelBiomeCodecs.EASY_STEEL_CODEC.get();
    }
}
