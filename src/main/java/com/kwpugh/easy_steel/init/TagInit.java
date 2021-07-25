package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class TagInit
{
    public static final Tag<Block> PAXEL_MINEABLE = getBlockTagWrapper("paxel_mineable");

    public static Tag<Block> getBlockTagWrapper(String path)
    {
        return BlockTags.bind(EasySteel.modid + ":" + path);
    }
}