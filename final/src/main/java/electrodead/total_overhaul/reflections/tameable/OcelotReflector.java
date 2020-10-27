package electrodead.total_overhaul.reflections.tameable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class OcelotReflector extends TameableReflector{
	private static Random rand = new Random();
	@Override
	public Set<Item> GetTameItems() {
		return Sets.newHashSet(Items.FISH);
	}

	@Override
	public void tame(EntityTameable et, EntityPlayer p) {
		
		Class cls = et.getClass();
		Method setTamedBy, setTameSkin, playTameEffect, setSitting, setEntityState;
		
		try {
			setTamedBy = cls.getSuperclass().getDeclaredMethod("setTamedBy", EntityPlayer.class);
            setTameSkin = cls.getDeclaredMethod("setTameSkin", int.class);
            playTameEffect = cls.getSuperclass().getDeclaredMethod("playTameEffect", boolean.class);
            
            Field field = cls.getSuperclass().getDeclaredField("aiSit");
            
            System.out.println(field.getName());
            
//            this.aiSit.setSitting(true);
//            this.world.setEntityState(this, (byte)7);
            
            setTamedBy.invoke(et, p);
            //setTameSkin.invoke(et, 1 + ocelot.world.rand.nextInt(3));
            //playTameEffect.invoke(et, true);
		} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(cls.getName());
//		
//		System.out.println("Tamed ocelot");
//		ocelot.setTameSkin(1 + ocelot.world.rand.nextInt(3));
//		playTameEffect(ocelot);
//		//ocelot.aiSit.setSitting(true);
//		ocelot.world.setEntityState(ocelot, (byte) 7);		
	}
}
