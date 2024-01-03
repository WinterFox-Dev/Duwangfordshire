/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package com.sheppard.screen;

import com.mojang.logging.LogUtils;
import java.util.Map;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class NetheriteAnvilScreenHandler
        extends AnvilScreenHandler {
    private int repairItemUsage;
    @Nullable
    private String newItemName;
    private final Property levelCost = Property.create();

    public NetheriteAnvilScreenHandler(int syncId, PlayerInventory inventory) {
        super(syncId, inventory);
    }

    public NetheriteAnvilScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(syncId, inventory, context);
    }

    @Override
    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return (player.getAbilities().creativeMode || player.experienceLevel >= this.levelCost.get()) && this.levelCost.get() > 0;
    }

    @Override
    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        if (!player.getAbilities().creativeMode) {
            player.addExperienceLevels(-this.levelCost.get());
        }
        this.input.setStack(0, ItemStack.EMPTY);
        if (this.repairItemUsage > 0) {
            ItemStack itemStack = this.input.getStack(1);
            if (!itemStack.isEmpty() && itemStack.getCount() > this.repairItemUsage) {
                itemStack.decrement(this.repairItemUsage);
                this.input.setStack(1, itemStack);
            } else {
                this.input.setStack(1, ItemStack.EMPTY);
            }
        } else {
            this.input.setStack(1, ItemStack.EMPTY);
        }
        this.levelCost.set(0);
        this.context.run((world, pos) -> {
            world.syncWorldEvent(WorldEvents.ANVIL_USED, (BlockPos)pos, 0);
        });
    }

    @Override
    public void updateResult() {
        ItemStack itemStack = this.input.getStack(0);
        this.levelCost.set(1);
        int i = 0;
        int j = 0;
        int k = 0;
        if (itemStack.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
            this.levelCost.set(0);
            return;
        }
        ItemStack inputStack = itemStack.copy();
        ItemStack secondInputStack = this.input.getStack(1);
        Map<Enchantment, Integer> map = EnchantmentHelper.get(inputStack);
        j += itemStack.getRepairCost() + (secondInputStack.isEmpty() ? 0 : secondInputStack.getRepairCost());
        this.repairItemUsage = 0;
        if (!secondInputStack.isEmpty()) {
            boolean isEnchantedBook = secondInputStack.isOf(Items.ENCHANTED_BOOK) && !EnchantedBookItem.getEnchantmentNbt(secondInputStack).isEmpty();
            if (inputStack.isDamageable() && inputStack.getItem().canRepair(itemStack, secondInputStack)) {
                int m;
                int l = Math.min(inputStack.getDamage(), inputStack.getMaxDamage() / 4);
                if (l <= 0) {
                    this.output.setStack(0, ItemStack.EMPTY);
                    this.levelCost.set(0);
                    return;
                }
                for (m = 0; l > 0 && m < secondInputStack.getCount(); ++m) {
                    int n = inputStack.getDamage() - l;
                    inputStack.setDamage(n);
                    ++i;
                    l = Math.min(inputStack.getDamage(), inputStack.getMaxDamage() / 4);
                }
                this.repairItemUsage = m;
            } else {
                if (!(isEnchantedBook || inputStack.isOf(secondInputStack.getItem()) && inputStack.isDamageable())) {
                    this.output.setStack(0, ItemStack.EMPTY);
                    this.levelCost.set(0);
                    return;
                }
                if (inputStack.isDamageable() && !isEnchantedBook) {
                    int l = itemStack.getMaxDamage() - itemStack.getDamage();
                    int m = secondInputStack.getMaxDamage() - secondInputStack.getDamage();
                    int n = m + inputStack.getMaxDamage() * 12 / 100;
                    int o = l + n;
                    int p = inputStack.getMaxDamage() - o;
                    if (p < 0) {
                        p = 0;
                    }
                    if (p < inputStack.getDamage()) {
                        inputStack.setDamage(p);
                        i += 2;
                    }
                }
                Map<Enchantment, Integer> map2 = EnchantmentHelper.get(secondInputStack);
                boolean enchantmentInList = false;
                boolean invalidEnchantmentInMap = false;
                for (Enchantment enchantment : map2.keySet()) {
                    int r;
                    if (enchantment == null) continue;
                    int enchantmentLevel = map.getOrDefault(enchantment, 0);
                    r = enchantmentLevel == (r = map2.get(enchantment).intValue()) ? r + 1 : Math.max(r, enchantmentLevel);
                    boolean acceptableEnchantment = enchantment.isAcceptableItem(itemStack);
                    if (this.player.getAbilities().creativeMode || itemStack.isOf(Items.ENCHANTED_BOOK)) {
                        acceptableEnchantment = true;
                    }
                    for (Enchantment enchantment2 : map.keySet()) {
                        if (enchantment2 == enchantment || enchantment.canCombine(enchantment2)) continue;
                        acceptableEnchantment = false;
                        ++i;
                    }
                    if (!acceptableEnchantment) {
                        invalidEnchantmentInMap = true;
                        continue;
                    }
                    enchantmentInList = true;
                    if (r > enchantment.getMaxLevel()) {
                        r = enchantment.getMaxLevel();
                    }
                    map.put(enchantment, r);
                    int s = 0;
                    switch (enchantment.getRarity()) {
                        case COMMON: {
                            s = 1;
                            break;
                        }
                        case UNCOMMON: {
                            s = 2;
                            break;
                        }
                        case RARE: {
                            s = 4;
                            break;
                        }
                        case VERY_RARE: {
                            s = 8;
                        }
                    }
                    if (isEnchantedBook) {
                        s = Math.max(1, s / 2);
                    }
                    i += s * r;
                    if (itemStack.getCount() <= 1) continue;
                    i = 40;
                }
                if (invalidEnchantmentInMap && !enchantmentInList) {
                    this.output.setStack(0, ItemStack.EMPTY);
                    this.levelCost.set(0);
                    return;
                }
            }
        }
        if (this.newItemName == null || Util.isBlank(this.newItemName)) {
            if (itemStack.hasCustomName()) {
                k = 1;
                i += k;
                inputStack.removeCustomName();
            }
        } else if (!this.newItemName.equals(itemStack.getName().getString())) {
            k = 1;
            i += k;
            inputStack.setCustomName(Text.literal(this.newItemName));
        }
        this.levelCost.set(j + i);
        if (i <= 0) {
            inputStack = ItemStack.EMPTY;
        }
        if (!inputStack.isEmpty()) {
            int t = inputStack.getRepairCost();
            if (!secondInputStack.isEmpty() && t < secondInputStack.getRepairCost()) {
                t = secondInputStack.getRepairCost();
            }
            if (k != i || k == 0) {
                t = NetheriteAnvilScreenHandler.getNextCost(t);
            }
            inputStack.setRepairCost(t);
            EnchantmentHelper.set(map, inputStack);
        }
        this.output.setStack(0, inputStack);
        this.sendContentUpdates();
    }

    public boolean setNewItemName(String newItemName) {
        String string = NetheriteAnvilScreenHandler.sanitize(newItemName);
        if (string == null || string.equals(this.newItemName)) {
            return false;
        }
        this.newItemName = string;
        if (this.getSlot(2).hasStack()) {
            ItemStack itemStack = this.getSlot(2).getStack();
            if (Util.isBlank(string)) {
                itemStack.removeCustomName();
            } else {
                itemStack.setCustomName(Text.literal(string));
            }
        }
        this.updateResult();
        return true;
    }

    @Nullable
    private static String sanitize(String name) {
        String string = SharedConstants.stripInvalidChars(name);
        if (string.length() <= 50) {
            return string;
        }
        return null;
    }

    public static int getNextCost(int cost) {
        return cost + 1;
    }
}

