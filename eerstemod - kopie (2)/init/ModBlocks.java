package mattias.EersteMod.init;

import java.util.ArrayList;
import java.util.List;

import mattias.EersteMod.blocks.Herb;
import mattias.EersteMod.blocks.SilverBlock;
import mattias.EersteMod.blocks.SilverOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//silver
	public static final Block SILVER_ORE_BLOCK = new SilverOreBlock("silver_ore_block", Material.IRON);
	public static final Block SILVER_BLOCK = new SilverBlock("silver_block", Material.IRON);
	
	//herbs
	public static final BlockBush ALLSPICE = new Herb("allspice", Material.PLANTS);
	public static final BlockBush BALISSE = new Herb("balisse", Material.PLANTS);
	public static final BlockBush BEGGARTICK = new Herb("beggartick", Material.PLANTS);
	public static final BlockBush BERBERCANE = new Herb("berbercane", Material.PLANTS);
	public static final BlockBush BRYONIA = new Herb("bryonia", Material.PLANTS);
	public static final BlockBush CELANDINE = new Herb("celandine", Material.PLANTS);
	public static final BlockBush CROWSEYE = new Herb("crows_eye", Material.PLANTS);
	public static final BlockBush ERGOT = new Herb("ergot", Material.PLANTS);
	public static final BlockBush FEAINNEWEDD = new Herb("feainnewedd", Material.PLANTS);
	public static final BlockBush FOOLS_PARSLEY = new Herb("fools_parsley", Material.PLANTS);
	public static final BlockBush GINATIA = new Herb("ginatia", Material.PLANTS);
	public static final BlockBush GREEN_MUSHROOM = new Herb("green_mushroom", Material.PLANTS);
	public static final BlockBush HAN_FIBER = new Herb("han_fiber", Material.PLANTS);
	public static final BlockBush HELLEBORE = new Herb("hellebore", Material.PLANTS);
	public static final BlockBush HONEYSUCKLE = new Herb("honeysuckle", Material.PLANTS);
	public static final BlockBush HOP = new Herb("hop", Material.PLANTS);
	public static final BlockBush MANDRAKE = new Herb("mandrake", Material.PLANTS);
	public static final BlockBush MISTLETOE = new Herb("mistletoe", Material.PLANTS);
	public static final BlockBush SEWANT_MUSHROOM = new Herb("sewant_mushroom", Material.PLANTS);
	public static final BlockBush VERBENA = new Herb("verbena", Material.PLANTS);
	public static final BlockBush WHITE_MYRTLE = new Herb("white_myrtle", Material.PLANTS);
	public static final BlockBush WOLFS_ALOE_LEAVES = new Herb("wolfs_aloe_leaves", Material.PLANTS);
	public static final BlockBush WOLFSBANE = new Herb("wolfsbane", Material.PLANTS);
}