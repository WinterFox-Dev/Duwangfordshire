package com.sheppard.event;

import com.sheppard.registry.DuwangfordshireItems;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class DuwangfordshireEventCallbacks {

    public static void registerUseItemCallbacks() {
        /*
        UseItemCallback.EVENT.register((player, world, hand) -> {
            if(player.getActiveItem() != null) {
                if(player.getActiveItem().getItem() == DuwangfordshireItems.GOLD_BOW) {
                    player.addExperienceLevels(1);
                }
            }
            return TypedActionResult.pass(ItemStack.EMPTY);
        });
         */
    }
}
