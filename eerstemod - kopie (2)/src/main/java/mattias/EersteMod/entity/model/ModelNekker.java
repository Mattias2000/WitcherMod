package mattias.EersteMod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelNekker extends ModelBase {
    public ModelRenderer RightArm;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftLeg;

    public ModelNekker() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.6F, 16.8F, -0.1F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 8.6F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 8.5F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(1.5F, 16.8F, 0.1F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LeftArm = new ModelRenderer(this, 40, 16);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(3.5F, 10.8F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LeftArm, 2.9595548126067843F, -2.9595548126067843F, 3.050486466635689F);
        this.RightArm = new ModelRenderer(this, 40, 16);
        this.RightArm.setRotationPoint(-3.5F, 10.8F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(RightArm, 2.9140017191297325F, 2.86844862565268F, -3.141592653589793F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.RightLeg.offsetX, this.RightLeg.offsetY, this.RightLeg.offsetZ);
        GlStateManager.translate(this.RightLeg.rotationPointX * f5, this.RightLeg.rotationPointY * f5, this.RightLeg.rotationPointZ * f5);
        GlStateManager.scale(0.6D, 0.6D, 0.6D);
        GlStateManager.translate(-this.RightLeg.offsetX, -this.RightLeg.offsetY, -this.RightLeg.offsetZ);
        GlStateManager.translate(-this.RightLeg.rotationPointX * f5, -this.RightLeg.rotationPointY * f5, -this.RightLeg.rotationPointZ * f5);
        this.RightLeg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
        GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 0.7D);
        GlStateManager.translate(-this.Head.offsetX, -this.Head.offsetY, -this.Head.offsetZ);
        GlStateManager.translate(-this.Head.rotationPointX * f5, -this.Head.rotationPointY * f5, -this.Head.rotationPointZ * f5);
        this.Head.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
        GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 0.7D);
        GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
        GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5, -this.Body.rotationPointZ * f5);
        this.Body.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.LeftLeg.offsetX, this.LeftLeg.offsetY, this.LeftLeg.offsetZ);
        GlStateManager.translate(this.LeftLeg.rotationPointX * f5, this.LeftLeg.rotationPointY * f5, this.LeftLeg.rotationPointZ * f5);
        GlStateManager.scale(0.6D, 0.6D, 0.6D);
        GlStateManager.translate(-this.LeftLeg.offsetX, -this.LeftLeg.offsetY, -this.LeftLeg.offsetZ);
        GlStateManager.translate(-this.LeftLeg.rotationPointX * f5, -this.LeftLeg.rotationPointY * f5, -this.LeftLeg.rotationPointZ * f5);
        this.LeftLeg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.LeftArm.offsetX, this.LeftArm.offsetY, this.LeftArm.offsetZ);
        GlStateManager.translate(this.LeftArm.rotationPointX * f5, this.LeftArm.rotationPointY * f5, this.LeftArm.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 0.8D, 0.5D);
        GlStateManager.translate(-this.LeftArm.offsetX, -this.LeftArm.offsetY, -this.LeftArm.offsetZ);
        GlStateManager.translate(-this.LeftArm.rotationPointX * f5, -this.LeftArm.rotationPointY * f5, -this.LeftArm.rotationPointZ * f5);
        this.LeftArm.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.RightArm.offsetX, this.RightArm.offsetY, this.RightArm.offsetZ);
        GlStateManager.translate(this.RightArm.rotationPointX * f5, this.RightArm.rotationPointY * f5, this.RightArm.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 0.8D, 0.5D);
        GlStateManager.translate(-this.RightArm.offsetX, -this.RightArm.offsetY, -this.RightArm.offsetZ);
        GlStateManager.translate(-this.RightArm.rotationPointX * f5, -this.RightArm.rotationPointY * f5, -this.RightArm.rotationPointZ * f5);
        this.RightArm.render(f5);
        GlStateManager.popMatrix();
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
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LeftArm.rotateAngleX = (float)Math.PI + (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI)) * 1.4F * limbSwingAmount;
    	this.RightArm.rotateAngleX = (float)Math.PI + (MathHelper.cos(limbSwing * 0.6662F)) * 1.4F * limbSwingAmount;
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    } 
}

