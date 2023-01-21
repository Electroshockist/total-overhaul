package com.electroshockist.total_overhaul.features.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

public class MobDropModifier {
	private static boolean checkConditions(Entity entity) {
		// set entity to
		if (entity instanceof Bat) {
			return true;
		}
		
		//this does not work, since the game does not even check if child animals drop XP
		//TODO: figure out how to get child animals to drop drops and exp
		
		if (entity instanceof Animal) {
			Animal entityAnimal = (Animal) entity;
			if (entityAnimal.isBaby()) {
				return true;
			}
		}
		
		return false;
	}

	// handle XP drop changes
	public static void onXPDrop(LivingExperienceDropEvent event) {

		// summon XP if entity matches conditions
		if (checkConditions(event.getEntity())) {
			ExperienceOrb.award((ServerLevel) event.getEntity().level, event.getEntity().position(), 1);
		}

	}

	public static void onItemDrop(LivingDropsEvent event) {
		if (checkConditions(event.getEntity())) {

		}
	}
}
