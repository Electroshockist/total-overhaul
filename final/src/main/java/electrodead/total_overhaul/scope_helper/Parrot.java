package electrodead.total_overhaul.scope_helper;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;

public class Parrot {
	private static Random rand = new Random();

	public static void tameParrot(EntityParrot parrot, EntityPlayer player) {
		if (!parrot.isSilent()) {
			parrot.world.playSound((EntityPlayer) null, parrot.posX, parrot.posY, parrot.posZ,
					SoundEvents.ENTITY_PARROT_EAT, parrot.getSoundCategory(), 1.0F,
					1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F);
		}

		if (!parrot.world.isRemote) {
			playTameEffect(parrot, player);
		}
	}

	private static void playTameEffect(EntityParrot parrot, EntityPlayer player) {
		EnumParticleTypes enumparticletypes = EnumParticleTypes.HEART;
		System.out.println(Minecraft.getMinecraft().player.getDisplayNameString());
		System.out.println(player.getDisplayNameString());

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			Minecraft.getMinecraft().player.world.spawnParticle(enumparticletypes,
					parrot.posX + (double) (rand.nextFloat() * parrot.width * 2.0F) - (double) parrot.width,
					parrot.posY + 0.5D + (double) (rand.nextFloat() * parrot.height),
					parrot.posZ + (double) (rand.nextFloat() * parrot.width * 2.0F) - (double) parrot.width, d0, d1,
					d2);
		}
	}
}
