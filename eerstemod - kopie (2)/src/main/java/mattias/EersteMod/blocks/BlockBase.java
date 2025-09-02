package mattias.EersteMod.blocks;

import mattias.EersteMod.Main;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockBase extends BlockItem {

	public BlockBase(Block block) {
		super(block, new Properties().group(Main.TAB));
	}
}