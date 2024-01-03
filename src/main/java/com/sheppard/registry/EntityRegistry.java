package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.ExplosiveArrowEntity;
import com.sheppard.entity.TorchArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
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
    public static void registerEntities() {
    }
}
