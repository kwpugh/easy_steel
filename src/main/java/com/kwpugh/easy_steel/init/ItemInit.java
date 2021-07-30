package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.items.CrackHammer;
import com.kwpugh.easy_steel.items.HandShovel;
import com.kwpugh.easy_steel.items.misc.SharpFlint;
import com.kwpugh.easy_steel.items.bronze.ArmorBronze;
import com.kwpugh.easy_steel.items.bronze.BronzeAxe;
import com.kwpugh.easy_steel.items.bronze.BronzeExcavator;
import com.kwpugh.easy_steel.items.bronze.BronzeHammer;
import com.kwpugh.easy_steel.items.bronze.BronzePaxel;
import com.kwpugh.easy_steel.items.bronze.BronzePickaxe;
import com.kwpugh.easy_steel.items.bronze.BronzeShovel;
import com.kwpugh.easy_steel.items.bronze.BronzeSword;
import com.kwpugh.easy_steel.items.flint.FlintHatchet;
import com.kwpugh.easy_steel.items.flint.FlintKnife;
import com.kwpugh.easy_steel.items.flint.FlintMattock;
import com.kwpugh.easy_steel.items.flint.FlintShovel;
import com.kwpugh.easy_steel.items.hardenedsteel.ArmorHardenedSteel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelAxe;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelExcavator;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelHammer;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelPaxel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelPickaxe;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelShovel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelSword;
import com.kwpugh.easy_steel.items.misc.IronLinks;
import com.kwpugh.easy_steel.items.powders.Carbon;
import com.kwpugh.easy_steel.items.steel.*;
import com.kwpugh.easy_steel.items.titanium.ArmorTitanium;
import com.kwpugh.easy_steel.items.titanium.TitaniumAxe;
import com.kwpugh.easy_steel.items.titanium.TitaniumExcavator;
import com.kwpugh.easy_steel.items.titanium.TitaniumHammer;
import com.kwpugh.easy_steel.items.titanium.TitaniumPaxel;
import com.kwpugh.easy_steel.items.titanium.TitaniumPickaxe;
import com.kwpugh.easy_steel.items.titanium.TitaniumShovel;
import com.kwpugh.easy_steel.items.titanium.TitaniumSword;
import com.kwpugh.easy_steel.items.tungstencarbide.ArmorTungstenCarbide;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideAxe;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideExcavator;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideHammer;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbidePaxel;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbidePickaxe;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideShovel;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideSword;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideTreeAxe;
import com.kwpugh.easy_steel.lists.*;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
	// Tool stats can be adjusted in config
	public static final Tier FLINT_TOOL_MATERIAL = new FlintToolMaterial();
	public static final Tier BRONZE_TOOL_MATERIAL = new BronzeToolMaterial();
	public static final Tier STEEL_TOOL_MATERIAL = new SteelToolMaterial();
	public static final Tier TITANIUM_TOOL_MATERIAL = new TitaniumToolMaterial();
	public static final Tier HARDENED_STEEL_TOOL_MATERIAL = new HardenedSteelToolMaterial();
	public static final Tier TUNGSTEN_TOOL_MATERIAL = new TungstenToolMaterial();

	// USed for bows & crossbows only
	public static final int steelDurability = GeneralModConfig.STEEL_TOOLS_DURABILITY.get();
	public static final int hardenedSteelDurability = GeneralModConfig.HARDENED_STEEL_TOOLS_DURABILITY.get();

	// Armor stats can be adjusted in config
	public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = new BronzeArmorMaterial();
	public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new SteelArmorMaterial();
	public static final ArmorMaterial TITANIUM_ARMOR_MATERIAL = new SteelArmorMaterial();
	public static final ArmorMaterial HARDENED_STEEL_ARMOR_MATERIAL = new HardenedSteelArmorMaterial();
	public static final ArmorMaterial TUNGSTEN_ARMOR_MATERIAL = new TungstenArmorMaterial();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasySteel.modid);

	public static final RegistryObject<Item> CASSITERITE_ORE = ITEMS.register("cassiterite_ore", () -> new BlockItem(BlockInit.CASSITERITE_ORE.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RUTILE_ORE = ITEMS.register("rutile_ore", () -> new BlockItem(BlockInit.RUTILE_ORE.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> WOLFRAMITE_ORE = ITEMS.register("wolframite_ore", () -> new BlockItem(BlockInit.WOLFRAMITE_ORE.get(), new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> HAND_SHOVEL = ITEMS.register("hand_shovel", () -> new HandShovel(FLINT_TOOL_MATERIAL, 1, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> SHARP_FLINT = ITEMS.register("sharp_flint", () -> new SharpFlint(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> FLINT_MATTOCK = ITEMS.register("flint_mattock", () -> new FlintMattock(FLINT_TOOL_MATERIAL, 1, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> FLINT_SHOVEL = ITEMS.register("flint_shovel", () -> new FlintShovel(FLINT_TOOL_MATERIAL, 1, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> FLINT_HATCHET = ITEMS.register("flint_hatchet", () -> new FlintHatchet(FLINT_TOOL_MATERIAL, 5, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> FLINT_KNIFE = ITEMS.register("flint_knife", () -> new FlintKnife(FLINT_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> FLINT_HOE = ITEMS.register("flint_hoe", () -> new HoeItem(FLINT_TOOL_MATERIAL, -2, -2.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> CRACK_HAMMER = ITEMS.register("crack_hammer", () -> new CrackHammer(new Item.Properties().durability(251).tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> STONE_POWDER = ITEMS.register("stone_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TIN_POWDER = ITEMS.register("tin_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> COPPER_POWDER = ITEMS.register("copper_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> CARBON = ITEMS.register("carbon", () -> new Carbon(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> IRON_POWDER = ITEMS.register("iron_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> GOLD_POWDER = ITEMS.register("gold_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> DIAMOND_POWDER = ITEMS.register("diamond_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> EMERALD_POWDER = ITEMS.register("emerald_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> NETHERITE_POWDER = ITEMS.register("netherite_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_POWDER = ITEMS.register("titanium_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_POWDER = ITEMS.register("tungsten_powder", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> IRON_LINKS = ITEMS.register("iron_links", () -> new IronLinks(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> RAW_BRONZE = ITEMS.register("raw_bronze", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_TITANIUM_ALLOY = ITEMS.register("raw_titanium_alloy", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_HARDENED_STEEL = ITEMS.register("raw_hardened_steel", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> RAW_TUNGSTEN_CARBIDE = ITEMS.register("raw_tungsten_carbide", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_ALLOY_INGOT = ITEMS.register("titanium_alloy_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_INGOT = ITEMS.register("hardened_steel_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = ITEMS.register("tungsten_carbide_ingot", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> BRONZE_BLOCK = ITEMS.register("bronze_block", () -> new BlockItem(BlockInit.BRONZE_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_BLOCK = ITEMS.register("tungsten_block", () -> new BlockItem(BlockInit.TUNGSTEN_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register("steel_block", () -> new BlockItem(BlockInit.STEEL_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_BLOCK = ITEMS.register("titanium_block", () -> new BlockItem(BlockInit.TITANIUM_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_BLOCK = ITEMS.register("hardened_steel_block", () -> new BlockItem(BlockInit.HARDENED_STEEL_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_BLOCK = ITEMS.register("tungsten_carbide_block", () -> new BlockItem(BlockInit.TUNGSTEN_CARBIDE_BLOCK.get(), new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> BRONZE_ROD = ITEMS.register("bronze_rod", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_ROD = ITEMS.register("titanium_rod", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_ROD = ITEMS.register("hardened_steel_rod", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_ROD = ITEMS.register("tungsten_carbide_rod", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> STEEL_STRING = ITEMS.register("steel_string", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_STRING = ITEMS.register("hardened_steel_string", () -> new Item(new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new BronzeSword(BRONZE_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new BronzePickaxe(BRONZE_TOOL_MATERIAL, 2, -2.8f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new BronzeAxe(BRONZE_TOOL_MATERIAL, 6, -3.1f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new BronzeShovel(BRONZE_TOOL_MATERIAL, 2, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () -> new HoeItem(BRONZE_TOOL_MATERIAL, -2, -2.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () -> new BronzeHammer(BRONZE_TOOL_MATERIAL,6, -3.3f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_EXCAVATOR = ITEMS.register("bronze_excavator", () -> new BronzeExcavator(BRONZE_TOOL_MATERIAL, 2, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> BRONZE_PAXEL = ITEMS.register("bronze_paxel", () -> new BronzePaxel(6, -3.2f, BRONZE_TOOL_MATERIAL, null, new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SteelSword(STEEL_TOOL_MATERIAL, 5, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new SteelPickaxe(STEEL_TOOL_MATERIAL,  3, -2.8f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new SteelAxe(STEEL_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new SteelShovel(STEEL_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(STEEL_TOOL_MATERIAL, -2, -1.5f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer", () -> new SteelHammer(STEEL_TOOL_MATERIAL, 7, -3.3f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_EXCAVATOR = ITEMS.register("steel_excavator", () -> new SteelExcavator(STEEL_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_PAXEL = ITEMS.register("steel_paxel", () -> new SteelPaxel(7, -3.2f, STEEL_TOOL_MATERIAL, null, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_BOW = ITEMS.register("steel_bow", () -> new SteelBow(new Item.Properties().stacksTo(1).durability(steelDurability).tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> STEEL_CROSSBOW = ITEMS.register("steel_crossbow", () -> new SteelCrossbow(new Item.Properties().stacksTo(1).durability(steelDurability).tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new TitaniumSword(TITANIUM_TOOL_MATERIAL, 5, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new TitaniumPickaxe(TITANIUM_TOOL_MATERIAL, 3, -2.8f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new TitaniumAxe(TITANIUM_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new TitaniumShovel(TITANIUM_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(TITANIUM_TOOL_MATERIAL, -2, -1.5f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer", () -> new TitaniumHammer(TITANIUM_TOOL_MATERIAL, 7, -3.3f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_EXCAVATOR = ITEMS.register("titanium_excavator", () -> new TitaniumExcavator(TITANIUM_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TITANIUM_PAXEL = ITEMS.register("titanium_paxel", () -> new TitaniumPaxel(7, -3.2f, TITANIUM_TOOL_MATERIAL, null, new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> HARDENED_STEEL_SWORD = ITEMS.register("hardened_steel_sword", () -> new HardenedSteelSword(HARDENED_STEEL_TOOL_MATERIAL, 5, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_PICKAXE = ITEMS.register("hardened_steel_pickaxe", () -> new HardenedSteelPickaxe(HARDENED_STEEL_TOOL_MATERIAL, 3, -2.8f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_AXE = ITEMS.register("hardened_steel_axe", () -> new HardenedSteelAxe(HARDENED_STEEL_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_SHOVEL = ITEMS.register("hardened_steel_shovel", () -> new HardenedSteelShovel(HARDENED_STEEL_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_HOE = ITEMS.register("hardened_steel_hoe", () -> new HoeItem(HARDENED_STEEL_TOOL_MATERIAL,  -2, -1.5f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_HAMMER = ITEMS.register("hardened_steel_hammer", () -> new HardenedSteelHammer(HARDENED_STEEL_TOOL_MATERIAL,  7, -3.3f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_EXCAVATOR = ITEMS.register("hardened_steel_excavator", () -> new HardenedSteelExcavator(HARDENED_STEEL_TOOL_MATERIAL,  3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_PAXEL = ITEMS.register("hardened_steel_paxel", () -> new HardenedSteelPaxel(7, -3.2f, HARDENED_STEEL_TOOL_MATERIAL, null, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_BOW = ITEMS.register("hardened_steel_bow", () -> new SteelBow(new Item.Properties().stacksTo(1).durability(hardenedSteelDurability).tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> HARDENED_STEEL_CROSSBOW = ITEMS.register("hardened_steel_crossbow", () -> new SteelCrossbow(new Item.Properties().stacksTo(1).durability(hardenedSteelDurability).tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SWORD = ITEMS.register("tungsten_carbide_sword", () -> new TungstenCarbideSword(TUNGSTEN_TOOL_MATERIAL, 5, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PICKAXE = ITEMS.register("tungsten_carbide_pickaxe", () -> new TungstenCarbidePickaxe(TUNGSTEN_TOOL_MATERIAL, 5, -2.4f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_AXE = ITEMS.register("tungsten_carbide_axe", () -> new TungstenCarbideAxe(TUNGSTEN_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_TREE_AXE = ITEMS.register("tungsten_carbide_tree_axe", () -> new TungstenCarbideTreeAxe(TUNGSTEN_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_SHOVEL = ITEMS.register("tungsten_carbide_shovel", () -> new TungstenCarbideShovel(TUNGSTEN_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HOE = ITEMS.register("tungsten_carbide_hoe", () -> new HoeItem(TUNGSTEN_TOOL_MATERIAL, -2, -1.5f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_HAMMER = ITEMS.register("tungsten_carbide_hammer", () -> new TungstenCarbideHammer(TUNGSTEN_TOOL_MATERIAL, 7, -3.3f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_EXCAVATOR = ITEMS.register("tungsten_carbide_excavator", () -> new TungstenCarbideExcavator(TUNGSTEN_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PAXEL = ITEMS.register("tungsten_carbide_paxel", () -> new TungstenCarbidePaxel(7, -3.2f, TUNGSTEN_TOOL_MATERIAL, null, new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> ARMOR_BRONZE_HEAD = ITEMS.register("armor_bronze_head", () -> new ArmorBronze(BRONZE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_BRONZE_BODY = ITEMS.register("armor_bronze_body", () -> new ArmorBronze(BRONZE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_BRONZE_LEGGINGS = ITEMS.register("armor_bronze_leggings", () -> new ArmorBronze(BRONZE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_BRONZE_BOOTS = ITEMS.register("armor_bronze_boots", () -> new ArmorBronze(BRONZE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasySteel.easy_steel)));

	public static final RegistryObject<Item> ARMOR_STEEL_HEAD = ITEMS.register("armor_steel_head", () -> new ArmorSteel(STEEL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_STEEL_BODY = ITEMS.register("armor_steel_body", () -> new ArmorSteel(STEEL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_STEEL_LEGGINGS = ITEMS.register("armor_steel_leggings", () -> new ArmorSteel(STEEL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_STEEL_BOOTS = ITEMS.register("armor_steel_boots", () -> new ArmorSteel(STEEL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> ARMOR_TITANIUM_HEAD = ITEMS.register("armor_titanium_head", () -> new ArmorTitanium(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TITANIUM_BODY = ITEMS.register("armor_titanium_body", () -> new ArmorTitanium(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TITANIUM_LEGGINGS = ITEMS.register("armor_titanium_leggings", () -> new ArmorTitanium(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TITANIUM_BOOTS = ITEMS.register("armor_titanium_boots", () -> new ArmorTitanium(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> ARMOR_HARDENED_STEEL_HEAD = ITEMS.register("armor_hardened_steel_head", () -> new ArmorHardenedSteel(HARDENED_STEEL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_HARDENED_STEEL_BODY = ITEMS.register("armor_hardened_steel_body", () -> new ArmorHardenedSteel(HARDENED_STEEL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_HARDENED_STEEL_LEGGINGS = ITEMS.register("armor_hardened_steel_leggings", () -> new ArmorHardenedSteel(HARDENED_STEEL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_HARDENED_STEEL_BOOTS = ITEMS.register("armor_hardened_steel_boots", () -> new ArmorHardenedSteel(HARDENED_STEEL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasySteel.easy_steel)));
	
	public static final RegistryObject<Item> ARMOR_TUNGSTEN_CARBIDE_HEAD = ITEMS.register("armor_tungsten_carbide_head", () -> new ArmorTungstenCarbide(TUNGSTEN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TUNGSTEN_CARBIDE_BODY = ITEMS.register("armor_tungsten_carbide_body", () -> new ArmorTungstenCarbide(TUNGSTEN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TUNGSTEN_CARBIDE_LEGGINGS = ITEMS.register("armor_tungsten_carbide_leggings", () -> new ArmorTungstenCarbide(TUNGSTEN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasySteel.easy_steel)));
	public static final RegistryObject<Item> ARMOR_TUNGSTEN_CARBIDE_BOOTS = ITEMS.register("armor_tungsten_carbide_boots", () -> new ArmorTungstenCarbide(TUNGSTEN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasySteel.easy_steel)));
}
