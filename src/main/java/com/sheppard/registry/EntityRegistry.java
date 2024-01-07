package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.DuckEntity;
import com.sheppard.entity.ExplosiveArrowEntity;
import com.sheppard.entity.TorchArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityRegistry {
    public static final EntityType<ExplosiveArrowEntity> EXPLOSIVE_ARROW = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DuwangfordshireMod.MODID, "explosive_arrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, (EntityType.EntityFactory<ExplosiveArrowEntity>)ExplosiveArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build()
    );
    public static final EntityType<TorchArrowEntity> TORCH_ARROW = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DuwangfordshireMod.MODID, "torch_arrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, (EntityType.EntityFactory<TorchArrowEntity>)TorchArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build()
    );

    public static final EntityType<DuckEntity> DUCK = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DuwangfordshireMod.MODID, "duck"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, DuckEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3F, 0.3F)).build()
    );
    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(DUCK,
                MobEntity.createMobAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
                        .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.5)
        );
    }
}
