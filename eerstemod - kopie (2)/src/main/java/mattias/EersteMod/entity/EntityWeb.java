package mattias.EersteMod.entity;

import mattias.EersteMod.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import mattias.EersteMod.entity.EntityArachas;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWeb extends EntityThrowable{

	int x;
	int y;
	int z;
	EntityArachas thrower;
	public EntityWeb(World worldIn) {
		super(worldIn);
	}
	
	public EntityWeb(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        thrower = (EntityArachas) throwerIn;
        this.x=(int)thrower.posX;
        this.y=(int)thrower.posY;
        this.z=(int)thrower.posZ;
    }
	 
	@SideOnly(Side.CLIENT)   
	public EntityWeb(World worldIn, double x, double y, double z)
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
	                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ModItems.WEB));
	            }
	        }
	    }
	
	protected void onImpact(RayTraceResult result) {
		
		if (!this.world.isRemote)
        {
			if (result.entityHit instanceof EntityArachas == false)
		{
			if(result.entityHit != null)
			{
	            
	            
	                ((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 0, false, true));
	            
			}
			this.world.setEntityState(this, (byte)3);
			this.setDead();
        }
		}
	}

    @Override
	public void onUpdate() {
		EntityLivingBase thrower = this.getThrower();
		
		if(thrower != null && thrower instanceof EntityArachas && !thrower.isEntityAlive())
			this.setDead();
		else
			super.onUpdate();
	}
	
}