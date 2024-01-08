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

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        World world = target.getEntityWorld();
        if(world instanceof ServerWorld serverWorld) {
            target.moveToWorld(serverWorld.getServer().getWorld(World.END));
            target.moveToWorld(serverWorld.getServer().getWorld(World.OVERWORLD));
            target.getEntityWorld().playSound(null, target.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        }
    }
}
