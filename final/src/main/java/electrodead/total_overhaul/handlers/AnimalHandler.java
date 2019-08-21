package electrodead.total_overhaul.handlers;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;

//handles natural breeding and dying of animals
public class AnimalHandler {
	private static Random rand = new Random();
	private static final int deathRate = 10000, breedRate = 2500;

	public static void onRecieveAnimal(Entity entity) {
		//do not run if animal is tameable or a horse
		if (entity instanceof EntityTameable || entity instanceof AbstractHorse)
			return;
		if (entity instanceof EntityAnimal) {
			EntityAnimal e = (EntityAnimal) entity;
			//only run if mob can despawn
			if (!e.isNoDespawnRequired()) {
				//check if animal is an adult
				if (e.getGrowingAge() == 0) {
					//1/breedRate chance of running
					if (rand.nextInt(breedRate) == breedRate - 1) {
						//check if animal is not already in love
						if (!e.isInLove()) {
							e.setInLove(null);
							//System.out.println(e.getName() + " is now in love");
							return;
						}
					}
					//1/deathRate chance of running
					if (rand.nextInt(deathRate) == deathRate - 1) {
						e.setDead();
						return;
					}
				}
			}
		}
	}
}
