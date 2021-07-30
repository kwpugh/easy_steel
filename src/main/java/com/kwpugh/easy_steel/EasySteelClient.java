package com.kwpugh.easy_steel;

import com.kwpugh.easy_steel.init.ItemInit;

import com.kwpugh.easy_steel.items.steel.SteelCrossbow;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
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
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("pull"), (p_174620_, p_174621_, p_174622_, p_174623_) ->
        {
            if (p_174622_ == null)
            {
                return 0.0F;
            }
            else
            {
                return SteelCrossbow.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getUseDuration() - p_174622_.getUseItemRemainingTicks()) / (float)SteelCrossbow.getChargeDuration(p_174620_);
            }
        });
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("pulling"), (p_174615_, p_174616_, p_174617_, p_174618_) ->
        {
            return p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getUseItem() == p_174615_ && !SteelCrossbow.isCharged(p_174615_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) ->
        {
            return p_174612_ != null && SteelCrossbow.isCharged(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.STEEL_CROSSBOW.get(), new ResourceLocation("firework"), (p_174605_, p_174606_, p_174607_, p_174608_) ->
        {
            return p_174607_ != null && SteelCrossbow.isCharged(p_174605_) && SteelCrossbow.containsChargedProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });


        // Hardened Steel Crossbow
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("pull"), (p_174620_, p_174621_, p_174622_, p_174623_) ->
        {
            if (p_174622_ == null)
            {
                return 0.0F;
            }
            else
            {
                return SteelCrossbow.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getUseDuration() - p_174622_.getUseItemRemainingTicks()) / (float)SteelCrossbow.getChargeDuration(p_174620_);
            }
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("pulling"), (p_174615_, p_174616_, p_174617_, p_174618_) ->
        {
            return p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getUseItem() == p_174615_ && !SteelCrossbow.isCharged(p_174615_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) ->
        {
            return p_174612_ != null && SteelCrossbow.isCharged(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.HARDENED_STEEL_CROSSBOW.get(), new ResourceLocation("firework"), (p_174605_, p_174606_, p_174607_, p_174608_) ->
        {
            return p_174607_ != null && SteelCrossbow.isCharged(p_174605_) && SteelCrossbow.containsChargedProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}
