package mattias.EersteMod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class FalkaOil extends ItemBase {

	public FalkaOil(String name)
	{
		super(name);
		setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		EnumHand swordhand = EnumHand.MAIN_HAND;
		ItemStack swordstack = playerIn.getHeldItem(swordhand);
		if(!playerIn.capabilities.isCreativeMode)
		{
		stack.shrink(1);
		playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
		}
		Enchantment sharpness = Enchantment.getEnchantmentByID(16);
		swordstack.addEnchantment(sharpness, 3);
		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
