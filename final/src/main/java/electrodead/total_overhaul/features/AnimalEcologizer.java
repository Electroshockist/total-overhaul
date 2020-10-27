package electrodead.total_overhaul.features;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

//handles natural breeding and dying of animals
public class AnimalEcologizer {
	private static Random rand = new Random();

	private static final int deathRate = 4, breedRate = 1;
	private static final int ecologyScalar = 2500;

	private static final int totalBreedRate = breedRate * ecologyScalar, totalDeathRate = deathRate * ecologyScalar;

	public static void onRecieveAnimal(Entity entity) {
		checkAnimalEcology(entity);
	}

	private static void checkAnimalEcology(Entity entity) {
		// do not run if animal is tameable or a horse
		if (entity instanceof EntityTameable || entity instanceof AbstractHorse)
			return;
		if (entity instanceof EntityAnimal) {
			EntityAnimal e = (EntityAnimal) entity;
			// only run if mob is not already in love, can despawn and is an adult
			if (!e.isInLove() && !e.isNoDespawnRequired() && e.getGrowingAge() == 0) {
				// 1/totalBreedRate chance of running
				if (rand.nextInt(totalBreedRate) == totalBreedRate - 1) {
					e.setInLove(null);
					return;
				}
				// 1/totalDeathRate chance of running
				if (rand.nextInt(totalDeathRate) == totalDeathRate - 1) {
					// deal damage to entity for it's current health via void damage, killing it
					e.attackEntityFrom(DamageSource.OUT_OF_WORLD, e.getHealth());
					return;
				}
			}
		}
	}
}
