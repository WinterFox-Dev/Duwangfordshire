package com.sheppard.world.dimension.biome.surface;

import com.sheppard.registry.BiomeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class DuwangMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.WARPED_DOOR);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.IRON_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeRegistry.WARDEN_BIOME),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
                )));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
