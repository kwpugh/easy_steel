package com.kwpugh.easy_steel.util;

/*
 * Based on the work of Cadiboo
 */

//
//@Mod.EventBusSubscriber(modid = EasySteel.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
//public final class NewConfig
//{
//
//	/**
//	 * Called from inside the mod constructor.
//	 *
//	 * @param context The ModLoadingContext to register the configs to
//	 */
//	public static void register(final ModLoadingContext context)
//	{
//		context.registerConfig(ModConfig.Type.COMMON, Common.SPEC);
//		context.registerConfig(ModConfig.Type.CLIENT, Client.SPEC);
//		context.registerConfig(ModConfig.Type.SERVER, Server.SPEC);
//	}
//
//	@SubscribeEvent
//	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent)
//	{
//		final ForgeConfigSpec spec = configEvent.getConfig().getSpec();
//		if (spec == Common.SPEC)
//			Common.bake();
//		else if (spec == Client.SPEC)
//			Client.bake();
//		else if (spec == Server.SPEC)
//			Server.bake();
//
//	}
//
//	public static class Common
//	{
//
//		public static final ConfigImpl INSTANCE;
//		public static final ForgeConfigSpec SPEC;
//
//		
//		static
//		{
//			final Pair<ConfigImpl, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigImpl::new);
//			SPEC = specPair.getRight();
//			INSTANCE = specPair.getLeft();
//		}
//
//		public static void bake()
//		{
//			//baked values here
//		}
//
//		static class ConfigImpl
//		{
//
//			
//
//			private ConfigImpl(final ForgeConfigSpec.Builder builder)
//			{
//				//common config items here
//			}
//
//		}
//
//	}
//
//	public static class Client
//	{
//
//		public static final ConfigImpl INSTANCE;
//		public static final ForgeConfigSpec SPEC;
//		
//		static
//		{
//			final Pair<ConfigImpl, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigImpl::new);
//			SPEC = specPair.getRight();
//			INSTANCE = specPair.getLeft();
//		}
//
//		public static void bake()
//		{
//			//baked values here
//		}
//
//		static class ConfigImpl
//		{
//			
//			private ConfigImpl(final ForgeConfigSpec.Builder builder)
//			{
//
//				//client config things here
//			}
//		}
//	}
//
//	public static class Server
//	{
//		public static final ConfigImpl INSTANCE;
//		public static final ForgeConfigSpec SPEC;
//
//		public static boolean bornite_ore_generation;
//	    public static int bornite_ore_chance;
//	    public static int bornite_ore_size;
//	    public static int bornite_ore_min_height;
//	    public static int bornite_ore_max_height;
//	    
//	    public static boolean cassiterite_ore_generation;
//	    public static int cassiterite_ore_chance;
//	    public static int cassiterite_ore_size;
//	    public static int cassiterite_min_height;
//	    public static int cassiterite_max_height;
//	
//	    public static boolean wolframite_ore_generation;
//	    public static int wolframite_ore_chance;
//	    public static int wolframite_ore_size;
//	    public static int wolframite_min_height;
//	    public static int wolframite_max_height;
//
//	    public static boolean rutile_ore_generation;
//	    public static int rutile_ore_chance;
//	    public static int rutile_ore_size;
//	    public static int rutile_min_height;
//	    public static int rutile_max_height;
//		
//		static
//		{
//			final Pair<ConfigImpl, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigImpl::new);
//			SPEC = specPair.getRight();
//			INSTANCE = specPair.getLeft();
//		}
//
//		public static void bake()
//		{
//			bornite_ore_generation = INSTANCE.bornite_ore_generation.get();
//			bornite_ore_chance = INSTANCE.bornite_ore_chance.get();
//			bornite_ore_size = INSTANCE.bornite_ore_size.get();
//			bornite_ore_min_height = INSTANCE.bornite_ore_min_height.get();
//			bornite_ore_max_height = INSTANCE.bornite_ore_max_height.get();
//
//			cassiterite_ore_generation = INSTANCE.cassiterite_ore_generation.get();
//			cassiterite_ore_chance = INSTANCE.cassiterite_ore_chance.get();
//			cassiterite_ore_size = INSTANCE.cassiterite_ore_size.get();
//			cassiterite_min_height = INSTANCE.cassiterite_min_height.get();
//			cassiterite_max_height = INSTANCE.cassiterite_max_height.get();
//			
//			wolframite_ore_generation = INSTANCE.wolframite_ore_generation.get();
//			wolframite_ore_chance = INSTANCE.wolframite_ore_chance.get();
//			wolframite_ore_size = INSTANCE.wolframite_ore_size.get();
//			wolframite_min_height = INSTANCE.wolframite_min_height.get();
//			wolframite_max_height = INSTANCE.wolframite_max_height.get();
//			
//			rutile_ore_generation = INSTANCE.rutile_ore_generation.get();
//			rutile_ore_chance = INSTANCE.rutile_ore_chance.get();
//			rutile_ore_size = INSTANCE.rutile_ore_size.get();
//			rutile_min_height = INSTANCE.rutile_min_height.get();
//			rutile_max_height = INSTANCE.rutile_max_height.get();
//		}
//
//		static class ConfigImpl
//		{
//			final BooleanValue bornite_ore_generation;
//		    final IntValue bornite_ore_chance;
//		    final IntValue bornite_ore_size;
//		    final IntValue bornite_ore_min_height;
//		    final IntValue bornite_ore_max_height;
//		
//		    final BooleanValue cassiterite_ore_generation;
//		    final IntValue cassiterite_ore_chance;
//		    final IntValue cassiterite_ore_size;
//		    final IntValue cassiterite_min_height;
//		    final IntValue cassiterite_max_height;
//
//		    final BooleanValue wolframite_ore_generation;
//		    final IntValue wolframite_ore_chance;
//		    final IntValue wolframite_ore_size;
//		    final IntValue wolframite_min_height;
//		    final IntValue wolframite_max_height;
//		
//		    final BooleanValue rutile_ore_generation;
//		    final IntValue rutile_ore_chance;
//		    final IntValue rutile_ore_size;
//		    final IntValue rutile_min_height;
//		    final IntValue rutile_max_height;
//		    
//			private ConfigImpl(final ForgeConfigSpec.Builder builder)
//			{
//				builder.comment("Bornite Ore Generation").push("bornite_ore");
//				
//			    bornite_ore_generation = builder.comment("Generate Bornite Ore in the world [true / false]").define("borniteOreGeneration", true);
//			    bornite_ore_size = builder.comment("Size of Bornite Ore pockets [0-100, default: 12]").defineInRange("borniteOreSize", 12, 0, 100);
//		        bornite_ore_chance = builder.comment("Chances of Bornite Ore pocket being generated [0-100, default: 25]").defineInRange("borniteOreChance", 25, 0, 100);
//		        bornite_ore_min_height = builder.comment("Minimal height for Bornite Ore pocket generation, [0-255, default: 1]").defineInRange("borniteOreMinHeight", 1, 0, 255);
//		        bornite_ore_max_height = builder.comment("Maximal height for Bornite Ore pocket generation [0-255, default: 200]").defineInRange("borniteOreMaxHeight", 200, 0, 255);
//		        
//		        builder.pop();
//		        
//		        builder.comment("Cassiterite Ore Generation").push("cassiterite_ore");
//		        
//		        cassiterite_ore_generation = builder.comment("Generate Cassiterite Ore in the world [true / false]").define("cassiteriteOreGeneration", true);
//		        cassiterite_ore_size = builder.comment("Size of Cassiterite Ore pockets [0-100, default: 9]").defineInRange("cassiteriteOreSize", 9, 0, 100);
//		        cassiterite_ore_chance = builder.comment("Chances of Cassiterite Ore pocket being generated [0-100, default: 25]").defineInRange("cassiteriteOreChance", 25, 0, 100);
//		        cassiterite_min_height = builder.comment("Minimal height for Cassiterite Ore pocket generation, [0-255, default: 1]").defineInRange("cassiteriteOreMinHeight", 1, 0, 255);
//		        cassiterite_max_height = builder.comment("Maximal height for Cassiterite Ore pocket generation [0-255, default: 200]").defineInRange("cassiteriteOreMaxHeight", 200, 0, 255);
//		        
//		        builder.pop();
//		        
//		        builder.comment("Wolframite Ore Generation").push("wolframite_ore");
//		        
//		        wolframite_ore_generation = builder.comment("Generate Wolframite Ore in the world [true / false]").define("wolframiteOreGeneration", true);
//		        wolframite_ore_size = builder.comment("Size of Wolframite Ore pockets [0-100, default: 5]").defineInRange("wolframiteOreSize", 4, 0, 100);
//		        wolframite_ore_chance = builder.comment("Chances of Wolframite Ore pocket being generated [0-100, default: 6]").defineInRange("wolframiteOreChance", 4, 0, 100);
//		        wolframite_min_height = builder.comment("Minimal height for Wolframite Ore pocket generation, [0-255, default: 1]").defineInRange("wolframiteOreMinHeight", 1, 0, 255);
//		        wolframite_max_height = builder.comment("Maximal height for Wolframite Ore pocket generation [0-255, default: 200]").defineInRange("wolframiteOreMaxHeight", 15, 0, 255);
//		        
//		        builder.pop();
//		        
//		        builder.comment("Rutile Ore Generation").push("rutile");
//		        
//		        rutile_ore_generation = builder.comment("Generate Rutile Ore in the world [true / false]").define("rutileOreGeneration", true);
//		        rutile_ore_size = builder.comment("Size of Rutile Ore pockets [0-100, default: 5]").defineInRange("rutileOreSize", 4, 0, 100);
//		        rutile_ore_chance = builder.comment("Chances of Rutile Ore pocket being generated [0-100, default: 6]").defineInRange("rutileOreChance", 4, 0, 100);
//		        rutile_min_height = builder.comment("Minimal height for Rutile Ore pocket generation, [0-255, default: 1]").defineInRange("rutileOreMinHeight", 1, 0, 255);
//		        rutile_max_height = builder.comment("Maximal height for Rutile Ore pocket generation [0-255, default: 200]").defineInRange("rutileOreMaxHeight", 15, 0, 255);
//		        
//		        builder.pop();
//			}
//		}
//	}