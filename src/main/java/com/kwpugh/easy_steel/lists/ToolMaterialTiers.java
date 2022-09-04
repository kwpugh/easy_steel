package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ToolMaterialTiers
{
    private static int flintDurability = GeneralModConfig.FLINT_TOOLS_DURABILITY.get();
    private static double flintMiningSpeed = GeneralModConfig.FLINT_TOOLS_MINING_SPEED.get();
    private static double flintAttackDamage = GeneralModConfig.FLINT_TOOLS_ATTACK_DAMAGE.get();
    private static int flintMiningLevel = 1;
    private static int flintEnchantability = GeneralModConfig.FLINT_TOOLS_ENCHANTABILITY.get();

    private static int bronzeDurability = GeneralModConfig.BRONZE_TOOLS_DURABILITY.get();
    private static double bronzeMiningSpeed = GeneralModConfig.BRONZE_TOOLS_MINING_SPEED.get();
    private static double bronzeAttackDamage = GeneralModConfig.BRONZE_TOOLS_ATTACK_DAMAGE.get();
    private static int bronzeMiningLevel = 2;
    private static int bronzeEnchantability = GeneralModConfig.BRONZE_TOOLS_ENCHANTABILITY.get();

    private static int steelDurability = GeneralModConfig.STEEL_TOOLS_DURABILITY.get();
    private static double steelMiningSpeed = GeneralModConfig.STEEL_TOOLS_MINING_SPEED.get();
    private static double steelAttackDamage = GeneralModConfig.STEEL_TOOLS_ATTACK_DAMAGE.get();
    private static int steelMiningLevel = 2;
    private static int steelEnchantability = GeneralModConfig.STEEL_TOOLS_ENCHANTABILITY.get();

    private static int titaniumDurability = GeneralModConfig.TITANIUM_TOOLS_DURABILITY.get();
    private static double titaniumMiningSpeed = GeneralModConfig.TITANIUM_TOOLS_MINING_SPEED.get();
    private static double titaniumAttackDamage = GeneralModConfig.TITANIUM_TOOLS_ATTACK_DAMAGE.get();
    private static int titaniumMiningLevel = 2;
    private static int titaniumEnchantability = GeneralModConfig.TITANIUM_TOOLS_ENCHANTABILITY.get();

    private static int hardenedSteelDurability = GeneralModConfig.HARDENED_STEEL_TOOLS_DURABILITY.get();
    private static double hardenedSteelMiningSpeed = GeneralModConfig.HARDENED_STEEL_TOOLS_MINING_SPEED.get();
    private static double hardenedSteelAttackDamage = GeneralModConfig.HARDENED_STEEL_TOOLS_ATTACK_DAMAGE.get();
    private static int hardenedSteelMiningLevel = 2;
    private static int hardenedSteelEnchantability = GeneralModConfig.HARDENED_STEEL_TOOLS_ENCHANTABILITY.get();

    private static int tungstenDurability = GeneralModConfig.TUNGSTEN_TOOLS_DURABILITY.get();
    private static double tungstenMiningSpeed = GeneralModConfig.TUNGSTEN_TOOLS_MINING_SPEED.get();
    private static double tungstenAttackDamage = GeneralModConfig.TUNGSTEN_TOOLS_ATTACK_DAMAGE.get();
    private static int tungstenMiningLevel = 3;
    private static int tungstenEnchantability = GeneralModConfig.TUNGSTEN_TOOLS_ENCHANTABILITY.get();


    public static final Tier FLINT = new ForgeTier(flintMiningLevel,
            flintDurability,
            (float) flintMiningSpeed,
            (float) flintAttackDamage,
            flintEnchantability,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.FLINT));

    public static final Tier BRONZE = new ForgeTier(bronzeMiningLevel,
            bronzeDurability, (float) bronzeMiningSpeed,
            (float) bronzeAttackDamage,
            bronzeEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemInit.BRONZE_INGOT.get()));

    public static final Tier STEEL = new ForgeTier(steelMiningLevel,
            steelDurability,
            (float) steelMiningSpeed,
            (float) steelAttackDamage,
            steelEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemInit.STEEL_INGOT.get()));

    public static final Tier TITANIUM = new ForgeTier(titaniumMiningLevel,
            titaniumDurability,
            (float) titaniumMiningSpeed,
            (float) titaniumAttackDamage,
            titaniumEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemInit.TITANIUM_ALLOY_INGOT.get()));

    public static final Tier HARDENED_STEEL = new ForgeTier(hardenedSteelMiningLevel,
            hardenedSteelDurability,
            (float) hardenedSteelMiningSpeed,
            (float) hardenedSteelAttackDamage,
            hardenedSteelEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemInit.HARDENED_STEEL_INGOT.get()));

    public static final Tier TUNGSTEN = new ForgeTier(tungstenMiningLevel,
            tungstenDurability,
            (float) tungstenMiningSpeed,
            (float) tungstenAttackDamage,
            tungstenEnchantability,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemInit.TUNGSTEN_CARBIDE_INGOT.get()));



    public static void register()
    {
        TierSortingRegistry.registerTier(FLINT, new ResourceLocation(EasySteel.modid, "flint"), List.of(Tiers.STONE), List.of(Tiers.IRON));
        TierSortingRegistry.registerTier(BRONZE, new ResourceLocation(EasySteel.modid, "bronze"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
        TierSortingRegistry.registerTier(STEEL, new ResourceLocation(EasySteel.modid, "steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
        TierSortingRegistry.registerTier(TITANIUM, new ResourceLocation(EasySteel.modid, "titanium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
        TierSortingRegistry.registerTier(HARDENED_STEEL, new ResourceLocation(EasySteel.modid, "hardened_steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
        TierSortingRegistry.registerTier(TUNGSTEN, new ResourceLocation(EasySteel.modid, "tungsten"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    }
}
