package com.sheppard.event;

import com.sheppard.registry.EnchantmentRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class LavaWalkerHandler implements ServerTickEvents.EndWorldTick {
    @Override
    public void onEndTick(ServerWorld world) {
        for (ServerPlayerEntity player : world.getPlayers()) {
            if(player == null) { return; }
            int enchantLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.LAVA_WALKER, player);
            if (!(player.isOnGround() || enchantLevel > 0)) {
                return;
            }
            BlockPos pos = player.getBlockPos();
            BlockState blockState = Blocks.OBSIDIAN.getDefaultState();
            int i = Math.min(enchantLevel, 2 * enchantLevel);
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            for (BlockPos blockPos2 : BlockPos.iterate(pos.add(-i, -1, -i), pos.add(i, -1, i))) {
                if (!blockPos2.isWithinDistance(player.getPos(), (double) i)) continue;
                mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
                BlockState blockState2 = world.getBlockState(mutable);
                if (!blockState2.isAir() || (world.getBlockState(blockPos2)) != Blocks.LAVA.getDefaultState() || !blockState.canPlaceAt(world, blockPos2) || !world.canPlace(blockState, blockPos2, ShapeContext.absent()))
                    continue;
                world.setBlockState(blockPos2, blockState);
                world.scheduleBlockTick(blockPos2, Blocks.OBSIDIAN, MathHelper.nextInt(player.getRandom(), 60, 120));
            }
        }
    }
}
