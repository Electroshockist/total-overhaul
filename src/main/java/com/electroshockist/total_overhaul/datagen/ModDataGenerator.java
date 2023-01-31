package com.electroshockist.total_overhaul.datagen;

import com.electroshockist.total_overhaul.datagen.client.ModBlockStateProvider;
import com.electroshockist.total_overhaul.datagen.client.ModItemModelProvider;
import com.electroshockist.total_overhaul.datagen.client.lang.ModEnUSProvider;
import com.electroshockist.total_overhaul.datagen.server.ModBlockTagsProvider;
import com.electroshockist.total_overhaul.datagen.server.ModItemTagProvider;
import com.electroshockist.total_overhaul.datagen.server.ModLootTableProvider;
import com.electroshockist.total_overhaul.datagen.server.ModRecipeProvider;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Bus.MOD)
public class ModDataGenerator {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if(event.includeClient()) {
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
			generator.addProvider(new ModEnUSProvider(generator));
		}
		
		if(event.includeServer()) {
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTagProvider(generator, blockTags, helper));
			generator.addProvider(new ModLootTableProvider(generator));
		}
	}
}
