package com.sheppard.render;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.entity.DuckEntity;
import com.sheppard.model.DuckEntityModel;
import com.sheppard.registry.EntityRegistry;
import com.sheppard.registry.RendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DuckEntityRenderer extends GeoEntityRenderer<DuckEntity> {
    public DuckEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckEntityModel());
    }
}
