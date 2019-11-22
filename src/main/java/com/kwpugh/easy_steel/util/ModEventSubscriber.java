package com.kwpugh.easy_steel.util;


import com.kwpugh.easy_steel.EasySteel;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/*
 * Inspired and adapted from Sinhika's code in NetherRocks
 * 
 */

@EventBusSubscriber(modid = EasySteel.modid, bus = EventBusSubscriber.Bus.FORGE )
public final class ModEventSubscriber
{
    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingHurtEvent(LivingAttackEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //Fall Damage
            if ((event.getSource() == DamageSource.FALL) &&
                ArmorUtil.isPlayerGotFallProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            } 
            
            //Fire & Lava
            if (((event.getSource() == DamageSource.IN_FIRE) ||
            		(event.getSource() == DamageSource.ON_FIRE) || 
            		(event.getSource() == DamageSource.LAVA)) && 
            		ArmorUtil.isPlayerGotFireProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            }
            
//            //Drowning
//            if ((event.getSource() == DamageSource.DROWN) &&
//                    ArmorUtil.isPlayerGotWaterBreathing(player))
//            {
//            	if (event.isCancelable()) event.setCanceled(true);
//            }
        } 
    }    

//    @SubscribeEvent
//    public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event)
//    {
//        PlayerEntity player = (PlayerEntity) event.player;
//        if(ArmorUtil.isPlayerGotFlight(player))
//        {
//            event.player.abilities.allowFlying = true;
//        }
//        
//        if(!ArmorUtil.isPlayerGotFlight(player))
//        {
//            if(event.player.abilities.isFlying)
//            {
//                event.player.abilities.isFlying = event.player.abilities.isCreativeMode ? true : false;
//                event.player.abilities.allowFlying = event.player.abilities.isCreativeMode ? true : false;
//            }
//        }
//    }	
} 