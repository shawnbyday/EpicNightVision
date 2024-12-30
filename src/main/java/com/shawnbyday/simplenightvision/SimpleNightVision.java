package com.shawnbyday.simplenightvision;

import com.shawnbyday.simplenightvision.item.ModCreativeModeTabs;
import com.shawnbyday.simplenightvision.item.ModItems;
// import org.slf4j.Logger;

// import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// This needs to match the value in META-INF/neoforge.mods.toml.
@Mod(SimpleNightVision.MODID)
public class SimpleNightVision {
    // Define the MODID for the rest of the project.
    public static final String MODID = "simplenightvision";
    // Connect to the NeoForge logger.
    // private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor that runs when the mod first loads.
    // NeoForge will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public SimpleNightVision(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading.
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (SimpleNightVision) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register Simple Night Vision creative mode tab.
        ModCreativeModeTabs.register(modEventBus);

        // Call ModItems.register method.
        ModItems.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the shawnbyday block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.DIAMOND_HELMET);
            event.accept(ModItems.NETHERITE_HELMET);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
