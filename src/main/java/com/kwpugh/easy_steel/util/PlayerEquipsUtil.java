package com.kwpugh.easy_steel.util;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public final class PlayerEquipsUtil
{
    @Nonnull
    @SuppressWarnings("ConstantConditions")
    public static <T> T _null() {
        return null;
    }

    public static boolean hasArrowInInventory(Player player)
    {
        Inventory inv = player.getInventory();
        for (int slot = 0; slot < inv.getContainerSize(); slot++)
        {
            ItemStack stack = inv.getItem(slot);
            if (stack.getItem() instanceof ArrowItem)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean hasItemInInventory(Player player, Item item)
    {
        Inventory inv = player.getInventory();
        for (int slot = 0; slot < inv.getContainerSize(); slot++)
        {
            ItemStack stack = inv.getItem(slot);
            if (stack.getItem() == item)
            {
                return true;
            }
        }

        return false;
    }

    public static ItemStack getItemInInventory(Player player, Item item)
    {
        Inventory inv = player.getInventory();
        for (int slot = 0; slot < inv.getContainerSize(); slot++)
        {
            ItemStack stack = inv.getItem(slot);
            if (stack.getItem() == item)
            {
                return stack;
            }
        }

        return ItemStack.EMPTY;
    }

    public static boolean hasItemInEnderchest(Player player, Item item)
    {
        PlayerEnderChestContainer end_inv = player.getEnderChestInventory();
        for (int slot = 0; slot < end_inv.getContainerSize(); slot++)
        {
            ItemStack stack = end_inv.getItem(slot);
            if (stack.getItem() == item)
            {
                return true;
            }
        }

        return false;
    }

    public static ItemStack getItemInEnderchest(Player player, Item item)
    {
        PlayerEnderChestContainer end_inv = player.getEnderChestInventory();
        for (int slot = 0; slot < end_inv.getContainerSize(); slot++)
        {
            ItemStack stack = end_inv.getItem(slot);
            if (stack.getItem() == item)
            {
                return stack;
            }
        }

        return ItemStack.EMPTY;
    }
}
