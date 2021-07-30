package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TitaniumToolMaterial implements Tier
{
    private static int durability = GeneralModConfig.TITANIUM_TOOLS_DURABILITY.get();
    private static double miningSpeed = GeneralModConfig.TITANIUM_TOOLS_MINING_SPEED.get();
    private static double attackDamage = GeneralModConfig.TITANIUM_TOOLS_ATTACK_DAMAGE.get();
    private static int miningLevel = GeneralModConfig.TITANIUM_TOOLS_MINING_LEVEL.get();
    private static int enchantability = GeneralModConfig.TITANIUM_TOOLS_ENCHANTABILITY.get();

    @Override
    public int getUses()
    {
        return durability;
    }

    @Override
    public float getSpeed()
    {
        return (float) miningSpeed;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return (float) attackDamage;
    }

    @Override
    public int getLevel()
    {
        return miningLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ItemInit.TITANIUM_ALLOY_INGOT.get());
    }
}