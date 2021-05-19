package mattias.EersteMod.blocks;

import mattias.EersteMod.Main;
import mattias.EersteMod.init.ModBlocks;
import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.util.IHasModel;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Herb extends BlockBush implements IHasModel {

	public Herb(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setSoundType(SoundType.PLANT);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0,"inventory");
	}



}