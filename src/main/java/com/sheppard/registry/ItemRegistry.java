package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
    public static final Item RAW_ENDERITE = new Item(new FabricItemSettings());

    public static final Item NINJA_POWDER = new Item(new FabricItemSettings());
    public static final Item STIMULATING_POWDER = new Item(new FabricItemSettings());
    public static final Item DOLPHIN_FIN = new Item(new FabricItemSettings());

    public static final Item DUCK_SPAWN_EGG = new SpawnEggItem(EntityRegistry.DUCK, 0x5e3217, 0x336323, new FabricItemSettings());

    //food
    public static final FoodComponent FC_AXOLOTL_ON_STICK = new FoodComponent.Builder().hunger(2).saturationModifier(0.10F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 500), 1.0F).build();
    public static final Item AXOLOTL_ON_STICK = new Item(new FabricItemSettings().food(FC_AXOLOTL_ON_STICK));
    public static final FoodComponent FC_COOKED_AXOLOTL_ON_STICK = new FoodComponent.Builder().hunger(10).saturationModifier(0.8f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 1), 1.0F).build();
    public static final Item COOKED_AXOLOTL_ON_STICK = new Item(new FabricItemSettings().food(FC_COOKED_AXOLOTL_ON_STICK));

    public static final FoodComponent FC_COOKED_BLUE_AXOLOTL_ON_STICK = new FoodComponent.Builder().hunger(16).saturationModifier(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 500, 1), 1.0F)
            .build();

    public static final Item BLUE_AXOLOTL_ON_STICK = new Item(new FabricItemSettings().food(FC_AXOLOTL_ON_STICK));
    public static final Item COOKED_BLUE_AXOLOTL_ON_STICK = new Item(new FabricItemSettings().food(FC_COOKED_BLUE_AXOLOTL_ON_STICK));

    //potions
    public static final Potion POTION_TELEPORT = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 40, 0)));
    public static final Potion POTION_TELEPORT_POTENT = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion_potent"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 40, 1)));
    public static final Potion POTION_TELEPORT_LONG = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_potion_long"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT, 80, 0)));
    public static final Potion POTION_TELEPORT_BED = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_bed_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT_BED, 1, 0)));
    public static final Potion POTION_TELEPORT_END = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_end_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT_END, 1, 0)));
    public static final Potion POTION_TELEPORT_NETHER = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "teleport_nether_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.TELEPORT_NETHER, 1, 0)));
    public static final Potion POTION_FORGIVE_ANGER = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "forgive_anger_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.FORGIVE_ANGER, 100, 0)));

    public static final Potion POTION_NINJA_ESCAPE = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "ninja_escape_potion"), new Potion(new StatusEffectInstance(StatusEffectRegistry.NINJA_ESCAPE,1, 0)));

    public static final Potion POTION_HASTE = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "haste_potion"), new Potion(new StatusEffectInstance(StatusEffects.HASTE, 4800, 0)));
    public static final Potion POTION_DOLPHIN_GRACE = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "dolphin_grace_potion"), new Potion(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 4800, 0)));

    public static final Potion POTION_HASTE_POTENT = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "haste_potion_potent"), new Potion(new StatusEffectInstance(StatusEffects.HASTE, 4800, 1)));
    public static final Potion POTION_DOLPHIN_GRACE_POTENT = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "dolphin_grace_potion_potent"), new Potion(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 4800, 1)));
    public static final Potion POTION_HASTE_LONG = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "haste_potion_long"), new Potion(new StatusEffectInstance(StatusEffects.HASTE, 9600, 0)));
    public static final Potion POTION_DOLPHIN_GRACE_LONG = Registry.register(Registries.POTION, new Identifier(DuwangfordshireMod.MODID, "dolphin_grace_potion_long"), new Potion(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 9600, 0)));

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
                entries.add(ItemRegistry.AXOLOTL_ON_STICK);
                entries.add(ItemRegistry.COOKED_AXOLOTL_ON_STICK);
                entries.add(ItemRegistry.BLUE_AXOLOTL_ON_STICK);
                entries.add(ItemRegistry.COOKED_BLUE_AXOLOTL_ON_STICK);
                entries.add(ItemRegistry.DUCK_SPAWN_EGG);
                entries.add(BlockRegistry.ENDERITE_BLOCK);
                entries.add(ItemRegistry.RAW_ENDERITE);
                entries.add(ItemRegistry.NINJA_POWDER);
                entries.add(ItemRegistry.STIMULATING_POWDER);
                entries.add(ItemRegistry.DOLPHIN_FIN);
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
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "axolotl_on_stick"), AXOLOTL_ON_STICK);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cooked_axolotl_on_stick"), COOKED_AXOLOTL_ON_STICK);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "blue_axolotl_on_stick"), BLUE_AXOLOTL_ON_STICK);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cooked_blue_axolotl_on_stick"), COOKED_BLUE_AXOLOTL_ON_STICK);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "duck_spawn_egg"), DUCK_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "raw_enderite"), RAW_ENDERITE);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "enderite_block"), new BlockItem(BlockRegistry.ENDERITE_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "ninja_powder"), NINJA_POWDER);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "stimulating_powder"), STIMULATING_POWDER);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "dolphin_fin"), DOLPHIN_FIN);
    }

    public static void registerPotions() {

    }

    public static void registerPotionRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ItemRegistry.POTION_TELEPORT);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.DANDELION, ItemRegistry.POTION_FORGIVE_ANGER);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_TELEPORT, Items.GLOWSTONE_DUST, ItemRegistry.POTION_TELEPORT_POTENT);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_TELEPORT, Items.REDSTONE, ItemRegistry.POTION_TELEPORT_LONG);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_TELEPORT, Items.WARPED_FUNGUS, ItemRegistry.POTION_TELEPORT_NETHER);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_TELEPORT, Items.SUNFLOWER, ItemRegistry.POTION_TELEPORT_BED);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_TELEPORT, ItemRegistry.SYNTHETIC_ENDER_EYE, ItemRegistry.POTION_TELEPORT_END);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ItemRegistry.NINJA_POWDER, ItemRegistry.POTION_NINJA_ESCAPE);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ItemRegistry.STIMULATING_POWDER, ItemRegistry.POTION_HASTE);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ItemRegistry.DOLPHIN_FIN, ItemRegistry.POTION_DOLPHIN_GRACE);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_HASTE, Items.GLOWSTONE_DUST, ItemRegistry.POTION_HASTE_POTENT);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_DOLPHIN_GRACE, Items.GLOWSTONE_DUST, ItemRegistry.POTION_DOLPHIN_GRACE_POTENT);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_HASTE, Items.REDSTONE, ItemRegistry.POTION_HASTE_LONG);
        BrewingRecipeRegistry.registerPotionRecipe(ItemRegistry.POTION_DOLPHIN_GRACE, Items.REDSTONE, ItemRegistry.POTION_DOLPHIN_GRACE_LONG);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(DuwangfordshireMod.MODID, "duwangfordshire_group"), DUWANGFORD_ITEMGROUP);
    }
}
