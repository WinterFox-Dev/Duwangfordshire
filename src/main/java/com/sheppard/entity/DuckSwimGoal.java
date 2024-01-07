package com.sheppard.entity;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.EnumSet;

public class DuckSwimGoal extends Goal {
    private final MobEntity mob;

    public DuckSwimGoal(MobEntity mob) {
        this.mob = mob;
    }

    public boolean canStart() {
        return this.mob.isTouchingWater() && this.mob.getFluidHeight(FluidTags.WATER) > this.mob.getSwimHeight() || this.mob.isInLava();
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if(this.mob.getFluidHeight(FluidTags.WATER) > this.mob.getSwimHeight()) {
            this.mob.setPos(this.mob.getX(), this.mob.getFluidHeight(FluidTags.WATER), this.mob.getZ());
            this.mob.getWorld().playSound(this.mob, this.mob.getBlockPos(), SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.AMBIENT, 1.0F, 1.0F);
        }
    }
}
