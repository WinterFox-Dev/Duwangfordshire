package com.sheppard.datagen;

import com.sheppard.block.DuwangfordshireBlocks;
import com.sheppard.item.DuwangfordshireItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import java.nio.file.Path;
import java.util.Optional;

public class DuwangfordshireModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        final FabricDataGenerator.Pack pack = gen.createPack();
        pack.addProvider(DuwangfordshireEnglishLangProvider::new);
        pack.addProvider(DuwangfordshireModelGenerator::new);
        pack.addProvider(DuwangfordshireLootTableGenerator::new);
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
