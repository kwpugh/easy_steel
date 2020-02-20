package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.items.CrackHammer;
import com.kwpugh.easy_steel.items.HandShovel;
import com.kwpugh.easy_steel.items.SharpFlint;
import com.kwpugh.easy_steel.items.bronze.ArmorBronze;
import com.kwpugh.easy_steel.items.bronze.BronzeAxe;
import com.kwpugh.easy_steel.items.bronze.BronzeExcavator;
import com.kwpugh.easy_steel.items.bronze.BronzeHammer;
import com.kwpugh.easy_steel.items.bronze.BronzeHoe;
import com.kwpugh.easy_steel.items.bronze.BronzePaxel;
import com.kwpugh.easy_steel.items.bronze.BronzePickaxe;
import com.kwpugh.easy_steel.items.bronze.BronzeShovel;
import com.kwpugh.easy_steel.items.bronze.BronzeSword;
import com.kwpugh.easy_steel.items.flint.FlintHatchet;
import com.kwpugh.easy_steel.items.flint.FlintHoe;
import com.kwpugh.easy_steel.items.flint.FlintKnife;
import com.kwpugh.easy_steel.items.flint.FlintMattock;
import com.kwpugh.easy_steel.items.flint.FlintShovel;
import com.kwpugh.easy_steel.items.hardenedsteel.ArmorHardenedSteel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelAxe;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelExcavator;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelHammer;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelHoe;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelPaxel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelPickaxe;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelShovel;
import com.kwpugh.easy_steel.items.hardenedsteel.HardenedSteelSword;
import com.kwpugh.easy_steel.items.misc.IronLinks;
import com.kwpugh.easy_steel.items.powders.Carbon;
import com.kwpugh.easy_steel.items.steel.ArmorSteel;
import com.kwpugh.easy_steel.items.steel.SteelAxe;
import com.kwpugh.easy_steel.items.steel.SteelBow;
import com.kwpugh.easy_steel.items.steel.SteelCrossbow;
import com.kwpugh.easy_steel.items.steel.SteelExcavator;
import com.kwpugh.easy_steel.items.steel.SteelHammer;
import com.kwpugh.easy_steel.items.steel.SteelHoe;
import com.kwpugh.easy_steel.items.steel.SteelPaxel;
import com.kwpugh.easy_steel.items.steel.SteelPickaxe;
import com.kwpugh.easy_steel.items.steel.SteelShovel;
import com.kwpugh.easy_steel.items.steel.SteelSword;
import com.kwpugh.easy_steel.items.titanium.ArmorTitanium;
import com.kwpugh.easy_steel.items.titanium.TitaniumAxe;
import com.kwpugh.easy_steel.items.titanium.TitaniumExcavator;
import com.kwpugh.easy_steel.items.titanium.TitaniumHammer;
import com.kwpugh.easy_steel.items.titanium.TitaniumHoe;
import com.kwpugh.easy_steel.items.titanium.TitaniumPaxel;
import com.kwpugh.easy_steel.items.titanium.TitaniumPickaxe;
import com.kwpugh.easy_steel.items.titanium.TitaniumShovel;
import com.kwpugh.easy_steel.items.titanium.TitaniumSword;
import com.kwpugh.easy_steel.items.tungstencarbide.ArmorTungstenCarbide;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideAxe;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideExcavator;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideHammer;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideHoe;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbidePaxel;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbidePickaxe;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideShovel;
import com.kwpugh.easy_steel.items.tungstencarbide.TungstenCarbideSword;
import com.kwpugh.easy_steel.lists.ArmorMaterialList;
import com.kwpugh.easy_steel.lists.BlockList;
import com.kwpugh.easy_steel.lists.ItemList;
import com.kwpugh.easy_steel.lists.ToolMaterialList;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ItemInit
{
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.bornite_ore = new BlockItem(BlockList.bornite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.bornite_ore.getRegistryName()),
				ItemList.cassiterite_ore = new BlockItem(BlockList.cassiterite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.cassiterite_ore.getRegistryName()),
				ItemList.rutile_ore = new BlockItem(BlockList.rutile_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.rutile_ore.getRegistryName()),
				ItemList.wolframite_ore = new BlockItem(BlockList.wolframite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.wolframite_ore.getRegistryName()),
						
				ItemList.sharp_flint = new SharpFlint(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("sharp_flint")),
				ItemList.hand_shovel = new HandShovel(ItemTier.WOOD, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hand_shovel")),
				
				ItemList.flint_mattock = new FlintMattock(ToolMaterialList.flint, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_mattock")),
				ItemList.flint_shovel = new FlintShovel(ToolMaterialList.flint, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_shovel")),
				ItemList.flint_hatchet = new FlintHatchet(ToolMaterialList.flint, 5, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_hatchet")),
				ItemList.flint_knife = new FlintKnife(ToolMaterialList.flint, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_knife")),
				ItemList.flint_hoe = new FlintHoe(ToolMaterialList.flint, -1.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_hoe")),
				
				ItemList.crack_hammer = new CrackHammer(ItemTier.IRON, 1, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("crack_hammer")),
				
				ItemList.iron_links = new IronLinks(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("iron_links")),
				
				ItemList.stone_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("stone_powder")),
				ItemList.tin_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tin_powder")),
				ItemList.copper_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("copper_powder")),
				ItemList.carbon = new Carbon(new Item.Properties().group(EasySteel.easy_steel), "carbon", 600),
				ItemList.iron_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("iron_powder")),
				ItemList.gold_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("gold_powder")),
				ItemList.diamond_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("diamond_powder")),
				ItemList.emerald_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("emerald_powder")),
				ItemList.titanium_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_powder")),
				ItemList.tungsten_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_powder")),

				ItemList.copper_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("copper_ingot")),
				ItemList.tin_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tin_ingot")),
				ItemList.titanium_base_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_base_ingot")),
				ItemList.tungsten_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_ingot")),
				
				ItemList.raw_bronze = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_bronze")),
				ItemList.raw_steel = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_steel")),	
				ItemList.raw_titanium_alloy = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_titanium_alloy")),
				ItemList.raw_hardened_steel = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_hardened_steel")),
				ItemList.raw_tungsten_carbide = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_tungsten_carbide")),			

				ItemList.bronze_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_ingot")),
				ItemList.steel_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_ingot")),
				ItemList.titanium_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_ingot")),
				ItemList.hardened_steel_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_ingot")),
				ItemList.tungsten_carbide_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_ingot")),
								
				ItemList.bronze_block = new BlockItem(BlockList.bronze_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.bronze_block.getRegistryName()),
				ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.steel_block.getRegistryName()),
				ItemList.titanium_block = new BlockItem(BlockList.titanium_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.titanium_block.getRegistryName()),
				ItemList.hardened_steel_block = new BlockItem(BlockList.hardened_steel_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.hardened_steel_block.getRegistryName()),
				ItemList.tungsten_carbide_block = new BlockItem(BlockList.tungsten_carbide_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.tungsten_carbide_block.getRegistryName()),						
				
				ItemList.bronze_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_plate")),
				ItemList.steel_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_plate")),
				ItemList.titanium_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_plate")),
				ItemList.hardened_steel_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_plate")),
				ItemList.tungsten_carbide_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_plate")),
										
				ItemList.bronze_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_rod")),
				ItemList.steel_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_rod")),
				ItemList.titanium_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_rod")),
				ItemList.hardened_steel_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_rod")),
				ItemList.tungsten_carbide_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_rod")),
				
				
				ItemList.steel_string = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_string")),
				ItemList.hardened_steel_string = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_string")),
						
				ItemList.bronze_sword = new BronzeSword(ToolMaterialList.bronze, 4, -2.4f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_sword")),
				ItemList.bronze_pickaxe = new BronzePickaxe(ToolMaterialList.bronze, 2, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_pickaxe")),
				ItemList.bronze_axe = new BronzeAxe(ToolMaterialList.bronze, 6, -3.1f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_axe")),
				ItemList.bronze_shovel = new BronzeShovel(ToolMaterialList.bronze, 2, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_shovel")),			
				ItemList.bronze_hoe = new BronzeHoe(ToolMaterialList.bronze, -1.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_hoe")),			
				ItemList.bronze_hammer = new BronzeHammer(ToolMaterialList.bronze, 6, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_hammer")),
				ItemList.bronze_excavator = new BronzeExcavator(ToolMaterialList.bronze, 2, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_excavator")),
				ItemList.bronze_paxel = new BronzePaxel(6, -3.2f, ToolMaterialList.bronze, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_paxel")),
						
				ItemList.steel_sword = new SteelSword(ToolMaterialList.steel, 5, -2.4f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_sword")),
				ItemList.steel_pickaxe = new SteelPickaxe(ToolMaterialList.steel, 3, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_pickaxe")),
				ItemList.steel_axe = new SteelAxe(ToolMaterialList.steel, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_axe")),
				ItemList.steel_shovel = new SteelShovel(ToolMaterialList.steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_shovel")),
				ItemList.steel_hoe = new SteelHoe(ToolMaterialList.steel, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hoe")),					
				ItemList.steel_hammer = new SteelHammer(ToolMaterialList.steel, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hammer")),
				ItemList.steel_excavator = new SteelExcavator(ToolMaterialList.steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_excavator")),
				ItemList.steel_paxel = new SteelPaxel(7, -3.2f, ToolMaterialList.steel, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_paxel")),
				ItemList.steel_bow = new SteelBow((new Item.Properties()).maxStackSize(1).group(EasySteel.easy_steel).maxDamage(482)).setRegistryName(location("steel_bow")),
				ItemList.steel_crossbow = new SteelCrossbow((new Item.Properties()).maxStackSize(1).group(EasySteel.easy_steel).maxDamage(482)).setRegistryName(location("steel_crossbow")),
				
				ItemList.titanium_sword = new TitaniumSword(ToolMaterialList.titanium, 5, -2.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_sword")),
				ItemList.titanium_pickaxe = new TitaniumPickaxe(ToolMaterialList.titanium, 3, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_pickaxe")),
				ItemList.titanium_axe = new TitaniumAxe(ToolMaterialList.titanium, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_axe")),
				ItemList.titanium_shovel = new TitaniumShovel(ToolMaterialList.titanium, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_shovel")),
				ItemList.titanium_hoe = new TitaniumHoe(ToolMaterialList.titanium, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_hoe")),
				ItemList.titanium_hammer = new TitaniumHammer(ToolMaterialList.titanium, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_hammer")),
				ItemList.titanium_excavator = new TitaniumExcavator(ToolMaterialList.titanium, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_excavator")),
				ItemList.titanium_paxel = new TitaniumPaxel(7, -3.2f, ToolMaterialList.titanium, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("titanium_paxel")),
						
				ItemList.hardened_steel_sword = new HardenedSteelSword(ToolMaterialList.hardened_steel, 5, -2.4f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_sword")),
				ItemList.hardened_steel_pickaxe = new HardenedSteelPickaxe(ToolMaterialList.hardened_steel, 3, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_pickaxe")),
				ItemList.hardened_steel_axe = new HardenedSteelAxe(ToolMaterialList.hardened_steel, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_axe")),
				ItemList.hardened_steel_shovel = new HardenedSteelShovel(ToolMaterialList.hardened_steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_shovel")),
				ItemList.hardened_steel_hoe = new HardenedSteelHoe(ToolMaterialList.hardened_steel, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_hoe")),
				ItemList.hardened_steel_hammer = new HardenedSteelHammer(ToolMaterialList.hardened_steel, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_hammer")),
				ItemList.hardened_steel_excavator = new HardenedSteelExcavator(ToolMaterialList.hardened_steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_excavator")),
				ItemList.hardened_steel_paxel = new HardenedSteelPaxel(7, -3.2f, ToolMaterialList.hardened_steel, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_paxel")),
				ItemList.hardened_steel_bow = new SteelBow((new Item.Properties()).maxStackSize(1).group(EasySteel.easy_steel).maxDamage(816)).setRegistryName(location("hardened_steel_bow")),
				ItemList.hardened_steel_crossbow = new SteelCrossbow((new Item.Properties()).maxStackSize(1).group(EasySteel.easy_steel).maxDamage(816)).setRegistryName(location("hardened_steel_crossbow")),
						
				ItemList.tungsten_carbide_sword = new TungstenCarbideSword(ToolMaterialList.tungsten_carbide, 5, -2.4f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_sword")),
				ItemList.tungsten_carbide_pickaxe = new TungstenCarbidePickaxe(ToolMaterialList.tungsten_carbide, 3, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_pickaxe")),
				ItemList.tungsten_carbide_axe = new TungstenCarbideAxe(ToolMaterialList.tungsten_carbide, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_axe")),
				ItemList.tungsten_carbide_shovel = new TungstenCarbideShovel(ToolMaterialList.tungsten_carbide, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_shovel")),				
				ItemList.tungsten_carbide_hoe = new TungstenCarbideHoe(ToolMaterialList.tungsten_carbide, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_hoe")),
				ItemList.tungsten_carbide_hammer = new TungstenCarbideHammer(ToolMaterialList.tungsten_carbide, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_hammer")),
				ItemList.tungsten_carbide_excavator = new TungstenCarbideExcavator(ToolMaterialList.tungsten_carbide, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_excavator")),
				ItemList.tungsten_carbide_paxel = new TungstenCarbidePaxel(7, -3.2f, ToolMaterialList.tungsten_carbide, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_paxel")),
						
				ItemList.armor_bronze_head = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_head")),
				ItemList.armor_bronze_body = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_body")),
				ItemList.armor_bronze_leggings = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_leggings")),
				ItemList.armor_bronze_boots = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_boots")),
						
				ItemList.armor_steel_head = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_head")),
				ItemList.armor_steel_body = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_body")),
				ItemList.armor_steel_leggings = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_leggings")),
				ItemList.armor_steel_boots = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_boots")),
				
				ItemList.armor_titanium_head = new ArmorTitanium(ArmorMaterialList.titanium, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_titanium_head")),
				ItemList.armor_titanium_body = new ArmorTitanium(ArmorMaterialList.titanium, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_titanium_body")),
				ItemList.armor_titanium_leggings = new ArmorTitanium(ArmorMaterialList.titanium, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_titanium_leggings")),
				ItemList.armor_titanium_boots = new ArmorTitanium(ArmorMaterialList.titanium, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_titanium_boots")),
						
				ItemList.armor_hardened_steel_head = new ArmorHardenedSteel(ArmorMaterialList.hardened_steel, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_head")),
				ItemList.armor_hardened_steel_body = new ArmorHardenedSteel(ArmorMaterialList.hardened_steel, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_body")),
				ItemList.armor_hardened_steel_leggings = new ArmorHardenedSteel(ArmorMaterialList.hardened_steel, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_leggings")),
				ItemList.armor_hardened_steel_boots = new ArmorHardenedSteel(ArmorMaterialList.hardened_steel, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_boots")),
									
				ItemList.armor_tungsten_carbide_head = new ArmorTungstenCarbide(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_head")),
				ItemList.armor_tungsten_carbide_body = new ArmorTungstenCarbide(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_body")),
				ItemList.armor_tungsten_carbide_leggings = new ArmorTungstenCarbide(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_leggings")),
				ItemList.armor_tungsten_carbide_boots = new ArmorTungstenCarbide(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_boots"))
			);		
			EasySteel.logger.info("Easy Steel items registered.");
		}
		 
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(EasySteel.modid, name);
		}
	}
	
	
}
