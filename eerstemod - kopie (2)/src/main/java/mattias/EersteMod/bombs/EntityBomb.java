package mattias.EersteMod.bombs;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBomb extends EntityThrowable{

	public static final PropertyBool EXPLODE = PropertyBool.create("explode");
	public EntityBomb(World worldIn) {
		super(worldIn);
	}
	 public EntityBomb(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }


	 
	 @SideOnly(Side.CLIENT)   
	 public EntityBomb(World worldIn, double x, double y, double z)
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
	 
	    if (!this.world.isRemote)
        {
	    /*    if (result.entityHit != null)
	        {
	            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
	        }*/
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