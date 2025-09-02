package mattias.EersteMod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.Collections;
import java.util.List;

public class Herb extends BushBlock {

	public Herb() {
		super(Properties.create(Material.PLANTS)
			.notSolid()
			.doesNotBlockMovement()
			.sound(SoundType.PLANT));
	}
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
	}