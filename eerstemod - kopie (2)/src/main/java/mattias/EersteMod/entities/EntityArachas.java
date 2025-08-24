package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityArachas extends MonsterEntity implements IRangedAttackMob{
	
	int timer=2;
	public EntityArachas(final EntityType<? extends EntityArachas> type, final World worldIn) {
		super(type, worldIn);
	}

	void PoisonAttack(LivingEntity target, float distanceFactor) {
		EntityWeb entityWeb = new EntityWeb(this.world, this);

		// Spawn at the shooter's eye height
		double startX = this.getPosX();
		double startY = this.getPosYEye() - 0.1D; // eye level, slightly adjusted
		double startZ = this.getPosZ();
		entityWeb.setPosition(startX, startY, startZ);

		// Aim towards target
		double d0 = target.getPosY() + (double)target.getEyeHeight() - 1.1D;
		double d1 = target.getPosX() - this.getPosX();
		double d2 = d0 - entityWeb.getPosY();
		double d3 = target.getPosZ() - this.getPosZ();
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;

		entityWeb.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);

		this.playSound(SoundsHandler.ENTITY_ARACHAS_SHOOT, 1.0F,
				1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));

		this.world.addEntity(entityWeb);
	}


	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		timer--;
		if (timer == 1) {
			this.playSound(SoundsHandler.ENTITY_ARACHAS_WARNING, 1.0F,
					1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		}
		if (timer == 0) {
			timer = 5;
			PoisonAttack(target, distanceFactor);
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this,0.8));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
		this.goalSelector.addGoal(3, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
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

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 18)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
	}
}