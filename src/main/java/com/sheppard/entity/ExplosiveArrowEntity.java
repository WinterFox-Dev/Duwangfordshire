package com.sheppard.entity;

import com.sheppard.registry.EntityRegistry;
import com.sheppard.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class ExplosiveArrowEntity extends PersistentProjectileEntity {

    private static final ItemStack DEFAULT_STACK = new ItemStack(ItemRegistry.EXPLOSIVE_ARROW);

    public ExplosiveArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world, DEFAULT_STACK);
    }

    public ExplosiveArrowEntity(World world, double x, double y, double z) {
        super(EntityRegistry.EXPLOSIVE_ARROW, x, y, z, world, DEFAULT_STACK);
    }

    public ExplosiveArrowEntity(World world, LivingEntity owner) {
        super(EntityRegistry.EXPLOSIVE_ARROW, owner, world, DEFAULT_STACK);
    }

    @Override
    protected void onHit(LivingEntity target) {
        if(target instanceof CreeperEntity creeper) {
            creeper.ignite();
            for(int i = 0; i < 31; i++) {
                creeper.tick();
            }
            this.discard();

        } else {
            super.onHit(target);
            target.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, true, World.ExplosionSourceType.TNT);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, true, World.ExplosionSourceType.TNT);
        this.discard();
    }
}
