package mattias.EersteMod.signs;

import javax.vecmath.Vector2d;

import mattias.EersteMod.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAard extends EntityThrowable{

	int x;
	int y;
	int z;
	EntityPlayer thrower;
	public EntityAard(World worldIn) {
		super(worldIn);
	}
	
	public EntityAard(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        thrower = (EntityPlayer) throwerIn;
        this.x=(int)thrower.posX;
        this.y=(int)thrower.posY;
        this.z=(int)thrower.posZ;
    }
	 
	@SideOnly(Side.CLIENT)   
	public EntityAard(World worldIn, double x, double y, double z)
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
	                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ModItems.AARD));
	            }
	        }
	    }
   
		public void knockBack(Entity entity, double d, double d1)
	    {
	        entity.isAirBorne = true;
	        float f = MathHelper.sqrt(d * d + d1 * d1);
	       // float f1 = 0.4F;
	        float f1 = 1.2F;
	        entity.motionX /= 2D;
	        entity.motionY /= 2D;
	        entity.motionZ /= 2D;
	        entity.motionX -= (d / (double)f) * (double)f1;
	        entity.motionY += 0.40000000596046448D;
	        entity.motionZ -= (d1 / (double)f) * (double)f1;
	        if(entity.motionY > 0.40000000596046448D)
	        {
	        	entity.motionY = 0.40000000596046448D;
	        }
	    }
	
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote)
        {
			if(result.entityHit != null)
			{
				Entity hit = result.entityHit;
				knockBack(hit,x-hit.posX,z-hit.posZ);
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