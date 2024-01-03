package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.block.CherryCraftingTableBlock;
import com.sheppard.block.EnderiteEndPortalFrameBlock;
import com.sheppard.block.NetheriteAnvil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockRegistry {

    public static final Block CHERRY_BLOSSOM_CRAFTING_TABLE = new CherryCraftingTableBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE));
    public static final Block NETHERITE_ANVIL = new NetheriteAnvil(FabricBlockSettings.copyOf(Blocks.ANVIL));
    public static final Block ENDERITE_ORE = new Block(FabricBlockSettings.create().strength(1.5F).mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool());

    public static final Block ENDERITE_END_PORTAL_FRAME_BLOCK = new EnderiteEndPortalFrameBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.GLASS).luminance(state -> 1).strength(5.0f, 6.0f).requiresTool());
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), CHERRY_BLOSSOM_CRAFTING_TABLE);
        Registry.register(Registries.BLOCK, new Identifier(DuwangfordshireMod.MODID, "netherite_anvil"), NETHERITE_ANVIL);
        Registry.register(Registries.BLOCK, new Identifier((DuwangfordshireMod.MODID), "enderite_ore"), ENDERITE_ORE);
        Registry.register(Registries.BLOCK, new Identifier((DuwangfordshireMod.MODID), "enderite_end_portal_frame"), ENDERITE_END_PORTAL_FRAME_BLOCK);
    }
}
