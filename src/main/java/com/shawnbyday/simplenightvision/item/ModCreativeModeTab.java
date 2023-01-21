package com.shawnbyday.simplenightvision.item;

import com.shawnbyday.simplenightvision.SimpleNightVision;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimpleNightVision.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab ENV_TAB;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ENV_TAB = event.registerCreativeModeTab(new ResourceLocation(SimpleNightVision.MOD_ID, "simplenightvision_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.HELMET.get())).title(Component.translatable("simplenightvision_tab")).build());
    }
}