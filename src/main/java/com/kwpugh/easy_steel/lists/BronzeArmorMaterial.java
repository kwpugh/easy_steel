package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class BronzeArmorMaterial implements ArmorMaterial
{
    private static int durabilityMultiplier = GeneralModConfig.BRONZE_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int enchantability = GeneralModConfig.BRONZE_ARMOR_ENCHANTABILITY.get();
    private static double toughness = GeneralModConfig.BRONZE_ARMOR_TOUGHNESS.get();
    private static double knochback = GeneralModConfig.BRONZE_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static int bronzeHead = GeneralModConfig.BRONZE_ARMOR_PROTECTION_HEAD.get();
    private static int bronzeBody = GeneralModConfig.BRONZE_ARMOR_PROTECTION_BODY.get();
    private static int bronzeLeggings = GeneralModConfig.BRONZE_ARMOR_PROTECTION_LEGGINGS.get();
    private static int bronzeFeet = GeneralModConfig.BRONZE_ARMOR_PROTECTION_FEET.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{bronzeHead, bronzeLeggings, bronzeBody, bronzeFeet};

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
        return Ingredient.of(ItemInit.BRONZE_INGOT.get());
    }

    @Override
    public String getName()
    {
        return EasySteel.modid + ":" + "armor_bronze";
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