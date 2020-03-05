package com.kwpugh.easy_steel.items;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HandShovel extends ShovelItem
{

	public HandShovel(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
		Block block = state.getBlock();
		
		if(block == Blocks.GRAVEL)
		{
	        stack.damageItem(1, entityLiving, (p_220038_0_) -> {
	            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });
	        
	        double chance = random.nextDouble();
	        
	        if(chance <= .5)
	        {
	        	worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.SHARP_FLINT.get(), 1)));	
	        }
		}
		else
		{
		    stack.damageItem(1, entityLiving, (p_220038_0_) -> {
	            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });	
		}
	    
		return true;
	}	
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.OAK_PLANKS;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.hand_shovel.line1").applyTextStyle(TextFormatting.GREEN)));
	}
}
