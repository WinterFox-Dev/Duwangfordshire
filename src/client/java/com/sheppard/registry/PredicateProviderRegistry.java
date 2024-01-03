package com.sheppard.registry;

import com.sheppard.item.GoldBowItem;
import com.sheppard.item.IronBowItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class PredicateProviderRegistry {

    public static void registerPredicateProviders() {
        //gold bow
        ModelPredicateProviderRegistry.register(ItemRegistry.GOLD_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if(livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : GoldBowItem.getPullProgress(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft());
        });

        ModelPredicateProviderRegistry.register(ItemRegistry.GOLD_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });

        //iron bow
        ModelPredicateProviderRegistry.register(ItemRegistry.IRON_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if(livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : IronBowItem.getPullProgress(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft());
        });

        ModelPredicateProviderRegistry.register(ItemRegistry.IRON_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}
