package mattias.EersteMod.entity;

import mattias.EersteMod.util.handlers.LootTableHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFleder extends EntityMonster{

	public EntityFleder(World worldIn)
	{
		super(worldIn);
		this.setSize(1.2F, 3.2F);
	}
	
	protected ResourceLocation getLootTable() {
		return LootTableHandler.FLEDER;
	}
	
	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
      //  this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityMonster.AIMonsterAttack(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityMonster.AIMonsterTarget(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new EntityMonster.AIMonsterTarget(this, EntityIronGolem.class));
	}
	
	protected SoundEvent getAmbientSound()
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_FLEDER_AMBIENT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_FLEDER_AMBIENT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_FLEDER_AMBIENT3;
		}else
		{
			return SoundsHandler.ENTITY_FLEDER_AMBIENT4;
		}
	}
	


	
	protected SoundEvent getHurtSound(DamageSource source)
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_FLEDER_HURT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_FLEDER_HURT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_FLEDER_HURT3;
		}else
		{
			return SoundsHandler.ENTITY_FLEDER_HURT4;
		}
	}
	

	protected SoundEvent getDeathSound()
	{
		//todo: change sound
		return SoundsHandler.ENTITY_FLEDER_DEATH;
	}
	
	protected void applyEntityAttributes()
	{
		//todo: change attributes
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
	}
	
	


}
