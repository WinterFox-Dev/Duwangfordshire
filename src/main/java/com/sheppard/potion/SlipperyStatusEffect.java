package com.sheppard.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SlipperyStatusEffect extends StatusEffect {
    public SlipperyStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x81c0eb);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //((EntityAccessor)entity).setDefaultFriction(0.1F);
    }
}
