package mattias.EersteMod.entity;

import javax.annotation.Nullable;

import mattias.EersteMod.util.handlers.LootTableHandler;
import mattias.EersteMod.util.handlers.SoundsHandler;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFoglet extends EntityMonster{

	public EntityFoglet(World worldIn)
	{
		super(worldIn);
		this.setSize(0.6F, 1.95F);
		this.addPotionEffect(new PotionEffect(new PotionEffect(MobEffects.INVISIBILITY, Integer.MAX_VALUE, 0, false, true)));
	}
	protected ResourceLocation getLootTable() {
		//todo: return real loottable
		return LootTableHandler.FOGLET;
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
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}
	
	


}
