package mattias.EersteMod.bombs;

import java.util.List;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySamum extends EntityThrowable{

	public static final PropertyBool EXPLODE = PropertyBool.create("explode");
	PotionEffect effect = new PotionEffect(MobEffects.SLOWNESS, 2400, 0, false, true);
	public EntitySamum(World worldIn) {
		super(worldIn);
	}
	 public EntitySamum(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }


	 
	 @SideOnly(Side.CLIENT)   
	 public EntitySamum(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }

	   public static void registerFixesBomb(DataFixer fixer)
	    {
	        EntityThrowable.registerFixesThrowable(fixer, "ThrownBomb");
	    }

	    /**
	     * Handler for {@link World#setEntityState}
	     */


	    /**
	     * Called when this EntityThrowable hits a block or entity.
	     */
	    protected void onImpact(RayTraceResult result)
	    {
	    AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().grow(4.0D, 2.0D, 4.0D);
	    List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
	 
	    if (!this.world.isRemote)
        {
	     /*   if (result.entityHit != null)
	        {
	            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
	        }*/
	        if(!list.isEmpty())
	        {
	        	for(EntityLivingBase entitylivingbase : list)
	        	{
	        		if(entitylivingbase.canBeHitWithPotion())
	        		{
	        			double d0 = this.getDistanceSq(entitylivingbase);
	        			if(d0<16.0D)
	        			{
	        				double d1 = 1.0D - Math.sqrt(d0) / 4.0D;
	        				if(entitylivingbase==result.entityHit)
	        				{
	        					d1=1.0D;
	        				}
	        				int i = (int)(d1*(double)effect.getDuration()+0.5D);
	        				if(i>20)
	        				{
	        					entitylivingbase.addPotionEffect(new PotionEffect(effect.getPotion(), i, effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
	        				}
	        			}
	        		}
	        	}
	        }
	        this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 1.5F, true);
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