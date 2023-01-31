package com.electroshockist.total_overhaul.datagen.client;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider{

	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Reference.MOD_ID,  helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.TEST_BLOCK.get());
	}
	
}
