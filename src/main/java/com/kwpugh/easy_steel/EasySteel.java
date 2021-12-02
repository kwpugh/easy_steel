package com.kwpugh.easy_steel;

import com.kwpugh.easy_steel.config.EasySteelConfig;
import com.kwpugh.easy_steel.group.GroupEasySteel;
import com.kwpugh.easy_steel.init.BlockInit;
import com.kwpugh.easy_steel.init.ItemInit;
import com.kwpugh.easy_steel.world.EasySteelConfiguredFeature;
import com.kwpugh.easy_steel.world.EasySteelPlacedFeature;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("easy_steel")
public class EasySteel
{
	public static final String modid = "easy_steel";
	public static final Logger logger = LogManager.getLogger(modid);
	public static final CreativeModeTab easy_steel = new GroupEasySteel();

    public EasySteel()
    {
		EasySteelConfig.loadConfig(EasySteelConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("easy_steel-general.toml"));
    	BlockInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        EasySteelConfiguredFeature.registerConfiguredFeatures();
        EasySteelPlacedFeature.registerPlacedFeatures();

        logger.info("EasySteel common setup complete");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
    	logger.info("EasySteel client setup complete");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("easy_steel", "hello world", () -> { logger.info("Hello world from EasySteel"); return "Hello world"; });
    }

    private void processIMC(final InterModProcessEvent event)
    {
    	logger.info("EasySteel IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    	logger.info("EasySteel server setup complete");
    }
}
