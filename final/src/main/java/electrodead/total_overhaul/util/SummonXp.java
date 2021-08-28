package electrodead.total_overhaul.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;

public class SummonXp {
	public static void summon(Entity entity) {
		entity.world.spawnEntity(new EntityXPOrb(entity.world, entity.posX, entity.posY, entity.posZ, 1));
	}
}
