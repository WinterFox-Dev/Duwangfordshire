package com.sheppard.potion;

import com.sheppard.mixin.ServerPlayerEntityInvoker;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;

public class ResetAggroStatusEffect extends StatusEffect {
    public ResetAggroStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xb08d2c);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            ((ServerPlayerEntityInvoker) player).invokeForgiveMobAnger();
        }
    }
}
