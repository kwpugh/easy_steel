package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class TungstenArmorMaterial implements ArmorMaterial
{
    private static int durabilityMultiplier = GeneralModConfig.TUNGSTEN_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int enchantability = GeneralModConfig.TUNGSTEN_ARMOR_ENCHANTABILITY.get();
    private static double toughness = GeneralModConfig.TUNGSTEN_ARMOR_TOUGHNESS.get();
    private static double knochback = GeneralModConfig.TUNGSTEN_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static int tungstenHead = GeneralModConfig.TUNGSTEN_ARMOR_PROTECTION_HEAD.get();
    private static int tungstenBody = GeneralModConfig.TUNGSTEN_ARMOR_PROTECTION_BODY.get();
    private static int tungstenLeggings = GeneralModConfig.TUNGSTEN_ARMOR_PROTECTION_LEGGINGS.get();
    private static int tungstenFeet = GeneralModConfig.TUNGSTEN_ARMOR_PROTECTION_FEET.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{tungstenHead, tungstenLeggings, tungstenBody, tungstenFeet};

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
        return Ingredient.of(ItemInit.TUNGSTEN_CARBIDE_INGOT.get());
    }

    @Override
    public String getName()
    {
        return EasySteel.modid + ":" + "armor_tungsten_carbide";
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