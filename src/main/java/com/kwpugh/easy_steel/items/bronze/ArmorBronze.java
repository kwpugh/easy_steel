package com.kwpugh.easy_steel.items.bronze;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.init.ItemInit;

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

public class ArmorBronze extends ArmorItem
{
	public ArmorBronze(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
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
	    	if(head.getItem() == ItemInit.ARMOR_BRONZE_HEAD.get() && 
	    			chest.getItem() == ItemInit.ARMOR_BRONZE_BODY.get() && 
	    			legs.getItem() == ItemInit.ARMOR_BRONZE_LEGGINGS.get() && 
	    			feet.getItem() == ItemInit.ARMOR_BRONZE_BOOTS.get())
	    	{
				player.removeActivePotionEffect(Effects.POISON);
	    	}	
		    
		    //Helmet
		    if(head.getItem() == ItemInit.ARMOR_BRONZE_HEAD.get())
			{
		    	//unused
			}
			else
			{
				//unused
			}
		    
		    //Chestplate
		    if(chest.getItem() == ItemInit.ARMOR_BRONZE_BODY.get())
			{
		    	//unused
			}
		    
		    //Leggings
		    if(legs.getItem() == ItemInit.ARMOR_BRONZE_LEGGINGS.get())
			{
		    	//unused
			}
			else
			{
				//unused
			}
		    
		    //Boots
		    if(feet.getItem() == ItemInit.ARMOR_BRONZE_BOOTS.get())
			{
		    	//unused
			}
			else
			{
				//unused
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
		return repair.getItem() == ItemInit.BRONZE_INGOT.get();
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.armor_bronze_full.line1").applyTextStyle(TextFormatting.GREEN)));
	}
}
