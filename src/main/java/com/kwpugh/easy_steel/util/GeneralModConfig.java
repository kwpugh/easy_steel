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

    public static ForgeConfigSpec.BooleanValue WOLFRAMITE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue RUTILE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_MAX_HEIGHT;
    
    public static ForgeConfigSpec.BooleanValue ENABLE_BRONZE_RELATED_ITEMS;
    
    public static ForgeConfigSpec.DoubleValue STONE_DROP_CHANCE;
    public static ForgeConfigSpec.DoubleValue ONE_DROP_CHANCE;
    public static ForgeConfigSpec.DoubleValue TWO_DROP_CHANCE;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        SERVER_BUILDER.comment("Bornite Ore Generation").push("bornite_ore");

        BORNITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Bornite Ore in the world [true / false]").define("borniteOreGeneration", true);
        BORNITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Bornite Ore pockets [0-100, default: 12]").defineInRange("borniteOreSize", 12, 0, 100);
        BORNITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Bornite Ore pocket being generated [0-100, default: 25]").defineInRange("borniteOreChance", 25, 0, 100);
        BORNITE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Bornite Ore pocket generation, [0-255, default: 1]").defineInRange("borniteOreMinHeight", 1, 0, 255);
        BORNITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Bornite Ore pocket generation [0-255, default: 200]").defineInRange("borniteOreMaxHeight", 200, 0, 255);

        SERVER_BUILDER.pop();
                    
        SERVER_BUILDER.comment("Cassiterite Ore Generation").push("cassiterite_ore");

        CASSITERITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Cassiterite Ore in the world [true / false]").define("cassiteriteOreGeneration", true);
        CASSITERITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Cassiterite Ore pockets [0-100, default: 9]").defineInRange("cassiteriteOreSize", 9, 0, 100);
        CASSITERITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Cassiterite Ore pocket being generated [0-100, default: 25]").defineInRange("cassiteriteOreChance", 25, 0, 100);
        CASSITERITE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Cassiterite Ore pocket generation, [0-255, default: 1]").defineInRange("cassiteriteOreMinHeight", 1, 0, 255);
        CASSITERITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Cassiterite Ore pocket generation [0-255, default: 200]").defineInRange("cassiteriteOreMaxHeight", 200, 0, 255);

        SERVER_BUILDER.pop();
        
        SERVER_BUILDER.comment("Wolframite Ore Generation").push("wolframite_ore");

        WOLFRAMITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Wolframite Ore in the world [true / false]").define("wolframiteOreGeneration", true);
        WOLFRAMITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Wolframite Ore pockets [0-100, default: 5]").defineInRange("wolframiteOreSize", 4, 0, 100);
        WOLFRAMITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Wolframite Ore pocket being generated [0-100, default: 6]").defineInRange("wolframiteOreChance", 4, 0, 100);
        WOLFRAMITE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Wolframite Ore pocket generation, [0-255, default: 1]").defineInRange("wolframiteOreMinHeight", 1, 0, 255);
        WOLFRAMITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Wolframite Ore pocket generation [0-255, default: 200]").defineInRange("wolframiteOreMaxHeight", 15, 0, 255);

        SERVER_BUILDER.pop();
        
        SERVER_BUILDER.comment("Rutile Ore Generation").push("rutile");

        RUTILE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Rutile Ore in the world [true / false]").define("rutileOreGeneration", true);
        RUTILE_ORE_SIZE = SERVER_BUILDER.comment("Size of Rutile Ore pockets [0-100, default: 5]").defineInRange("rutileOreSize", 4, 0, 100);
        RUTILE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Rutile Ore pocket being generated [0-100, default: 6]").defineInRange("rutileOreChance", 4, 0, 100);
        RUTILE_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Rutile Ore pocket generation, [0-255, default: 1]").defineInRange("rutileOreMinHeight", 1, 0, 255);
        RUTILE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Rutile Ore pocket generation [0-255, default: 200]").defineInRange("rutileOreMaxHeight", 15, 0, 255);

        SERVER_BUILDER.pop();
        
        SERVER_BUILDER.comment("Crack Hammer drop chances, numbers represent a sequence of evaluating a random number. Stone_drop, one_drop, and two_drop numbers need to be in ascending order and not overlap.").push("crack_hammer");
        
        STONE_DROP_CHANCE = SERVER_BUILDER.comment("Chance of Crack Hammer dropping Stone Powder [0-1, default: .001]").defineInRange("stone_drop_chance", .001, 0, 1);
        ONE_DROP_CHANCE = SERVER_BUILDER.comment("Chance of Crack Hammer dropping (2) of the target powders [0-1, default: .997]").defineInRange("one_drop_chance", .997, 0, 1);
        TWO_DROP_CHANCE = SERVER_BUILDER.comment("Chance of Crack Hammer dropping (3) of the target powders [0-1, default: .999]").defineInRange("two_drop_chance", .999, 0, 1);

        SERVER_BUILDER.pop();
    }
}