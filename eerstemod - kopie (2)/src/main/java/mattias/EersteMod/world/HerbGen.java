package mattias.EersteMod.world;

import java.util.Random;

import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class HerbGen extends Feature<NoFeatureConfig> {

	BushBlock flower;
	public HerbGen(BushBlock flower)
    {
        super(NoFeatureConfig.CODEC);
        this.flower=flower;
    }

	@Override
    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos position, NoFeatureConfig config) {
        BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

        // Check if the block is air, not in the Nether, and can survive
        if (worldIn.isAirBlock(blockpos) && worldIn.getWorld().getDimensionKey() != World.THE_NETHER && blockpos.getY() < 255 && flower.getDefaultState().isValidPosition(worldIn, blockpos)) {
            worldIn.setBlockState(blockpos, flower.getDefaultState(), 2);
            return true;
        }
        return false;
    }
}