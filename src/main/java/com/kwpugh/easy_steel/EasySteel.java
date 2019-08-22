package com.kwpugh.easy_steel;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kwpugh.easy_steel.group.GroupEasySteel;
import com.kwpugh.easy_steel.util.EasySteelConfig;
import com.kwpugh.easy_steel.world.OreGenerator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("easy_steel")
public class EasySteel
{

	public static final String modid = "easy_steel";
	public static final Logger logger = LogManager.getLogger(modid);	
	public static final ItemGroup easy_steel = new GroupEasySteel();

    public EasySteel()
    {
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, EasySteelConfig.SERVER_CONFIG);
		EasySteelConfig.loadConfig(EasySteelConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("easy_steel-general.toml"));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	OreGenerator.setupOregen();
    	
        logger.info("Mod preinit");
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    	logger.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

        InterModComms.sendTo("easy_steel", "helloworld", () -> { logger.info("Hello world from EasySteel"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

    	logger.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    	logger.info("Server starting");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {

        	logger.info("Blocks registered");
        }
    }
}
