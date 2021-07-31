package com.kwpugh.easy_steel.items.baseclasses;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import com.mojang.math.Quaternion;
import net.minecraft.world.phys.Vec3;
import com.mojang.math.Vector3f;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/*
 * Taken directly from CrossbowItem and customized a bit
 *
 */

public class CrossbowBase extends CrossbowItem
{
	static Random random = new Random();

	public CrossbowBase(Properties propertiesIn)
	{
		super(propertiesIn);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn)
	{
		ItemStack itemstack = playerIn.getItemInHand(handIn);

	    if (isCharged(itemstack))
	    {
		    fireProjectiles(worldIn, playerIn, handIn, itemstack, 5.5F, 0.0F);   // set inaccuracy to 0.0 and velocity to 5.5F
		    setCharged(itemstack, false);

		    return InteractionResultHolder.consume(itemstack);
	    }
	    else if (!playerIn.getProjectile(itemstack).isEmpty())
	    {
	    	if (!isCharged(itemstack))
	    	{
	            playerIn.startUsingItem(handIn);
	        }
	    		return InteractionResultHolder.consume(itemstack);
	    }
	    else
      	{
      		return InteractionResultHolder.fail(itemstack);
      	}
	}

	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
	{
		int i = this.getUseDuration(stack);  // Removing timeLeft creates a builtin Quickcharge
		//int i = this.getUseDuration(stack) - timeLeft;
	    float f = getCharge(i, stack);

	    if (f >= 0.6F && !isCharged(stack) && hasAmmo(entityLiving, stack)) //Had to reduce the test down from >= 1.0F because it was never reached
	    {
	         setCharged(stack, true);
	         SoundSource soundcategory = entityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
	         worldIn.playSound((Player)null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
	    }
	}

   public static void fireProjectiles(Level worldIn, LivingEntity shooter, InteractionHand handIn, ItemStack stack, float velocityIn, float inaccuracyIn)
   {
	   List<ItemStack> list = getChargedProjectiles(stack);
	   float[] afloat = getRandomSoundPitches(shooter.getRandom());

	   for(int i = 0; i < list.size(); ++i)
	   {
		   ItemStack itemstack = list.get(i);
		   boolean flag = shooter instanceof Player && ((Player)shooter).getAbilities().instabuild;
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

   private static void fireProjectile(Level worldIn, LivingEntity shooter, InteractionHand handIn, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle)
   {
	  if (!worldIn.isClientSide)
	  {
	     boolean flag = projectile.getItem() == Items.FIREWORK_ROCKET;
	     Projectile projectileentity;
	     if (flag)
	     {
	        projectileentity = new FireworkRocketEntity(worldIn, projectile, shooter, shooter.getX(), shooter.getEyeY() - (double)0.15F, shooter.getZ(), true);
	     }
	     else
	     {
	        projectileentity = createArrow(worldIn, shooter, crossbow, projectile);
	        if (isCreativeMode || projectileAngle != 0.0F)
	        {
	           ((AbstractArrow)projectileentity).pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
	        }
	     }

	     if (shooter instanceof CrossbowAttackMob)
	     {
	        CrossbowAttackMob icrossbowuser = (CrossbowAttackMob)shooter;
	        icrossbowuser.shootCrossbowProjectile(icrossbowuser.getTarget(), crossbow, projectileentity, projectileAngle);
	     }
	     else
	     {
	    	Vec3 vec3d1 = shooter.getUpVector(1.0F);
	        Quaternion quaternion = new Quaternion(new Vector3f(vec3d1), projectileAngle, true);
	        Vec3 vec3d = shooter.getViewVector(1.0F);
	        Vector3f vector3f = new Vector3f(vec3d);
	        vector3f.transform(quaternion);
	        projectileentity.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), velocity, inaccuracy);
	     }

	     crossbow.hurtAndBreak(flag ? 3 : 1, shooter, (p_220017_1_) -> {
	        p_220017_1_.broadcastBreakEvent(handIn);
	     });
	     worldIn.addFreshEntity((Entity)projectileentity);
	     worldIn.playSound((Player)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 1.0F, soundPitch);
	  }
   }

   private static AbstractArrow createArrow(Level worldIn, LivingEntity shooter, ItemStack crossbow, ItemStack ammo)
   {
	   ArrowItem arrowitem = (ArrowItem)(ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
	   AbstractArrow abstractarrowentity = arrowitem.createArrow(worldIn, ammo, shooter);

	   //Better than you average Crossbow
	   abstractarrowentity.setCritArrow(true);
	   abstractarrowentity.setSoundEvent(SoundEvents.CROSSBOW_HIT);
	   abstractarrowentity.setShotFromCrossbow(true);
	   abstractarrowentity.setPierceLevel((byte)5);

	   return abstractarrowentity;
   }

   private static void fireProjectilesAfter(Level worldIn, LivingEntity shooter, ItemStack stack)
   {
      if (shooter instanceof ServerPlayer)
      {
         ServerPlayer serverplayerentity = (ServerPlayer)shooter;
         if (!worldIn.isClientSide)
         {
            CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayerentity, stack);
         }

         serverplayerentity.awardStat(Stats.ITEM_USED.get(stack.getItem()));
      }

      clearProjectiles(stack);
   }

   private static void clearProjectiles(ItemStack stack)
   {
      CompoundTag compoundnbt = stack.getTag();
      if (compoundnbt != null)
      {
         ListTag listnbt = compoundnbt.getList("ChargedProjectiles", 9);
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
		CompoundTag compoundnbt = stack.getTag();

		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9))
		{
			ListTag listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			if (listnbt != null)
			{
				for(int i = 0; i < listnbt.size(); ++i)
				{
					CompoundTag compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.of(compoundnbt1));
				}
			}
		}

		return list;
	}

   public static void setCharged(ItemStack stack, boolean chargedIn)
   {
	  CompoundTag compoundnbt = stack.getOrCreateTag();
	  compoundnbt.putBoolean("Charged", chargedIn);
   }

   public static boolean isCharged(ItemStack stack)
   {
      CompoundTag compoundnbt = stack.getTag();
      return compoundnbt != null && compoundnbt.getBoolean("Charged");
   }

   public int getUseDuration(ItemStack stack)
   {
      return getChargeTime(stack) + 3;
   }


   public static int getChargeTime(ItemStack stack)
   {
      int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
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
	   int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, stack);
	   int j = i == 0 ? 1 : 3;

	   boolean flag = entityIn instanceof Player && ((Player)entityIn).getAbilities().instabuild;

	   ItemStack itemstack = entityIn.getProjectile(stack);
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

		   if (!loadProjectile(entityIn, stack, itemstack, k > 0, flag))
		   {
			   return false;
		   }
	   }

	   return true;
   }

   private static boolean loadProjectile(LivingEntity p_220023_0_, ItemStack p_220023_1_, ItemStack p_220023_2_, boolean p_220023_3_, boolean p_220023_4_)
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

			   if (p_220023_2_.isEmpty() && p_220023_0_ instanceof Player)
			   {
				   ((Player)p_220023_0_).getInventory().removeItem(p_220023_2_);
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
	   CompoundTag compoundnbt = crossbow.getOrCreateTag();
	   ListTag listnbt;

	   if (compoundnbt.contains("ChargedProjectiles", 9))
	   {
         listnbt = compoundnbt.getList("ChargedProjectiles", 10);
       }
	   else
	   {
		   listnbt = new ListTag();
	   }
	   CompoundTag compoundnbt1 = new CompoundTag();
	   projectile.save(compoundnbt1);
	   listnbt.add(compoundnbt1);
	   compoundnbt.put("ChargedProjectiles", listnbt);
   }

   @Override
   public boolean isBookEnchantable(ItemStack stack, ItemStack book)
   {
	   return true;
   }

   @Override
   public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
   {
	   return repair.getItem() == ItemInit.STEEL_INGOT.get();
   }

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
}