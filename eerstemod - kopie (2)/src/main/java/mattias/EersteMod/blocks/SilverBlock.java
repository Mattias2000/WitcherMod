package mattias.EersteMod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;

public class SilverBlock extends Block{
		
	public SilverBlock() {
		super(AbstractBlock.Properties.create(Material.IRON)
				.hardnessAndResistance(4.0F, 30.0F)
				.sound(SoundType.METAL)
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