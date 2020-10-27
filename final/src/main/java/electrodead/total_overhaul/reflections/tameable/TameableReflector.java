package electrodead.total_overhaul.reflections.tameable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;

public abstract class TameableReflector {
	public abstract Set<Item> GetTameItems();
	
	protected static Random rand = new Random();

	public void playTameEffect(EntityTameable et) {
		Class c = et.getClass();
		try {
			Method playTameEffectReflection = c.getDeclaredMethod("playTameEffect", boolean.class);
			
			playTameEffectReflection.invoke(et, true);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public abstract void tame(EntityTameable et, EntityPlayer p);

}
