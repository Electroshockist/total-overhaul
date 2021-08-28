package electrodead.total_overhaul.handlers;

import electrodead.total_overhaul.features.AnimalEcologizer;
import electrodead.total_overhaul.features.CreativeInstaTame;
import electrodead.total_overhaul.features.MobDropModifier;
import electrodead.total_overhaul.visual_effects.VoidFog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockRailBase;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomEventHandler {
	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent event) {
		VoidFog.updateParticles();
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onFogDensityRender(EntityViewRenderEvent.FogDensity event) {
		VoidFog.updateFog(event);
		event.setCanceled(true);
	}

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
		if (event.getState().getBlock() instanceof BlockCrops) {
			BlockCrops crop = (BlockCrops)block;
			if(crop.isMaxAge(event.getState())) {
				//generate 1 xp on crop break
				event.setExpToDrop(1);
			}
		}
	}

	@SubscribeEvent
	public void onPlaceBlock(BlockEvent.PlaceEvent event) {
		if (event.getPlacedBlock().getBlock() instanceof BlockRailBase) {
			BlockRailBase rail = (BlockRailBase) event.getPlacedBlock().getBlock();
		}
	}
}
