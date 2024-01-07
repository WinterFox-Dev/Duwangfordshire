package com.sheppard.entity;

import com.sheppard.DuwangfordshireMod;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

import java.util.EnumSet;
import java.util.Random;

public class FlapGoal extends Goal {

    private final MobEntity mob;

    private Random rand = new Random();

    private int flapTick = rand.nextInt(0, 201);

    public FlapGoal(MobEntity mob) {
        this.mob = mob;
    }
    @Override
    public boolean canStart() {
        if (this.mob instanceof DuckEntity duck) {
            return duck.shouldFlap();
        }
        return false;
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if(this.mob instanceof DuckEntity duck) {
            //DuwangfordshireMod.LOGGER.info("FlapGoal Tick="+flapTick);
            if(!this.mob.isOnGround() && !this.mob.isTouchingWater()) {
                duck.flap();
            } else {
                if(flapTick <= 0) {
                    flapTick = rand.nextInt(0, 201);
                    duck.flap();
                }
            }
            flapTick--;
        }
    }


}
