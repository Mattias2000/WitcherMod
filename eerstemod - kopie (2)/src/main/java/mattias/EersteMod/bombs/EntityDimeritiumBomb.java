package mattias.EersteMod.bombs;

import java.util.List;

import mattias.EersteMod.init.RegistryHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public class EntityDimeritiumBomb extends ThrowableEntity implements IRendersAsItem {

	public EntityDimeritiumBomb(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityDimeritiumBomb(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.DIMERITIUM_BOMB_ENTITY.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		if (!this.world.isRemote) {
			applyEffects();
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			applyEffects();
		}
	}

	private void applyEffects() {
		// Area scan around the impact point
		AxisAlignedBB area = this.getBoundingBox().grow(4.0D, 2.0D, 4.0D);
		List<LivingEntity> entities = this.world.getEntitiesWithinAABB(LivingEntity.class, area);

		if (!entities.isEmpty()) {
			for (LivingEntity target : entities) {
				double distanceSq = this.getDistanceSq(target);
				if (distanceSq < 16.0D) { // within 4 blocks
					 {
						target.clearActivePotions();
					}
				}
			}
		}

		this.remove(); // remove projectile after effect
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(RegistryHandler.DIMERITIUM_BOMB.get());
	}

	@Override
	protected void registerData() {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}