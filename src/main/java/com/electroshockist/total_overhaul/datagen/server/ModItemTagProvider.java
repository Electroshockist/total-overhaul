package com.electroshockist.total_overhaul.datagen.server;

import org.jetbrains.annotations.Nullable;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

	public ModItemTagProvider(DataGenerator generator, BlockTagsProvider provider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(generator, provider, Reference.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Items.COBBLESTONE).add(BlockInit.TEST_BLOCK.get().asItem());
	}

}
