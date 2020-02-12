package com.kwpugh.easy_steel.items;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrackHammer extends PickaxeItem
{
	Block block;
	
	public CrackHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context)
	{
		 World world = context.getWorld();
		 PlayerEntity player = context.getPlayer();
		 BlockPos pos = context.getPos();
		 BlockState state = world.getBlockState(pos);
		 Block block = state.getBlock();
		 ItemStack stack = context.getItem();
		 
		 
	     if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F)
		 {
	    	 stack.damageItem(1, player, (p_220038_0_) -> {
	         p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });
	     }

	     String blockForgeTags = block.getTags().toString();
	     
	     if(blockForgeTags.contains("forge:ores/copper") || blockForgeTags.contains("forge:ores/malachite"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);;
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.COPPER_POWDER.get(), 3))); 
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/tin"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TIN_POWDER.get(), 2)));    	 
	     }

	     if(blockForgeTags.contains("forge:ores/tungsten"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TUNGSTEN_POWDER.get(), 2)));  
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/titanium"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TITANIUM_POWDER.get(), 2)));  
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/coal"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.CARBON.get(), 2))); 
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:storage_blocks/coal") || blockForgeTags.contains("forge:storage_blocks/charcoal"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.CARBON.get(), 5))); 
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/iron"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.IRON_POWDER.get(), 2)));
	    	 return ActionResultType.SUCCESS;
	     }
	    
	     if(blockForgeTags.contains("forge:ores/gold"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.GOLD_POWDER.get(), 2)));   
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/diamond"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.DIAMOND_POWDER.get(), 2)));   
	    	 return ActionResultType.SUCCESS;
	     }
	     
	     if(blockForgeTags.contains("forge:ores/emerald"))
	     {
	    	 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.EMERALD_POWDER.get(), 2)));   
	    	 return ActionResultType.SUCCESS;
	     }
	
		 return ActionResultType.PASS;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.crack_hammer.line1").applyTextStyle(TextFormatting.GREEN)));
		tooltip.add((new TranslationTextComponent("item.easy_steel.crack_hammer.line2").applyTextStyle(TextFormatting.AQUA)));
	}
}
