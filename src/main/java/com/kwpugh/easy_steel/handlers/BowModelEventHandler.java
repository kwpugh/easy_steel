package com.kwpugh.easy_steel.handlers;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.util.BowUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EasySteel.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BowModelEventHandler
{
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
        BowUtils.setupBowModelProperties(ItemInit.STEEL_BOW.get());
        BowUtils.setupBowModelProperties(ItemInit.HARDENED_STEEL_BOW.get());

        BowUtils.setupCrossbowModelProperties((ItemInit.STEEL_CROSSBOW.get()));
        BowUtils.setupCrossbowModelProperties((ItemInit.HARDENED_STEEL_CROSSBOW.get()));
    }
}
