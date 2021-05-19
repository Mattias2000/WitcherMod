package mattias.EersteMod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelDrowner extends ModelBase {
    public ModelRenderer right_arm;
    public ModelRenderer right_leg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer left_arm;
    public ModelRenderer left_leg;

    public ModelDrowner() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.7F, 0.3F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 7, 7, 7, 0.0F);
        this.right_arm = new ModelRenderer(this, 40, 16);
        this.right_arm.setRotationPoint(-4.5F, 1.5F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(right_arm, -0.05462880558742251F, -0.10000736613927509F, 0.16824973989225336F);
        this.right_leg = new ModelRenderer(this, 0, 16);
        this.right_leg.setRotationPoint(-1.9F, 9.9F, 0.1F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 3, 0.0F);
        this.left_arm = new ModelRenderer(this, 40, 16);
        this.left_arm.mirror = true;
        this.left_arm.setRotationPoint(5.2F, 1.2F, 0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(left_arm, -0.0317649923862968F, 0.10000736613927509F, -0.12269664641520138F);
        this.left_leg = new ModelRenderer(this, 0, 16);
        this.left_leg.mirror = true;
        this.left_leg.setRotationPoint(1.9F, 9.9F, 0.1F);
        this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 3, 0.0F);
        this.setRotateAngle(left_leg, -0.0F, 0.0F, -0.022689280275926284F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
        this.right_arm.render(f5);
        this.right_leg.render(f5);
        this.left_arm.render(f5);
        this.left_leg.render(f5);
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.left_arm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI)) * 1.4F * limbSwingAmount;
    	this.right_arm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F)) * 1.4F * limbSwingAmount;
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    } 
}
