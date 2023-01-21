package com.electroshockist.total_overhaul.features.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HyperTestItem extends Item {

	public HyperTestItem(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		if(!level.isClientSide()) {
			System.out.println("used thing in " + hand.toString());
		}
		
		return super.use(level, player, hand);
	}
	
}
