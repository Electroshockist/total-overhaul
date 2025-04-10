package com.electroshockist.totaloverhaul.datagen;

import com.electroshockist.totaloverhaul.TotalOverhaul;
import com.electroshockist.totaloverhaul.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TotalOverhaul.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TESTIMS.get());
    }
}
