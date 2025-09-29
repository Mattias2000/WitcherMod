package mattias.EersteMod.blocks;

import mattias.EersteMod.Main;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class HerbBlockBase extends BlockItem {

	public HerbBlockBase(Block block) {
		super(block, new Item.Properties().group(Main.TAB));
	}
}