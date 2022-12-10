package com.shawnbyday.epicnightvision.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ENV_TAB = new CreativeModeTab("epicnightvision_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GOGGLES.get());
        }
    };
}
