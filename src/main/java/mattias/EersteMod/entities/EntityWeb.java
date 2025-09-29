package mattias.EersteMod.entities;

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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;


public class EntityWeb extends ThrowableEntity implements IRendersAsItem {

	public EntityWeb(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityWeb(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.WEB_ENTITY.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		if (!this.world.isRemote) {
			{
				if (result.hitInfo instanceof EntityArachas == false) {
					applyEffect(result.getEntity());
				}
			}
		}
	}

	private void applyEffect(Entity hitEntity) {
		LivingEntity target = (LivingEntity) hitEntity;
		target.addPotionEffect(new EffectInstance(Effects.POISON, 200, 0, false, true));
		this.world.setEntityState(this, (byte) 3);
		this.remove(); // remove projectile after effect
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(RegistryHandler.WEB.get());
	}

	@Override
	protected void registerData() {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; i++) {
				this.world.addParticle(
						new ItemParticleData(ParticleTypes.ITEM, new ItemStack(RegistryHandler.WEB.get())),
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
}