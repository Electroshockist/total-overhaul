package com.electroshockist.totaloverhaul.systems;

import net.minecraft.world.entity.animal.Animal;

import java.util.Random;

public class EcologyHandler {
    private static Random rand = new Random();

    private static final float deathChancePerTick = 0.2f, breedChancePerTick = 0.5f;
    private static final float ecologyScalar = 2500f;

    public static void tryEcologize(Animal animal){
        if(canEcologize(animal)) {
            if(shouldMakeDie(animal)){
                animal.kill();
            } else if (shouldMakeInLove(animal)) {
                animal.setInLove(null);
            }
        }
    }

    private static boolean shouldMakeInLove(Animal animal){
        return true;
    }

    private static boolean shouldMakeDie(Animal animal){

        if(isRandomChanceFulfilled(deathChancePerTick)){

            //multiply death chance by age
            return true;
        }
        return false;
    }

    private static boolean canEcologize(Animal animal){
        return !(animal.isBaby() || animal.isInLove());
    }

    private static boolean isRandomChanceFulfilled(float threshold){
        return rand.nextFloat() < threshold;
    }
}
