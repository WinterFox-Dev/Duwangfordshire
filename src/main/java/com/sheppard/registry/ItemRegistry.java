package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    //items
    public static final Item GOLD_BOW = new GoldBowItem(new FabricItemSettings().maxDamage(50));
    public static final Item IRON_BOW = new IronBowItem(new FabricItemSettings().maxDamage(400));
    public static final Item TORCH_ARROW = new TorchArrowItem(new FabricItemSettings());
    public static final Item EXPLOSIVE_ARROW = new ExplosiveArrowItem(new FabricItemSettings());
    public static final Item GUNPOWDER_SACHET = new Item(new FabricItemSettings());
    public static final Item ENDERITE_INGOT = new Item(new FabricItemSettings());
    public static final Item SYNTHETIC_ENDER_EYE = new SyntheticEyeOfEnderItem(new FabricItemSettings());

    public static final Potion TELEPORT_POTION = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 20, 0)));
    public static final Potion TELEPORT_POTION_POTENT = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion_potent"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 20, 1)));
    public static final Potion TELEPORT_POTION_LONG = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion_long"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 40, 0)));

    //item groups
    private static final ItemGroup DUWANGFORD_ITEMGROUP = ItemGroup.create(ItemGroup.Row.TOP, 1)
            .icon(() -> new ItemStack(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE))
            .displayName(Text.translatable("itemGroup.duwangfordshire.duwangfordshire_group"))
            .entries((context, entries) -> {
                entries.add(ItemRegistry.GOLD_BOW);
                entries.add(ItemRegistry.IRON_BOW);
                entries.add(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE);
                entries.add(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK);
                entries.add(BlockRegistry.NETHERITE_ANVIL);
                entries.add(BlockRegistry.ENDERITE_ORE);
                entries.add(ItemRegistry.EXPLOSIVE_ARROW);
                entries.add(ItemRegistry.TORCH_ARROW);
                entries.add(ItemRegistry.GUNPOWDER_SACHET);
                entries.add(ItemRegistry.ENDERITE_INGOT);
                entries.add(ItemRegistry.SYNTHETIC_ENDER_EYE);
            })
            .build();

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "netherite_anvil"), new BlockItem(BlockRegistry.NETHERITE_ANVIL, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), new BlockItem(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "enderite_ore"), new BlockItem(BlockRegistry.ENDERITE_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "enderite_end_portal_frame"), new BlockItem(BlockRegistry.ENDERITE_END_PORTAL_FRAME_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "gold_bow"), GOLD_BOW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "iron_bow"), IRON_BOW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "explosive_arrow"), EXPLOSIVE_ARROW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "torch_arrow"), TORCH_ARROW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "gunpowder_sachet"), GUNPOWDER_SACHET);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "enderite_ingot"), ENDERITE_INGOT);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "synthetic_ender_eye"), SYNTHETIC_ENDER_EYE);
    }

    public static void registerPotions() {

    }

    public static void registerPotionRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ItemRegistry.TELEPORT_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.TELEPORT_POTION, Items.GLOWSTONE_DUST, ItemRegistry.TELEPORT_POTION_POTENT);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.TELEPORT_POTION, Items.REDSTONE, ItemRegistry.TELEPORT_POTION_LONG);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(DuwangfordshireMod.MODID, "duwangfordshire_group"), DUWANGFORD_ITEMGROUP);
    }
}
