package com.sheppard.entity;

import com.sheppard.DuwangfordshireMod;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

import java.util.Random;

public class DivingGoal extends Goal {

    private final MobEntity mob;

    private Random rand = new Random();

    private int diveTick = rand.nextInt(0, 201);

    public DivingGoal(MobEntity mob) {
        this.mob = mob;
    }
    @Override
    public boolean canStart() {
        if (this.mob instanceof DuckEntity duck && duck.isTouchingWater()) {
            return duck.shouldDive();
        }
        return false;
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if(this.mob instanceof DuckEntity duck) {
            //DuwangfordshireMod.LOGGER.info("DiveGoal Tick="+diveTick);
            if(diveTick <= 0) {
                diveTick = rand.nextInt(0, 201);
                duck.dive();
            }
            diveTick--;
        }
    }


}
