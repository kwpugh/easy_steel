package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class TitaniumArmorMaterial implements ArmorMaterial
{
    private static int durabilityMultiplier = GeneralModConfig.TITANIUM_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int enchantability = GeneralModConfig.TITANIUM_ARMOR_ENCHANTABILITY.get();
    private static double toughness = GeneralModConfig.TITANIUM_ARMOR_TOUGHNESS.get();
    private static double knochback = GeneralModConfig.TITANIUM_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static int titaniumHead = GeneralModConfig.TITANIUM_ARMOR_PROTECTION_HEAD.get();
    private static int titaniumBody = GeneralModConfig.TITANIUM_ARMOR_PROTECTION_BODY.get();
    private static int titaniumLeggings = GeneralModConfig.TITANIUM_ARMOR_PROTECTION_LEGGINGS.get();
    private static int titaniumFeet = GeneralModConfig.TITANIUM_ARMOR_PROTECTION_FEET.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{titaniumHead, titaniumLeggings, titaniumBody, titaniumFeet};

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
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ItemInit.TITANIUM_INGOT.get());
    }

    @Override
    public String getName()
    {
        return EasySteel.modid + ":" + "armor_titanium";
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