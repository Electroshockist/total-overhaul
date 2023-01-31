package com.electroshockist.total_overhaul.datagen.client;

import com.electroshockist.total_overhaul.init.BlockInit;
import com.electroshockist.total_overhaul.init.ItemInit;
import com.electroshockist.total_overhaul.util.Reference;
import com.mojang.logging.LogUtils;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Reference.MOD_ID, helper);
	}

	protected void simpleBlockItem(Item item) {
		getBuilder(item.getRegistryName().toString())
				.parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
	}

	protected void oneLayerItem(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(),
				"item/" + item.getRegistryName().getPath());
		
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
		} else {
			LogUtils.getLogger().warn(
					"Item texture " + item.getRegistryName().toString() + " not found at " + itemTexture.toString());
		}
	}
	
	protected void oneLayerItem(Item item) {
		oneLayerItem(item, item.getRegistryName());
	}

	@Override
	protected void registerModels() {
		//BLock Items
		simpleBlockItem(BlockInit.TEST_BLOCK.get().asItem());
		simpleBlockItem(BlockInit.ROTATABLE_BLOCK.get().asItem());
		
		//Items
		oneLayerItem(ItemInit.TEST_ITEM.get());
	}

}
