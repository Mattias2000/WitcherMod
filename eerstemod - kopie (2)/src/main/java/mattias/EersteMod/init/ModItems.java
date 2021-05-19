package mattias.EersteMod.init;

import java.util.ArrayList;
import java.util.List;

import mattias.EersteMod.items.BombBase;
import mattias.EersteMod.items.FalkaOil;
import mattias.EersteMod.items.ItemBase;
import mattias.EersteMod.items.MedallionBase;
import mattias.EersteMod.items.PetrisPhilterBase;
import mattias.EersteMod.items.PotionBase;
import mattias.EersteMod.items.SignBase;
import mattias.EersteMod.items.UndeadOil;
import mattias.EersteMod.items.WhiteHoneyBase;
import mattias.EersteMod.items.tools.ToolSword;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materals
	public static final ToolMaterial MATERIAL_SILVER = EnumHelper.addToolMaterial("material_silver",2, 250, 5.0F, 3.0F, 14);
	
	//Signs
	public static final Item AARD = new SignBase("aard");
	public static final Item IGNI = new SignBase("igni");
	public static final Item QUEN = new SignBase("quen");
	public static final Item AXII = new SignBase("axii");
	public static final Item YRDEN = new SignBase("yrden");	
	
	//Monster loot
	public static final Item MONSTER_CLAW = new ItemBase("monster_claw");
	public static final Item MONSTER_EYE = new ItemBase("monster_eye");
	public static final Item MONSTER_TOOTH = new ItemBase("monster_tooth");
	public static final Item MONSTER_SKIN = new ItemBase("monster_skin");
	public static final Item MONSTER_TONGUE = new ItemBase("monster_tongue");
	public static final Item MONSTER_BRAIN = new ItemBase("monster_brain");
	public static final Item MONSTER_BONE = new ItemBase("monster_bone");
	public static final Item MONSTER_HAIR = new ItemBase("monster_hair");
	public static final Item MONSTER_HEART = new ItemBase("monster_heart");
	public static final Item MONSTER_LIVER = new ItemBase("monster_liver");
	public static final Item MONSTER_EAR = new ItemBase("monster_ear");
	public static final Item MONSTER_BLOOD = new ItemBase("monster_blood");
	
	//Ingredients
	public static final Item VITRIOL = new ItemBase("vitriol");
	public static final Item REBIS = new ItemBase("rebis");
	public static final Item AETHER = new ItemBase("aether");
	public static final Item QUEBRITH = new ItemBase("quebrith");
	public static final Item HYDRAGENUM = new ItemBase("hydragenum");
	public static final Item VERMILION = new ItemBase("vermilion");
	
	//Tools
	public static final ItemSword SILVER_SWORD = new ToolSword("silver_sword", MATERIAL_SILVER);

	//Potions
	public static final Item SWALLOW = new PotionBase("swallow", new PotionEffect(MobEffects.REGENERATION, 6000, 0, false, true),null);
	public static final Item CAT = new PotionBase("cat", new PotionEffect(MobEffects.NIGHT_VISION, 6000, 0, false, true),null);
	public static final Item BLIZZARD = new PotionBase("blizzard", new PotionEffect(MobEffects.HASTE, 6000, 0, false, true), new PotionEffect(MobEffects.SPEED, 6000, 0, false, true));
	public static final Item FULL_MOON = new PotionBase("full_moon", new PotionEffect(MobEffects.HEALTH_BOOST, 6000, 0, false, true),null);
	public static final Item THUNDERBOLT = new PotionBase("thunderbolt", new PotionEffect(MobEffects.STRENGTH, 6000, 1, false, true), new PotionEffect(MobEffects.SLOWNESS, 6000, 0, false, true));
	public static final Item RAFFARD = new PotionBase("raffard", new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0, false, true), null);
	public static final Item TAWNY = new PotionBase("tawny", new PotionEffect(MobEffects.HEALTH_BOOST, 6000, 1, false, true), new PotionEffect(MobEffects.WEAKNESS, 6000, 0, false, true));
	public static final Item GADWALL = new PotionBase("gadwall", new PotionEffect(MobEffects.REGENERATION, 6000, 1, false, true), new PotionEffect(MobEffects.WEAKNESS, 6000, 0, false, true));
	public static final Item ROOK = new PotionBase("rook", new PotionEffect(MobEffects.STRENGTH, 6000, 0, false, true),null);
	public static final Item KILLER_WHALE = new PotionBase("killer_whale", new PotionEffect(MobEffects.WATER_BREATHING, 6000, 0, false, true), null);
	public static final Item WHITE_HONEY = new WhiteHoneyBase("white_honey");
	public static final Item PETRIS_PHILTER = new PetrisPhilterBase("petris_philter");
	
	//Oils
	public static final Item FALKA = new FalkaOil("falka");
	public static final Item UNDEAD = new UndeadOil("undead");
	public static final Item ARTHROPOD = new UndeadOil("arthropod");
	
	//Bombs
	public static final Item BOMB = new BombBase("bomb");
	public static final Item DEVILS_PUFFBALL = new BombBase("devils_puffball");
	public static final Item SAMUM = new BombBase("samum");
	public static final Item DANCING_STAR = new BombBase("dancing_star");
	public static final Item DIMERITIUM_BOMB = new BombBase("dimeritium_bomb");
	public static final Item STENCHBULB = new BombBase("stenchbulb");
	
	//Misc
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item MEDALLION = new MedallionBase("medallion");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item WEB = new ItemBase("web");
}