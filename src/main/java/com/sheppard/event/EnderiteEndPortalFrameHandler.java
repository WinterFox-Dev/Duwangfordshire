package com.sheppard.event;

import com.google.common.base.Predicates;
import com.sheppard.DuwangfordshireMod;
import com.sheppard.block.EnderiteEndPortalFrameBlock;
import com.sheppard.registry.BlockRegistry;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EnderiteEndPortalFrameHandler implements PlayerBlockBreakEvents.After {
    @Override
    public void afterBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        DuwangfordshireMod.LOGGER.info("Called the EnderiteEndPortalFrameHandler afterBlockBreak");
        DuwangfordshireMod.LOGGER.info(state.toString());
        if(state.getBlock() instanceof EnderiteEndPortalFrameBlock) {
            BlockPattern broken_frame_1 = BlockPatternBuilder.start().aisle("??vv?", ">???<", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_2 = BlockPatternBuilder.start().aisle("?v?v?", ">???<", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_3 = BlockPatternBuilder.start().aisle("?vv??", ">???<", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_4 = BlockPatternBuilder.start().aisle("?vvv?", "????<", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_5 = BlockPatternBuilder.start().aisle("?vvv?", ">????", ">???<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_6 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", "????<", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_7 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">????", ">???<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_8 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", "????<", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_9 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">????", "?^^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_10 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "??^^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_11 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^?^?").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPattern broken_frame_12 = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^??").where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK).with(EnderiteEndPortalFrameBlock.EYE, Predicates.equalTo(true)).with(EnderiteEndPortalFrameBlock.FACING, Predicates.equalTo(Direction.EAST)))).build();
            BlockPos blockPos2;
            BlockPattern.Result result;
            if ((broken_frame_1.searchAround(world, pos)) != null) {
                blockPos2 = broken_frame_1.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_2.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_2.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_3.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_3.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_4.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_4.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_5.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_5.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_6.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_6.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_7.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_7.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_8.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_8.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_9.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_9.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_10.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_10.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_11.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_11.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            } else if (broken_frame_12.searchAround(world, pos) != null) {
                blockPos2 = broken_frame_12.searchAround(world, pos).getFrontTopLeft().add(-3, 0, -3);
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        world.setBlockState(blockPos2.add(i, 0, j), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }
            }
        }
    }
}
