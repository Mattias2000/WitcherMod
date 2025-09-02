package mattias.EersteMod.world;

import mattias.EersteMod.util.handlers.RegistryHandler;

import net.minecraft.block.BushBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.entity.EntityClassification;

import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Random;

public class ModWorldGen {

	// === ORE FEATURE ===
	public static final ConfiguredFeature<?, ?> SILVER_ORE = Feature.ORE
			.withConfiguration(new OreFeatureConfig(
					OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
					RegistryHandler.SILVER_ORE.get().getDefaultState(),
					6 // vein size
			))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(16, 0, 64)))
			.square()
			.count(6); // veins per chunk

	// === EVENT HANDLER ===
	public static void onBiomeLoading(BiomeLoadingEvent event) {
		// Ores in Overworld
		if (event.getCategory() != Biome.Category.NETHER && event.getCategory() != Biome.Category.THEEND) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SILVER_ORE);
		}

		Biome.Category category = event.getCategory();
		ResourceLocation biomeName = event.getName();

		// Forest herbs + Nekker spawns
		if (category == Biome.Category.FOREST) {
			addHerbs(event, RegistryHandler.ALLSPICE.get());
			addHerbs(event, RegistryHandler.BALISSE.get());
			addHerbs(event, RegistryHandler.MISTLETOE.get());

			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.NEKKER.get(),
							120, // spawn weight
							4,  // min group
							10   // max group
					)
			);
		}

		if (category == Biome.Category.JUNGLE) {
			addHerbs(event, RegistryHandler.FEAINNEWEDD.get());
			addHerbs(event, RegistryHandler.ERGOT.get());
		}

		if (category == Biome.Category.PLAINS) {
			addHerbs(event, RegistryHandler.HAN_FIBER.get());
			addHerbs(event, RegistryHandler.HELLEBORE.get());
			addHerbs(event, RegistryHandler.WHITE_MYRTLE.get());

			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.GHOUL.get(),
							120, // spawn weight
							3,  // min group
							6   // max group
					)
			);
			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.ROTFIEND.get(),
							120, // spawn weight
							1,  // min group
							3  // max group
					)
			);
		}

		if (category == Biome.Category.SWAMP) {
			addHerbs(event, RegistryHandler.BEGGARTICK.get());
			addHerbs(event, RegistryHandler.FOOLS_PARSLEY.get());
			addHerbs(event, RegistryHandler.WOLFS_ALOE_LEAVES.get());

			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.DROWNER.get(),
							120, // spawn weight
							2,  // min group
							5  // max group
					)
			);
			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.FOGLET.get(),
							120, // spawn weight
							3,  // min group
							4  // max group
					)
			);
		}

		if (category == Biome.Category.TAIGA) {
			addHerbs(event, RegistryHandler.CROWSEYE.get());
			addHerbs(event, RegistryHandler.HOP.get());
			addHerbs(event, RegistryHandler.WOLFSBANE.get());
		}

		if (category == Biome.Category.MUSHROOM) {
			addHerbs(event, RegistryHandler.GREEN_MUSHROOM.get());
			addHerbs(event, RegistryHandler.SEWANT_MUSHROOM.get());
		}

		if (category == Biome.Category.DESERT) {
			event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.ARACHAS.get(),
							120, // spawn weight
							1,  // min group
							3  // max group
					)
			);
		}

		if (category == Biome.Category.EXTREME_HILLS) {
			addHerbs(event, RegistryHandler.GINATIA.get());
			addHerbs(event, RegistryHandler.BERBERCANE.get());
			addHerbs(event, RegistryHandler.CELANDINE.get());
		}

		if (category == Biome.Category.SAVANNA) {
			addHerbs(event, RegistryHandler.MANDRAKE.get());
			addHerbs(event, RegistryHandler.VERBENA.get());
		}

		if (category == Biome.Category.ICY) {
			addHerbs(event, RegistryHandler.BRYONIA.get());
			addHerbs(event, RegistryHandler.HONEYSUCKLE.get());
		}
	}

	// === INLINE HERB FEATURE ===
	private static void addHerbs(BiomeLoadingEvent event, BushBlock herb) {
		ConfiguredFeature<?, ?> herbFeature = new Feature<NoFeatureConfig>(NoFeatureConfig.CODEC) {
			@Override
			public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos position, NoFeatureConfig config) {
				BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));


				if (world.isAirBlock(blockpos)
						&& world.getWorld().getDimensionKey() != World.THE_NETHER
						&& blockpos.getY() < 255
						&& herb.getDefaultState().isValidPosition(world, blockpos)) {
					world.setBlockState(blockpos, herb.getDefaultState(), 2);
					return true;
				}
				return false;
			}
		}
				.withConfiguration(NoFeatureConfig.INSTANCE)
				.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT)
				.count(5); // ~5 patches per chunk

		event.getGeneration().withFeature(
				GenerationStage.Decoration.VEGETAL_DECORATION,
				herbFeature
		);
	}
}
