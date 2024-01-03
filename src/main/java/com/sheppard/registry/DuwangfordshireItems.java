package com.sheppard.registry;

import com.sheppard.DuwangfordshireMod;
import com.sheppard.item.GoldBow;
import com.sheppard.item.IronBow;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DuwangfordshireItems {

    //items
    public static final Item GOLD_BOW = new GoldBow(new FabricItemSettings().maxDamage(50));
    public static final Item IRON_BOW = new IronBow(new FabricItemSettings().maxDamage(400));

    //item groups
    private static final ItemGroup DUWANGFORD_ITEMGROUP = ItemGroup.create(ItemGroup.Row.TOP, 1)
            .icon(() -> new ItemStack(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE))
            .displayName(Text.translatable("itemGroup.duwangfordshire.duwangfordshire_group"))
            .entries((context, entries) -> {
                entries.add(DuwangfordshireItems.GOLD_BOW);
                entries.add(DuwangfordshireItems.IRON_BOW);
                entries.add(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE);
            })
            .build();

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "cherry_blossom_crafting_table"), new BlockItem(DuwangfordshireBlocks.CHERRY_BLOSSOM_CRAFTING_TABLE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "gold_bow"), GOLD_BOW);
        Registry.register(Registries.ITEM, new Identifier(DuwangfordshireMod.MODID, "iron_bow"), IRON_BOW);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(DuwangfordshireMod.MODID, "duwangfordshire_group"), DUWANGFORD_ITEMGROUP);
    }
}
