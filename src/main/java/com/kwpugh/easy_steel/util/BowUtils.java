package com.kwpugh.easy_steel.util;

import com.kwpugh.easy_steel.items.baseclasses.CrossbowBase;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.event.ComputeFovModifierEvent;

import java.util.function.Predicate;

public final class BowUtils
{
    public static void setupBowFov(ComputeFovModifierEvent event, Predicate<Item> predicate, float zoomValue)
    {
        float oldFOV = event.getFovModifier();
        float newFOV = 1.0F;

        ItemStack stack = event.getPlayer().getMainHandItem();
        if (stack.isEmpty()) return;

        Item item = stack.getItem();
        int ticks = event.getPlayer().getTicksUsingItem();
        if (item instanceof BowItem && PlayerEquipsUtil.hasArrowInInventory(event.getPlayer()))
        {
            float zoom = 1.0F;
            if (predicate.test(item))
            {
                zoom = zoomValue;
            }
            else {
                return;
            }
            newFOV = oldFOV - (ticks * zoom / 20.0F);
            if (newFOV < oldFOV - zoom)
                newFOV = (oldFOV - zoom);
            event.setNewFovModifier(newFOV);
        }
    }

    //  standard bow
    public static void setupBowModelProperties(Item item)
    {
        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) -> {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);

    }

    // Crossbow
    public static void setupCrossbowModelProperties(Item item)
    {
        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) ->
        {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return CrossbowItem.isCharged(itemStack) ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / (float) CrossbowBase.getChargeDuration(itemStack);
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(item, new ResourceLocation("charged"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(item, new ResourceLocation("firework"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) && CrossbowItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }


}