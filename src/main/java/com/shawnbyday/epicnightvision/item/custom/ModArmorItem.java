package com.shawnbyday.epicnightvision.item.custom;

import com.google.common.collect.ImmutableMap;
import com.shawnbyday.epicnightvision.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;
import java.util.Objects;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>()).put(ModArmorMaterials.GOGGLES, new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1)).build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasGogglesOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectGogglesOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectGogglesOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(), mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        } else {
            if(player.hasEffect(MobEffects.NIGHT_VISION)) {
                int duration = Objects.requireNonNull(player.getEffect(MobEffects.NIGHT_VISION)).getDuration();
                if (duration < 360) {
                    player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(), mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
                }
            }
        }
    }

    private boolean hasGogglesOn(Player player) {
        ItemStack goggles = player.getInventory().getArmor(3);

        return !goggles.isEmpty();
    }

    private boolean hasCorrectGogglesOn(ArmorMaterial material, Player player) {
        ArmorItem goggles = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return goggles.getMaterial() == material;
    }
}
