package com.electroshockist.totaloverhaul.item;

import com.electroshockist.totaloverhaul.TotalOverhaul;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TotalOverhaul.MOD_ID);

    public static  final RegistryObject<Item> TESTIMS = ITEMS.register("sus",
            () -> new Item(new Item.Properties())
    );

    public  static  void  register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
