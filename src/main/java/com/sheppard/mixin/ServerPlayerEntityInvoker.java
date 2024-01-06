package com.sheppard.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Debug(export = true)
@Mixin(ServerPlayerEntity.class)
public abstract interface ServerPlayerEntityInvoker {

    @Invoker("forgiveMobAnger")
    public abstract void invokeForgiveMobAnger();
}
