package com.sheppard.block;

import com.google.common.base.Predicates;
import com.sheppard.registry.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;

public class EnderiteEndPortalFrameBlock extends EndPortalFrameBlock {

    private static BlockPattern COMPLETED_FRAME;

    public EnderiteEndPortalFrameBlock(FabricBlockSettings settings) {
        super(settings);
    }

    public static BlockPattern getCompletedFramePattern() {
        if (COMPLETED_FRAME == null) {
            COMPLETED_FRAME = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.EAST)))).build();
        }
        return COMPLETED_FRAME;
    }
}
