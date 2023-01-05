package mattias.EersteMod.items;

import mattias.EersteMod.Main;
import mattias.EersteMod.entity.EntityWeb;
import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityAard;
import mattias.EersteMod.signs.EntityAxii;
import mattias.EersteMod.signs.EntityIgni;
import mattias.EersteMod.signs.EntityYrden;
import mattias.EersteMod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class SignBase extends Item implements IHasModel{

	String name;
	public SignBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.maxStackSize=1;
		this.setMaxDamage(200);
		
		ModItems.ITEMS.add(this);
		
		this.name=name;
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if(!playerIn.capabilities.isCreativeMode && !worldIn.isRemote)
		stack.damageItem(1, playerIn);
		
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if(!worldIn.isRemote) {
			
			switch(name)
			{
				case "aard":
					EntityAard aard = new EntityAard(worldIn, playerIn);
					aard.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			        worldIn.spawnEntity(aard);
			        break;
				case "igni":
					EntityIgni igni = new EntityIgni(worldIn, playerIn);
					igni.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			        worldIn.spawnEntity(igni);
			        break;
				case "quen":
					playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1200, 0, false, true));
			        break;
				case "axii":
					EntityAxii axii = new EntityAxii(worldIn, playerIn);
					axii.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			        worldIn.spawnEntity(axii);
			        break;
				case "yrden":
					EntityYrden yrden = new EntityYrden(worldIn, playerIn);
					yrden.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			        worldIn.spawnEntity(yrden);
			        break;
			}
		}
		
		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

}
