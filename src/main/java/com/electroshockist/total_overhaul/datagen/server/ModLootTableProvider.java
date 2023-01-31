package com.electroshockist.total_overhaul.datagen.server;

import com.electroshockist.total_overhaul.datagen.util.BaseLootTableProvider;
import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModLootTableProvider extends BaseLootTableProvider {

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(BlockInit.TEST_BLOCK.get());
		silkTouch(BlockInit.ROTATABLE_BLOCK.get(), ItemInit.TEST_ITEM.get(), 1, 3);
	}

	//drop self on silk touch
	protected void silkTouch(Block block, Item drop, int minFortuneDrop, int maxFortuneDrop) {
		add(block, 
				createSilkTouchTable(block.getRegistryName().getPath(), block, drop, minFortuneDrop, maxFortuneDrop));
	}

	protected void dropSelf(Block block) {
		add(block, createSimpleTable(block.getRegistryName().getPath(), block));
	}

}
