package com.kwpugh.easy_steel.items;

import java.util.List;

import com.kwpugh.easy_steel.lists.BlockList;
import com.kwpugh.easy_steel.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

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
		 Direction direction = context.getFace();
		 
	     if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F)
		 {
	    	 stack.damageItem(1, player, (p_220038_0_) -> {
	         p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });
	     }
	      
	     if(block == Blocks.COAL_ORE)
	     {
	    	 world.removeBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.carbon_chunk, 2))); 
	    	 spawnSpecialEffect(world, pos);    	 
	     }

	     if(block == Blocks.IRON_ORE)
	     {
	    	 world.removeBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.iron_chunk, 2))); 
	    	 spawnSpecialEffect(world, pos);    	 
	     }
	     
	     if(block == Blocks.GOLD_ORE)
	     {
	    	 world.removeBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.gold_chunk, 2))); 
	    	 spawnSpecialEffect(world, pos);    	 
	     }
	     
	     if(block == BlockList.bornite_ore)
	     {
	    	 world.removeBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.copper_chunk, 3))); 
	    	 spawnSpecialEffect(world, pos);    	 
	     }
	     
	     if(block == BlockList.cassiterite_ore)
	     {
	    	 world.removeBlock(pos, false);
	    	 world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemList.tin_chunk, 2))); 
	    	 spawnSpecialEffect(world, pos);    	 
	     }

		 return ActionResultType.PASS;
	}
	
	public void spawnSpecialEffect(World world, BlockPos pos)
	{
		SilverfishEntity dummyEntity = EntityType.SILVERFISH.create(world);
		dummyEntity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        world.addEntity(dummyEntity);
        dummyEntity.spawnExplosionParticle();
        dummyEntity.remove();
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
	
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.GREEN + "Used to break various ores into chunks"));
		list.add(new StringTextComponent(TextFormatting.BLUE + "Right-click on ore to use"));

	} 
}
