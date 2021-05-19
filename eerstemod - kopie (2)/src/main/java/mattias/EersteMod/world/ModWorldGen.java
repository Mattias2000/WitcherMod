package mattias.EersteMod.world;

import java.util.Random;

import mattias.EersteMod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeForestMutated;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomeMushroomIsland;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSavannaMutated;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0 && world.getWorldType() != WorldType.FLAT) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkgenerator, IChunkProvider chunkprovider) {
		generateOre(ModBlocks.SILVER_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(6) + 1, 6);
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeForest) {
			populate(new HerbGen(ModBlocks.ALLSPICE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.BALISSE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.MISTLETOE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeForestMutated) {
			populate(new HerbGen(ModBlocks.ALLSPICE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.BALISSE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.MISTLETOE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeHills) {
			populate(new HerbGen(ModBlocks.GINATIA), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.BERBERCANE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.CELANDINE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeJungle) {
			populate(new HerbGen(ModBlocks.FEAINNEWEDD), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.ERGOT), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeMushroomIsland) {
			populate(new HerbGen(ModBlocks.GREEN_MUSHROOM), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.SEWANT_MUSHROOM), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomePlains) {
			populate(new HerbGen(ModBlocks.HAN_FIBER), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.HELLEBORE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.WHITE_MYRTLE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeForest) {
			populate(new HerbGen(ModBlocks.ALLSPICE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.BALISSE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.MISTLETOE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeSavanna) {
			populate(new HerbGen(ModBlocks.MANDRAKE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.VERBENA), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeSavannaMutated) {
			populate(new HerbGen(ModBlocks.MANDRAKE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.VERBENA), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeSnow) {
			populate(new HerbGen(ModBlocks.BRYONIA), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.HONEYSUCKLE), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeSwamp) {
			populate(new HerbGen(ModBlocks.BEGGARTICK), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.FOOLS_PARSLEY), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.WOLFS_ALOE_LEAVES), world, random, chunkX, chunkZ, 5);
		}
		if(world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 70, chunkZ * 16)) instanceof BiomeTaiga) {
			populate(new HerbGen(ModBlocks.CROWSEYE), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.HOP), world, random, chunkX, chunkZ, 5);
			populate(new HerbGen(ModBlocks.WOLFSBANE), world, random, chunkX, chunkZ, 5);
		}
	}
	


	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		int deltaY = maxY - minY;
		
		for (int i = 0; i < chances; i++)
		{
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world,  random,  pos);
		}
	}
	private void populate(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int amountPerChunk) {
		for(int i = 0; i < amountPerChunk; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			int y = world.getChunkFromChunkCoords(x >> 4, z >> 4).getHeight(new BlockPos(x & 15, 0, z & 15)) - 1;
			generator.generate(world, random, new BlockPos(x, y, z));
		}
	}
}