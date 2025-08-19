package mattias.EersteMod.bombs;

import mattias.EersteMod.init.RegistryHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public class EntityBomb extends ThrowableEntity implements IRendersAsItem {

	public EntityBomb(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityBomb(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.BOMB_ENTITY.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		if (!this.world.isRemote) {
			applyEffectsAndExplode();
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			applyEffectsAndExplode();
		}
	}

	private void applyEffectsAndExplode() {

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
		return new ItemStack(RegistryHandler.BOMB.get());
	}

	@Override
	protected void registerData() {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}