//package com.electroshockist.total_overhaul.vfx;
//
//import java.util.Random;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.world.phys.Vec3;
//import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
//
//public class VoidFog {
//private static final Random r = new Random();
//	
//	private static final int VOID_HEIGHT = 16;
//	private static final double DENSITY_FALLOFF = 1/Math.log(VOID_HEIGHT);
//
//	public static void updateParticles() {
//		Vec3 p = Minecraft.getInstance().player.position();
//
//		if (!Minecraft.getInstance().isPaused() && getLevel() != null) {
//			doVoidFogParticles(
//					(int)Math.floor(p.x),
//					(int)Math.floor(p.y),
//					(int)Math.floor(p.z));
//		}
//
//	}
//
//	//unimplemented.
//	//todo: reimplement the depthsuspend particle
//	private static void doVoidFogParticles(int x, int y, int z) {
////		byte b0 = 16;
////		
////		ClientLevel level = getLevel();
////
////		for (int l = 0; l < 1000; ++l) {
////			int i1 = x + r.nextInt(b0) - r.nextInt(b0);
////			int j1 = y + r.nextInt(b0) - r.nextInt(b0);
////			int k1 = z + r.nextInt(b0) - r.nextInt(b0);
////			
////			blockpos
////			
////			
////			if (level.getBlockState().isAir()) {
////				if (r.nextInt(8) > j1 && getWorldHasVoidParticles()) {
////					level.spawnParticle(blockpos,
////							(double) ( i1 + r.nextDouble()),
////							(double) ( j1 + r.nextDouble()),
////							(double) ( k1 + r.nextDouble()),
////							0.0D, 0.0D, 0.0D);
////				}
////			}
////		}
//	}
//
//	//@SideOnly(Side.CLIENT)
//	public static boolean getWorldHasVoidParticles() {
//		return getLevel().dimensionType().hasSkyLight();
//	}
//	
//	
//	public static void updateFog(FogDensity event) {
//		float baseDensity = 0;
//		double density = baseDensity;
//		
//		//gets feet height, adds 1 to get head height
//		double height = Minecraft.getInstance().player.position().y;		
//		
//		int voidStart = VOID_HEIGHT + 1;
//		
//		if(height < VOID_HEIGHT) {
//			density = DENSITY_FALLOFF * Math.log(voidStart-height);
//			
//			if(density > 1) density = 1;			
//			
//		}
//		event.setDensity((float)density);
//	}
//	
//	private static ClientLevel getLevel() {		
//		return Minecraft.getInstance().level;
//	}
//}
