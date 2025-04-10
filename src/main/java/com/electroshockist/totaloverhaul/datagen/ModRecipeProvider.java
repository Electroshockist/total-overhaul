package com.electroshockist.totaloverhaul.datagen;

import com.electroshockist.totaloverhaul.TotalOverhaul;
import com.electroshockist.totaloverhaul.block.ModBlocks;
import com.electroshockist.totaloverhaul.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUS_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TESTIMS.get())
                .unlockedBy(getHasName(ModItems.TESTIMS.get()), has(ModItems.TESTIMS.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TESTIMS.get(),9)
                .requires(ModBlocks.SUS_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SUS_BLOCK.get()),has(ModBlocks.SUS_BLOCK.get()))
                .save(pRecipeOutput, TotalOverhaul.MOD_ID + ":sus_to_sus_block");
    }
}
