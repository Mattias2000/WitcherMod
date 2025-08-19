package mattias.EersteMod.items;

import mattias.EersteMod.bombs.*;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class BombBase extends Item {

		public enum BombType {
			STENCHBULB,
			NORMAL,
			FIRE,
			DEVILS_PUFF_BALL,
			DIMERITIUM,
			SAMUM
		}

		private final BombType type;

		public BombBase(BombType type) {
			super(new Item.Properties().group(ItemGroup.COMBAT));
			this.type = type;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			ItemStack stack = playerIn.getHeldItem(handIn);

			if (!playerIn.abilities.isCreativeMode) {
				stack.shrink(1);
			}

			worldIn.playSound(null,
					playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(),
					SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL,
					0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote) {
				switch (this.type) {
					case STENCHBULB:
						EntityStenchbulb sb = new EntityStenchbulb(worldIn, playerIn);
						worldIn.addEntity(sb);
						break;

					case NORMAL:
						EntityBomb nb = new EntityBomb(worldIn, playerIn);
						worldIn.addEntity(nb);
						break;

					case FIRE:
						EntityDancingStar fb = new EntityDancingStar(worldIn, playerIn);
						worldIn.addEntity(fb);
						break;

					case DEVILS_PUFF_BALL:
						EntityDevilsPuffball dp = new EntityDevilsPuffball(worldIn, playerIn);
						worldIn.addEntity(dp);
						break;

					case DIMERITIUM:
						EntityDimeritiumBomb db = new EntityDimeritiumBomb(worldIn, playerIn);
						worldIn.addEntity(db);
						break;

					case SAMUM:
						EntitySamum s = new EntitySamum(worldIn, playerIn);
						worldIn.addEntity(s);
						break;
				}
			}

			return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}
	}