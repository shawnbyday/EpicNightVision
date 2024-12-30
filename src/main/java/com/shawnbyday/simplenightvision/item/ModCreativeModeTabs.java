package com.shawnbyday.simplenightvision.item;

import com.shawnbyday.simplenightvision.SimpleNightVision;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleNightVision.MODID);

    public static final Supplier<CreativeModeTab> SIMPLE_NIGHT_VISION_TAB = CREATIVE_MODE_TAB.register("simple_night_vision_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHERITE_HELMET.get()))
                    .title(Component.translatable("creativemodetab.simplenightvision.simple_night_vision_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DIAMOND_HELMET);
                        output.accept(ModItems.NETHERITE_HELMET);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
