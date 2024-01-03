package com.sheppard.block;

import com.sheppard.screen.NetheriteAnvilScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NetheriteAnvil extends AnvilBlock {

    private static final Text TITLE = Text.translatable("container.repair");
    public NetheriteAnvil(FabricBlockSettings settings) {
        super(settings);
    }

    @Override
    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new NetheriteAnvilScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE);
    }

    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(6.0f, 80);
    }
}
