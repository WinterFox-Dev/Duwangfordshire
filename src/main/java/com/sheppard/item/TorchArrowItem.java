package com.sheppard.item;

import com.sheppard.entity.ExplosiveArrowEntity;
import com.sheppard.entity.TorchArrowEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TorchArrowItem extends ArrowItem {
    public TorchArrowItem(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new TorchArrowEntity(world, shooter);
    }
}
