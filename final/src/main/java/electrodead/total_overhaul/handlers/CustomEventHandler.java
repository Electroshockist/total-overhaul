package electrodead.total_overhaul.handlers;

import electrodead.total_overhaul.visual_effects.VoidFog;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class CustomEventHandler {
	World world;
	
	AnimalHandler animalHandler;

	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent event) {
		VoidFog.update();
	}
	
	 @SubscribeEvent
	 public void onCheckSpawn(LivingUpdateEvent event) {
		 AnimalHandler.onRecieveAnimal(event.getEntity());
	 }

	@SubscribeEvent
	public void onLivingExperienceDrop(LivingExperienceDropEvent event) {
		if (event.getEntity() instanceof EntityBat) {
			world = event.getEntity().world;
			world.spawnEntity(new EntityXPOrb(world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, 1));
		}
	}
}
