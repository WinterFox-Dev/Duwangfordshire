package com.sheppard.block;

import com.sheppard.screen.CherryCraftingScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CherryCraftingTableBlock extends CraftingTableBlock {
    private static final Text TITLE = Text.translatable("container.crafting");

    public CherryCraftingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
            return new CherryCraftingScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos));
        }, TITLE);
    }
}
