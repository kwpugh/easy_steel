package com.kwpugh.easy_steel.items.baseclasses;

import com.google.common.collect.ImmutableSet;
import com.kwpugh.easy_steel.util.HammerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.TierSortingRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

/*
 * This is the base class for all types of Hammers
 * 
 */

public class HammerBase extends PickaxeItem
{	
	public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.STONE, Material.METAL, Material.GLASS, Material.ICE, Material.ICE_SOLID, Material.HEAVY_METAL);

	public HammerBase(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity)
	{
		stack.hurt(1, world.random, null);

		if(entity instanceof Player player)
		{
			Block block = state.getBlock();
			boolean isWithinHarvestLevel = player.getMainHandItem().isCorrectToolForDrops(state);  //added to ensure each block in the breaking is harvestable with this tool material
			boolean isHarvestable = block.canHarvestBlock(state, world, pos, player);  // added in case a block overrides canHarvestBlock to false at block level

			if(isHarvestable && isWithinHarvestLevel)
			{
				HammerUtil.attemptBreakNeighbors(world, pos, player, EFFECTIVE_MATERIALS);
			}
		}

		return true;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((Component.translatable("item.easy_steel.hammer").withStyle(ChatFormatting.GREEN)));
	}
}
