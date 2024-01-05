package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.potion.TeleportStatusEffect;
import com.sheppard.potion.TeleportToBedStatusEffect;
import com.sheppard.potion.TeleportToEndStatusEffect;
import com.sheppard.potion.TeleportToNetherStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffectRegistry {

    public static final StatusEffect TELEPORT = new TeleportStatusEffect();
    public static final StatusEffect TELEPORT_END = new TeleportToEndStatusEffect();
    public static final StatusEffect TELEPORT_NETHER = new TeleportToNetherStatusEffect();
    public static final StatusEffect TELEPORT_BED = new TeleportToBedStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport"), TELEPORT);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_end"), TELEPORT_END);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_nether"), TELEPORT_NETHER);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DuwangfordshireMod.MODID, "teleport_bed"), TELEPORT_BED);
    }
}
