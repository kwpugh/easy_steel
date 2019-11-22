package com.kwpugh.easy_steel.items.flint;

import java.util.List;

import com.kwpugh.easy_steel.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class FlintHatchet extends AxeItem
{
	public FlintHatchet(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
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
		 Direction direction = context.getFace();
		 
	     if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F)
		 {
	    	 stack.damageItem(1, player, (p_220038_0_) -> {
	         p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });
	     }
	      
	     if(block == Blocks.WHITE_WOOL ||
	    		 block == Blocks.BLACK_WOOL ||
	    		 block == Blocks.BLUE_WOOL ||
	    		 block == Blocks.BROWN_WOOL ||
	    		 block == Blocks.CYAN_WOOL ||
	    		 block == Blocks.GRAY_WOOL ||
	    		 block == Blocks.GREEN_WOOL ||
	    		 block == Blocks.LIGHT_BLUE_WOOL ||
	    		 block == Blocks.LIGHT_GRAY_WOOL ||
	    		 block == Blocks.LIME_WOOL ||
	    		 block == Blocks.MAGENTA_WOOL ||
	    		 block == Blocks.ORANGE_WOOL ||
	    		 block == Blocks.PINK_WOOL ||
	    		 block == Blocks.PURPLE_WOOL ||
	    		 block == Blocks.RED_WOOL ||
	    		 block == Blocks.YELLOW_WOOL
	    		 )
	     {
	    	 world.destroyBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STRING, 4)));    	 
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
		return repair.getItem() == ItemList.sharp_flint;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.GREEN + "A primitive tool for breaking wood"));
	} 
}