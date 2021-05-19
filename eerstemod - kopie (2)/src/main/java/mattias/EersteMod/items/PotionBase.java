package mattias.EersteMod.items;

import mattias.EersteMod.Main;
import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.util.IHasModel;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionBase extends Item implements IHasModel {
	
	PotionEffect effect;
	PotionEffect effect2;

	public PotionBase(String name, PotionEffect effect, PotionEffect effect2)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.BREWING);
		
		ModItems.ITEMS.add(this);
		
		this.effect = effect;
		this.effect2 = effect2;
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	@SideOnly(Side.CLIENT)
    public ItemStack getDefaultInstance()
    {
        return PotionUtils.addPotionToItemStack(super.getDefaultInstance(), PotionTypes.WATER);
    }

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
		 
		if (entityplayer instanceof EntityPlayerMP)
		{
			CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
		}
	 
	 	 if(!worldIn.isRemote)
	 	 {
	 		if(effect!=null)
	 		entityLiving.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
	 		if(effect2!=null)
	 		entityLiving.addPotionEffect(new PotionEffect(effect2.getPotion(), effect2.getDuration(), effect2.getAmplifier(), effect2.getIsAmbient(), effect2.doesShowParticles()));
	 	 }
		  
		 if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
	     {
			 stack.shrink(1);
	     }
		 
		 if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
		 {
			 if (stack.isEmpty())
			 {
				 return new ItemStack(Items.GLASS_BOTTLE);
			 }

			 if (entityplayer != null)
			 {
				 entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
			 }
		 }
		 return stack;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.DRINK;
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 32;
	} 
}
