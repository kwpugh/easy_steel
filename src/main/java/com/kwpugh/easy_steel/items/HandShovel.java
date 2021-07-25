package com.kwpugh.easy_steel.items;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class HandShovel extends ShovelItem
{
	public HandShovel(Tier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
		Block block = state.getBlock();
		
		if(block == Blocks.GRAVEL)
		{
	        stack.hurtAndBreak(1, entityLiving, (p_220038_0_) -> {
	            p_220038_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
	         });
	        
	        double chance = worldIn.random.nextDouble();
	        
	        if(chance <= .5)
	        {
	        	worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.SHARP_FLINT.get(), 1)));	
	        }
		}
		else
		{
		    stack.hurtAndBreak(1, entityLiving, (p_220038_0_) -> {
	            p_220038_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
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
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.OAK_PLANKS;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslatableComponent("item.easy_steel.hand_shovel.line1").withStyle(ChatFormatting.GREEN)));
	}
}
