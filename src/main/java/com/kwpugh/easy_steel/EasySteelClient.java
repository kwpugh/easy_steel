package com.kwpugh.easy_steel;

import com.kwpugh.easy_steel.init.ItemInit;

import com.kwpugh.easy_steel.items.baseclasses.CrossbowBase;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = EasySteel.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EasySteelClient
{   
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
        // Steel Bow
    	ItemProperties.register(ItemInit.STEEL_BOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) -> {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(ItemInit.STEEL_BOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);


        //Hardened Steel Bow
        ItemProperties.register(ItemInit.HARDENED_STEEL_BOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) -> {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_BOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);


        // Steel Crossbow
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) ->
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
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("charged"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("firework"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) && CrossbowItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });


        // Hardened Steel Crossbow
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity, seed) ->
        {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return CrossbowItem.isCharged(itemStack) ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(itemStack);
            }
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("charged"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("firework"), (itemStack, world, livingEntity, seed) ->
        {
            return livingEntity != null && CrossbowItem.isCharged(itemStack) && CrossbowItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}
