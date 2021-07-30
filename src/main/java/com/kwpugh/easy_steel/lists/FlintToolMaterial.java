package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.config.GeneralModConfig;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class FlintToolMaterial implements Tier
{
    private static int durability = GeneralModConfig.FLINT_TOOLS_DURABILITY.get();
    private static double miningSpeed = GeneralModConfig.FLINT_TOOLS_MINING_SPEED.get();
    private static double attackDamage = GeneralModConfig.FLINT_TOOLS_ATTACK_DAMAGE.get();
    private static int miningLevel = GeneralModConfig.FLINT_TOOLS_MINING_LEVEL.get();
    private static int enchantability = GeneralModConfig.FLINT_TOOLS_ENCHANTABILITY.get();

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
        return Ingredient.of(Items.FLINT);
    }
}
