package mattias.EersteMod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraftforge.common.ToolType;

public class SilverBlock extends Block{
		
	public SilverBlock() {
		super(AbstractBlock.Properties.create(Material.IRON)
				.hardnessAndResistance(4.0F, 30.0F)
				.sound(SoundType.METAL)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
	}
}