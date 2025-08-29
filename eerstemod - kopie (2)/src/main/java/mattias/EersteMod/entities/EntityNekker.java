package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityNekker extends EntityLeapingMonster {

	public EntityNekker(final EntityType<? extends EntityNekker> type, final World worldIn) {
		super(type, worldIn);
	}

	protected SoundEvent getAmbientSound()
	{
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_NEKKER_AMBIENT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_NEKKER_AMBIENT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_NEKKER_AMBIENT3;
		}else
		{
			return SoundsHandler.ENTITY_NEKKER_AMBIENT4;
		}
	}

	protected SoundEvent getHurtSound(DamageSource source)
	{
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_NEKKER_HURT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_NEKKER_HURT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_NEKKER_HURT3;
		}else
		{
			return SoundsHandler.ENTITY_NEKKER_HURT4;
		}
	}

	protected SoundEvent getDeathSound()
	{
		return SoundsHandler.ENTITY_NEKKER_DEATH;
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 16)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1D);
	}
}