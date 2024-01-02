package com.sheppard.item;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.block.DuwangfordshireBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DuwangfordshireItems {

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), new BlockItem(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE, new FabricItemSettings()));
    }
}
