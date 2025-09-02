package mattias.EersteMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;

public class SilverOreBlock extends Block {

	public SilverOreBlock() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(3.0F, 15.0F)
				.sound(SoundType.STONE)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
	}
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
