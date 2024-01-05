package com.sheppard.event;

import com.sheppard.block.EnderiteEndPortalFrameBlock;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class EventCallbacks {

    public static void registerCallbacks() {
        ServerTickEvents.END_WORLD_TICK.register(new LavaWalkerHandler());
        PlayerBlockBreakEvents.AFTER.register(new EnderiteEndPortalFrameHandler());
        UseEntityCallback.EVENT.register(new AxolotlStickHandler());
    }

}
