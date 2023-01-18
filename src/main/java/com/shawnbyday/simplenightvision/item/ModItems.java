package com.shawnbyday.simplenightvision.item;

import com.shawnbyday.simplenightvision.SimpleNightVision;
import com.shawnbyday.simplenightvision.item.custom.ModArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleNightVision.MOD_ID);

    public static final RegistryObject<Item> HELMET = ITEMS.register("helmet", () -> new ModArmorItem(ModArmorMaterials.HELMET, EquipmentSlot.HEAD, new Item.Properties() /* new Item.Properties().tab(ModCreativeModeTab.ENV_TAB) */));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}