package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.enchantment.LavaWalkerEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.event.GameEvent;

public class EnchantmentRegistry {

    public static Enchantment LAVA_WALKER = new LavaWalkerEnchantment();

    public static void registerEnchantments() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(DuwangfordshireMod.MODID, "lava_walker"), LAVA_WALKER);
    }
}
