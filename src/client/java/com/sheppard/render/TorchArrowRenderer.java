package com.sheppard.render;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.ExplosiveArrowEntity;
import com.sheppard.entity.TorchArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class TorchArrowRenderer extends ProjectileEntityRenderer<TorchArrowEntity> {

    public static final Identifier TEXTURE = new Identifier(DuwangfordshireMod.MODID, "textures/entity/torch_arrow.png");

    public TorchArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TorchArrowEntity entity) {
        return TEXTURE;
    }
}
