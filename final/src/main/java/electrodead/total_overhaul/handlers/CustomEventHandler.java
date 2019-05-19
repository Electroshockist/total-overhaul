package electrodead.total_overhaul.handlers;

import electrodead.total_overhaul.visual_effects.VoidFog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class CustomEventHandler {
	World world;

	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event) {
//		System.out.println("Item picked up!");
//		world = event.getEntity().world;
//		int i = 1 + world.rand.nextInt(3);
//		while (i > 0) {
//			int j = EntityXPOrb.getXPSplit(i);
//			i -= j;
//			world.spawnEntity(
//					new EntityXPOrb(world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, j));
//		}
	}

	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent event) {
		VoidFog.update();
	}

	//
	// @SubscribeEvent
	// public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event){
	// }

	@SubscribeEvent
	public void onLivingExperienceDrop(LivingExperienceDropEvent event) {
		if (event.getEntity() instanceof EntityBat) {
			world = event.getEntity().world;
			world.spawnEntity(new EntityXPOrb(world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, 1));
		}
	}
}
