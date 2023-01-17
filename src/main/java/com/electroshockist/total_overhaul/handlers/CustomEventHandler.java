package com.electroshockist.total_overhaul.handlers;

import com.electroshockist.total_overhaul.features.AnimalEcologizer;
import com.electroshockist.total_overhaul.features.CreativeInstaTame;
import com.electroshockist.total_overhaul.features.MobDropModifier;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CustomEventHandler {
	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent event) {
		//VoidFog.updateParticles();
	}

	//@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void onFogDensityRender(EntityViewRenderEvent.FogDensity event) {
//		//VoidFog.updateFog(event);
//		event.setCanceled(true);
//	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		AnimalEcologizer.onRecieveAnimal(event.getEntity());
	}

	@SubscribeEvent
	public void onLivingExperienceDrop(LivingExperienceDropEvent event) {
		MobDropModifier.onXPDrop(event);
	}

	public void onItemDrop(LivingDropsEvent event) {
		MobDropModifier.onItemDrop(event);
	}

	@SubscribeEvent
	public void onInteractEntity(PlayerInteractEvent.EntityInteract event) {
		CreativeInstaTame.onEntityInteract(event);
	}

	@SubscribeEvent
	public void onDestoryBlock(BlockEvent.BreakEvent event) {
		Block block = event.getState().getBlock();
		
		//crops drop xp if fully aged 
		if (event.getState().getBlock() instanceof CropBlock) {
			CropBlock crop = (CropBlock)block;
			if(crop.isMaxAge(event.getState())) {
				//generate 1 xp on crop break
				event.setExpToDrop(1);
			}
		}
	}

//	@SubscribeEvent
//	public void onPlaceBlock(BlockEvent.PlaceEvent event) {
//		if (event.getPlacedBlock().getBlock() instanceof BlockRailBase) {
//			BlockRailBase rail = (BlockRailBase) event.getPlacedBlock().getBlock();
//		}
//	}
}
