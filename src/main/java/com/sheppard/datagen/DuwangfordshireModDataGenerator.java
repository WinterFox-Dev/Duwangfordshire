package com.sheppard.datagen;

import com.sheppard.block.DuwangfordshireBlocks;
import com.sheppard.item.DuwangfordshireItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Util;
import org.apache.commons.compress.utils.Lists;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class DuwangfordshireModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        final FabricDataGenerator.Pack pack = gen.createPack();
        pack.addProvider(DuwangfordshireEnglishLangProvider::new);
        pack.addProvider(DuwangfordshireModelGenerator::new);
        pack.addProvider(DuwangfordshireLootTableGenerator::new);
        pack.addProvider(DuwangfordshireRecipeGenerator::new);
    }

    private static class DuwangfordshireRecipeGenerator extends FabricRecipeProvider {
        public DuwangfordshireRecipeGenerator(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            //cherry crafting table
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE)
                    .pattern("xx").pattern("xx")
                    .input('x', Blocks.CHERRY_PLANKS)
                    .criterion("has_cherry_planks", conditionsFromItem(Blocks.CHERRY_PLANKS))
                    .offerTo(exporter);


            //vanilla crafting table

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CRAFTING_TABLE)
                    .pattern("xx").pattern(("xx"))
                    .input('x', Ingredient.ofItems(Blocks.ACACIA_PLANKS, Blocks.BAMBOO_PLANKS, Blocks.BIRCH_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.WARPED_PLANKS))
                    .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                    .offerTo(exporter);
        }
    }

    private static class DuwangfordshireLootTableGenerator extends FabricBlockLootTableProvider {
        public DuwangfordshireLootTableGenerator(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            addDrop(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE, drops(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE));
        }
    }

    private static class DuwangfordshireModelGenerator extends FabricModelProvider {
        private DuwangfordshireModelGenerator(FabricDataOutput gen) {
            super(gen);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator bsmGen) {
            //this block has weird json data, easier just to write it manually
            //bsmGen.registerSimpleCubeAll(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGen) {

        }
    }

    private static class DuwangfordshireEnglishLangProvider extends FabricLanguageProvider {

        private DuwangfordshireEnglishLangProvider(FabricDataOutput dataGen) {
            super(dataGen, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE, "Cherry Crafting Table");

            try {
                Optional<Path> existingFilePath = dataOutput.getModContainer().findPath("assets/duwangfordshire/lang/en_us.existing.json");
                if(existingFilePath.isPresent()) {
                    translationBuilder.add(existingFilePath.get());
                } else {
                    throw new RuntimeException("The existing language file could not be found in the Duwangfordshire assets!");
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to add existing language file!", e);
            }
        }
    }
}
