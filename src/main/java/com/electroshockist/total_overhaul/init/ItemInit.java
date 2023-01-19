package com.electroshockist.total_overhaul.init;

import com.electroshockist.total_overhaul.ui.CreativeTabs;
import com.electroshockist.total_overhaul.util.Reference;
import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	
	public static final RegistryObject<Item> ITEM = register ("test_item", () -> new  Item(new Item.Properties().tab(CreativeTabs.MAIN_TAB)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
		return ITEMS.register(name, item);
	}
}
