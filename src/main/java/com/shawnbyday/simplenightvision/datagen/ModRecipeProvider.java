package com.shawnbyday.simplenightvision.datagen;

import com.shawnbyday.simplenightvision.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_HELMET.get())
                .pattern("DDD")
                .pattern("ELE")
                .pattern("D D")
                .define('D', Items.DIAMOND)
                .define('E', Items.EMERALD)
                .define('L', Items.LEATHER)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ModItems.DIAMOND_HELMET), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
                ModItems.NETHERITE_HELMET.get())
                .unlocks("has_template", has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .unlocks("has_diamond_helmet", has(Items.DIAMOND_HELMET))
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(recipeOutput, "netherite_helmet");
    }
}
