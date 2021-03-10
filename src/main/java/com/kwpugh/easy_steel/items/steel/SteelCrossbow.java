package com.kwpugh.easy_steel.items.steel;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/*
 * Taken directly from CrossbowItem and customized a bit
 * 
 */

public class SteelCrossbow extends CrossbowItem
{
	public SteelCrossbow(Properties propertiesIn)
	{
		super(propertiesIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	     
	    if (isCharged(itemstack))
	    {
		    fireProjectiles(worldIn, playerIn, handIn, itemstack, 5.5F, 0.0F);   // set inaccuracy to 0.0 and velocity to 5.5F
		    setCharged(itemstack, false);

		    return ActionResult.resultConsume(itemstack);
	    }
	    else if (!playerIn.findAmmo(itemstack).isEmpty())
	    {
	    	if (!isCharged(itemstack))
	    	{
	            playerIn.setActiveHand(handIn);
	        }
	    		return ActionResult.resultConsume(itemstack);
	    }
	    else
      	{
      		return ActionResult.resultFail(itemstack);
      	}
	}
	   
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
	{
		int i = this.getUseDuration(stack);  // Removing timeLeft creates a builtin Quickcharge
		//int i = this.getUseDuration(stack) - timeLeft;
	    float f = getCharge(i, stack);
	    
	    if (f >= 0.6F && !isCharged(stack) && hasAmmo(entityLiving, stack)) //Had to reduce the test down from >= 1.0F because it was never reached
	    {
	         setCharged(stack, true);
	         SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
	         worldIn.playSound((PlayerEntity)null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
	    }
	}

   public static void fireProjectiles(World worldIn, LivingEntity shooter, Hand handIn, ItemStack stack, float velocityIn, float inaccuracyIn)
   {
	   List<ItemStack> list = getChargedProjectiles(stack);
	   float[] afloat = getRandomSoundPitches(shooter.getRNG());

	   for(int i = 0; i < list.size(); ++i) 
	   {
		   ItemStack itemstack = list.get(i);
		   boolean flag = shooter instanceof PlayerEntity && ((PlayerEntity)shooter).abilities.isCreativeMode;
		   if (!itemstack.isEmpty())
		   {
			   if (i == 0) {
				   fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 0.0F);
			   }
			   else if (i == 1)
			   {
				   fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, -10.0F);
			   }
			   else if (i == 2)
			   {
				   fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 10.0F);
			   }
		   }
	   }

	   fireProjectilesAfter(worldIn, shooter, stack);
   }
   
   private static void fireProjectile(World worldIn, LivingEntity shooter, Hand handIn, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle)
   {
	  if (!worldIn.isRemote)
	  {
	     boolean flag = projectile.getItem() == Items.FIREWORK_ROCKET;
	     ProjectileEntity projectileentity;
	     if (flag)
	     {
	        projectileentity = new FireworkRocketEntity(worldIn, projectile, shooter, shooter.getPosX(), shooter.getPosYEye() - (double)0.15F, shooter.getPosZ(), true);
	     }
	     else
	     {
	        projectileentity = createArrow(worldIn, shooter, crossbow, projectile);
	        if (isCreativeMode || projectileAngle != 0.0F)
	        {
	           ((AbstractArrowEntity)projectileentity).pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
	        }
	     }
	
	     if (shooter instanceof ICrossbowUser)
	     {
	        ICrossbowUser icrossbowuser = (ICrossbowUser)shooter;
	        icrossbowuser.fireProjectile(icrossbowuser.getAttackTarget(), crossbow, projectileentity, projectileAngle);
	     }
	     else
	     {
	    	Vector3d vec3d1 = shooter.getUpVector(1.0F);
	        Quaternion quaternion = new Quaternion(new Vector3f(vec3d1), projectileAngle, true);
	        Vector3d vec3d = shooter.getLook(1.0F);
	        Vector3f vector3f = new Vector3f(vec3d);
	        vector3f.transform(quaternion);
	        projectileentity.shoot((double)vector3f.getX(), (double)vector3f.getY(), (double)vector3f.getZ(), velocity, inaccuracy);
	     }
	
	     crossbow.damageItem(flag ? 3 : 1, shooter, (p_220017_1_) -> {
	        p_220017_1_.sendBreakAnimation(handIn);
	     });
	     worldIn.addEntity((Entity)projectileentity);
	     worldIn.playSound((PlayerEntity)null, shooter.getPosX(), shooter.getPosY(), shooter.getPosZ(), SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
	  }
   }
	   
   private static AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter, ItemStack crossbow, ItemStack ammo) 
   {
	   ArrowItem arrowitem = (ArrowItem)(ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
	   AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, ammo, shooter);

	   //Better than you average Crossbow
	   abstractarrowentity.setIsCritical(true);
	   abstractarrowentity.setHitSound(SoundEvents.ITEM_CROSSBOW_HIT);
	   abstractarrowentity.setShotFromCrossbow(true);
	   abstractarrowentity.setPierceLevel((byte)5);

	   return abstractarrowentity;
   }
	 
   private static void fireProjectilesAfter(World worldIn, LivingEntity shooter, ItemStack stack)
   {
      if (shooter instanceof ServerPlayerEntity)
      {
         ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)shooter;
         if (!worldIn.isRemote)
         {
            CriteriaTriggers.SHOT_CROSSBOW.test(serverplayerentity, stack);
         }

         serverplayerentity.addStat(Stats.ITEM_USED.get(stack.getItem()));
      }

      clearProjectiles(stack);
   }
	   
   private static void clearProjectiles(ItemStack stack)
   {
      CompoundNBT compoundnbt = stack.getTag();
      if (compoundnbt != null)
      {
         ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 9);
         listnbt.clear();
         compoundnbt.put("ChargedProjectiles", listnbt);
      }
   }
	   
   private static float[] getRandomSoundPitches(Random rand)
   {
      boolean flag = rand.nextBoolean();
      return new float[]{1.0F, getRandomSoundPitch(flag), getRandomSoundPitch(!flag)};
   }

   private static float getRandomSoundPitch(boolean flagIn)
   {
      float f = flagIn ? 0.63F : 0.43F;
      return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
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
      return i == 0 ? 25 : 25 - 5 * i;
   }
	      
   private static float getCharge(int useTime, ItemStack stack)
   {
      float f = (float)useTime / (float)getChargeTime(stack);
      if (f > 0.6F)
      {
         f = 0.6F;
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
	   return repair.getItem() == ItemInit.STEEL_INGOT.get();
   }
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.easy_steel.crossbow.line1").mergeStyle(TextFormatting.GREEN)));
		tooltip.add((new TranslationTextComponent("item.easy_steel.crossbow.line2").mergeStyle(TextFormatting.AQUA)));
	}
}