package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.world.dimension.biome.surface.DuwangMaterialRules;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class BiomeRegistry {

    public static final RegistryKey<Biome> WARDEN_BIOME = RegistryKey.of(
            RegistryKeys.BIOME, new Identifier(DuwangfordshireMod.MODID, "warden_biome")
    );
    /*
    public static final RegistryKey<MaterialRules.MaterialRule> WARDEN_MATERIAL_RULES = RegistryKey.of(
            RegistryKeys.MATERIAL_RULE, new Identifier(DuwangfordshireMod.MODID, "warden_material_rules")
    );

    public static void bootstrapBiomes(Registerable<Biome> context) {
        context.register(WARDEN_BIOME, wardenBiome(context));
    }

    public static void bootstrapMaterialRules(Registerable<MaterialRules.MaterialRule> context) {
        context.register(WARDEN_MATERIAL_RULES, DuwangMaterialRules.makeRules());
    }

     */

    public static Biome wardenBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x0)
                        .waterFogColor(0x0)
                        .skyColor(0x0)
                        .grassColor(0x0)
                        .foliageColor(0x0)
                        .fogColor(0x0)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();

    }
}
