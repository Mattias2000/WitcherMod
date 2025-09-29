package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFoglet extends EntityLeapingMonster {

	public EntityFoglet(final EntityType<? extends EntityFoglet> type, final World worldIn) {
		super(type, worldIn);
		this.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, Integer.MAX_VALUE, 0, false, true));
	}

	protected SoundEvent getAmbientSound()
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_FOGLET_AMBIENT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_FOGLET_AMBIENT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_FOGLET_AMBIENT3;
		}else
		{
			return SoundsHandler.ENTITY_FOGLET_AMBIENT4;
		}
	}

	protected SoundEvent getHurtSound(DamageSource source)
	{
		//todo: change sounds and chances
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_FOGLET_HURT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_FOGLET_HURT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_FOGLET_HURT3;
		}else
		{
			return SoundsHandler.ENTITY_FOGLET_HURT4;
		}
	}

	protected SoundEvent getDeathSound()
	{
		//todo: change sound
		return SoundsHandler.ENTITY_FOGLET_DEATH;
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 20)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);
	}
}