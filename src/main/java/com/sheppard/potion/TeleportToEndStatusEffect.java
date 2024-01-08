package com.sheppard.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TeleportToEndStatusEffect extends InstantStatusEffect {
    public TeleportToEndStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x4c6cb5);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        //todo: fix bug where crashes if end doesnt exist yet
        target.getEntityWorld().playSound(target, target.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        World world = target.getEntityWorld();
        if(world instanceof ServerWorld serverWorld) {
            target.moveToWorld(serverWorld.getServer().getWorld(World.END));
        }
    }
}
