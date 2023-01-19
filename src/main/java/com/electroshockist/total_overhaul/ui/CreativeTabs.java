package com.electroshockist.total_overhaul.ui;

import com.electroshockist.total_overhaul.init.ItemInit;
import com.electroshockist.total_overhaul.util.Reference;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabs {
	public static final CreativeModeTab MAIN_TAB = new CreativeModeTab(Reference.MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ItemInit.ITEM.get());
		}
	};
}
