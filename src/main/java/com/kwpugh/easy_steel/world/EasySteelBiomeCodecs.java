package com.kwpugh.easy_steel.world;

import com.kwpugh.easy_steel.EasySteel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EasySteelBiomeCodecs
{
    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, EasySteel.modid);

    public static RegistryObject<Codec<EasySteelBiomeModifier>> EASY_STEEL_CODEC = BIOME_MODIFIER_SERIALIZERS.register("easy_steel_codec", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(EasySteelBiomeModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(EasySteelBiomeModifier::feature)
            ).apply(builder, EasySteelBiomeModifier::new)));
}