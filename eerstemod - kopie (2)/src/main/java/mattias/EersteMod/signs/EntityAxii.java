package mattias.EersteMod.signs;

import mattias.EersteMod.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAxii extends EntityThrowable{

	public EntityAxii(World worldIn) {
		super(worldIn);
	}
	
	public EntityAxii(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }
	 
	@SideOnly(Side.CLIENT)   
	public EntityAxii(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

	   public static void registerFixesSign(DataFixer fixer)
	    {
	        EntityThrowable.registerFixesThrowable(fixer, "ThrownSign");
	    }

	    @SideOnly(Side.CLIENT)
	    public void handleStatusUpdate(byte id)
	    {
	        if (id == 3)
	        {
	            double d0 = 0.08D;

	            for (int i = 0; i < 8; ++i)
	            {
	                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ModItems.AXII));
	            }
	        }
	    }
	
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote)
        {
			if(result.entityHit != null)
			{
				((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 3, false, true));
				((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 100, 3, false, true));
				((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 3, false, true));
			}
			this.world.setEntityState(this, (byte)3);
			this.setDead();
        }
		
	}

    @Override
	public void onUpdate() {
		EntityLivingBase thrower = this.getThrower();
		
		if(thrower != null && thrower instanceof EntityPlayer && !thrower.isEntityAlive())
			this.setDead();
		else
			super.onUpdate();
	}
	
}