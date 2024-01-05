package com.sheppard.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class TradeOfferRegistry {

    public static void registerTradeOffers() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ItemRegistry.AXOLOTL_ON_STICK, 2),
                    6, 2, 0.02f
            )));
        });
    }
}
