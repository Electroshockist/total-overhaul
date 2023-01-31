package com.electroshockist.total_overhaul.init;

import com.electroshockist.total_overhaul.features.items.HyperTestItem;
import com.electroshockist.total_overhaul.ui.CreativeTabs;
import com.electroshockist.total_overhaul.util.Reference;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	
	public static final RegistryObject<Item> TEST_ITEM = register ("test_item", () -> new HyperTestItem(
			new Item.Properties()
			.tab(CreativeTabs.MAIN_TAB)
			.food(
					new FoodProperties.Builder()
					.alwaysEat()
					.nutrition(3)
					.saturationMod(3.5f)
					.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 1f)
					.build())));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
		return ITEMS.register(name, item);
	}
}
