package electrodead.total_overhaul.handlers;

import electrodead.total_overhaul.visual_effects.VoidFog;
import net.minecraft.block.BlockRailBase;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class CustomEventHandler {

//	@SubscribeEvent
//	public void onClientTickEvent(ClientTickEvent event) {
//		VoidFog.update();
//	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		AnimalHandler.onRecieveAnimal(event.getEntity());
	}

	@SubscribeEvent
	public void onLivingExperienceDrop(LivingExperienceDropEvent event) {
		DropHandler.onXPDrop(event);
	}

	public void onItemDrop(LivingDropsEvent event) {
		DropHandler.onItemDrop(event);
	}

	@SubscribeEvent
	public void onInteractEntity(PlayerInteractEvent.EntityInteract event) {
		CreativeTameableHandler.onEntityInteract(event);
	}

	public void onPlaceBlock(BlockEvent.PlaceEvent event) {
		if (event.getPlacedBlock().getBlock() instanceof BlockRailBase) {
			BlockRailBase rail = (BlockRailBase) event.getPlacedBlock().getBlock();
		}
	}
}
