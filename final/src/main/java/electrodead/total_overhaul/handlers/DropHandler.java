package electrodead.total_overhaul.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

public class DropHandler {

	private static Entity entity;

	private static boolean checkConditions(Entity e) {
		// set entity to
		if (e instanceof EntityBat) {
			entity = e;
			return true;
		}
		
		//todo add child animals to list
//		else if (e instanceof EntityAnimal) {
//			EntityAnimal entityAnimal = (EntityAnimal) entity;
//			if (entityAnimal.isChild()) {
//				entity = e;
//				return true;
//			}
//		}
		return false;
	}

	// handle XP drop changes
	public static void onXPDrop(LivingExperienceDropEvent event) {

		// summon XP if entity matches conditions
		if (checkConditions(event.getEntity())) {
			summonXpAtEntity(entity);
		}

	}

	public static void onItemDrop(LivingDropsEvent event) {
		if (checkConditions(event.getEntity())) {

		}
	}

	private static void summonXpAtEntity(Entity entity) {
		entity.world.spawnEntity(new EntityXPOrb(entity.world, entity.posX, entity.posY, entity.posZ, 1));
	}
}
