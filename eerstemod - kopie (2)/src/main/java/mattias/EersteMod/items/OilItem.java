package mattias.EersteMod.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class OilItem extends Item {

	private final Enchantment enchantment;
	private final int level;

	public OilItem(Enchantment enchantment, int level) {
		super(new Properties().group(ItemGroup.COMBAT));
		this.enchantment = enchantment;
		this.level = level;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		if (hand == Hand.OFF_HAND) {
			ItemStack oilStack = player.getHeldItem(Hand.OFF_HAND);
			ItemStack swordStack = player.getHeldItem(Hand.MAIN_HAND);

			if (swordStack.getItem() instanceof SwordItem) {
				if (!player.abilities.isCreativeMode) {
					oilStack.shrink(1);
					player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
				}

				swordStack.addEnchantment(this.enchantment, this.level);
				player.addStat(Stats.ITEM_USED.get(this));
				return ActionResult.resultSuccess(oilStack);
			}
		}

		return ActionResult.resultPass(player.getHeldItem(hand));
	}
}