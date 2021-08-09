package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class HardenedSteelArmorMaterial implements ArmorMaterial
{
    private static int durabilityMultiplier = GeneralModConfig.HARDENED_STEEL_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int enchantability = GeneralModConfig.HARDENED_STEEL_ARMOR_ENCHANTABILITY.get();
    private static double toughness = GeneralModConfig.HARDENED_STEEL_ARMOR_TOUGHNESS.get();
    private static double knochback = GeneralModConfig.HARDENED_STEEL_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{3, 6, 7, 3};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot)
    {
        return BASE_DURABILITY[slot.getIndex()] * durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot)
    {
        return PROTECTION_AMOUNT[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return new SoundEvent(new ResourceLocation("item.armor.equip_iron"));
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ItemInit.HARDENED_STEEL_INGOT.get());
    }

    @Override
    public String getName()
    {
        return EasySteel.modid + ":" + "armor_hardened_steel";
    }

    @Override
    public float getToughness()
    {
        return (float) toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return (float) knochback;
    }
}