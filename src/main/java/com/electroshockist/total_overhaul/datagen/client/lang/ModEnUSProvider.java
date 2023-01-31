package com.electroshockist.total_overhaul.datagen.client.lang;

import org.slf4j.Logger;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.init.ItemInit;
import com.electroshockist.total_overhaul.util.Reference;
import com.mojang.logging.LogUtils;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUSProvider extends LanguageProvider {

	
	private static final Logger LOGGER = LogUtils.getLogger();

	public ModEnUSProvider(DataGenerator generator) {
		super(generator, Reference.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {

		
		LOGGER.info("Triggered " + Reference.MOD_ID + " EN_US localization");
		//items
		add(ItemInit.TEST_ITEM.get(), "Test Item");
		
		//item groups
		add("itemGroup.total_overhaul", "Total Overhaul");
		
		//blocks
		add(BlockInit.TEST_BLOCK.get(), "Test Block");
		add(BlockInit.ROTATABLE_BLOCK.get(), "Rotatable Block");
	}

}
