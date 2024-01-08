package com.sheppard.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NinjaEscapeStatusEffect extends InstantStatusEffect {
    public NinjaEscapeStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xd66790);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        World world = target.getEntityWorld();
        if(!world.isClient) {
            if(world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, target.getX(), target.getY(), target.getZ(), 400, 0.1, 0.1, 0.1, 0.1);
            }
        }
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 0));
    }
}
