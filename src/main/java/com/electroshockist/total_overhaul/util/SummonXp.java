package com.electroshockist.total_overhaul.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;

public class SummonXp {
	public static void summon(Entity entity) {
		ExperienceOrb.award((ServerLevel) entity.level, entity.position(), 1);
	}
}
