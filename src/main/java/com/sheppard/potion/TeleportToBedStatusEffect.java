package com.sheppard.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TeleportToBedStatusEffect extends InstantStatusEffect {
    public TeleportToBedStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x56d1b8);
    }

    /*
    public void teleportToOverworld(Entity entity, ServerWorld destination) {
        if (entity.getWorld() instanceof ServerWorld && !entity.isRemoved()) {
            if (destination.getRegistryKey() == World.OVERWORLD) {
                TeleportTarget teleportTarget = ((EntityInvoker) entity).getTeleportTarget(destination);
                if (teleportTarget == null) {
                    return;
                } else {
                    entity.requestTeleport(teleportTarget.position.x, teleportTarget.position.y, teleportTarget.position.z);
                }
            } else {
                entity.getWorld().getProfiler().push("changeDimension");
                entity.detach();
                entity.getWorld().getProfiler().push("reposition");
                TeleportTarget teleportTarget = ((EntityInvoker) entity).getTeleportTarget(destination);
                if (teleportTarget == null) {
                    return;
                } else {
                    entity.getWorld().getProfiler().swap("reloading");
                    Entity teleportedEntity = entity.getType().create(destination);
                    if (teleportedEntity != null) {
                        teleportedEntity.copyFrom(entity);
                        teleportedEntity.refreshPositionAndAngles(teleportTarget.position.x, teleportTarget.position.y, teleportTarget.position.z, teleportTarget.yaw, teleportedEntity.getPitch());
                        teleportedEntity.setVelocity(teleportTarget.velocity);
                        destination.onDimensionChanged(teleportedEntity);
                        if (destination.getRegistryKey() == World.END) {
                            ServerWorld.createEndSpawnPlatform(destination);
                        }
                    }

                    ((EntityInvoker) entity).removeFromDimension();
                    entity.getWorld().getProfiler().pop();
                    ((ServerWorld) entity.getWorld()).resetIdleTimeout();
                    destination.resetIdleTimeout();
                    entity.getWorld().getProfiler().pop();
                }
            }
        }
    }

     */

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        World world = target.getEntityWorld();
        if(world instanceof ServerWorld serverWorld) {
            target.moveToWorld(serverWorld.getServer().getWorld(World.END));
            target.moveToWorld(serverWorld.getServer().getWorld(World.OVERWORLD));
            target.getEntityWorld().playSound(target, target.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        }
    }
}
