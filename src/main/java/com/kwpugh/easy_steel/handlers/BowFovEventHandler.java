package com.kwpugh.easy_steel.handlers;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.items.baseclasses.BowBase;
import com.kwpugh.easy_steel.util.BowUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;


@EventBusSubscriber(modid= EasySteel.modid, bus=EventBusSubscriber.Bus.FORGE, value=Dist.CLIENT)
public class BowFovEventHandler
{
    static double zoom = GeneralModConfig.BOW_ZOOM.get();

    @SubscribeEvent
    public static void onFovEvent(ComputeFovModifierEvent event)
    {
        BowUtils.setupBowFov(event, p -> p instanceof BowBase, (float) zoom);
    }
}
