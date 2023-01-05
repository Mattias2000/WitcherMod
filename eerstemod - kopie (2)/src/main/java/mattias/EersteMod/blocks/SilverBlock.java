package mattias.EersteMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SilverBlock extends BlockBase{

		
	public SilverBlock(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(4.0F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}