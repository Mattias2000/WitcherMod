package mattias.EersteMod;

import mattias.EersteMod.init.RegistryHandler;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("em")
public class Main {
	public static final Logger LOGGER = LogManager.getLogger("The Witcher");
	public static final String MOD_ID = "em";

	public Main() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		RegistryHandler.init();

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
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

	}
}