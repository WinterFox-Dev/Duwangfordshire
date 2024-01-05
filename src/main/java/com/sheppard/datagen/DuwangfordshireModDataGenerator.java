package com.sheppard.datagen;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.registry.BlockRegistry;
import com.sheppard.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE)
                    .pattern("xx").pattern("xx")
                    .input('x', Blocks.CHERRY_PLANKS)
                    .criterion("has_cherry_planks", conditionsFromItem(Blocks.CHERRY_PLANKS))
                    .offerTo(exporter);

            //Netherite Anvil
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.NETHERITE_ANVIL)
                    .pattern("ZZZ")
                    .pattern(" Y ")
                    .pattern("YYY")
                    .input('Z', Items.NETHERITE_BLOCK)
                    .input('Y', Items.NETHERITE_INGOT)
                    .criterion("has_netherite_block", conditionsFromItem(Items.NETHERITE_BLOCK))
                    .offerTo(exporter);


            //vanilla crafting table
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CRAFTING_TABLE)
                    .pattern("xx").pattern(("xx"))
                    .input('x', Ingredient.ofItems(Blocks.ACACIA_PLANKS, Blocks.BAMBOO_PLANKS, Blocks.BIRCH_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.WARPED_PLANKS))
                    .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                    .offerTo(exporter);

            //gold bow
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemRegistry.GOLD_BOW)
                    .pattern("XY ")
                    .pattern("X Y")
                    .pattern("XY ")
                    .input('Y', Items.GOLD_INGOT)
                    .input('X', Items.STRING)
                    .criterion("has_gold", conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);

            //iron bow
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemRegistry.IRON_BOW)
                    .pattern("XY ")
                    .pattern("X Y")
                    .pattern("XY ")
                    .input('Y', Items.IRON_INGOT)
                    .input('X', Items.STRING)
                    .criterion("has_iron", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

            //Torch Arrow
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemRegistry.TORCH_ARROW, 3)
                    .pattern("  Z")
                    .pattern(" Y ")
                    .pattern("X  ")
                    .input('X', Items.FEATHER)
                    .input('Y', Items.STICK)
                    .input('Z', Items.TORCH)
                    .criterion("has_torch", conditionsFromItem(Items.TORCH))
                    .offerTo(exporter);

            //Explosive Arrow
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemRegistry.EXPLOSIVE_ARROW, 3)
                    .pattern("  Z")
                    .pattern(" Y ")
                    .pattern("X  ")
                    .input('X', Items.FEATHER)
                    .input('Y', Items.STICK)
                    .input('Z', ItemRegistry.GUNPOWDER_SACHET)
                    .criterion("has_gunpowder_sachet", conditionsFromItem(ItemRegistry.GUNPOWDER_SACHET))
                    .offerTo(exporter);

            //Enderite End Portal Frame
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK)
                    .pattern("X X")
                    .pattern("YXY")
                    .pattern("YYY")
                    .input('X', ItemRegistry.ENDERITE_INGOT)
                    .input('Y', Blocks.END_STONE)
                    .criterion("has_enderite_ingot", conditionsFromItem(ItemRegistry.ENDERITE_INGOT))
                    .offerTo(exporter);


            //gunpowder sachet
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegistry.GUNPOWDER_SACHET, 2)
                    .input(Items.GUNPOWDER, 2)
                    .input(Items.LEATHER, 2)
                    .criterion("has_gunpowder", conditionsFromItem(Items.GUNPOWDER))
                    .offerTo(exporter);

            //Synthetic Eye of Ender
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegistry.SYNTHETIC_ENDER_EYE, 1)
                    .input(ItemRegistry.ENDERITE_INGOT, 1)
                    .input(Items.ENDER_EYE, 1)
                    .criterion("has_enderite_ingot", conditionsFromItem(ItemRegistry.ENDERITE_INGOT))
                    .offerTo(exporter);

            //SMELTING

            //enderite ingot
            RecipeProvider.offerSmelting(exporter, List.of(BlockRegistry.ENDERITE_ORE), RecipeCategory.MISC, ItemRegistry.ENDERITE_INGOT, 0.45F, 200, DuwangfordshireMod.MODID);
            RecipeProvider.offerBlasting(exporter, List.of(BlockRegistry.ENDERITE_ORE), RecipeCategory.MISC, ItemRegistry.ENDERITE_INGOT, 0.45F, 100, DuwangfordshireMod.MODID);

            RecipeProvider.offerSmelting(exporter, List.of(ItemRegistry.AXOLOTL_ON_STICK), RecipeCategory.FOOD, ItemRegistry.COOKED_AXOLOTL_ON_STICK, 1.0F, 200, DuwangfordshireMod.MODID);
            //figure out that other cooking thing
            //RecipeProvider.offer(exporter, List.of(ItemRegistry.AXOLOTL_ON_STICK), RecipeCategory.FOOD, ItemRegistry.COOKED_AXOLOTL_ON_STICK, 1.0F, 100, DuwangfordshireMod.MODID);
        }


    }

    private static class DuwangfordshireLootTableGenerator extends FabricBlockLootTableProvider {
        public DuwangfordshireLootTableGenerator(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            addDrop(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE, drops(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE));
            addDrop(BlockRegistry.NETHERITE_ANVIL, drops(BlockRegistry.NETHERITE_ANVIL));
            addDrop(BlockRegistry.ENDERITE_ORE, drops(BlockRegistry.ENDERITE_ORE));
            addDrop(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK, drops(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK));
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
            bsmGen.registerAnvil(BlockRegistry.NETHERITE_ANVIL);
            bsmGen.registerSimpleCubeAll(BlockRegistry.ENDERITE_ORE);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGen) {
            //this item has weird json data, easier to write it manually
            //itemModelGen.register(DuwangfordshireItems.GOLD_BOW, Models.GENERATED);
            itemModelGen.register(ItemRegistry.EXPLOSIVE_ARROW, Models.GENERATED);
            itemModelGen.register(ItemRegistry.TORCH_ARROW, Models.GENERATED);
            itemModelGen.register(ItemRegistry.GUNPOWDER_SACHET, Models.GENERATED);
            itemModelGen.register(ItemRegistry.ENDERITE_INGOT, Models.GENERATED);
            itemModelGen.register(ItemRegistry.SYNTHETIC_ENDER_EYE, Models.GENERATED);
            itemModelGen.register(ItemRegistry.AXOLOTL_ON_STICK, Models.GENERATED);
            itemModelGen.register(ItemRegistry.COOKED_AXOLOTL_ON_STICK, Models.GENERATED);
        }
    }

    private static class DuwangfordshireEnglishLangProvider extends FabricLanguageProvider {

        private DuwangfordshireEnglishLangProvider(FabricDataOutput dataGen) {
            super(dataGen, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE, "Cherry Crafting Table");
            translationBuilder.add(ItemRegistry.GOLD_BOW, "Gold Bow");
            translationBuilder.add(ItemRegistry.IRON_BOW, "Iron Bow");
            translationBuilder.add(ItemRegistry.EXPLOSIVE_ARROW, "Explosive Arrow");
            translationBuilder.add(ItemRegistry.TORCH_ARROW, "Torch Arrow");
            translationBuilder.add(ItemRegistry.GUNPOWDER_SACHET, "Gunpowder Sachet");
            translationBuilder.add(BlockRegistry.NETHERITE_ANVIL, "Netherite Anvil");
            translationBuilder.add(BlockRegistry.ENDERITE_ORE, "Enderite Ore");
            translationBuilder.add(ItemRegistry.ENDERITE_INGOT, "Enderite Ingot");
            translationBuilder.add(ItemRegistry.SYNTHETIC_ENDER_EYE, "Eye of Enderite");
            translationBuilder.add(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK, "Enderite Portal Frame");
            translationBuilder.add(ItemRegistry.AXOLOTL_ON_STICK, "Axolotl on a Stick");
            translationBuilder.add(ItemRegistry.COOKED_AXOLOTL_ON_STICK, "Seared Axolotl on a Stick");

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
