package mattias.EersteMod.items;

import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class MedallionBase extends Item {

	public MedallionBase()
	{
		super(new Item.Properties()
				.group(ItemGroup.TOOLS)
				.maxDamage(50));
}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);

		if (!playerIn.abilities.isCreativeMode && !worldIn.isRemote) {
			stack.damageItem(1, playerIn, (p) -> p.sendBreakAnimation(handIn));
		}

		AxisAlignedBB area = new AxisAlignedBB(
				playerIn.getPosX() - 8.0D, playerIn.getPosY() - 5.0D, playerIn.getPosZ() - 8.0D,
				playerIn.getPosX() + 8.0D, playerIn.getPosY() + 5.0D, playerIn.getPosZ() + 8.0D
		);

		List<MonsterEntity> list = playerIn.world.getEntitiesWithinAABB(MonsterEntity.class, area);
		if (!list.isEmpty()) {
			for (MonsterEntity mob : list) {
				mob.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0, false, false));
			}
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}


}