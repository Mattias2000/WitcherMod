package mattias.EersteMod;

import mattias.EersteMod.entities.*;
import mattias.EersteMod.entities.renders.*;
import mattias.EersteMod.util.WitcherTab;
import mattias.EersteMod.util.handlers.RegistryHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import mattias.EersteMod.world.ModWorldGen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod("em")
public class Main {
	public static final Logger LOGGER = LogManager.getLogger("The Witcher");
	public static final String MOD_ID = "em";
	public static final ItemGroup TAB = new WitcherTab();


	public Main() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		RegistryHandler.init();
		MinecraftForge.EVENT_BUS.addListener(ModWorldGen::onBiomeLoading);
		SoundsHandler.registerSounds();
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		ItemModelsProperties.registerProperty(
				RegistryHandler.MEDALLION.get(),
				new ResourceLocation("vibrating"),
				(stack, world, entity) -> {
					if (entity == null) {
						return 0.0F;
					} else {
						AxisAlignedBB area = new AxisAlignedBB(
								entity.getPosX() - 8.0D, entity.getPosY() - 5.0D, entity.getPosZ() - 8.0D,
								entity.getPosX() + 8.0D, entity.getPosY() + 5.0D, entity.getPosZ() + 8.0D
						);
						List<MonsterEntity> mobs = entity.world.getEntitiesWithinAABB(MonsterEntity.class, area);
						return mobs.isEmpty() ? 0.0F : 1.0F;
					}
				}
		);
		DeferredWorkQueue.runLater(() -> {
			GlobalEntityTypeAttributes.put(RegistryHandler.ARACHAS.get(), EntityArachas.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.DROWNER.get(), EntityDrowner.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.FLEDER.get(), EntityFleder.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.FOGLET.get(), EntityFoglet.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.GHOUL.get(), EntityGhoul.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.ROTFIEND.get(), EntityRotfiend.getAttributes().create());
			GlobalEntityTypeAttributes.put(RegistryHandler.NEKKER.get(), EntityNekker.getAttributes().create());
		});
		event.enqueueWork(() -> {
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.NEKKER.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.ARACHAS.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.DROWNER.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.FLEDER.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.FOGLET.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.GHOUL.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
			EntitySpawnPlacementRegistry.register(
					RegistryHandler.ROTFIEND.get(),
					EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
					Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					MonsterEntity::canMonsterSpawn
			);
		});
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(RegistryHandler.ALLSPICE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.BALISSE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.BEGGARTICK.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.BERBERCANE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.BRYONIA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.CELANDINE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.CROWSEYE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.ERGOT.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.FEAINNEWEDD.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.FOOLS_PARSLEY.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.GINATIA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.GREEN_MUSHROOM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.HAN_FIBER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.HELLEBORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.HONEYSUCKLE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.HOP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.MANDRAKE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.MISTLETOE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.SEWANT_MUSHROOM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.VERBENA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.WHITE_MYRTLE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.WOLFS_ALOE_LEAVES.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(RegistryHandler.WOLFSBANE.get(), RenderType.getCutout());
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.STENCH_BULB.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BOMB_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DANCING_STAR_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DEVILS_PUFFBALL_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DIMERITIUM_BOMB_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.SAMUM_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.AARD_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.IGNI_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.AXII_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.YRDEN_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.WEB_ENTITY.get(),
				manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ARACHAS.get(), RenderArachas::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DROWNER.get(), RenderDrowner::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.FLEDER.get(), RenderFleder::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.FOGLET.get(), RenderFoglet::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.GHOUL.get(), RenderGhoul::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.NEKKER.get(), RenderNekker::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ROTFIEND.get(), RenderRotfiend::new);
	}
}