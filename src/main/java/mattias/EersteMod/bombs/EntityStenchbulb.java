package mattias.EersteMod.bombs;

import mattias.EersteMod.util.handlers.RegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class EntityStenchbulb extends ThrowableEntity implements IRendersAsItem {

	public EntityStenchbulb(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityStenchbulb(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.STENCH_BULB.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		if (!this.world.isRemote) {
			applyEffectsAndExplode(result.getEntity());
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			applyEffectsAndExplode(null);
		}
	}

	private void applyEffectsAndExplode(Entity hitEntity) {
		// Area scan around the impact point
		AxisAlignedBB area = this.getBoundingBox().grow(4.0D, 2.0D, 4.0D);
		List<LivingEntity> entities = this.world.getEntitiesWithinAABB(LivingEntity.class, area);

		if (!entities.isEmpty()) {
			for (LivingEntity target : entities) {
				double distanceSq = this.getDistanceSq(target);
				if (distanceSq < 16.0D) { // within 4 blocks
					double scale = 1.0D - Math.sqrt(distanceSq) / 4.0D;
					if (target == hitEntity) {
						scale = 1.0D; // direct hit = full effect
					}
					int duration = (int)(scale * 2400 + 0.5D); // max 2400 ticks = 2 minutes
					if (duration > 20) { // must last at least 1 sec
						target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, duration, 0, false, true));
					}
				}
			}
		}

		// Explosion with TNT smoke, no fire, block damage
		this.world.createExplosion(
				this,
				this.getPosX(), this.getPosY(), this.getPosZ(),
				1.5F,
				false,
				Explosion.Mode.DESTROY
		);

		this.remove(); // remove projectile after effect
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(RegistryHandler.STENCHBULB.get());
	}

	@Override
	protected void registerData() {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}