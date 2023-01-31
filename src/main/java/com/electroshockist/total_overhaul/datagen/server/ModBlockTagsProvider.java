package com.electroshockist.total_overhaul.datagen.server;

import org.jetbrains.annotations.Nullable;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper helper) {
		super(generator, Reference.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Blocks.STONE).add(BlockInit.TEST_BLOCK.get());
	}

}
