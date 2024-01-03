package com.sheppard.item;

import com.sheppard.block.EnderiteEndPortalFrameBlock;
import com.sheppard.registry.BlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

public class SyntheticEyeOfEnderItem extends Item {
    public SyntheticEyeOfEnderItem(FabricItemSettings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos;
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos = context.getBlockPos());
        if (!blockState.isOf(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK) || blockState.get(EnderiteEndPortalFrameBlock.EYE)) {
            return ActionResult.PASS;
        }
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        BlockState blockState2 = (BlockState)blockState.with(EnderiteEndPortalFrameBlock.EYE, true);
        Block.pushEntitiesUpBeforeBlockChange(blockState, blockState2, world, blockPos);
        world.setBlockState(blockPos, blockState2, Block.NOTIFY_LISTENERS);
        world.updateComparators(blockPos,BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK);
        context.getStack().decrement(1);
        world.syncWorldEvent(WorldEvents.END_PORTAL_FRAME_FILLED, blockPos, 0);
        BlockPattern.Result result = EnderiteEndPortalFrameBlock.getCompletedFramePattern().searchAround(world, blockPos);
        if (result != null) {
            BlockPos blockPos2 = result.getFrontTopLeft().add(-3, 0, -3);
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    world.setBlockState(blockPos2.add(i, 0, j), Blocks.END_PORTAL.getDefaultState(), Block.NOTIFY_LISTENERS);
                }
            }
            world.syncGlobalEvent(WorldEvents.END_PORTAL_OPENED, blockPos2.add(1, 0, 1), 0);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ServerWorld serverWorld;
        BlockPos blockPos;
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = EnderEyeItem.raycast(world, user, RaycastContext.FluidHandling.NONE);
        if (blockHitResult.getType() == HitResult.Type.BLOCK && world.getBlockState(blockHitResult.getBlockPos()).isOf(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK)) {
            return TypedActionResult.pass(itemStack);
        }
        user.setCurrentHand(hand);
        if (world instanceof ServerWorld && (blockPos = (serverWorld = (ServerWorld)world).locateStructure(StructureTags.EYE_OF_ENDER_LOCATED, user.getBlockPos(), 100, false)) != null) {
            EyeOfEnderEntity eyeOfEnderEntity = new EyeOfEnderEntity(world, user.getX(), user.getBodyY(0.5), user.getZ());
            eyeOfEnderEntity.setItem(itemStack);
            eyeOfEnderEntity.initTargetPos(blockPos);
            world.emitGameEvent(GameEvent.PROJECTILE_SHOOT, eyeOfEnderEntity.getPos(), GameEvent.Emitter.of(user));
            world.spawnEntity(eyeOfEnderEntity);
            if (user instanceof ServerPlayerEntity) {
                Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity)user, blockPos);
            }
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            world.syncWorldEvent(null, WorldEvents.EYE_OF_ENDER_LAUNCHES, user.getBlockPos(), 0);
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            user.swingHand(hand, true);
            return TypedActionResult.success(itemStack);
        }
        return TypedActionResult.consume(itemStack);
    }
}
