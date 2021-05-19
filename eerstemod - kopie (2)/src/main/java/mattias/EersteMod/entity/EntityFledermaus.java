package mattias.EersteMod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;


public class EntityFledermaus extends EntityBat {

    private static final DataParameter<Byte> HANGING = EntityDataManager.<Byte>createKey(EntityBat.class, DataSerializers.BYTE);
	public EntityFledermaus(World worldIn) {
		super(worldIn);
        this.setSize(0.5F, 0.9F);
        this.setIsBatHanging(true);
	}
	protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(HANGING, Byte.valueOf((byte)0));
    }
	public static void registerFixesMonster(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityMonster.class);
    }
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
        }
        EntityPlayer player=world.getClosestPlayerToEntity(this, 5.0);
        if(player!=null) {
        if (!this.world.isRemote && !this.isDead)
        {
            EntityFleder entitypigzombie = new EntityFleder(this.world);
            entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            entitypigzombie.setNoAI(this.isAIDisabled());

            if (this.hasCustomName())
            {
                entitypigzombie.setCustomNameTag(this.getCustomNameTag());
                entitypigzombie.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
            }

            this.world.spawnEntity(entitypigzombie);
            this.setDead();
        }}
    }
}