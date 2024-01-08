package com.sheppard.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public abstract interface EntityInvoker {

    @Invoker("getTeleportTarget")
    public abstract TeleportTarget invokeGetTeleportTarget(ServerWorld destination);
}
