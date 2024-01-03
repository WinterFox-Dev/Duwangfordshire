package com.sheppard;

import com.sheppard.registry.RendererRegistry;
import com.sheppard.registry.PredicateProviderRegistry;
import net.fabricmc.api.ClientModInitializer;

public class DuwangfordshireClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		PredicateProviderRegistry.registerPredicateProviders();
		RendererRegistry.registerEntityRenderers();
	}
}