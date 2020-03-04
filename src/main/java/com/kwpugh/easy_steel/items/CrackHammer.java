package com.kwpugh.easy_steel.items;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.util.GeneralModConfig;

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
import net.minecraft.item.PickaxeItem;
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
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stackIn)
    {
    	ItemStack stack = stackIn.copy();
    	stack.setDamage(getDamage(stack) + 1);

        return stack;
    }	
    
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
		Block block = state.getBlock();		

		String blockForgeTags = block.getTags().toString(); 
		int drops = 0;	
     
		if (!worldIn.isRemote)
		{		     
			double chance = random.nextDouble();
 
			//Determine the # of drops for a given block break
			if(chance <= GeneralModConfig.STONE_DROP_CHANCE.get())  
			{
				if(blockForgeTags.contains("forge:ores") || blockForgeTags.contains("forge:stone") || block == Blocks.STONE)
				{
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.STONE_POWDER.get(), 2)));     		 
				}
			}
			else if(chance <= GeneralModConfig.ONE_DROP_CHANCE.get())  
			{
				drops = 1;
			}
			else if(chance <= GeneralModConfig.TWO_DROP_CHANCE.get())  
			{
				drops = 2;
			}
			else   
			{
				drops = 3;
			}

			if(block == Blocks.LAPIS_ORE)
			{
		        stack.damageItem(1, entityLiving, (p_220038_0_) -> {
		            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		        	});
		        
		        worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.LAPIS_LAZULI, drops)));  		         	 
			}
			
			if(block == Blocks.REDSTONE_ORE)
			{
		        stack.damageItem(1, entityLiving, (p_220038_0_) -> {
		            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		        	});
		        
		        worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.REDSTONE, drops)));  		         	 
			}
			
			if(block == Blocks.COAL_ORE)
			{
		        stack.damageItem(1, entityLiving, (p_220038_0_) -> {
		            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		        	});
		        
		        worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.CARBON.get(), drops)));  		         	 
			}
	    
			if(blockForgeTags.contains("forge:ores/iron"))  
			{
				stack.damageItem(1, entityLiving, (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
					});
	        
				worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.IRON_POWDER.get(), drops))); 
			}
		
			 if(blockForgeTags.contains("forge:ores/gold"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.GOLD_POWDER.get(), drops))); 
			 }
		
			 if(blockForgeTags.contains("forge:ores/diamond"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.DIAMOND_POWDER.get(), drops)));  
			 }
		
			 if(blockForgeTags.contains("forge:ores/emerald"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.EMERALD_POWDER.get(), drops))); 
			 }
			 
			 if(blockForgeTags.contains("forge:ores/copper") || blockForgeTags.contains("forge:ores/malachite"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.COPPER_POWDER.get(), drops)));  
			 }
			 
			 if(blockForgeTags.contains("forge:ores/tin"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TIN_POWDER.get(), drops))); 
			 }
			 
			 if(blockForgeTags.contains("forge:ores/titanium"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TITANIUM_POWDER.get(), drops))); 
			 }
			 
			 if(blockForgeTags.contains("forge:ores/tungsten"))
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						});
		        
					worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TUNGSTEN_POWDER.get(), drops))); 
			 }
			 
			 if(	!(block == Blocks.COAL_ORE) || 
					 !(block == Blocks.REDSTONE_ORE) ||
					 !(block == Blocks.LAPIS_ORE) ||
					 !(blockForgeTags.contains("forge:ores/iron")) || 
					 !(blockForgeTags.contains("forge:ores/gold")) || 
					 !(blockForgeTags.contains("forge:ores/diamond")) ||
					 !(blockForgeTags.contains("forge:ores/emerald"))  ||
					 !(blockForgeTags.contains("forge:ores/copper")) || 
					 !(blockForgeTags.contains("forge:ores/malachite")) ||
					 !(blockForgeTags.contains("forge:ores/tin")) ||
					 !(blockForgeTags.contains("forge:ores/titanium")) ||
					 !(blockForgeTags.contains("forge:ores/tungsten"))          ) 
			 {
					stack.damageItem(1, entityLiving, (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						}); 
			 }
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
		return repair.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.crack_hammer.line1").applyTextStyle(TextFormatting.GREEN)));
		tooltip.add((new TranslationTextComponent("item.easy_steel.crack_hammer.line2").applyTextStyle(TextFormatting.RED)));
	}
}
