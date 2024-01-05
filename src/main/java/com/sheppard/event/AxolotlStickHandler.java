package com.sheppard.event;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.registry.ItemRegistry;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AxolotlStickHandler implements UseEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if(hitResult == null) {
            return ActionResult.PASS;
        }
        if(!(hitResult.getEntity() instanceof AxolotlEntity)) {
            return ActionResult.PASS;
        }
        if(!(player.getStackInHand(hand).getItem() == Items.STICK)) {
            return ActionResult.PASS;
        }
        player.getStackInHand(hand).decrement(1);
        player.giveItemStack(new ItemStack(ItemRegistry.AXOLOTL_ON_STICK));
        world.playSound(player, player.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        hitResult.getEntity().discard();
        return ActionResult.SUCCESS;
    }
}
