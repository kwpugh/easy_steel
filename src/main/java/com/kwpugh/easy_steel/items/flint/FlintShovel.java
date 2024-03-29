package com.kwpugh.easy_steel.items.flint;

import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class FlintShovel extends ShovelItem
{
	public FlintShovel(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
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
		return repair.getItem() == ItemInit.SHARP_FLINT.get();
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((Component.translatable("item.easy_steel.flint.line1").withStyle(ChatFormatting.GREEN)));
	}
}
