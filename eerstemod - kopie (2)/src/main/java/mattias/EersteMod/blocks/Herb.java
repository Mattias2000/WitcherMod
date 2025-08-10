package mattias.EersteMod.blocks;

import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Herb extends BushBlock {

	public Herb()
	{ super(Properties.create(Material.PLANTS)
			.notSolid()
			.doesNotBlockMovement()
			.sound(SoundType.PLANT));
	}
	}