package com.sheppard.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class TeleportStatusEffect  extends StatusEffect {
    public TeleportStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x873AA4);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    //@Override
    public void applyUpdateEffect2(LivingEntity entity, int amplifier) {
        Random rand = new Random();
        if(rand.nextInt(1, 101) == 100) {
            entity.getEntityWorld().playSound(entity, entity.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if(rand.nextInt(1, 3) == 1) {
                entity.moveToWorld(entity.getEntityWorld().getServer().getWorld(World.END));
            } else {
                entity.moveToWorld(entity.getEntityWorld().getServer().getWorld(World.NETHER));
            }
        } else {
            int amp = amplifier + 1;
            entity.setPos(entity.getX() + (-5*amp + rand.nextDouble()*10*amp), entity.getY()+ (-5*amp + rand.nextDouble()*10*amp), entity.getZ()+ (-5*amp + rand.nextDouble()*10*amp));
            entity.getEntityWorld().playSound(entity, entity.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        Random rand = new Random();
        World world = entity.getEntityWorld();
        int amp = amplifier + 1;
        //1% chance to randomly change worlds
        if(rand.nextInt(1, 101) == 100) {
            if(world instanceof  ServerWorld serverWorld) {
                //teleport to end
                if (rand.nextInt(1, 3) == 1) {
                    entity.moveToWorld(serverWorld.getServer().getWorld(World.END));
                    //teleport to nether
                } else {
                    entity.moveToWorld(serverWorld.getServer().getWorld(World.NETHER));
                }
            }

        //otherwise teleport around
        } else {
            if(!world.isClient) {
                if(entity instanceof ServerPlayerEntity serverPlayerEntity) {
                    if (serverPlayerEntity.networkHandler.isConnectionOpen() && serverPlayerEntity.getWorld() == world && !serverPlayerEntity.isSleeping()) {
                        if(entity.hasVehicle()) {
                            serverPlayerEntity.requestTeleportAndDismount(entity.getX() + (-5*amp + rand.nextDouble()*10*amp), entity.getY()+ (-5*amp + rand.nextDouble()*10*amp), entity.getZ()+ (-5*amp + rand.nextDouble()*10*amp));
                        } else {
                            entity.requestTeleport(entity.getX() + (-5*amp + rand.nextDouble()*10*amp), entity.getY()+ (-5*amp + rand.nextDouble()*10*amp), entity.getZ()+ (-5*amp + rand.nextDouble()*10*amp));
                        }
                    }
                    //non player entity
                } else {
                    entity.requestTeleport(entity.getX() + (-5*amp + rand.nextDouble()*10*amp), entity.getY()+ (-5*amp + rand.nextDouble()*10*amp), entity.getZ()+ (-5*amp + rand.nextDouble()*10*amp));
                }
            }
            entity.getEntityWorld().playSound(entity, entity.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        }
    }

}
