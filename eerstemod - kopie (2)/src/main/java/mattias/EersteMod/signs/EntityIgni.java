package mattias.EersteMod.signs;

import java.util.Random;

import mattias.EersteMod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityIgni extends EntityThrowable{

	public EntityIgni(World worldIn) {
		super(worldIn);
	}
	
	 public EntityIgni(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }
	 
	 @SideOnly(Side.CLIENT)   
	 public EntityIgni(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }
	
	   public static void registerFixesSign(DataFixer fixer)
	    {
	        EntityThrowable.registerFixesThrowable(fixer, "ThrownSign");
	    }

   
	    @SideOnly(Side.CLIENT)
	    public void handleStatusUpdate(byte id)
	    {
	        if (id == 3)
	        {
	            double d0 = 0.08D;

	            for (int i = 0; i < 8; ++i)
	            {
	                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ModItems.IGNI));
	            }
	        }
	    }
	
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote)
        {
	        if (result.entityHit != null)
	        {
	        	result.entityHit.setFire(10);
	        }
	        else
	        {
	        	BlockPos pos=result.getBlockPos();
	        	EnumFacing facing = result.sideHit;
	        	switch(facing)
	        	{
	        	case UP:
	        		if (this.world.getBlockState(pos.up()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.up(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	case DOWN:
	        		if (this.world.getBlockState(pos.down()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.down(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	case NORTH:
	        		if (this.world.getBlockState(pos.north()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.north(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	case SOUTH:
	        		if (this.world.getBlockState(pos.south()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.south(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	case WEST:
	        		if (this.world.getBlockState(pos.west()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.west(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	case EAST:
	        		if (this.world.getBlockState(pos.east()).getMaterial() == Material.AIR && this.world.getBlockState(pos).isFullBlock())
	                {
	                    this.world.setBlockState(pos.east(), Blocks.FIRE.getDefaultState());
	                }
	        		break;
	        	}

	        		
	        	
	        }
	        this.world.setEntityState(this, (byte)3);
			this.setDead();
        }
		
	}

    @Override
	public void onUpdate() {
		EntityLivingBase thrower = this.getThrower();
		
		if(thrower != null && thrower instanceof EntityPlayer && !thrower.isEntityAlive())
			this.setDead();
		else
			super.onUpdate();
	}
	
}