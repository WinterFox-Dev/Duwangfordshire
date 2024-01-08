package com.sheppard.potion;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.mixin.EntityInvoker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TeleportToNetherStatusEffect extends InstantStatusEffect {
    public TeleportToNetherStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x963841);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        World world = target.getEntityWorld();
        boolean failed = false;
        if (world instanceof ServerWorld serverWorld) {
            try {
                ((EntityInvoker) target).invokeGetTeleportTarget(serverWorld.getServer().getWorld(World.NETHER));
                target.moveToWorld(serverWorld.getServer().getWorld(World.NETHER));
                target.getEntityWorld().playSound(null, target.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            } catch (NullPointerException e) {
                if (!world.isClient) {
                    target.getEntityWorld().playSound(null, target.getBlockPos(), SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    serverWorld.spawnParticles(ParticleTypes.ASH, target.getX(), target.getY(), target.getZ(), 200, 0.5, 2, 0.5, 0.5);
                }
            }
        }
    }
}
