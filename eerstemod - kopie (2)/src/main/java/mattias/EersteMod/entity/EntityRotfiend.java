package mattias.EersteMod.entity;

import mattias.EersteMod.util.handlers.LootTableHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRotfiend extends EntityMonster{

	public EntityRotfiend(World worldIn)
	{
		super(worldIn);
		this.setSize(0.6F, 1.95F);
	}
	protected ResourceLocation getLootTable() {
		return LootTableHandler.ROTFIEND;
	}
	
	protected SoundEvent getAmbientSound()
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_ROTFIEND_AMBIENT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT3;
		}else
		{
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT4;
		}
	}
	


	
	protected SoundEvent getHurtSound(DamageSource source)
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.33)
		{
		return SoundsHandler.ENTITY_ROTFIEND_HURT1;
		}
		else if (chance < 0.66)
		{
			return SoundsHandler.ENTITY_ROTFIEND_HURT2;
		}else
		{
			return SoundsHandler.ENTITY_DROWNER_HURT3;
		}
	}
	

	protected SoundEvent getDeathSound()
	{
		//todo: change sound
		return SoundsHandler.ENTITY_ROTFIEND_DEATH;
	}
	
	protected void applyEntityAttributes()
	{
		//todo: change attributes
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(19.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.3D);
	}
	
	public void onDeath(DamageSource cause)
	{
        EntityTNTPrimed entitypigzombie = new EntityTNTPrimed(this.world);
        entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.world.spawnEntity(entitypigzombie);		
        if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, cause)) return;
        if (!this.dead)
        {
            Entity entity = cause.getTrueSource();
            EntityLivingBase entitylivingbase = this.getAttackingEntity();

            if (this.scoreValue >= 0 && entitylivingbase != null)
            {
                entitylivingbase.awardKillScore(this, this.scoreValue, cause);
            }

            if (entity != null)
            {
                entity.onKillEntity(this);
            }

            this.dead = true;
            this.getCombatTracker().reset();

            if (!this.world.isRemote)
            {
                int i = net.minecraftforge.common.ForgeHooks.getLootingLevel(this, entity, cause);

                captureDrops = true;
                capturedDrops.clear();

                if (this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot"))
                {
                    boolean flag = this.recentlyHit > 0;
                    this.dropLoot(flag, i, cause);
                }

                captureDrops = false;

                if (!net.minecraftforge.common.ForgeHooks.onLivingDrops(this, cause, capturedDrops, i, recentlyHit > 0))
                {
                    for (EntityItem item : capturedDrops)
                    {
                        world.spawnEntity(item);
                    }
                }
            }

            this.world.setEntityState(this, (byte)3);
        }

	}
}