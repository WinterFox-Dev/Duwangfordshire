package com.sheppard.render;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.ExplosiveArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ExplosiveArrowRenderer extends ProjectileEntityRenderer<ExplosiveArrowEntity> {

    public static final Identifier TEXTURE = new Identifier(DuwangfordshireMod.MODID, "textures/entity/explosive_arrow.png");

    public ExplosiveArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ExplosiveArrowEntity entity) {
        return TEXTURE;
    }
}
