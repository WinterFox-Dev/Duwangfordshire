package com.sheppard.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class TeleportToNetherStatusEffect extends StatusEffect {
    public TeleportToNetherStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x963841);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //todo: fix bug where crashes if nether doesnt exist yet
        if(entity.getEntityWorld().isClient()) {
            return;
        } else {
            entity.getEntityWorld().playSound(entity, entity.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            entity.moveToWorld(entity.getEntityWorld().getServer().getWorld(World.NETHER));
        }

    }
}
