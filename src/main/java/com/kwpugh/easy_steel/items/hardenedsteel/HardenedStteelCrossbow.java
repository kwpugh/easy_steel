package com.kwpugh.easy_steel.items.hardenedsteel;

import java.util.List;

import com.google.common.collect.Lists;
import com.kwpugh.easy_steel.lists.ItemList;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class HardenedStteelCrossbow extends CrossbowItem
{
	public HardenedStteelCrossbow(Properties propertiesIn)
	{
		super(propertiesIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	     
	    if (isCharged(itemstack))
	    {
		    fireProjectiles(worldIn, playerIn, handIn, itemstack, func_220013_l(itemstack), 0.0F);
		    setCharged(itemstack, false);

		    return ActionResult.func_226249_b_(itemstack);
	    }
	    else if (!playerIn.findAmmo(itemstack).isEmpty())
	    {
	    	if (!isCharged(itemstack))
	    	{
	            playerIn.setActiveHand(handIn);
	        }
	    		return ActionResult.func_226249_b_(itemstack);
	    }
	    else
      	{
      		return ActionResult.func_226251_d_(itemstack);
      	}
	}
	   
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
	{
		int i = this.getUseDuration(stack) - timeLeft;
	    float f = getCharge(i, stack);
	    
	    if (f >= 0.6F && !isCharged(stack) && hasAmmo(entityLiving, stack)) //Had to reduce the test down from >= 1.0F because it was never reached
	    {
	         setCharged(stack, true);
	         SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
	         worldIn.playSound((PlayerEntity)null, entityLiving.func_226277_ct_(), entityLiving.func_226278_cu_(), entityLiving.func_226281_cx_(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
	    }
	}
	      
	private static float func_220013_l(ItemStack p_220013_0_)
	{
		return p_220013_0_.getItem() == ItemList.steel_crossbow && hasChargedProjectile(p_220013_0_, Items.FIREWORK_ROCKET) ? 2.5F : 4.0F;
	}

	private static boolean hasChargedProjectile(ItemStack stack, Item ammoItem)
	{
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
	         return p_220010_1_.getItem() == ammoItem;
	      });
	}
	   
	private static List<ItemStack> getChargedProjectiles(ItemStack stack)
	{
		List<ItemStack> list = Lists.newArrayList();
		CompoundNBT compoundnbt = stack.getTag();
		
		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9))
		{
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			if (listnbt != null)
			{
				for(int i = 0; i < listnbt.size(); ++i)
				{
					CompoundNBT compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.read(compoundnbt1));
				}
			}
		}

		return list;
	}
	   
   public static void setCharged(ItemStack stack, boolean chargedIn)
   {
	  CompoundNBT compoundnbt = stack.getOrCreateTag();
	  compoundnbt.putBoolean("Charged", chargedIn);
   }
	   
   public static boolean isCharged(ItemStack stack)
   {
      CompoundNBT compoundnbt = stack.getTag();
      return compoundnbt != null && compoundnbt.getBoolean("Charged");
   }
	  
   public int getUseDuration(ItemStack stack)
   {
      return getChargeTime(stack) + 3;
   }
	   

   public static int getChargeTime(ItemStack stack)
   {
      int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
      //System.out.println(i);
      return i == 0 ? 25 : 25 - 5 * i;
   }
	      
   private static float getCharge(int useTime, ItemStack stack)
   {
      float f = (float)useTime / (float)getChargeTime(stack);
      if (f > 1.0F)
      {
         f = 1.0F;
      }
      
      return f;
   }
	   
   private static boolean hasAmmo(LivingEntity entityIn, ItemStack stack)
   {
	   int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, stack);
	   int j = i == 0 ? 1 : 3;
	   
	   boolean flag = entityIn instanceof PlayerEntity && ((PlayerEntity)entityIn).abilities.isCreativeMode;
	   
	   ItemStack itemstack = entityIn.findAmmo(stack);
	   ItemStack itemstack1 = itemstack.copy();

	   for(int k = 0; k < j; ++k)
	   {
		   if (k > 0)
		   {
			   itemstack = itemstack1.copy();
		   }
	
		   if (itemstack.isEmpty() && flag)
		   {
			   itemstack = new ItemStack(Items.ARROW);
			   itemstack1 = itemstack.copy();
		   }

		   if (!func_220023_a(entityIn, stack, itemstack, k > 0, flag))
		   {
			   return false;
		   }
	   }

	   return true;
   }
	      
   private static boolean func_220023_a(LivingEntity p_220023_0_, ItemStack p_220023_1_, ItemStack p_220023_2_, boolean p_220023_3_, boolean p_220023_4_)
   {
	   if (p_220023_2_.isEmpty())
	   {
		   return false;
	   }
	   else
	   {
		   boolean flag = p_220023_4_ && p_220023_2_.getItem() instanceof ArrowItem;
		   ItemStack itemstack;
		   
		   if (!flag && !p_220023_4_ && !p_220023_3_)
		   {
			   itemstack = p_220023_2_.split(1);
			   
			   if (p_220023_2_.isEmpty() && p_220023_0_ instanceof PlayerEntity)
			   {
				   ((PlayerEntity)p_220023_0_).inventory.deleteStack(p_220023_2_);
			   }
		   }
		   else
		   {
			   itemstack = p_220023_2_.copy();
		   }

		   addChargedProjectile(p_220023_1_, itemstack);
        
		   return true;
	   }
   }
	   
   private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile)
   {
	   CompoundNBT compoundnbt = crossbow.getOrCreateTag();
	   ListNBT listnbt;
	
	   if (compoundnbt.contains("ChargedProjectiles", 9))
	   {
         listnbt = compoundnbt.getList("ChargedProjectiles", 10);
       }
	   else
	   {
		   listnbt = new ListNBT();
	   }
	   CompoundNBT compoundnbt1 = new CompoundNBT();
	   projectile.write(compoundnbt1);
	   listnbt.add(compoundnbt1);
	   compoundnbt.put("ChargedProjectiles", listnbt);
   }
   
   @Override
   public boolean isBookEnchantable(ItemStack stack, ItemStack book)
   {
	   return true;
   }

   @Override
   public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
   {
	   return repair.getItem() == ItemList.steel_ingot;
   }
	
   @Override
   public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
   {
	   super.addInformation(stack, world, list, flag);				
	   list.add(new StringTextComponent(TextFormatting.GREEN + "A more accurate crossbow"));
	   list.add(new StringTextComponent(TextFormatting.BLUE + "NOTE: Has a shorter charge interval"));
   } 
}