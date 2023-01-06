package mattias.EersteMod;

import mattias.EersteMod.init.ModBlocks;
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
		ModBlocks.init();

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ModBlocks.ALLSPICE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BALISSE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BEGGARTICK.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BERBERCANE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BRYONIA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.CELANDINE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.CROWSEYE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.ERGOT.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.FEAINNEWEDD.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.FOOLS_PARSLEY.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GINATIA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_MUSHROOM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HAN_FIBER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HELLEBORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HONEYSUCKLE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HOP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.MANDRAKE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.MISTLETOE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.SEWANT_MUSHROOM.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.VERBENA.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_MYRTLE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WOLFS_ALOE_LEAVES.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WOLFSBANE.get(), RenderType.getCutout());

	}
}



