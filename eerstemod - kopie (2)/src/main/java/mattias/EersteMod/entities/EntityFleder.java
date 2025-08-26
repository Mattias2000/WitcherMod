package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFleder extends MonsterEntity {
	public EntityFleder(final EntityType<? extends EntityFleder> type, final World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this,0.8));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.8, true));
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

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 16)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.5D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);

	}
}