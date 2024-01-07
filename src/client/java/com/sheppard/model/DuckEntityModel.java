package com.sheppard.model;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.DuckEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.model.GeoModel;

public class DuckEntityModel extends GeoModel<DuckEntity> {
    @Override
    public Identifier getModelResource(DuckEntity animatable) {
        return new Identifier(DuwangfordshireMod.MODID, "geo/duck.json");
    }

    @Override
    public Identifier getTextureResource(DuckEntity animatable) {
        return new Identifier(DuwangfordshireMod.MODID, "textures/entity/duck_mallard_m.png");
    }

    @Override
    public Identifier getAnimationResource(DuckEntity animatable) {
        return new Identifier(DuwangfordshireMod.MODID, "animations/duck.json");
    }
}