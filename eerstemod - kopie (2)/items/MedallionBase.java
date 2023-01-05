package mattias.EersteMod.items;

import java.util.List;

import javax.annotation.Nullable;

import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MedallionBase extends ItemBase {

	public MedallionBase(String name)
	{
		super(name);
		setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxDamage(50);
		setMaxStackSize(1);
		
		
		
		this.addPropertyOverride(new ResourceLocation("vibrating"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
            	if(entityIn == null)
            	{
            		return 0.0F;
            	}
            	else
            	{
            	List<EntityMob> list = entityIn.world.<EntityMob>getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB((double)entityIn.posX - 8.0D, (double)entityIn.posY - 5.0D, (double)entityIn.posZ - 8.0D, (double)entityIn.posX + 8.0D, (double)entityIn.posY + 5.0D, (double)entityIn.posZ + 8.0D));
        	    if (!list.isEmpty())
        	    {
        	    	return 1.0F;
        	    }
            		else
            		{
            			return 0.0F;
            		}
            	}
            }
        });
	}
	

	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if(!playerIn.capabilities.isCreativeMode && !worldIn.isRemote)
		stack.damageItem(1, playerIn);
		
	    List<EntityMob> list = playerIn.world.<EntityMob>getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB((double)playerIn.posX - 8.0D, (double)playerIn.posY - 5.0D, (double)playerIn.posZ - 8.0D, (double)playerIn.posX + 8.0D, (double)playerIn.posY + 5.0D, (double)playerIn.posZ + 8.0D));
	    if (!list.isEmpty())
	    {

	    	for(EntityMob entitymob : list)
	    	{
    					entitymob.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 0, false, false));
	    	}
	    }
		
		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	
}