package mattias.EersteMod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBat - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelFleder extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;
    public ModelRenderer rightear;
    public ModelRenderer leftear;
    public ModelRenderer innerleftwing;
    public ModelRenderer innerrightwing;
    public ModelRenderer outerleftwing;
    public ModelRenderer outterrightwing;

    public ModelFleder() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.innerleftwing = new ModelRenderer(this, 42, 0);
        this.innerleftwing.setRotationPoint(-2.0F, 4.2F, 3.0F);
        this.innerleftwing.addBox(-12.0F, 1.0F, 1.5F, 10, 18, 1, 0.0F);
        this.setRotateAngle(innerleftwing, -0.15707963267948966F, -0.45378560551852565F, 0.0F);
        this.rightleg = new ModelRenderer(this, 41, 20);
        this.rightleg.setRotationPoint(0.9F, 8.1F, 0.4F);
        this.rightleg.addBox(0.3F, -0.3F, -2.9F, 5, 16, 5, 0.0F);
        this.rightear = new ModelRenderer(this, 24, 49);
        this.rightear.setRotationPoint(1.0F, -11.0F, -0.3F);
        this.rightear.addBox(3.1F, -13.8F, -4.9F, 2, 4, 10, 0.0F);
        this.outerleftwing = new ModelRenderer(this, 40, 45);
        this.outerleftwing.setRotationPoint(-12.0F, 1.0F, 1.5F);
        this.outerleftwing.addBox(-8.0F, 1.0F, 0.0F, 8, 12, 1, 0.0F);
        this.setRotateAngle(outerleftwing, 0.0F, -0.5960299395560635F, 0.0F);
        this.leftear = new ModelRenderer(this, 24, 49);
        this.leftear.setRotationPoint(1.0F, -11.0F, -0.3F);
        this.leftear.addBox(-4.8F, -13.7F, -4.9F, 2, 4, 10, 0.0F);
        this.outterrightwing = new ModelRenderer(this, 40, 45);
        this.outterrightwing.mirror = true;
        this.outterrightwing.setRotationPoint(12.0F, 1.0F, 1.5F);
        this.outterrightwing.addBox(0.0F, 1.0F, 0.0F, 9, 12, 1, 0.0F);
        this.setRotateAngle(outterrightwing, 0.0F, 0.9899507517311837F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, -11.0F, -0.3F);
        this.head.addBox(-5.3F, -0.1F, -5.0F, 10, 10, 10, 0.0F);
        this.setRotateAngle(head, 0.0F, -0.03490658503988659F, 3.141592653589793F);
        this.body = new ModelRenderer(this, 0, 30);
        this.body.setRotationPoint(2.5F, 12.1F, 0.0F);
        this.body.addBox(-3.0F, 4.0F, -3.0F, 9, 19, 6, 0.0F);
        this.setRotateAngle(body, 3.141592653589793F, -3.2288591161895095F, 0.0F);
        this.innerrightwing = new ModelRenderer(this, 42, 0);
        this.innerrightwing.mirror = true;
        this.innerrightwing.setRotationPoint(4.3F, 4.0F, 3.0F);
        this.innerrightwing.addBox(2.0F, 1.0F, 1.5F, 10, 18, 1, 0.0F);
        this.setRotateAngle(innerrightwing, -0.15707963267948966F, 0.017453292519943295F, 0.0F);
        this.leftleg = new ModelRenderer(this, 41, 20);
        this.leftleg.setRotationPoint(1.2F, 7.8F, 1.9F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 5, 16, 5, 0.0F);
        this.setRotateAngle(leftleg, 0.0F, 3.1175071099122715F, 0.0F);
        this.body.addChild(this.innerleftwing);
        this.innerleftwing.addChild(this.outerleftwing);
        this.innerrightwing.addChild(this.outterrightwing);
        this.body.addChild(this.innerrightwing);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rightleg.render(f5);
        this.rightear.render(f5);
        this.leftear.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.leftleg.render(f5);
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
    	this.leftleg.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * -0.017453292F;
    	this.leftear.rotateAngleY = netHeadYaw * -0.017453292F;
    	this.leftear.rotateAngleX = headPitch * 0.017453292F;
    	this.rightear.rotateAngleY = netHeadYaw * -0.017453292F;
    	this.rightear.rotateAngleX = headPitch * 0.017453292F;
    } 
}
