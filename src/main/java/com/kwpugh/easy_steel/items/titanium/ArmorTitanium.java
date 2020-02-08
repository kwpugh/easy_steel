package com.kwpugh.easy_steel.items.titanium;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.lists.ItemList;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorTitanium extends ArmorItem
{
	public ArmorTitanium(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}	
	
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		if(player instanceof PlayerEntity)
		{
			ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
			ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
			ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		    
		    //Full Set
	    	if(head.getItem() == ItemList.armor_titanium_head && 
	    			chest.getItem() == ItemList.armor_titanium_body && 
	    			legs.getItem() == ItemList.armor_titanium_leggings && 
	    			feet.getItem() == ItemList.armor_titanium_boots)
	    	{
				player.removeActivePotionEffect(Effects.POISON);
				player.removeActivePotionEffect(Effects.WEAKNESS);
				player.removeActivePotionEffect(Effects.SLOWNESS);
	    	}	
		    
		    //Helmet
		    if(head.getItem() == ItemList.armor_titanium_head)
			{
		    	//Unused			
			}
			else
			{
				//Unused
			}
		    
		    //Chestplate
		    if(chest.getItem() == ItemList.armor_titanium_body)
			{
		    	//Unused
			}
		    
		    //Leggings
		    if(legs.getItem() == ItemList.armor_titanium_leggings)
			{
		    	//Unused
			}
			else
			{
				//Unused
			}
		    
		    //Boots
		    if(feet.getItem() == ItemList.armor_titanium_boots)
			{
		    	//Unused
			}
			else
			{
				//Unused
			}		    	
		}
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.titanium_ingot;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.armor_titanium_full.line1").applyTextStyle(TextFormatting.GREEN)));
	}
}
