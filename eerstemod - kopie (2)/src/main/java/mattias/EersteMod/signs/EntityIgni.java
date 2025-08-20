package mattias.EersteMod.signs;

import mattias.EersteMod.init.RegistryHandler;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;


public class EntityIgni extends ThrowableEntity implements IRendersAsItem {

	public EntityIgni(EntityType<? extends ThrowableEntity> entity, World worldIn) {
		super(entity, worldIn);
	}

	public EntityIgni(World worldIn, LivingEntity shooter) {
		super(RegistryHandler.IGNI_ENTITY.get(), shooter, worldIn);
		this.setMotion(shooter.getLookVec().scale(1.5));

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);

		if (!this.world.isRemote) {
			Entity entity = result.getEntity();
			if (entity instanceof LivingEntity) {
				// Light mob on fire for 10 seconds
				entity.setFire(10);
			}
			this.world.setEntityState(this, (byte) 3);
			this.remove(); // projectile consumed
		}
	}

	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; i++) {
				this.world.addParticle(
						new ItemParticleData(ParticleTypes.ITEM, new ItemStack(RegistryHandler.IGNI.get())),
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
		return new ItemStack(RegistryHandler.IGNI.get());
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
			//handle block collisions here
			if (result.getType() == RayTraceResult.Type.BLOCK) {
				BlockRayTraceResult blockResult = (BlockRayTraceResult) result;

				BlockPos pos = blockResult.getPos().offset(blockResult.getFace());

				// Place fire if the block is air and fire can exist there
				if (this.world.isAirBlock(pos)) {
					this.world.setBlockState(pos, Blocks.FIRE.getDefaultState());
				}
			}
			this.world.setEntityState(this, (byte) 3);
			this.remove(); // projectile consumed
		}
	}
}