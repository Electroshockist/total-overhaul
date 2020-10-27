package electrodead.total_overhaul.features;

import java.util.Random;
import java.util.Set;

import electrodead.total_overhaul.reflections.tameable.OcelotReflector;
import electrodead.total_overhaul.reflections.tameable.ParrotReflector;
import electrodead.total_overhaul.reflections.tameable.TameableReflector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

//allows a player in creative mode to instantly
public class CreativeInstaTame {

	private static Random rand = new Random();;

	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		if (event.getEntityPlayer().capabilities.isCreativeMode) {
			Entity target = event.getTarget();
			EntityPlayer player = event.getEntityPlayer();
			ItemStack stack = event.getItemStack();			

			if (target instanceof AbstractHorse) {
				AbstractHorse horse = (AbstractHorse) event.getTarget();
				if (!horse.isTame() && !horse.isChild()) {
					if (stack == ItemStack.EMPTY || horse.isBreedingItem(stack)) {
						tameEntity(horse, player);
					}
				}
			}

			if (target instanceof EntityTameable) {
				EntityTameable et = (EntityTameable) target;
				TameableReflector th;
				Set<Item> TAME_ITEMS = null;

				if (!et.isTamed()) {

					if (target instanceof EntityParrot) {
						EntityParrot parrot = (EntityParrot) target;
						th = new ParrotReflector();

						TAME_ITEMS = th.GetTameItems();
						if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || TAME_ITEMS.contains(stack.getItem())) {
							th.tame(parrot, player);
							tameEntity(parrot, player);
							return;
						}
						
					}
					else if(target instanceof EntityOcelot) {
						EntityOcelot ocelot = (EntityOcelot) target;
						th = new OcelotReflector();

						TAME_ITEMS = th.GetTameItems();
						
						if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || TAME_ITEMS.contains(stack.getItem())) {
							th.tame(ocelot, player);
							tameEntity(ocelot, player);
							return;
						}
						
					}
					if (stack.getItem().getUnlocalizedName().equals(Blocks.AIR.getUnlocalizedName()) || et.isBreedingItem(stack)) {
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
