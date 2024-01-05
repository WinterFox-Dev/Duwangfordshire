package com.sheppard.potion;

import com.sheppard.DuwangfordshireMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TeleportToBedStatusEffect extends StatusEffect {
    public TeleportToBedStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x56d1b8);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.getEntityWorld().playSound(entity, entity.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        if (entity instanceof ServerPlayerEntity && !entity.getEntityWorld().isClient()) {
            entity.getServer().getPlayerManager().respawnPlayer(((ServerPlayerEntity)entity), true);
        } else {
            BlockPos spawnPos = entity.getEntityWorld().getSpawnPos();
            entity.setPos(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        }
    }
}
