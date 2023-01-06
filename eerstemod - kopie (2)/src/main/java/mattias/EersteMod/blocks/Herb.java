package mattias.EersteMod.blocks;



import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;


public class Herb extends BushBlock {

	public Herb()
	{ super(Properties.create(Material.PLANTS)
			.notSolid()
			.doesNotBlockMovement()
			.sound(SoundType.PLANT));
	}
	}