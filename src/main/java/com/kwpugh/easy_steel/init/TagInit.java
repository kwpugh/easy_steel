package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit
{
    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.create(Registry.BLOCK_REGISTRY,
            new ResourceLocation(EasySteel.modid, "paxel_mineable"));
}