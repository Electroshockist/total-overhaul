package electrodead.total_overhaul.handlers;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import electrodead.total_overhaul.scope_helper.Parrot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class CreativeTameableHandler {

	private static Random rand = new Random();;

	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		if (event.getEntityPlayer().capabilities.isCreativeMode) {
			Entity target = event.getTarget();
			EntityPlayer player = event.getEntityPlayer();

			if (target instanceof AbstractHorse) {
				AbstractHorse horse = (AbstractHorse) event.getTarget();
				if (!horse.isTame() && !horse.isChild()) {
					if (event.getItemStack() == ItemStack.EMPTY || horse.isBreedingItem(event.getItemStack())) {
						tameEntity(horse, player);
					}
				}
			} else if (target instanceof EntityParrot) {
				EntityParrot parrot = (EntityParrot) target;
				Set<Item> TAME_ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
				
				if (!parrot.isTamed() && !parrot.isChild()) {
					for (Item item : TAME_ITEMS) {
						if (item == event.getItemStack().getItem()) {
							Parrot.tameParrot(parrot, player);
							tameEntity(parrot, player);
							return;
						}
					}
				}
			} else if (target instanceof EntityTameable) {
				EntityTameable et = (EntityTameable) target;

				if (!et.isTamed() && !et.isChild()) {
					if (event.getItemStack() == ItemStack.EMPTY || et.isBreedingItem(event.getItemStack())) {
						tameEntity(et, player);
					}
				}
			}
		}
	}

	private static void tameEntity(EntityTameable et, EntityPlayer player) {
		et.setTamedBy(player);
	}

	private static void tameEntity(AbstractHorse horse, EntityPlayer player) {
		horse.setTamedBy(player);
	}

}
