package com.kwpugh.easy_steel.items.baseclasses;

import com.google.common.collect.ImmutableSet;
import com.kwpugh.easy_steel.config.GeneralModConfig;
import com.kwpugh.easy_steel.util.ExcavatorUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

/*
 * This is the base class for all types of Excavators
 *
 */

public class ExcavatorBase extends ShovelItem
{
	public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.DIRT);
	static boolean fullDamage = GeneralModConfig.FULL_DAMAGE.get();
	static int blocksBroken;

	public ExcavatorBase(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity)
	{
		stack.hurt(1, world.random, null);

		if (entity instanceof Player)
		{
			blocksBroken = ExcavatorUtil.attemptBreakNeighbors(world, pos, (Player) entity, BlockTags.MINEABLE_WITH_SHOVEL, EFFECTIVE_MATERIALS);

			if(fullDamage)
			{
				stack.hurt(blocksBroken - 1, world.random, null);
			}
		}

		return super.mineBlock(stack, world, state, pos, entity);
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
		tooltip.add((Component.translatable("item.easy_steel.excavator").withStyle(ChatFormatting.GREEN)));
	}
}
