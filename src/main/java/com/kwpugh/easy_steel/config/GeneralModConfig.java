package com.kwpugh.easy_steel.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GeneralModConfig
{
    public static ForgeConfigSpec.BooleanValue CASSITERITE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue CASSITERITE_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue WOLFRAMITE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue WOLFRAMITE_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue RUTILE_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_SIZE;
    public static ForgeConfigSpec.IntValue RUTILE_ORE_MAX_HEIGHT;
   
    public static ForgeConfigSpec.DoubleValue SHARP_FLINT_DROP_CHANCE;

    public static ForgeConfigSpec.IntValue FLINT_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue FLINT_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue FLINT_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue FLINT_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue FLINT_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue BRONZE_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue BRONZE_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue BRONZE_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue BRONZE_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue BRONZE_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue STEEL_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue STEEL_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue STEEL_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue STEEL_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue STEEL_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue TITANIUM_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue TITANIUM_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue TITANIUM_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue TITANIUM_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue TITANIUM_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue HARDENED_STEEL_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue HARDENED_STEEL_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue HARDENED_STEEL_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue HARDENED_STEEL_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue HARDENED_STEEL_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue TUNGSTEN_TOOLS_DURABILITY;
    public static ForgeConfigSpec.DoubleValue TUNGSTEN_TOOLS_MINING_SPEED;
    public static ForgeConfigSpec.DoubleValue TUNGSTEN_TOOLS_ATTACK_DAMAGE;
    public static ForgeConfigSpec.IntValue TUNGSTEN_TOOLS_MINING_LEVEL;
    public static ForgeConfigSpec.IntValue TUNGSTEN_TOOLS_ENCHANTABILITY;

    public static ForgeConfigSpec.IntValue BRONZE_ARMOR_DURABILITY_MULTIPLIER;
    public static ForgeConfigSpec.IntValue BRONZE_ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.DoubleValue BRONZE_ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.DoubleValue BRONZE_ARMOR_KNOCKBACK_RESISTANCE;

    public static ForgeConfigSpec.IntValue STEEL_ARMOR_DURABILITY_MULTIPLIER;
    public static ForgeConfigSpec.IntValue STEEL_ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.DoubleValue STEEL_ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.DoubleValue STEEL_ARMOR_KNOCKBACK_RESISTANCE;

    public static ForgeConfigSpec.IntValue TITANIUM_ARMOR_DURABILITY_MULTIPLIER;
    public static ForgeConfigSpec.IntValue TITANIUM_ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.DoubleValue TITANIUM_ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.DoubleValue TITANIUM_ARMOR_KNOCKBACK_RESISTANCE;

    public static ForgeConfigSpec.IntValue HARDENED_STEEL_ARMOR_DURABILITY_MULTIPLIER;
    public static ForgeConfigSpec.IntValue HARDENED_STEEL_ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.DoubleValue HARDENED_STEEL_ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.DoubleValue HARDENED_STEEL_ARMOR_KNOCKBACK_RESISTANCE;

    public static ForgeConfigSpec.IntValue TUNGSTEN_ARMOR_DURABILITY_MULTIPLIER;
    public static ForgeConfigSpec.IntValue TUNGSTEN_ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.DoubleValue TUNGSTEN_ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.DoubleValue TUNGSTEN_ARMOR_KNOCKBACK_RESISTANCE;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {           
        SERVER_BUILDER.comment("Cassiterite Ore Generation").push("cassiterite_ore");

        CASSITERITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Cassiterite Ore in the world [true / false]").define("cassiteriteOreGeneration", true);
        CASSITERITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Cassiterite Ore pockets [0-100, default: 9]").defineInRange("cassiteriteOreSize", 9, 0, 100);
        CASSITERITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Cassiterite Ore pocket being generated [0-100, default: 25]").defineInRange("cassiteriteOreChance", 25, 0, 100);
        CASSITERITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Cassiterite Ore pocket generation [0-255, default: 200]").defineInRange("cassiteriteOreMaxHeight", 200, 0, 255);

        SERVER_BUILDER.pop();
        
        
        SERVER_BUILDER.comment("Rutile Ore Generation").push("rutile");

        RUTILE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Rutile Ore in the world [true / false]").define("rutileOreGeneration", true);
        RUTILE_ORE_SIZE = SERVER_BUILDER.comment("Size of Rutile Ore pockets [0-100, default: 5]").defineInRange("rutileOreSize", 6, 0, 100);
        RUTILE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Rutile Ore pocket being generated [0-100, default: 6]").defineInRange("rutileOreChance", 18, 0, 100);
        RUTILE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Rutile Ore pocket generation [0-255, default: 200]").defineInRange("rutileOreMaxHeight", 40, 0, 255);

        SERVER_BUILDER.pop();
        
        
        SERVER_BUILDER.comment("Wolframite Ore Generation").push("wolframite_ore");

        WOLFRAMITE_ORE_GENERATION = SERVER_BUILDER.comment("Generate Wolframite Ore in the world [true / false]").define("wolframiteOreGeneration", true);
        WOLFRAMITE_ORE_SIZE = SERVER_BUILDER.comment("Size of Wolframite Ore pockets [0-100, default: 5]").defineInRange("wolframiteOreSize", 6, 0, 100);
        WOLFRAMITE_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Wolframite Ore pocket being generated [0-100, default: 6]").defineInRange("wolframiteOreChance", 18, 0, 100);
        WOLFRAMITE_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Wolframite Ore pocket generation [0-255, default: 200]").defineInRange("wolframiteOreMaxHeight", 20, 0, 255);

        SERVER_BUILDER.pop();
        
        
        SERVER_BUILDER.comment("Hand Sovel drop chances").push("hand_shovel");
        
        SHARP_FLINT_DROP_CHANCE = SERVER_BUILDER.comment("Chance of Hand Shovel dropping Sharp Flint [0-1, default: .30]").defineInRange("sharp_flint_drop_chance", .30, 0, 1);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Flint Tool Material Values").push("flint_tool_material");

        FLINT_TOOLS_DURABILITY = SERVER_BUILDER.comment("Flint tool durability [1-250, default: 145]").defineInRange("flintToolsDurability", 145, 1, 250);
        FLINT_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Flint tool mining speed [1-25, default: 5.5]").defineInRange("flintToolsSpeed", 5.5, 1, 25.0);
        FLINT_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Flint tool attack damage [1-100, default: 0.5]").defineInRange("flintToolsDamage", 0.5, 1, 100.0);
        FLINT_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Flint tool mining level [1-6, default: 1]").defineInRange("flintToolsMiningLevel", 1, 1, 6);
        FLINT_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Flint tool enchantability [0-50, default: 5]").defineInRange("flintToolsEnchantability", 5, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Bronze Tool Material Values").push("bronze_tool_material");

        BRONZE_TOOLS_DURABILITY = SERVER_BUILDER.comment("Bronze tool durability [1-800, default: 225]").defineInRange("bronzeToolsDurability", 225, 1, 800);
        BRONZE_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Bronze tool mining speed [1-25, default: 6.5]").defineInRange("bronzeToolsSpeed", 6.5, 1, 25.0);
        BRONZE_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Bronze tool attack damage [1-100, default: 0.5]").defineInRange("bronzeToolsDamage", 0.5, 1, 100.0);
        BRONZE_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Bronze tool mining level [1-6, default: 2]").defineInRange("bronzeToolsMiningLevel", 2, 1, 6);
        BRONZE_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Bronze tool enchantability [0-50, default: 10]").defineInRange("bronzeToolsEnchantability", 10, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Steel Tool Material Values").push("steel_tool_material");

        STEEL_TOOLS_DURABILITY = SERVER_BUILDER.comment("Steel tool durability [1-800, default: 482]").defineInRange("steelToolsDurability", 482, 1, 800);
        STEEL_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Steel tool mining speed [1-25, default: 6.5]").defineInRange("steelToolsSpeed", 6.5, 1, 25.0);
        STEEL_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Steel tool attack damage [1-100, default: 0.5]").defineInRange("steelToolsDamage", 0.5, 1, 100.0);
        STEEL_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Steel tool mining level [1-6, default: 2]").defineInRange("steelToolsMiningLevel", 2, 1, 6);
        STEEL_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Steel tool enchantability [0-50, default: 8]").defineInRange("steelToolsEnchantability", 8, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Titanium Tool Material Values").push("titanium_tool_material");

        TITANIUM_TOOLS_DURABILITY = SERVER_BUILDER.comment("Titanium tool durability [1-800, default: 625]").defineInRange("titaniumToolsDurability", 625, 1, 800);
        TITANIUM_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Titanium tool mining speed [1-25, default: 6.5]").defineInRange("titaniumToolsSpeed", 6.5, 1, 25.0);
        TITANIUM_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Titanium tool attack damage [1-100, default: 0.5]").defineInRange("titaniumToolsDamage", 0.5, 1, 100.0);
        TITANIUM_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Titanium tool mining level [1-6, default: 2]").defineInRange("titaniumToolsMiningLevel", 2, 1, 6);
        TITANIUM_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Titanium tool enchantability [0-50, default: 8]").defineInRange("titaniumToolsEnchantability", 8, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Hardened Steel Tool Material Values").push("hardened_steel_tool_material");

        HARDENED_STEEL_TOOLS_DURABILITY = SERVER_BUILDER.comment("Hardened Steel tool durability [1-1000, default: 816]").defineInRange("hardenedSteelToolsDurability", 816, 1, 1000);
        HARDENED_STEEL_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Hardened Steel tool mining speed [1-25, default: 6.5]").defineInRange("hardenedSteelToolsSpeed", 6.5, 1, 25.0);
        HARDENED_STEEL_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Hardened Steel tool attack damage [1-100, default: 0.5]").defineInRange("hardenedSteelToolsDamage", 0.5, 1, 100.0);
        HARDENED_STEEL_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Hardened Steel tool mining level [1-6, default: 2]").defineInRange("hardenedSteelToolsMiningLevel", 2, 1, 6);
        HARDENED_STEEL_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Hardened Steel tool enchantability [0-50, default: 8]").defineInRange("hardenedSteelToolsEnchantability", 8, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Tungsten Tool Material Values").push("tungsten_tool_material");

        TUNGSTEN_TOOLS_DURABILITY = SERVER_BUILDER.comment("Tungsten tool durability [1-1000, default: 1023]").defineInRange("tungstenToolsDurability", 1023, 1, 1400);
        TUNGSTEN_TOOLS_MINING_SPEED = SERVER_BUILDER.comment("Tungsten tool mining speed [1-25, default: 6.5]").defineInRange("tungstenToolsSpeed", 6.5, 1, 25.0);
        TUNGSTEN_TOOLS_ATTACK_DAMAGE = SERVER_BUILDER.comment("Tungsten tool attack damage [1-100, default: 0.75]").defineInRange("tungstenToolsDamage", 0.75, 1, 100.0);
        TUNGSTEN_TOOLS_MINING_LEVEL = SERVER_BUILDER.comment("Tungsten tool mining level [1-6, default: 2]").defineInRange("tungstenToolsMiningLevel", 2, 1, 6);
        TUNGSTEN_TOOLS_ENCHANTABILITY = SERVER_BUILDER.comment("Tungsten tool enchantability [0-50, default: 8]").defineInRange("tungstenToolsEnchantability", 8, 1, 50);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Bronze Armor Material").push("bronze_armor_material");

        BRONZE_ARMOR_DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Bronze armor durability multiplier [1-50, default: 14]").defineInRange("bronzeArmorDurabilityMultiplier", 14, 1, 50);
        BRONZE_ARMOR_ENCHANTABILITY = SERVER_BUILDER.comment("Bronze armor enchantability [1-31, default: 15]").defineInRange("bronzeArmorEnchantability", 15, 1, 31);
        BRONZE_ARMOR_TOUGHNESS = SERVER_BUILDER.comment("Bronze armor toughness [0.0-4.0, default: 0.5]").defineInRange("bronzeArmorToughness", 0.5, 0.0, 4.0);
        BRONZE_ARMOR_KNOCKBACK_RESISTANCE = SERVER_BUILDER.comment("Bronze armor knockback resistance [0.0-4.0, default: 0.0]").defineInRange("bronzeArmorKnockbackResistance", 0.0, 0.0, 4.0);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Steel Armor Material").push("steel_armor_material");

        STEEL_ARMOR_DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Steel armor durability multiplier [1-50, default: 19]").defineInRange("steelArmorDurabilityMultiplier", 19, 1, 50);
        STEEL_ARMOR_ENCHANTABILITY = SERVER_BUILDER.comment("Steel armor enchantability [1-31, default: 15]").defineInRange("steelArmorEnchantability", 15, 1, 31);
        STEEL_ARMOR_TOUGHNESS = SERVER_BUILDER.comment("Steel armor toughness [0.0-4.0, default: 1.0]").defineInRange("steelArmorToughness", 1.0, 0.0, 4.0);
        STEEL_ARMOR_KNOCKBACK_RESISTANCE = SERVER_BUILDER.comment("Steel armor knockback resistance [0.0-4.0, default: 0.1]").defineInRange("steelArmorKnockbackResistance", 0.1, 0.0, 4.0);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Titanium Armor Material").push("titanium_armor_material");

        TITANIUM_ARMOR_DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Titanium armor durability multiplier [1-50, default: 22]").defineInRange("titaniumArmorDurabilityMultiplier", 22, 1, 50);
        TITANIUM_ARMOR_ENCHANTABILITY = SERVER_BUILDER.comment("Titanium armor enchantability [1-31, default: 15]").defineInRange("titaniumArmorEnchantability", 15, 1, 31);
        TITANIUM_ARMOR_TOUGHNESS = SERVER_BUILDER.comment("Titanium armor toughness [0.0-4.0, default: 1.25]").defineInRange("titaniumArmorToughness", 1.25, 0.0, 4.0);
        TITANIUM_ARMOR_KNOCKBACK_RESISTANCE = SERVER_BUILDER.comment("Titanium armor knockback resistance [0.0-4.0, default: 0.1]").defineInRange("titaniumArmorKnockbackResistance", 0.2, 0.0, 4.0);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Hardened Steel Armor Material").push("hardened_steel_armor_material");

        HARDENED_STEEL_ARMOR_DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Hardened Steel armor durability multiplier [1-50, default: 23]").defineInRange("hardenedSteelArmorDurabilityMultiplier", 23, 1, 50);
        HARDENED_STEEL_ARMOR_ENCHANTABILITY = SERVER_BUILDER.comment("Hardened Steel armor enchantability [1-31, default: 15]").defineInRange("hardenedSteelArmorEnchantability", 15, 1, 31);
        HARDENED_STEEL_ARMOR_TOUGHNESS = SERVER_BUILDER.comment("Hardened Steel armor toughness [0.0-4.0, default: 1.5]").defineInRange("hardenedSteelArmorToughness", 1.5, 0.0, 4.0);
        HARDENED_STEEL_ARMOR_KNOCKBACK_RESISTANCE = SERVER_BUILDER.comment("Hardened Steel armor knockback resistance [0.0-4.0, default: 0.1]").defineInRange("hardenedSteelArmorKnockbackResistance", 0.2, 0.0, 4.0);

        SERVER_BUILDER.pop();


        SERVER_BUILDER.comment("Tungsten Armor Material").push("tungsten_armor_material");

        TUNGSTEN_ARMOR_DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Tungsten armor durability multiplier [1-50, default: 25]").defineInRange("tungstenArmorDurabilityMultiplier", 25, 1, 50);
        TUNGSTEN_ARMOR_ENCHANTABILITY = SERVER_BUILDER.comment("Tungsten armor enchantability [1-31, default: 15]").defineInRange("tungstenArmorEnchantability", 15, 1, 31);
        TUNGSTEN_ARMOR_TOUGHNESS = SERVER_BUILDER.comment("Tungsten armor toughness [0.0-4.0, default: 1.75]").defineInRange("tungstenArmorToughness", 1.75, 0.0, 4.0);
        TUNGSTEN_ARMOR_KNOCKBACK_RESISTANCE = SERVER_BUILDER.comment("Tungsten armor knockback resistance [0.0-4.0, default: 0.1]").defineInRange("tungstenArmorKnockbackResistance", 0.3, 0.0, 4.0);

        SERVER_BUILDER.pop();
    }
}