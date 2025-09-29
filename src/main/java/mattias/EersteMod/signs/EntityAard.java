package mattias.EersteMod.signs;

import mattias.EersteMod.util.handlers.RegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public class EntityAard extends ThrowableEntity implements IRendersAsItem {

	public EntityAard(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityAard(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.AARD_ENTITY.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);

		if (!this.world.isRemote) {
			Entity entity = result.getEntity();
			if (entity instanceof LivingEntity) {
				LivingEntity target = (LivingEntity) entity;

				// Calculate direction (from projectile to target)
				double dx = target.getPosX() - this.getPosX();
				double dz = target.getPosZ() - this.getPosZ();
				double dist = MathHelper.sqrt(dx * dx + dz * dz);

				if (dist >= 0.0001D) {
					dx /= dist;
					dz /= dist;

					float strength = 1.2F;

					// Apply knockback directly to the hit target
					target.setMotion(
							target.getMotion().x * 0.5D + dx * strength,
							target.getMotion().y * 0.5D + 0.4D,
							target.getMotion().z * 0.5D + dz * strength
					);

					// Cap upward motion
					if (target.getMotion().y > 0.4D) {
						target.setMotion(target.getMotion().x, 0.4D, target.getMotion().z);
					}

					target.isAirBorne = true;
				}
			}
			this.world.setEntityState(this, (byte) 3);
			this.remove(); // remove projectile after hitting
		}
	}

	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; i++) {
				this.world.addParticle(
						new ItemParticleData(ParticleTypes.ITEM, new ItemStack(RegistryHandler.AARD.get())),
						this.getPosX(),
						this.getPosY(),
						this.getPosZ(),
						(this.rand.nextDouble() - 0.5D) * 0.08D,
						(this.rand.nextDouble() - 0.5D) * 0.08D,
						(this.rand.nextDouble() - 0.5D) * 0.08D
				);
			}
		}
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(RegistryHandler.AARD.get());
	}

	@Override
	protected void registerData() {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
		}
	}
}