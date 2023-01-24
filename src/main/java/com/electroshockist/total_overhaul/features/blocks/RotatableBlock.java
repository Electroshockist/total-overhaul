package com.electroshockist.total_overhaul.features.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RotatableBlock extends Block {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public static final VoxelShape NORTH = Shapes.box(0, 0, 0, 1, 0.25, 0.25);
	public static final VoxelShape EAST = Shapes.box(0.75, 0, 0, 1, 0.25, 1);
	public static final VoxelShape SOUTH = Shapes.box(0, 0, 0.75, 1, 0.25, 1);
	public static final VoxelShape WEST = Shapes.box(0, 0, 0, 0.25, 0.25, 1);

	public RotatableBlock(Properties properties) {
		super(properties);

		this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
			case EAST:
				return EAST;
			case SOUTH:
				return SOUTH;
			case WEST:
				return WEST;
			default:
				return NORTH;
		}
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
		// TODO Auto-generated method stub
		super.createBlockStateDefinition(builder);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		// TODO Auto-generated method stub
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
		// TODO Auto-generated method stub
		return super.rotate(state, level, pos, direction);
	}
}
