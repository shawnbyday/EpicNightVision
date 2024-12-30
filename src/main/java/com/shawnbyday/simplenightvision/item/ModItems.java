package com.shawnbyday.simplenightvision.item;

import com.shawnbyday.simplenightvision.SimpleNightVision;
import com.shawnbyday.simplenightvision.item.custom.ModArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleNightVision.MODID);

    public static final DeferredItem<ArmorItem> DIAMOND_HELMET = ITEMS.register("diamond_helmet",
            () -> new ModArmorItem(ModArmorMaterials.DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));
    public static final DeferredItem<ArmorItem> NETHERITE_HELMET = ITEMS.register("netherite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
