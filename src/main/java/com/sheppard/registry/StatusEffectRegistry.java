package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.potion.TeleportStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffectRegistry {

    public static final StatusEffect TELEPORT = new TeleportStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport"), TELEPORT);
    }
}
