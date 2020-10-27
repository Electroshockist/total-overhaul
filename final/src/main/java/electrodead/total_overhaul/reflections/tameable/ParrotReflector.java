package electrodead.total_overhaul.reflections.tameable;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;

public class ParrotReflector extends TameableReflector {

	public static void tameParrot(EntityParrot parrot, EntityPlayer player) {

	}

	@Override
	public Set<Item> GetTameItems() {
		return Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
	}

	@Override
	public void tame(EntityTameable et, EntityPlayer player) {
		EntityParrot parrot = (EntityParrot)et;
		if (!parrot.isSilent()) {
			parrot.world.playSound((EntityPlayer) null, parrot.posX, parrot.posY, parrot.posZ,
					SoundEvents.ENTITY_PARROT_EAT, parrot.getSoundCategory(), 1.0F,
					1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F);
		}

		if (!parrot.world.isRemote) {
			playTameEffect(parrot);
		}

	}

}
