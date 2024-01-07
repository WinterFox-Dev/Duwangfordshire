package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.model.DuckEntityModel;
import com.sheppard.render.DuckEntityRenderer;
import com.sheppard.render.ExplosiveArrowRenderer;
import com.sheppard.render.TorchArrowRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class RendererRegistry {
  public static void registerEntityRenderers() {
      EntityRendererRegistry.register(EntityRegistry.EXPLOSIVE_ARROW, ExplosiveArrowRenderer::new);

      EntityRendererRegistry.register(EntityRegistry.TORCH_ARROW, TorchArrowRenderer::new);

      EntityRendererRegistry.register(EntityRegistry.DUCK, DuckEntityRenderer::new);

    }
}
