package com.sheppard;

import com.sheppard.registry.DuwangfordshirePredicateProviders;
import net.fabricmc.api.ClientModInitializer;

public class DuwangfordshireClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DuwangfordshirePredicateProviders.registerPredicateProviders();
	}
}