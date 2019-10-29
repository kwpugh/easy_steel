package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.items.BronzeHammer;
import com.kwpugh.easy_steel.items.BronzePaxel;
import com.kwpugh.easy_steel.items.CrackHammer;
import com.kwpugh.easy_steel.items.FlintHatchet;
import com.kwpugh.easy_steel.items.FlintHoe;
import com.kwpugh.easy_steel.items.FlintKnife;
import com.kwpugh.easy_steel.items.FlintMattock;
import com.kwpugh.easy_steel.items.FlintShovel;
import com.kwpugh.easy_steel.items.HandShovel;
import com.kwpugh.easy_steel.items.HardenedSteelHammer;
import com.kwpugh.easy_steel.items.HardenedSteelPaxel;
import com.kwpugh.easy_steel.items.SharpFlint;
import com.kwpugh.easy_steel.items.SteelHammer;
import com.kwpugh.easy_steel.items.SteelPaxel;
import com.kwpugh.easy_steel.items.TungstenCarbideHammer;
import com.kwpugh.easy_steel.items.TungstenCarbidePaxel;
import com.kwpugh.easy_steel.lists.ArmorMaterialList;
import com.kwpugh.easy_steel.lists.BlockList;
import com.kwpugh.easy_steel.lists.ItemList;
import com.kwpugh.easy_steel.lists.ToolMaterialList;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
				ItemList.sharp_flint = new SharpFlint(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("sharp_flint")),
				ItemList.hand_shovel = new HandShovel(ItemTier.WOOD, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hand_shovel")),
				
				ItemList.flint_mattock = new FlintMattock(ToolMaterialList.flint, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_mattock")),
				ItemList.flint_shovel = new FlintShovel(ToolMaterialList.flint, 1, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_shovel")),
				ItemList.flint_hatchet = new FlintHatchet(ToolMaterialList.flint, 5, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_hatchet")),
				ItemList.flint_knife = new FlintKnife(ToolMaterialList.flint, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_knife")),
				ItemList.flint_hoe = new FlintHoe(ToolMaterialList.flint, -1.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("flint_hoe")),
				
				ItemList.crack_hammer = new CrackHammer(ItemTier.IRON, 1, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("crack_hammer")),
						
				ItemList.cassiterite_ore = new BlockItem(BlockList.cassiterite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.cassiterite_ore.getRegistryName()),
				ItemList.bornite_ore = new BlockItem(BlockList.bornite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.bornite_ore.getRegistryName()),
				ItemList.wolframite_ore = new BlockItem(BlockList.wolframite_ore, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.wolframite_ore.getRegistryName()),
										
				ItemList.tin_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tin_powder")),
				ItemList.copper_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("copper_powder")),
				ItemList.carbon = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("carbon")),
				ItemList.iron_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("iron_powder")),
				ItemList.gold_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("gold_powder")),
				ItemList.diamond_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("diamond_powder")),
				ItemList.tungsten_powder = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_powder")),
						
				ItemList.raw_bronze = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_bronze")),
				ItemList.raw_steel = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_steel")),	
				ItemList.raw_hardened_steel = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_hardened_steel")),
				ItemList.raw_tungsten_carbide = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_tungsten_carbide")),
						
				ItemList.bronze_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_ingot")),
				ItemList.steel_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_ingot")),
				ItemList.hardened_steel_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_ingot")),
				ItemList.tungsten_carbide_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_ingot")),
				
				ItemList.bronze_block = new BlockItem(BlockList.bronze_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.bronze_block.getRegistryName()),
				ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.steel_block.getRegistryName()),
				ItemList.hardened_steel_block = new BlockItem(BlockList.hardened_steel_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.hardened_steel_block.getRegistryName()),
				ItemList.tungsten_carbide_block = new BlockItem(BlockList.tungsten_carbide_block, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(BlockList.tungsten_carbide_block.getRegistryName()),						
				
				ItemList.bronze_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_plate")),
				ItemList.steel_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_plate")),
				ItemList.hardened_steel_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_plate")),
				ItemList.tungsten_carbide_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_plate")),
						
				ItemList.bronze_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_rod")),
				ItemList.steel_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_rod")),
				ItemList.hardened_steel_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_rod")),
				ItemList.tungsten_carbide_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_rod")),
				
				ItemList.bronze_sword = new SwordItem(ToolMaterialList.bronze, 4, -2.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_sword")),
				ItemList.bronze_pickaxe = new PickaxeItem(ToolMaterialList.bronze, 2, -2.8f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_pickaxe")),
				ItemList.bronze_axe = new AxeItem(ToolMaterialList.bronze, 6, -3.1f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_axe")),
				ItemList.bronze_shovel = new ShovelItem(ToolMaterialList.bronze, 2, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_shovel")),
				ItemList.bronze_hoe = new HoeItem(ToolMaterialList.bronze, -1.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_hoe")),			
				ItemList.bronze_hammer = new BronzeHammer(ToolMaterialList.bronze, 6, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_hammer")),
				ItemList.bronze_paxel = new BronzePaxel(6, -3.2f, ToolMaterialList.bronze, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("bronze_paxel")),
						
				ItemList.steel_sword = new SwordItem(ToolMaterialList.steel, 5, -2.2f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_sword")),
				ItemList.steel_pickaxe = new PickaxeItem(ToolMaterialList.steel, 3, -2.7f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_pickaxe")),
				ItemList.steel_axe = new AxeItem(ToolMaterialList.steel, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_axe")),
				ItemList.steel_shovel = new ShovelItem(ToolMaterialList.steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_shovel")),
				ItemList.steel_hoe = new HoeItem(ToolMaterialList.steel, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hoe")),					
				ItemList.steel_hammer = new SteelHammer(ToolMaterialList.steel, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hammer")),
				ItemList.steel_paxel = new SteelPaxel(7, -3.2f, ToolMaterialList.steel, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_paxel")),				
						
				ItemList.hardened_steel_sword = new SwordItem(ToolMaterialList.hardened_steel, 5, -2.2f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_sword")),
				ItemList.hardened_steel_pickaxe = new PickaxeItem(ToolMaterialList.hardened_steel, 3, -2.2f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_pickaxe")),
				ItemList.hardened_steel_axe = new AxeItem(ToolMaterialList.hardened_steel, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_axe")),
				ItemList.hardened_steel_shovel = new ShovelItem(ToolMaterialList.hardened_steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_shovel")),
				ItemList.hardened_steel_hoe = new HoeItem(ToolMaterialList.hardened_steel, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_hoe")),
				ItemList.hardened_steel_hammer = new HardenedSteelHammer(ToolMaterialList.hardened_steel, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_hammer")),
				ItemList.hardened_steel_paxel = new HardenedSteelPaxel(7, -3.2f, ToolMaterialList.hardened_steel, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("hardened_steel_paxel")),
						
				ItemList.tungsten_carbide_sword = new SwordItem(ToolMaterialList.tungsten_carbide, 5, -2.2f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_sword")),
				ItemList.tungsten_carbide_pickaxe = new PickaxeItem(ToolMaterialList.tungsten_carbide, 3, -2.7f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_pickaxe")),
				ItemList.tungsten_carbide_axe = new AxeItem(ToolMaterialList.tungsten_carbide, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_axe")),
				ItemList.tungsten_carbide_shovel = new ShovelItem(ToolMaterialList.tungsten_carbide, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_shovel")),
				ItemList.tungsten_carbide_hoe = new HoeItem(ToolMaterialList.tungsten_carbide, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_hoe")),
				ItemList.tungsten_carbide_hammer = new TungstenCarbideHammer(ToolMaterialList.tungsten_carbide, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_hammer")),
				ItemList.tungsten_carbide_paxel = new TungstenCarbidePaxel(7, -3.2f, ToolMaterialList.tungsten_carbide, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("tungsten_carbide_paxel")),
						
				ItemList.armor_bronze_head = new ArmorItem(ArmorMaterialList.bronze, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_head")),
				ItemList.armor_bronze_body = new ArmorItem(ArmorMaterialList.bronze, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_body")),
				ItemList.armor_bronze_leggings = new ArmorItem(ArmorMaterialList.bronze, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_leggings")),
				ItemList.armor_bronze_boots = new ArmorItem(ArmorMaterialList.bronze, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_bronze_boots")),
						
				ItemList.armor_steel_head = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_head")),
				ItemList.armor_steel_body = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_body")),
				ItemList.armor_steel_leggings = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_leggings")),
				ItemList.armor_steel_boots = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_boots")),
				
				ItemList.armor_hardened_steel_head = new ArmorItem(ArmorMaterialList.hardened_steel, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_head")),
				ItemList.armor_hardened_steel_body = new ArmorItem(ArmorMaterialList.hardened_steel, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_body")),
				ItemList.armor_hardened_steel_leggings = new ArmorItem(ArmorMaterialList.hardened_steel, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_leggings")),
				ItemList.armor_hardened_steel_boots = new ArmorItem(ArmorMaterialList.hardened_steel, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_hardened_steel_boots")),
									
				ItemList.armor_tungsten_carbide_head = new ArmorItem(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_head")),
				ItemList.armor_tungsten_carbide_body = new ArmorItem(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_body")),
				ItemList.armor_tungsten_carbide_leggings = new ArmorItem(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_leggings")),
				ItemList.armor_tungsten_carbide_boots = new ArmorItem(ArmorMaterialList.tungsten_carbide, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_tungsten_carbide_boots"))
			);		
			EasySteel.logger.info("Items registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(EasySteel.modid, name);
		}
	}
}
