package mattias.EersteMod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPig - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelGhoul extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer left_leg;
    public ModelRenderer left_arm;
    public ModelRenderer right_leg;
    public ModelRenderer right_arm;
    public ModelRenderer head;

    public ModelGhoul() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.right_leg = new ModelRenderer(this, 0, 16);
        this.right_leg.setRotationPoint(-3.6F, 14.9F, 7.0F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 3, 0.0F);
        this.left_leg = new ModelRenderer(this, 0, 16);
        this.left_leg.setRotationPoint(3.4F, 14.9F, 7.0F);
        this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 3, 0.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.setRotationPoint(-0.6F, 7.9F, 2.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 6, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.left_arm = new ModelRenderer(this, 0, 16);
        this.left_arm.setRotationPoint(3.4F, 14.9F, -6.0F);
        this.left_arm.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 3, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 10.0F, -5.6F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 7, 7, 7, 0.0F);
        this.right_arm = new ModelRenderer(this, 0, 16);
        this.right_arm.setRotationPoint(-3.6F, 14.9F, -6.0F);
        this.right_arm.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.right_leg.render(f5);
        this.left_leg.render(f5);
        this.body.render(f5);
        this.left_arm.render(f5);
        this.head.render(f5);
        this.right_arm.render(f5);
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
