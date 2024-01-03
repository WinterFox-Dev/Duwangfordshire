package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class WorldGenRegistry {

    public static final RegistryKey<PlacedFeature> ENDERITE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DuwangfordshireMod.MODID, "ore_end_enderite"));

    public static void registerBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ENDERITE_ORE_PLACED_KEY);
    }
}
