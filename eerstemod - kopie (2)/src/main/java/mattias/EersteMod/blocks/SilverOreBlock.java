package mattias.EersteMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraftforge.common.ToolType;

public class SilverOreBlock extends Block {

	public SilverOreBlock() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(3.0F, 15.0F)
				.sound(SoundType.STONE)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
	}
}
