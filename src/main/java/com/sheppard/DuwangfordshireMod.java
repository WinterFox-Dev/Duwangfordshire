package com.sheppard;

import com.sheppard.event.DuwangfordshireEventCallbacks;
import com.sheppard.registry.DuwangfordshireBlocks;
import com.sheppard.registry.DuwangfordshireItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
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

		DuwangfordshireBlocks.registerBlocks();
		DuwangfordshireItems.registerItems();
		DuwangfordshireItems.registerItemGroups();
		DuwangfordshireEventCallbacks.registerUseItemCallbacks();

	}
}