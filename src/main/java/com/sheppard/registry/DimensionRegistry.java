package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class DimensionRegistry {
    public static final RegistryKey<DimensionOptions> WARDEN_DIM_OPTIONS = RegistryKey.of(
            RegistryKeys.DIMENSION, new Identifier(DuwangfordshireMod.MODID, "warden_dimension")
    );

    public static final RegistryKey<World> WARDEN_LEVEL_KEY = RegistryKey.of(
            RegistryKeys.WORLD, new Identifier(DuwangfordshireMod.MODID, "warden_dimension")
    );

    public static final RegistryKey<DimensionType> WARDEN_DIM_TYPE = RegistryKey.of(
            RegistryKeys.DIMENSION_TYPE, new Identifier(DuwangfordshireMod.MODID, "warden_dimension_type")
    );

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(WARDEN_DIM_TYPE, new DimensionType(
           OptionalLong.of(12000), //fixedTime
           false, //has skylight
           false, //has ceiling
           false, //ultrawarm
           true, //natural
           50.0, //coordinate scale
           false, //bed works
           false, //respawn anchor works
           0, //min Y
           256, //height
           256, //logical height
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID, //effect location
                1.0f, //ambient light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)
        ));
    }
}
