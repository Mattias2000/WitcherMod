package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Collection;

import static net.minecraftforge.common.ForgeHooks.*;

public class EntityRotfiend extends EntityLeapingMonster {

	public EntityRotfiend(final EntityType<? extends EntityRotfiend> type, final World worldIn) {
		super(type, worldIn);
	}

	protected SoundEvent getAmbientSound() {
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25) {
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT1;
		} else if (chance < 0.5) {
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT2;
		} else if (chance < 0.75) {
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT3;
		} else {
			return SoundsHandler.ENTITY_ROTFIEND_AMBIENT4;
		}
	}

	protected SoundEvent getHurtSound(DamageSource source) {
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.33) {
			return SoundsHandler.ENTITY_ROTFIEND_HURT1;
		} else if (chance < 0.66) {
			return SoundsHandler.ENTITY_ROTFIEND_HURT2;
		} else {
			return SoundsHandler.ENTITY_DROWNER_HURT3;
		}
	}

	protected SoundEvent getDeathSound() {
		//todo: change sound
		return SoundsHandler.ENTITY_ROTFIEND_DEATH;
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 19)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.3D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1D);
	}

	public void onDeath(DamageSource cause) {
		TNTEntity entityTNT = new TNTEntity(EntityType.TNT, this.world);
		TNTEntity entityTNT2 = new TNTEntity(EntityType.TNT, this.world);

		entityTNT.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
		entityTNT2.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
		this.world.addEntity(entityTNT);
		this.world.addEntity(entityTNT2);
		if (onLivingDeath(this, cause)) return;
		if (!this.dead) {
			Entity entity = cause.getTrueSource();
			LivingEntity entitylivingbase = this.getAttackingEntity();

			if (this.scoreValue >= 0 && entitylivingbase != null) {
				entitylivingbase.awardKillScore(this, this.scoreValue, cause);
			}

			if (entity != null) {
				entity.onKillEntity((ServerWorld) this.world, this);
			}

			this.dead = true;
			this.getCombatTracker().reset();

			if (!this.world.isRemote) {
				int i = getLootingLevel(this, entity, cause);

				Collection<ItemEntity> drops = this.captureDrops();

				if (this.canDropLoot() && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
					boolean flag = this.recentlyHit > 0;
					this.dropLoot(cause, flag);
				}

				if (!onLivingDrops(this, cause, drops, i, true)) {

					if (!onLivingDrops(this, cause, drops, i, true)) {
						for (ItemEntity item : drops) {
							this.world.addEntity(item);
						}
					}
				}
				this.world.setEntityState(this, (byte) 3);
			}
		}
	}
}