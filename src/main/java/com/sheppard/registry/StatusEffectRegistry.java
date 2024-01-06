package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.potion.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffectRegistry {

    public static final StatusEffect TELEPORT = new TeleportStatusEffect();
    public static final StatusEffect TELEPORT_END = new TeleportToEndStatusEffect();
    public static final StatusEffect TELEPORT_NETHER = new TeleportToNetherStatusEffect();
    public static final StatusEffect TELEPORT_BED = new TeleportToBedStatusEffect();
    public static final StatusEffect FORGIVE_ANGER = new ResetAggroStatusEffect();
    public static final StatusEffect SLIPPERY = new SlipperyStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport"), TELEPORT);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_end"), TELEPORT_END);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_nether"), TELEPORT_NETHER);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_bed"), TELEPORT_BED);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "forgive_anger"), FORGIVE_ANGER);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "slippery"), SLIPPERY);
    }
}
