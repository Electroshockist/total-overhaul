package electrodead.total_overhaul.visual_effects;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VoidFog {
	private static WorldClient world;

	public static void update() {

		world = Minecraft.getMinecraft().world;

		if (!Minecraft.getMinecraft().isGamePaused() && world != null) {
			world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, 0.0D, 70.0D, 0.0D, 0.0D, 0.0D, 0.0D);

			doVoidFogParticles(MathHelper.floor(Minecraft.getMinecraft().player.posX),
					MathHelper.floor(Minecraft.getMinecraft().player.posY),
					MathHelper.floor(Minecraft.getMinecraft().player.posZ));
		}

	}

	private static void doVoidFogParticles(int x, int y, int z) {
		byte b0 = 16;

		for (int l = 0; l < 1000; ++l) {
			int i1 = x + world.rand.nextInt(b0) - world.rand.nextInt(b0);
			int j1 = y + world.rand.nextInt(b0) - world.rand.nextInt(b0);
			int k1 = z + world.rand.nextInt(b0) - world.rand.nextInt(b0);
			// Block block = world.isAirBlock(new BlockPos(i1, j1, k1));

			if (world.isAirBlock(new BlockPos(i1, j1, k1))) {
				if (world.rand.nextInt(8) > j1 && getWorldHasVoidParticles()) {
					world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
							(double) ((float) i1 + world.rand.nextFloat()),
							(double) ((float) j1 + world.rand.nextFloat()),
							(double) ((float) k1 + world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static boolean getWorldHasVoidParticles() {
		// return world.provider.terr.hasVoidParticles(this.hasNoSky);
		return true;
	}

}
