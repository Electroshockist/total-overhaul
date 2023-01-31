package com.electroshockist.total_overhaul.datagen.server;

import java.util.function.Consumer;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.init.ItemInit;
import com.electroshockist.total_overhaul.init.TagInit;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(ItemInit.TEST_ITEM.get(), 4)
			.define('a', BlockInit.TEST_BLOCK.get().asItem())
				.define('b', TagInit.Items.COOL_ITEMS)
				.define('c', Items.DIAMOND)
				.unlockedBy("has_" + BlockInit.TEST_BLOCK.get().getRegistryName().getPath(), has(BlockInit.TEST_BLOCK.get().asItem()))
				
				.pattern("bbb")
				.pattern("aca")
				.pattern("aaa")
				
				.save(consumer,	new ResourceLocation(Reference.MOD_ID, ItemInit.TEST_ITEM.get().getRegistryName().getPath()));
	
		ShapelessRecipeBuilder.shapeless(BlockInit.TEST_BLOCK.get().asItem(), 2)
			.requires(Items.DIAMOND)
			.requires(ItemInit.TEST_ITEM.get())
			.unlockedBy("has_" + ItemInit.TEST_ITEM.get().getRegistryName().getPath(), has(ItemInit.TEST_ITEM.get()))
			.save(consumer, new ResourceLocation(Reference.MOD_ID, BlockInit.TEST_BLOCK.get().getRegistryName().getPath()));
		
		SimpleCookingRecipeBuilder.smelting(
				Ingredient.of(BlockInit.TEST_BLOCK.get().asItem()),
				BlockInit.ROTATABLE_BLOCK.get(),
				0.4f,
				50)
		.unlockedBy("has_" + BlockInit.TEST_BLOCK.get().getRegistryName().getPath(), has(BlockInit.TEST_BLOCK.get().asItem()))
		.save(consumer, new ResourceLocation(Reference.MOD_ID, BlockInit.ROTATABLE_BLOCK.get().getRegistryName().getPath() + "_smelting"));
	}

}
