package mattias.EersteMod.init;

import mattias.EersteMod.Main;
import mattias.EersteMod.blocks.HerbBlockBase;
import mattias.EersteMod.blocks.Herb;
//import mattias.EersteMod.blocks.SilverBlock;
//import mattias.EersteMod.blocks.SilverOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

	}
	//silver
//	public static final Block SILVER_ORE_BLOCK = new SilverOreBlock("silver_ore_block", Material.IRON);
//	public static final Block SILVER_BLOCK = new SilverBlock("silver_block", Material.IRON);
	
	//herb blocks
	public static final RegistryObject<BushBlock> ALLSPICE = BLOCKS.register("allspice", Herb::new);
	public static final RegistryObject<BushBlock> BALISSE = BLOCKS.register("balisse", Herb::new);
	public static final RegistryObject<BushBlock> BEGGARTICK = BLOCKS.register("beggartick", Herb::new);
	public static final RegistryObject<BushBlock> BERBERCANE = BLOCKS.register("berbercane", Herb::new);
	public static final RegistryObject<BushBlock> BRYONIA = BLOCKS.register("bryonia", Herb::new);
	public static final RegistryObject<BushBlock> CELANDINE = BLOCKS.register("celandine", Herb::new);
	public static final RegistryObject<BushBlock> CROWSEYE = BLOCKS.register("crows_eye", Herb::new);
	public static final RegistryObject<BushBlock> ERGOT = BLOCKS.register("ergot", Herb::new);
	public static final RegistryObject<BushBlock> FEAINNEWEDD = BLOCKS.register("feainnewedd", Herb::new);
	public static final RegistryObject<BushBlock> FOOLS_PARSLEY = BLOCKS.register("fools_parsley", Herb::new);
	public static final RegistryObject<BushBlock> GINATIA = BLOCKS.register("ginatia", Herb::new);
	public static final RegistryObject<BushBlock> GREEN_MUSHROOM = BLOCKS.register("green_mushroom", Herb::new);
	public static final RegistryObject<BushBlock> HAN_FIBER = BLOCKS.register("han_fiber", Herb::new);
	public static final RegistryObject<BushBlock> HELLEBORE = BLOCKS.register("hellebore", Herb::new);
	public static final RegistryObject<BushBlock> HONEYSUCKLE = BLOCKS.register("honeysuckle", Herb::new);
	public static final RegistryObject<BushBlock> HOP = BLOCKS.register("hop", Herb::new);
	public static final RegistryObject<BushBlock> MANDRAKE = BLOCKS.register("mandrake", Herb::new);
	public static final RegistryObject<BushBlock> MISTLETOE = BLOCKS.register("mistletoe", Herb::new);
	public static final RegistryObject<BushBlock> SEWANT_MUSHROOM = BLOCKS.register("sewant_mushroom", Herb::new);
	public static final RegistryObject<BushBlock> VERBENA = BLOCKS.register("verbena", Herb::new);
	public static final RegistryObject<BushBlock> WHITE_MYRTLE = BLOCKS.register("white_myrtle", Herb::new);
	public static final RegistryObject<BushBlock> WOLFS_ALOE_LEAVES = BLOCKS.register("wolfs_aloe_leaves", Herb::new);
	public static final RegistryObject<BushBlock> WOLFSBANE = BLOCKS.register("wolfsbane", Herb::new);

	//herb item blocks
	public static final RegistryObject<Item> ALLSPICE_ITEM = ITEMS.register("allspice", () -> new HerbBlockBase(ALLSPICE.get()));
	public static final RegistryObject<Item> BALISSE_ITEM = ITEMS.register("balisse", () -> new HerbBlockBase(BALISSE.get()));
	public static final RegistryObject<Item> BEGGARTICK_ITEM = ITEMS.register("beggartick", () -> new HerbBlockBase(BEGGARTICK.get()));
	public static final RegistryObject<Item> BERBERCANE_ITEM = ITEMS.register("berbercane", () -> new HerbBlockBase(BERBERCANE.get()));
	public static final RegistryObject<Item> BRYONIA_ITEM = ITEMS.register("bryonia", () -> new HerbBlockBase(BRYONIA.get()));
	public static final RegistryObject<Item> CELANDINE_ITEM = ITEMS.register("celandine", () -> new HerbBlockBase(CELANDINE.get()));
	public static final RegistryObject<Item> CROWSEYE_ITEM = ITEMS.register("crows_eye", () -> new HerbBlockBase(CROWSEYE.get()));
	public static final RegistryObject<Item> ERGOT_ITEM = ITEMS.register("ergot", () -> new HerbBlockBase(ERGOT.get()));
	public static final RegistryObject<Item> FEAINNEWEDD_ITEM = ITEMS.register("feainnewedd", () -> new HerbBlockBase(FEAINNEWEDD.get()));
	public static final RegistryObject<Item> FOOLS_PARSLEY_ITEM = ITEMS.register("fools_parsley", () -> new HerbBlockBase(FOOLS_PARSLEY.get()));
	public static final RegistryObject<Item> GINATIA_ITEM = ITEMS.register("ginatia", () -> new HerbBlockBase(GINATIA.get()));
	public static final RegistryObject<Item> GREEN_MUSHROOM_ITEM = ITEMS.register("green_mushroom", () -> new HerbBlockBase(GREEN_MUSHROOM.get()));
	public static final RegistryObject<Item> HAN_FIBER_ITEM = ITEMS.register("han_fiber", () -> new HerbBlockBase(HAN_FIBER.get()));
	public static final RegistryObject<Item> HELLEBORE_ITEM = ITEMS.register("hellebore", () -> new HerbBlockBase(HELLEBORE.get()));
	public static final RegistryObject<Item> HONEYSUCKLE_ITEM = ITEMS.register("honeysuckle", () -> new HerbBlockBase(HONEYSUCKLE.get()));
	public static final RegistryObject<Item> HOP_ITEM = ITEMS.register("hop", () -> new HerbBlockBase(HOP.get()));
	public static final RegistryObject<Item> MANDRAKE_ITEM = ITEMS.register("mandrake", () -> new HerbBlockBase(MANDRAKE.get()));
	public static final RegistryObject<Item> MISTLETOE_ITEM = ITEMS.register("mistletoe", () -> new HerbBlockBase(MISTLETOE.get()));
	public static final RegistryObject<Item> SEWANT_MUSHROOM_ITEM = ITEMS.register("sewant_mushroom", () -> new HerbBlockBase(SEWANT_MUSHROOM.get()));
	public static final RegistryObject<Item> VERBENA_ITEM = ITEMS.register("verbena", () -> new HerbBlockBase(VERBENA.get()));
	public static final RegistryObject<Item> WHITE_MYRTLE_ITEM = ITEMS.register("white_myrtle", () -> new HerbBlockBase(WHITE_MYRTLE.get()));
	public static final RegistryObject<Item> WOLFS_ALOE_LEAVES_ITEM = ITEMS.register("wolfs_aloe_leaves", () -> new HerbBlockBase(WOLFS_ALOE_LEAVES.get()));
	public static final RegistryObject<Item> WOLFSBANE_ITEM = ITEMS.register("wolfsbane", () -> new HerbBlockBase(WOLFSBANE.get()));



}