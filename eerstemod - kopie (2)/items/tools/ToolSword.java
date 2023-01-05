package mattias.EersteMod.items.tools;

import mattias.EersteMod.Main;
import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {

	public ToolSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
	}
	/*
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		Enchantment knockback = Enchantment.getEnchantmentByID(19);
		ItemStack stack = playerIn.getHeldItem(handIn);
		stack.addEnchantment(knockback, 4);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	*/
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
