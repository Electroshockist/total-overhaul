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
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VoidFog {
	private static WorldClient world;
	
	private static final int VOID_HEIGHT = 16;
	private static final double DENSITY_FALLOFF = 1/Math.log(VOID_HEIGHT);

	public static void updateParticles() {

		world = Minecraft.getMinecraft().world;

		if (!Minecraft.getMinecraft().isGamePaused() && world != null) {
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
					world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH,
							(double) ((float) i1 + world.rand.nextFloat()),
							(double) ((float) j1 + world.rand.nextFloat()),
							(double) ((float) k1 + world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static boolean getWorldHasVoidParticles() {
		return world.provider.hasSkyLight();
	}
	
	
	public static void updateFog(FogDensity event) {
		float baseDensity = 0;
		double density = baseDensity;
		
		//gets feet height, adds 1 to get head height
		double height = Minecraft.getMinecraft().player.getPositionVector().y;		
		
		int voidStart = VOID_HEIGHT + 1;
		
		if(height < VOID_HEIGHT) {
			density = DENSITY_FALLOFF * Math.log(voidStart-height);
			
			if(density > 1) density = 1;			
			
		}
		event.setDensity((float)density);		
		
	}

}
