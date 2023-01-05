package mattias.EersteMod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSpider - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelArachas extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;
    public ModelRenderer leg7;
    public ModelRenderer leg8;
    public ModelRenderer jaw2;
    public ModelRenderer jaw2_1;
    public ModelRenderer jaw2_2;
    public ModelRenderer jaw2_3;
    public ModelRenderer shell;

    public ModelArachas() {
        float f = 0.0F;
        int i = 15;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.jaw2_1 = new ModelRenderer(this, 0, 23);
        this.shell = new ModelRenderer(this, 20, 8);
         this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
       this.jaw2_1.setRotationPoint(-0.8F, 14.2F, -1.7F);
        this.jaw2_1.addBox(-2.5F, -2.9F, -5.6F, 3, 3, 4, 0.0F);     
        this.shell.setRotationPoint(-5.4F, 5.1F, 3.5F);
        this.shell.addBox(0.0F, 0.0F, 0.0F, 11, 13, 11, 0.0F); 
        this.jaw2_3 = new ModelRenderer(this, 0, 23);
        this.jaw2_3.setRotationPoint(2.0F, 15.4F, -7.6F);
        this.jaw2_3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.jaw2 = new ModelRenderer(this, 0, 23);
        this.jaw2.setRotationPoint(0.4F, 13.8F, -1.4F);
        this.jaw2.addBox(0.0F, 0.0F, -5.8F, 3, 3, 4, 0.0F);  
        this.jaw2_2 = new ModelRenderer(this, 0, 23);
        this.jaw2_2.setRotationPoint(-4.6F, 16.4F, -7.2F);
        this.jaw2_2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
       
        this.leg1 = new ModelRenderer(this, 18, 0);
        this.leg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.leg2 = new ModelRenderer(this, 18, 0);
        this.leg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.leg3 = new ModelRenderer(this, 18, 0);
        this.leg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.leg4 = new ModelRenderer(this, 18, 0);
        this.leg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.leg5 = new ModelRenderer(this, 18, 0);
        this.leg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.leg6 = new ModelRenderer(this, 18, 0);
        this.leg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg6.setRotationPoint(4.0F, 15.0F, 0.0F);
        this.leg7 = new ModelRenderer(this, 18, 0);
        this.leg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
        this.leg8 = new ModelRenderer(this, 18, 0);
        this.leg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.leg8.setRotationPoint(4.0F, 15.0F, -1.0F);
        this.setRotateAngle(jaw2_1, -0.33405601883171465F, -0.017453292519943295F, -0.4288273972150068F);
        this.setRotateAngle(jaw2_3, 0.0F, -0.40893064374227134F, 0.26930430358272506F);
        this.setRotateAngle(jaw2, -0.1694714703686494F, -0.2892010570554604F, -0.967436004380457F);
        this.setRotateAngle(jaw2_2, 0.0F, 0.30909781052819574F, -0.389033890269536F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.leg5.render(f5);
        this.body.render(f5);
        this.leg7.render(f5);
        this.jaw2_1.render(f5);
        this.leg2.render(f5);
        this.leg4.render(f5);
        this.shell.render(f5);
        this.leg3.render(f5);
        this.jaw2_3.render(f5);
        this.jaw2.render(f5);
        this.leg1.render(f5);
        this.leg8.render(f5);
        this.jaw2_2.render(f5);
        this.leg6.render(f5);
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
        float f = ((float)Math.PI / 4F);
        this.leg1.rotateAngleZ = -((float)Math.PI / 4F);
        this.leg2.rotateAngleZ = ((float)Math.PI / 4F);
        this.leg3.rotateAngleZ = -0.58119464F;
        this.leg4.rotateAngleZ = 0.58119464F;
        this.leg5.rotateAngleZ = -0.58119464F;
        this.leg6.rotateAngleZ = 0.58119464F;
        this.leg7.rotateAngleZ = -((float)Math.PI / 4F);
        this.leg8.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        this.leg1.rotateAngleY = ((float)Math.PI / 4F);
        this.leg2.rotateAngleY = -((float)Math.PI / 4F);
        this.leg3.rotateAngleY = 0.3926991F;
        this.leg4.rotateAngleY = -0.3926991F;
        this.leg5.rotateAngleY = -0.3926991F;
        this.leg6.rotateAngleY = 0.3926991F;
        this.leg7.rotateAngleY = -((float)Math.PI / 4F);
        this.leg8.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.leg1.rotateAngleY += f3;
        this.leg2.rotateAngleY += -f3;
        this.leg3.rotateAngleY += f4;
        this.leg4.rotateAngleY += -f4;
        this.leg5.rotateAngleY += f5;
        this.leg6.rotateAngleY += -f5;
        this.leg7.rotateAngleY += f6;
        this.leg8.rotateAngleY += -f6;
        this.leg1.rotateAngleZ += f7;
        this.leg2.rotateAngleZ += -f7;
        this.leg3.rotateAngleZ += f8;
        this.leg4.rotateAngleZ += -f8;
        this.leg5.rotateAngleZ += f9;
        this.leg6.rotateAngleZ += -f9;
        this.leg7.rotateAngleZ += f10;
        this.leg8.rotateAngleZ += -f10;
    } 
}
