package mattias.EersteMod.items;

import mattias.EersteMod.bombs.*;

import mattias.EersteMod.signs.EntityAard;
import mattias.EersteMod.signs.EntityAxii;
import mattias.EersteMod.signs.EntityIgni;
import mattias.EersteMod.signs.EntityYrden;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class Sign_BombBase extends Item {

	public enum ItemType {
		// Bombs
		STENCHBULB,
		NORMAL,
		FIRE,
		DEVILS_PUFF_BALL,
		DIMERITIUM,
		SAMUM,

		// Signs
		AARD,
		IGNI,
		QUEN,
		AXII,
		YRDEN
	}

	private final ItemType type;

	public Sign_BombBase(ItemType type) {
		super(getProperties(type));
		this.type = type;
	}

	private static Properties getProperties(ItemType type) {
		Item.Properties props = new Item.Properties().group(ItemGroup.COMBAT);
		if (type == ItemType.AARD || type == ItemType.IGNI || type == ItemType.QUEN || type == ItemType.AXII || type == ItemType.YRDEN) {
			props.maxDamage(200); // all signs use durability
		}
		return props;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);

		// Handle durability or consumption
		if (!playerIn.abilities.isCreativeMode) {
			if (type == ItemType.AARD || type == ItemType.IGNI || type == ItemType.QUEN || type == ItemType.AXII || type == ItemType.YRDEN) {
				stack.damageItem(1, playerIn, (p) -> p.sendBreakAnimation(handIn));
			} else {
				stack.shrink(1);
			}
		}

		if (!worldIn.isRemote) {
			switch (this.type) {
				case STENCHBULB:
					worldIn.addEntity(new EntityStenchbulb(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case NORMAL:
					worldIn.addEntity(new EntityBomb(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case FIRE:
					worldIn.addEntity(new EntityDancingStar(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case DEVILS_PUFF_BALL:
					worldIn.addEntity(new EntityDevilsPuffball(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case DIMERITIUM:
					worldIn.addEntity(new EntityDimeritiumBomb(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case SAMUM:
					worldIn.addEntity(new EntitySamum(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case AARD:
					worldIn.addEntity(new EntityAard(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case IGNI:
					worldIn.addEntity(new EntityIgni(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case QUEN:
					playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 1160, 0)); // 58 secs, lvl 1
					break;

				case AXII:
					worldIn.addEntity(new EntityAxii(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;

				case YRDEN:
					worldIn.addEntity(new EntityYrden(worldIn, playerIn));
					playThrowSound(worldIn, playerIn);
					break;
			}
		}

		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	private void playThrowSound(World worldIn, PlayerEntity playerIn) {
		worldIn.playSound(null,
				playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(),
				SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL,
				0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
	}
}