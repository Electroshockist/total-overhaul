package com.electroshockist.total_overhaul.features;

import java.util.Random;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

public class AnimalEcologizer {
	private static Random rand = new Random();

	private static final int deathRate = 6, breedRate = 1;
	private static final int ecologyScalar = 2500;

	private static final int totalBreedRate = breedRate * ecologyScalar, totalDeathRate = deathRate * ecologyScalar;

	public static void onRecieveAnimal(Entity entity) {
		checkAnimalEcology(entity);
	}

	private static void checkAnimalEcology(Entity entity) {
		// do not run if animal is tameable or a horse
		if (entity instanceof TamableAnimal || entity instanceof AbstractHorse)
			return;
		if (entity instanceof Animal) {
			Animal e = (Animal) entity;
			
			//check if the mob is eligible for ecolization
			if (canEcologize(e)) {
				// 1/totalBreedRate chance of running
				if (rand.nextInt(totalBreedRate) == totalBreedRate - 1) {
					e.setInLove(null);
					return;
				}
				// 1/totalDeathRate chance of killing a mob
				if (rand.nextInt(totalDeathRate) == totalDeathRate - 1) {
					e.kill();
					return;
				}
			}
		}
	}
	
	private static boolean canEcologize(Animal a) {
		// only run if mob is not already in love, can despawn and is an adult
		return !a.isInLove() && !a.isBaby() && !a.isPersistenceRequired();
	}
}
