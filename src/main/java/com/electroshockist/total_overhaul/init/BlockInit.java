package com.electroshockist.total_overhaul.init;

import java.util.function.Function;

import com.electroshockist.total_overhaul.features.blocks.HyperTestBlock;
import com.electroshockist.total_overhaul.ui.CreativeTabs;
import com.electroshockist.total_overhaul.util.Reference;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	public static final RegistryObject<Block> TEST_BLOCK = register(
			"test_block",
			() -> new HyperTestBlock( 
					BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD)
					.requiresCorrectToolForDrops()
					.strength(2.0f)
					.sound(SoundType.AMETHYST)),			
			object -> () -> new BlockItem(object.get(),new Item.Properties().tab(CreativeTabs.MAIN_TAB)));
	
	public static final RegistryObject<Block> ROTATABLE_BLOCK = register("rotatable_block",
			() -> new HyperTestBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).dynamicShape().sound(SoundType.WOOD)),		
			object -> () -> new BlockItem(object.get(),new Item.Properties().tab(CreativeTabs.MAIN_TAB)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item){

		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
