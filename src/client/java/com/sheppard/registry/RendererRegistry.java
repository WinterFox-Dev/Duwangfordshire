package com.sheppard.registry;

import com.sheppard.render.ExplosiveArrowRenderer;
import com.sheppard.render.TorchArrowRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RendererRegistry {

  public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityRegistry.EXPLOSIVE_ARROW, ExplosiveArrowRenderer::new);

      EntityRendererRegistry.register(EntityRegistry.TORCH_ARROW, TorchArrowRenderer::new);

    }
}
