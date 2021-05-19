package mattias.EersteMod.entity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import mattias.EersteMod.util.handlers.LootTableHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityArachas extends EntityMonster implements IRangedAttackMob{
	
	int timer=2;
	public EntityArachas(World worldIn)
	{
		super(worldIn);
		this.setSize(1.4F, 0.9F);
	}
	protected ResourceLocation getLootTable() {
		//todo: return real loottable
		return LootTableHandler.ARACHAS;
	}
	
    
	
    void PoisonAttack(EntityLivingBase target, float distanceFactor)
    {
    	    EntityWeb entitysnowball = new EntityWeb(this.world, this);
		    double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
	        double d1 = target.posX - this.posX;
	        double d2 = d0 - entitysnowball.posY;
	        double d3 = target.posZ - this.posZ;
	        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
	         entitysnowball.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
	        this.playSound(SoundsHandler.ENTITY_ARACHAS_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	        this.world.spawnEntity(entitysnowball);
    }
	
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
    {
    	timer--;
    	if(timer==1)
    	{
    		this.playSound(SoundsHandler.ENTITY_ARACHAS_WARNING, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
    	}
    	if(timer==0)
    	{
    		timer=5;
    		PoisonAttack(target,distanceFactor);
    	}
    }
	
    protected void initEntityAI()
    {

	    
        this.tasks.addTask(3, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		this.tasks.addTask(1, new EntityAISwimming(this));
      
        
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityMonster.AIMonsterTarget(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new EntityMonster.AIMonsterTarget(this, EntityIronGolem.class));
    }	
	
	protected SoundEvent getAmbientSound()
	{
		double chance = Math.random();
		if (chance < 0.33)
		{
		return SoundsHandler.ENTITY_ARACHAS_AMBIENT1;
		}
		else if (chance < 0.66)
		{
			return SoundsHandler.ENTITY_ARACHAS_AMBIENT2;
		}
		else
		{
			return SoundsHandler.ENTITY_ARACHAS_AMBIENT3;
		}
	}


	
	protected SoundEvent getHurtSound(DamageSource source)
	{
		double chance = Math.random();
		if (chance < 0.2)
		{
		return SoundsHandler.ENTITY_ARACHAS_HURT1;
		}
		else if (chance < 0.4)
		{
			return SoundsHandler.ENTITY_ARACHAS_HURT2;
		}
		else if (chance < 0.6)
		{
			return SoundsHandler.ENTITY_ARACHAS_HURT3;
		}
		else if (chance < 0.8)
		{
			return SoundsHandler.ENTITY_ARACHAS_HURT4;
		}
		else
		{
			return SoundsHandler.ENTITY_ARACHAS_HURT5;
		}
	}
	

	protected SoundEvent getDeathSound()
	{
		return SoundsHandler.ENTITY_ARACHAS_DEATH;
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(18.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}
	@Override
	public void setSwingingArms(boolean swingingArms) {
		// TODO Auto-generated method stub
		
	}
	


}