package mattias.EersteMod.entity;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMonster extends EntityMob {
	


	public EntityMonster(World worldIn) {
		super(worldIn);
	}
	protected void entityInit()
    {
        super.entityInit();
    }
	public static void registerFixesMonster(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityMonster.class);
    }

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityMonster.AIMonsterAttack(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityMonster.AIMonsterTarget(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new EntityMonster.AIMonsterTarget(this, EntityIronGolem.class));
	}
	
	static class AIMonsterTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
    {
        public AIMonsterTarget(EntityMonster monster, Class<T> classTarget)
        {
            super(monster, classTarget, true);
        }
    }
	
	static class AIMonsterAttack extends EntityAIAttackMelee
    {
        public AIMonsterAttack(EntityMonster monster)
        {
            super(monster, 1.0D, true);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            float f = this.attacker.getBrightness();

            if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0)
            {
                this.attacker.setAttackTarget((EntityLivingBase)null);
                return false;
            }
            else
            {
                return super.shouldContinueExecuting();
            }
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(4.0F + attackTarget.width);
        }
    }
	
	
	
	
	

	protected void playStepSound(BlockPos pos, Block blockIn)
    {
        SoundType soundtype = blockIn.getSoundType(world.getBlockState(pos), world, pos, this);

        if (this.world.getBlockState(pos.up()).getBlock() == Blocks.SNOW_LAYER)
        {
            soundtype = Blocks.SNOW_LAYER.getSoundType();
            this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
        }
        else if (!blockIn.getDefaultState().getMaterial().isLiquid())
        {
            this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
        }
    }
	 


	 protected PathNavigate createNavigator(World worldIn)
	    {
	        return new PathNavigateGround(this, worldIn);
	    }
	

	


}
