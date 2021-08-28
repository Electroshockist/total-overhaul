package electrodead.total_overhaul.features;

import electrodead.total_overhaul.util.SummonXp;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

public class MobDropModifier {

	private static boolean checkConditions(Entity entity) {
		// set entity to
		if (entity instanceof EntityBat) {
			return true;
		}
		
		//this does not work, since the game does not even check if child animals drop XP
		//TODO: figure out how to get child animals to drop drops and exp
		
//		if (entity instanceof EntityAnimal) {
//			EntityAnimal entityAnimal = (EntityAnimal) entity;
//			if (entityAnimal.isChild()) {
//				return true;
//			}
//		}
		
		return false;
	}

	// handle XP drop changes
	public static void onXPDrop(LivingExperienceDropEvent event) {

		// summon XP if entity matches conditions
		if (checkConditions(event.getEntity())) {
			SummonXp.summon(event.getEntity());
		}

	}

	public static void onItemDrop(LivingDropsEvent event) {
		if (checkConditions(event.getEntity())) {

		}
	}
}
