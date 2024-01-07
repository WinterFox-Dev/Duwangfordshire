package com.sheppard.entity;

import net.minecraft.entity.ai.goal.Goal;

public class DuckFlyGoal extends Goal {
    @Override
    public boolean canStart() {
        return false;
    }
}
