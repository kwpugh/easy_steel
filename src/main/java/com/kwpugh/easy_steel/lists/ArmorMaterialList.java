package com.kwpugh.easy_steel.lists;

import com.kwpugh.easy_steel.EasySteel;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

	
public enum ArmorMaterialList implements IArmorMaterial
{
	//Armor order: helmet, leggings, chestplate, boots
	BRONZE("armor_bronze", 14, new int[] {2, 5, 6, 2}, 15, ItemInit.BRONZE_PLATE.get(), "item.armor.equip_iron", 0.5f),
	STEEL("armor_steel", 19, new int[] {3, 6, 7, 3}, 15, ItemInit.STEEL_PLATE.get(), "item.armor.equip_iron", 1.0f),
	TITANIUM("armor_titanium", 22, new int[] {3, 6, 7, 3}, 15, ItemInit.TITANIUM_PLATE.get(), "item.armor.equip_iron", 1.25f),
	HARDENED_STEEL("armor_hardened_steel", 23, new int[] {3, 6, 7, 3}, 15, ItemInit.HARDENED_STEEL_PLATE.get(), "item.armor.equip_iron", 1.5f),
	TUNGSTEN_CARBIDE("armor_tungsten_carbide", 25, new int[] {3, 6, 8, 3}, 15, ItemInit.TUNGSTEN_CARBIDE_PLATE.get(), "item.armor.equip_iron", 1.75f);

	private int damageReductionMultiplierFromConfig = GeneralModConfig.DAMAGE_REDUCTION_MODIFIER.get();
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	
	private String name, equipSound;
	private int durability;
	private int enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		
		for (int i = 0; i < damageReductionAmounts.length; i++)
		{
			damageReductionAmounts[i] = damageReductionAmounts[i] * damageReductionMultiplierFromConfig;
		}
		
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return EasySteel.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance()
	{
		return 0;
	}
}
