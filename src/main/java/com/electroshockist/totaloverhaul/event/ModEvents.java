package com.electroshockist.totaloverhaul.event;

import com.electroshockist.totaloverhaul.TotalOverhaul;
import com.electroshockist.totaloverhaul.systems.EcologyHandler;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TotalOverhaul.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
//    @SubscribeEvent
//    public static void onLivingUpdate(LivingEvent event){
//        var entity = event.getEntity();
//        if (entity instanceof Animal){
//            EcologyHandler.tryEcologize((Animal) entity);
//        }
//    }
}
