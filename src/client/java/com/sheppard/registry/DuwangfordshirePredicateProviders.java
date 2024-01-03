package com.sheppard.registry;

import com.sheppard.item.GoldBow;
import com.sheppard.item.IronBow;
import net.minecraft.client.item.ClampedModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class DuwangfordshirePredicateProviders {

    public static void registerPredicateProviders() {
        //gold bow
        ModelPredicateProviderRegistry.register(DuwangfordshireItems.GOLD_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if(livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : GoldBow.getPullProgress(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft());
        });

        ModelPredicateProviderRegistry.register(DuwangfordshireItems.GOLD_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });

        //iron bow
        ModelPredicateProviderRegistry.register(DuwangfordshireItems.IRON_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if(livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : IronBow.getPullProgress(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft());
        });

        ModelPredicateProviderRegistry.register(DuwangfordshireItems.IRON_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}
