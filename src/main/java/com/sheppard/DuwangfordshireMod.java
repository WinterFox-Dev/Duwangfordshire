package com.sheppard;

import com.sheppard.event.EventCallbacks;
import com.sheppard.registry.BlockRegistry;
import com.sheppard.registry.EntityRegistry;
import com.sheppard.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuwangfordshireMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "duwangfordshire";
    public static final Logger LOGGER = LoggerFactory.getLogger(DuwangfordshireMod.MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from Duwangfordshire!");

		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();
		ItemRegistry.registerItemGroups();
		EventCallbacks.registerUseItemCallbacks();
		//EntityRegistry.registerEntities();

	}
}