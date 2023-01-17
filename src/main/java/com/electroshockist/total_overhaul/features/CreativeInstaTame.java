package com.electroshockist.total_overhaul.features;

import java.util.Random;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class CreativeInstaTame {
	//private static Random rand = new Random();

	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		if (event.getPlayer().isCreative()) {
			Entity target = event.getTarget();
			Player player = event.getPlayer();
			ItemStack stack = event.getItemStack();			

			if (target instanceof AbstractHorse) {
				Horse horse = (Horse) event.getTarget();
				if (!horse.isTamed() && !horse.isBaby()) {
					if (stack == ItemStack.EMPTY || horse.isFood(stack)) {
						tameEntity(horse, player);
					}
				}
			}
//
//			if (target instanceof TamableAnimal) {
//				TamableAnimal et = (TamableAnimal) target;
//				TameableReflector th;
//				Set<Item> TAME_ITEMS = null;
//
//				if (!et.isTame()) {
//
//					if (target instanceof Parrot) {
//						Parrot parrot = (Parrot) target;
//						th = new ParrotReflector();
//
//						TAME_ITEMS = th.GetTameItems();
//						if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || TAME_ITEMS.contains(stack.getItem())) {
//							th.tame(parrot, player);
//							tameEntity(parrot, player);
//							return;
//						}
//						
//					}
//					else if(target instanceof EntityOcelot) {
//						EntityOcelot ocelot = (EntityOcelot) target;
//						th = new OcelotReflector();
//
//						TAME_ITEMS = th.GetTameItems();
//						
//						if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || TAME_ITEMS.contains(stack.getItem())) {
//							th.tame(ocelot, player);
//							tameEntity(ocelot, player);
//							return;
//						}
//						
//					}
//					if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || et.isBreedingItem(stack)) {
//						tameEntity(et, player);
//					}
//				}
//			}
		}
	}
	private static void tameEntity(TamableAnimal tamable, Player player) {
		tamable.tame(player);
	}

	private static void tameEntity(AbstractHorse horse, Player player) {
		horse.tameWithName(player);
	}
}
