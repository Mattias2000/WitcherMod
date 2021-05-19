package mattias.EersteMod.items;

import mattias.EersteMod.bombs.EntityBomb;
import mattias.EersteMod.bombs.EntityDancingStar;
import mattias.EersteMod.bombs.EntityDevilsPuffball;
import mattias.EersteMod.bombs.EntityDimeritiumBomb;
import mattias.EersteMod.bombs.EntitySamum;
import mattias.EersteMod.bombs.EntityStenchbulb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class BombBase extends ItemBase {
	String name; 
	
	public BombBase(String name)
	{
		super(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.name = name;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if(!playerIn.capabilities.isCreativeMode)
		stack.shrink(1);
		
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!worldIn.isRemote)
		{
			switch(name)
			{
				case "bomb":
					EntityBomb rock = new EntityBomb(worldIn, playerIn);
					rock.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(rock);
			    	break;
				case "dancing_star":
					EntityDancingStar ds = new EntityDancingStar(worldIn, playerIn);
					ds.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(ds);
			    	break;
				case "samum":
					EntitySamum sa = new EntitySamum(worldIn, playerIn);
					sa.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(sa);
			    	break;
				case "devils_puffball":
					EntityDevilsPuffball dp = new EntityDevilsPuffball(worldIn, playerIn);
					dp.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(dp);
			    	break;
				case "stenchbulb":
					EntityStenchbulb sb = new EntityStenchbulb(worldIn, playerIn);
					sb.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(sb);
			    	break;
				case "dimeritium_bomb":
					EntityDimeritiumBomb db = new EntityDimeritiumBomb(worldIn, playerIn);
					db.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			    	worldIn.spawnEntity(db);
			    	break;
			}
		}
		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}