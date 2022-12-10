package com.shawnbyday.epicnightvision.item;

import com.shawnbyday.epicnightvision.EpicNightVision;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EpicNightVision.MOD_ID);

    public static final RegistryObject<Item> GOGGLES = ITEMS.register("goggles", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ENV_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
