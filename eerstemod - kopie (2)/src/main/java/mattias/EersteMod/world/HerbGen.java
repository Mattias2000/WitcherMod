package mattias.EersteMod.world;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class HerbGen extends WorldGenerator {

	BlockBush flower;
	public HerbGen(BlockBush flower)
    {
		this.flower=flower;
    }
	
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
					
		
		
	
	
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

			if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && flower .canBlockStay(worldIn, blockpos, flower.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, flower.getDefaultState(), 2);
            }
        

        return true;
	}

}
