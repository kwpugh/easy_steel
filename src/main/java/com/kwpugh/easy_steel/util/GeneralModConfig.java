package com.kwpugh.easy_steel.util;

import net.minecraftforge.common.ForgeConfigSpec;


public class GeneralModConfig
{
    public static ForgeConfigSpec.BooleanValue BORNITE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue BORNITE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue BORNITE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue BORNITE_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue BORNITE_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue CASSITERITE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_MAX_HEIGHT;

    
    
    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        SERVER_BUILDER.comment("Bornite Ore Generation").push("bornite_ore");

        BORNITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Bornite Ore in the world [true / false]").define("borniteOreGeneration", true);
        BORNITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Bornite Ore pockets [0-100, default: 3]").defineInRange("borniteOreSize", 50, 0, 100);
        BORNITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Bornite Ore pocket being generated [0-100, default: 10]").defineInRange("borniteOreChance", 90, 0, 100);
        BORNITE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Bornite Ore pocket generation, [0-255, default: 20]").defineInRange("borniteOreMinHeight", 1, 0, 255);
        BORNITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Bornite Ore pocket generation [0-255, default: 30]").defineInRange("borniteOreMaxHeight", 200, 0, 255);

        SERVER_BUILDER.pop();
                    
        SERVER_BUILDER.comment("Cassiterite Ore Generation").push("cassiterite_ore");

        CASSITERITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Cassiterite Ore in the world [true / false]").define("cassiteriteOreGeneration", true);
        CASSITERITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Cassiterite Ore pockets [0-100, default: 1]").defineInRange("cassiteriteOreSize", 50, 0, 100);
        CASSITERITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Cassiterite Ore pocket being generated [0-100, default: 10]").defineInRange("cassiteriteOreChance", 90, 0, 100);
        CASSITERITE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Cassiterite Ore pocket generation, [0-255, default: 5]").defineInRange("cassiteriteOreMinHeight", 1, 0, 255);
        CASSITERITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Cassiterite Ore pocket generation [0-255, default: 50]").defineInRange("cassiteriteOreMaxHeight", 200, 0, 255);

        SERVER_BUILDER.pop();
    }
}