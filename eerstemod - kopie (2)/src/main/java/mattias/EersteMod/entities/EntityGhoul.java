package mattias.EersteMod.entities;

import mattias.EersteMod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGhoul extends EntityLeapingMonster {

	public EntityGhoul(final EntityType<? extends EntityGhoul> type, final World worldIn) {
		super(type, worldIn);
	}

	protected SoundEvent getAmbientSound()
	{
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_GHOUL_AMBIENT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_GHOUL_AMBIENT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_GHOUL_AMBIENT3;
		}else
		{
			return SoundsHandler.ENTITY_GHOUL_AMBIENT4;
		}
	}
	
	protected SoundEvent getHurtSound(DamageSource source)
	{
		double chance = Math.random();
		if (chance < 0.25)
		{
		return SoundsHandler.ENTITY_GHOUL_HURT1;
		}
		else if (chance < 0.5)
		{
			return SoundsHandler.ENTITY_GHOUL_HURT2;
		}
		else if (chance < 0.75)
		{
			return SoundsHandler.ENTITY_GHOUL_HURT3;
		}else
		{
			return SoundsHandler.ENTITY_GHOUL_HURT4;
		}
	}

	protected SoundEvent getDeathSound()
	{
		return SoundsHandler.ENTITY_GHOUL_DEATH;
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.registerAttributes()
				.createMutableAttribute(Attributes.MAX_HEALTH, 20)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0F)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);
	}
}