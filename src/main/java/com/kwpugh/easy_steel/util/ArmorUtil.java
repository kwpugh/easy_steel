package com.kwpugh.easy_steel.util;
//
//
//import javax.annotation.Nonnull;
//
//import com.kwpugh.easy_steel.lists.ItemList;
//
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ItemStack;
//
///*
// * Inspired and adapted from Sinhika's code in NetherRocks
// * 
// */
//
//public final class ArmorUtil
//{
//    @Nonnull
//    @SuppressWarnings("ConstantConditions")
//    public static <T> T _null() {
//        return null;
//    }
//    
//    public static boolean isPlayerGotFallProtection(PlayerEntity player)
//    { 
//    	ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
//		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
//	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
//	    
//	    //Full Set or token
//    	if(		(head.getItem() == ItemList.armor_tungsten_carbide_head && 
//    			chest.getItem() == ItemList.armor_tungsten_carbide_body &&
//    			legs.getItem() == ItemList.armor_tungsten_carbide_leggings && 
//    			feet.getItem() == ItemList.armor_tungsten_carbide_boots)  )
//      	{
//      		return true;  		
//      	}
//      		
//        return false;
//    } 
//    
//    public static boolean isPlayerGotFireProtection(PlayerEntity player)
//    {
//    	ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
//		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
//	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
//    	
//	    //Full Set or token
//    	if(		((head.getItem() == ItemList.armor_hardened_steel_head && 
//    			chest.getItem() == ItemList.armor_hardened_steel_body &&
//    			legs.getItem() == ItemList.armor_hardened_steel_leggings && 
//    			feet.getItem() == ItemList.armor_hardened_steel_boots)) )
//      	{
//      		return true;  		
//      	}
//      		
//	    	return false;
//    }
//} 