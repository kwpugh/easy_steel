package com.kwpugh.easy_steel.init;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.items.CrackHammer;
import com.kwpugh.easy_steel.items.SteelHammer;
import com.kwpugh.easy_steel.items.SteelPaxel;
import com.kwpugh.easy_steel.lists.ArmorMaterialList;
import com.kwpugh.easy_steel.lists.ItemList;
import com.kwpugh.easy_steel.lists.ToolMaterialList;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
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
				ItemList.crack_hammer = new CrackHammer(ToolMaterialList.steel, 1, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("crack_hammer")),
				ItemList.carbon_chunk = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("carbon_chunk")),
						
				ItemList.carbon = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("carbon")),
				ItemList.raw_steel = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("raw_steel")),
				
				ItemList.steel_ingot = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_ingot")),
				
				ItemList.steel_plate = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_plate")),
				ItemList.steel_rod = new Item(new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_rod")),
				
				ItemList.steel_sword = new SwordItem(ToolMaterialList.steel, 5, -2.2f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_sword")),
				ItemList.steel_pickaxe = new PickaxeItem(ToolMaterialList.steel, 3, -2.7f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_pickaxe")),
				ItemList.steel_axe = new AxeItem(ToolMaterialList.steel, 7, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_axe")),
				ItemList.steel_shovel = new ShovelItem(ToolMaterialList.steel, 3, -3.0f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_shovel")),
				ItemList.steel_hoe = new HoeItem(ToolMaterialList.steel, -0.5f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hoe")),
						
				ItemList.steel_hammer = new SteelHammer(ToolMaterialList.steel, 7, -3.3f, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_hammer")),
				ItemList.steel_paxel = new SteelPaxel(7, -3.2f, ToolMaterialList.steel, null, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("steel_paxel")),
				
				ItemList.armor_steel_head = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.HEAD, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_head")),
				ItemList.armor_steel_body = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.CHEST, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_body")),
				ItemList.armor_steel_leggings = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.LEGS, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_leggings")),
				ItemList.armor_steel_boots = new ArmorItem(ArmorMaterialList.steel, EquipmentSlotType.FEET, new Item.Properties().group(EasySteel.easy_steel)).setRegistryName(location("armor_steel_boots"))
							
			);		
			EasySteel.logger.info("Items registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(EasySteel.modid, name);
		}
	}
}
