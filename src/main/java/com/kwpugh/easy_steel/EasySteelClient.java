package com.kwpugh.easy_steel;

import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static net.minecraft.item.ItemModelsProperties.func_239418_a_;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = EasySteel.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EasySteelClient
{   
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
    	func_239418_a_(ItemInit.STEEL_BOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity) -> {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return livingEntity.getActiveItemStack() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getItemInUseCount()) / 20.0F;
            }
        });
        
    	func_239418_a_(ItemInit.STEEL_BOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);

    	func_239418_a_(ItemInit.HARDENED_STEEL_BOW.get(), new ResourceLocation("pull"), (itemStack, world, livingEntity) -> {
            if (livingEntity == null)
            {
                return 0.0F;
            }
            else
            {
                return livingEntity.getActiveItemStack() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getItemInUseCount()) / 20.0F;
            }
        });
        
    	func_239418_a_(ItemInit.HARDENED_STEEL_BOW.get(), new ResourceLocation("pulling"), (itemStack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);

    }
}
