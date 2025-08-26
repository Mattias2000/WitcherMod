package mattias.EersteMod.util.handlers;

import mattias.EersteMod.Main;
import mattias.EersteMod.blocks.*;

import mattias.EersteMod.bombs.*;
import mattias.EersteMod.entities.EntityArachas;
import mattias.EersteMod.entities.EntityDrowner;
import mattias.EersteMod.entities.EntityWeb;
import mattias.EersteMod.items.*;
import mattias.EersteMod.items.tools.ToolMaterialList;
import mattias.EersteMod.signs.*;

import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);


	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

	}
	//silver
	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOreBlock::new);
	public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", SilverBlock::new);

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

	//silver item blocks
	public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> new BlockBase(SILVER_ORE.get()));
	public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block", () -> new BlockBase(SILVER_BLOCK.get()));

	//Bombs
	public static final RegistryObject<EntityType<EntityStenchbulb>> STENCH_BULB = ENTITIES
			.register("stench_bulb",
					() ->  EntityType.Builder.<EntityStenchbulb>create(EntityStenchbulb::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("stench_bulb"));
	public static final RegistryObject<EntityType<EntityBomb>> BOMB_ENTITY = ENTITIES
			.register("bomb",
					() ->  EntityType.Builder.<EntityBomb>create(EntityBomb::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("bomb"));
	public static final RegistryObject<EntityType<EntityDancingStar>> DANCING_STAR_ENTITY = ENTITIES
			.register("dancing_star",
					() ->  EntityType.Builder.<EntityDancingStar>create(EntityDancingStar::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("dancing_star"));
	public static final RegistryObject<EntityType<EntityDevilsPuffball>> DEVILS_PUFFBALL_ENTITY = ENTITIES
			.register("devils_puffball",
					() ->  EntityType.Builder.<EntityDevilsPuffball>create(EntityDevilsPuffball::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("devils_puffball"));
	public static final RegistryObject<EntityType<EntityDimeritiumBomb>> DIMERITIUM_BOMB_ENTITY = ENTITIES
			.register("dimeritium_bomb",
					() ->  EntityType.Builder.<EntityDimeritiumBomb>create(EntityDimeritiumBomb::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("dimeritium_bomb"));
	public static final RegistryObject<EntityType<EntitySamum>> SAMUM_ENTITY = ENTITIES
			.register("samum",
					() ->  EntityType.Builder.<EntitySamum>create(EntitySamum::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("samum"));

	public static final RegistryObject<Item> STENCHBULB = ITEMS.register("stenchbulb", () -> new Sign_BombBase(Sign_BombBase.ItemType.STENCHBULB));
	public static final RegistryObject<Item> BOMB = ITEMS.register("bomb", () -> new Sign_BombBase(Sign_BombBase.ItemType.NORMAL));
	public static final RegistryObject<Item> DANCING_STAR = ITEMS.register("dancing_star", () -> new Sign_BombBase(Sign_BombBase.ItemType.FIRE));
	public static final RegistryObject<Item> DEVILS_PUFFBALL = ITEMS.register("devils_puffball", () -> new Sign_BombBase(Sign_BombBase.ItemType.DEVILS_PUFF_BALL));
	public static final RegistryObject<Item> DIMERITIUM_BOMB = ITEMS.register("dimeritium_bomb", () -> new Sign_BombBase(Sign_BombBase.ItemType.DIMERITIUM));
	public static final RegistryObject<Item> SAMUM = ITEMS.register("samum", () -> new Sign_BombBase(Sign_BombBase.ItemType.SAMUM));

	//Signs
	public static final RegistryObject<EntityType<EntityAard>> AARD_ENTITY = ENTITIES
			.register("aard",
					() ->  EntityType.Builder.<EntityAard>create(EntityAard::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("aard"));
	public static final RegistryObject<EntityType<EntityIgni>> IGNI_ENTITY = ENTITIES
			.register("igni",
					() ->  EntityType.Builder.<EntityIgni>create(EntityIgni::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("igni"));
	public static final RegistryObject<EntityType<EntityAxii>> AXII_ENTITY = ENTITIES
			.register("axii",
					() ->  EntityType.Builder.<EntityAxii>create(EntityAxii::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("axii"));
	public static final RegistryObject<EntityType<EntityYrden>> YRDEN_ENTITY = ENTITIES
			.register("yrden",
					() ->  EntityType.Builder.<EntityYrden>create(EntityYrden::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("yrden"));
	public static final RegistryObject<Item> AARD = ITEMS.register("aard", () -> new Sign_BombBase(Sign_BombBase.ItemType.AARD));
	public static final RegistryObject<Item> IGNI = ITEMS.register("igni", () -> new Sign_BombBase(Sign_BombBase.ItemType.IGNI));
	public static final RegistryObject<Item> QUEN = ITEMS.register("quen", () -> new Sign_BombBase(Sign_BombBase.ItemType.QUEN));
	public static final RegistryObject<Item> AXII = ITEMS.register("axii", () -> new Sign_BombBase(Sign_BombBase.ItemType.AXII));
	public static final RegistryObject<Item> YRDEN = ITEMS.register("yrden", () -> new Sign_BombBase(Sign_BombBase.ItemType.YRDEN));

	//Oils
	public static final RegistryObject<Item> ARTHROPOD_OIL = ITEMS.register("arthropod", () -> new OilItem(Enchantments.BANE_OF_ARTHROPODS, 3));
	public static final RegistryObject<Item> UNDEAD_OIL = ITEMS.register("undead", () -> new OilItem(Enchantments.SMITE, 3));
	public static final RegistryObject<Item> FALKA_BLOOD = ITEMS.register("falka", () -> new OilItem(Enchantments.SHARPNESS, 3));

	//Potions
	public static final RegistryObject<Item> TAWNY = ITEMS.register("tawny", () -> new PotionBase(new EffectInstance(Effects.HEALTH_BOOST, 6000, 1, false, true), new EffectInstance(Effects.WEAKNESS, 6000, 0, false, true), false));
	public static final RegistryObject<Item> PETRIS_PHILTER = ITEMS.register("petris_philter", () -> new PotionBase(null, null, false, new ItemStack(RegistryHandler.QUEN.get()), new ItemStack(RegistryHandler.AXII.get()), new ItemStack(RegistryHandler.AARD.get()), new ItemStack(RegistryHandler.IGNI.get()), new ItemStack(RegistryHandler.YRDEN.get())));
	public static final RegistryObject<Item> WHITE_HONEY = ITEMS.register("white_honey", () -> new PotionBase(null, null, true));
	public static final RegistryObject<Item> SWALLOW = ITEMS.register("swallow", () -> new PotionBase(new EffectInstance(Effects.REGENERATION, 6000, 0, false, true), null, false));
	public static final RegistryObject<Item> CAT = ITEMS.register("cat", () -> new PotionBase(new EffectInstance(Effects.NIGHT_VISION, 6000, 0, false, true), null, false));
	public static final RegistryObject<Item> BLIZZARD = ITEMS.register("blizzard", () -> new PotionBase(new EffectInstance(Effects.HASTE, 6000, 0, false, true), new EffectInstance(Effects.SPEED, 6000, 0, false, true), false));
	public static final RegistryObject<Item> FULL_MOON = ITEMS.register("full_moon", () -> new PotionBase(new EffectInstance(Effects.HEALTH_BOOST, 6000, 0, false, true), null, false));
	public static final RegistryObject<Item> THUNDERBOLT = ITEMS.register("thunderbolt", () -> new PotionBase(new EffectInstance(Effects.STRENGTH, 6000, 1, false, true), new EffectInstance(Effects.SLOWNESS, 6000, 0, false, true), false));
	public static final RegistryObject<Item> RAFFARD = ITEMS.register("raffard", () -> new PotionBase(new EffectInstance(Effects.INSTANT_HEALTH, 0, 1, false, true), null, false));
	public static final RegistryObject<Item> GADWALL = ITEMS.register("gadwall", () -> new PotionBase(new EffectInstance(Effects.REGENERATION, 6000, 1, false, true), new EffectInstance(Effects.WEAKNESS, 6000, 0, false, true), false));
	public static final RegistryObject<Item> ROOK = ITEMS.register("rook", () -> new PotionBase(new EffectInstance(Effects.STRENGTH, 6000, 0, false, true), null, false));
	public static final RegistryObject<Item> KILLER_WHALE = ITEMS.register("killer_whale", () -> new PotionBase(new EffectInstance(Effects.WATER_BREATHING, 6000, 0, false, true), null, false));

	//MISC
	public static final RegistryObject<Item> MEDALLION = ITEMS.register("medallion", MedallionBase::new);
	public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", WItem::new);
	public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", WItem::new);
	public static final RegistryObject<Item> WEB = ITEMS.register("web", WItem::new);
	public static final RegistryObject<Item> ARACHAS_SPAWN_EGG = ITEMS.register("arachas_spawn_egg", () -> new ForgeSpawnEggItem(RegistryHandler.ARACHAS, 0xff99cc, 0x99ffcc, new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> DROWNER_SPAWN_EGG = ITEMS.register("drowner_spawn_egg", () -> new ForgeSpawnEggItem(RegistryHandler.DROWNER, 9732779, 6936552, new Item.Properties().group(ItemGroup.MISC)));

	//Monster Loot
	public static final RegistryObject<Item> MONSTER_CLAW = ITEMS.register("monster_claw", WItem::new);
	public static final RegistryObject<Item> MONSTER_EYE= ITEMS.register("monster_eye", WItem::new);
	public static final RegistryObject<Item> MONSTER_TOOTH = ITEMS.register("monster_tooth", WItem::new);
	public static final RegistryObject<Item> MONSTER_SKIN = ITEMS.register("monster_skin", WItem::new);
	public static final RegistryObject<Item> MONSTER_TONGUE = ITEMS.register("monster_tongue", WItem::new);
	public static final RegistryObject<Item> MONSTER_BRAIN = ITEMS.register("monster_brain", WItem::new);
	public static final RegistryObject<Item> MONSTER_HAIR = ITEMS.register("monster_hair", WItem::new);
	public static final RegistryObject<Item> MONSTER_HEART = ITEMS.register("monster_heart", WItem::new);
	public static final RegistryObject<Item> MONSTER_LIVER = ITEMS.register("monster_liver", WItem::new);
	public static final RegistryObject<Item> MONSTER_EAR = ITEMS.register("monster_ear", WItem::new);
	public static final RegistryObject<Item> MONSTER_BLOOD = ITEMS.register("monster_blood", WItem::new);

	//Ingredients
	public static final RegistryObject<Item> VITRIOL = ITEMS.register("vitriol", WItem::new);
	public static final RegistryObject<Item> REBIS = ITEMS.register("rebis", WItem::new);
	public static final RegistryObject<Item> AETHER = ITEMS.register("aether", WItem::new);
	public static final RegistryObject<Item> QUEBRITH = ITEMS.register("quebrith", WItem::new);
	public static final RegistryObject<Item> HYDRAGENUM = ITEMS.register("hydragenum", WItem::new);
	public static final RegistryObject<Item> VERMILION = ITEMS.register("vermilion", WItem::new);

	//Weapons
	public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () -> new SwordItem(ToolMaterialList.SILVER, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)));

	//Entities
	public static final RegistryObject<EntityType<EntityWeb>> WEB_ENTITY = ENTITIES
			.register("web",
					() ->  EntityType.Builder.<EntityWeb>create(EntityWeb::new, EntityClassification.MISC)
							.size(0.5F, 0.4F)
							.build("web"));
	public static final RegistryObject<EntityType<EntityArachas>> ARACHAS = ENTITIES
			.register("arachas",
					() -> EntityType.Builder.<EntityArachas>create(EntityArachas::new, EntityClassification.MONSTER)
							.size(1.4F, 0.9F)
							.build(new ResourceLocation(Main.MOD_ID, "arachas").toString()));
	public static final RegistryObject<EntityType<EntityDrowner>> DROWNER = ENTITIES
			.register("drowner",
					() -> EntityType.Builder.<EntityDrowner>create(EntityDrowner::new, EntityClassification.MONSTER)
							.size(1.2F, 2.1F)
							.build(new ResourceLocation(Main.MOD_ID, "drowner").toString()));
}