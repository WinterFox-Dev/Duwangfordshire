package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.block.CherryCraftingTableBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegistry {

    public static final Block CHERRY_BLOSSOM_CRAFTING_TABLE = new CherryCraftingTableBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE));

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), CHERRY_BLOSSOM_CRAFTING_TABLE);
    }
}
