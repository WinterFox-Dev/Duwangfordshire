package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.item.ExplosiveArrowItem;
import com.sheppard.item.GoldBow;
import com.sheppard.item.IronBow;
import com.sheppard.item.TorchArrowItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    //items
    public static final Item GOLD_BOW = new GoldBow(new FabricItemSettings().maxDamage(50));
    public static final Item IRON_BOW = new IronBow(new FabricItemSettings().maxDamage(400));
    public static final Item TORCH_ARROW = new TorchArrowItem(new FabricItemSettings());
    public static final Item EXPLOSIVE_ARROW = new ExplosiveArrowItem(new FabricItemSettings());
    public static final Item GUNPOWDER_SACHET = new Item(new FabricItemSettings());

    //item groups
    private static final ItemGroup DUWANGFORD_ITEMGROUP = ItemGroup.create(ItemGroup.Row.TOP, 1)
            .icon(() -> new ItemStack(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE))
            .displayName(Text.translatable("itemGroup.duwangfordshire.duwangfordshire_group"))
            .entries((context, entries) -> {
                entries.add(ItemRegistry.GOLD_BOW);
                entries.add(ItemRegistry.IRON_BOW);
                entries.add(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE);
                entries.add(ItemRegistry.EXPLOSIVE_ARROW);
                entries.add(ItemRegistry.TORCH_ARROW);
                entries.add(ItemRegistry.GUNPOWDER_SACHET);
            })
            .build();

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), new BlockItem(BlockRegistry.CHERRY_BLOSSOM_CRAFTING_TABLE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "gold_bow"), GOLD_BOW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "iron_bow"), IRON_BOW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "explosive_arrow"), EXPLOSIVE_ARROW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "torch_arrow"), TORCH_ARROW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "gunpowder_sachet"), GUNPOWDER_SACHET);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(DuwangfordshireMod.MODID, "duwangfordshire_group"), DUWANGFORD_ITEMGROUP);
    }
}
