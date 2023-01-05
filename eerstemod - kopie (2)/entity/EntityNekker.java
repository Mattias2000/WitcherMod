package mattias.EersteMod.entity;

import mattias.EersteMod.util.handlers.LootTableHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityNekker extends EntityMonster {
	


	public EntityNekker(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 1.3F);
	}
	protected ResourceLocation getLootTable() {
		return LootTableHandler.NEKKER;
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
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}


}
