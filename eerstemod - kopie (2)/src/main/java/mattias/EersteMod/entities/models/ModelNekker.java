package mattias.EersteMod.entities.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mattias.EersteMod.entities.EntityNekker;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelNekker<n> extends EntityModel<EntityNekker> {
	private final ModelRenderer RightArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftLeg;

	public ModelNekker() {
		textureWidth = 64;
		textureHeight = 64;

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-3.5F, 10.8F, 0.0F);
		setRotationAngle(RightArm, 2.914F, 2.8684F, -3.1416F);
		RightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.6F, 16.8F, -0.1F);
		RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 8.6F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 8.5F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(3.5F, 10.8F, 0.0F);
		setRotationAngle(LeftArm, 2.9596F, -2.9596F, 3.0505F);
		LeftArm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.5F, 16.8F, 0.1F);
		LeftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
	}


	@Override
	public void setRotationAngles(EntityNekker entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LeftArm.rotateAngleX = (float)Math.PI + (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI)) * 1.4F * limbSwingAmount;
		this.RightArm.rotateAngleX = (float)Math.PI + (MathHelper.cos(limbSwing * 0.6662F)) * 1.4F * limbSwingAmount;
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Head.rotateAngleX = headPitch * 0.017453292F;	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

			// Right Leg
			matrixStack.push();
			matrixStack.translate(this.RightLeg.rotationPointX / 16.0F, this.RightLeg.rotationPointY / 16.0F, this.RightLeg.rotationPointZ / 16.0F);
			matrixStack.scale(0.6F, 0.6F, 0.6F);
			matrixStack.translate(-this.RightLeg.rotationPointX / 16.0F, -this.RightLeg.rotationPointY / 16.0F, -this.RightLeg.rotationPointZ / 16.0F);
			this.RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();

			// Head
			matrixStack.push();
			matrixStack.translate(this.Head.rotationPointX / 16.0F, this.Head.rotationPointY / 16.0F, this.Head.rotationPointZ / 16.0F);
			matrixStack.scale(0.7F, 0.7F, 0.7F);
			matrixStack.translate(-this.Head.rotationPointX / 16.0F, -this.Head.rotationPointY / 16.0F, -this.Head.rotationPointZ / 16.0F);
			this.Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();

			// Body
			matrixStack.push();
			matrixStack.translate(this.Body.rotationPointX / 16.0F, this.Body.rotationPointY / 16.0F, this.Body.rotationPointZ / 16.0F);
			matrixStack.scale(0.7F, 0.7F, 0.7F);
			matrixStack.translate(-this.Body.rotationPointX / 16.0F, -this.Body.rotationPointY / 16.0F, -this.Body.rotationPointZ / 16.0F);
			this.Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();

			// Left Leg
			matrixStack.push();
			matrixStack.translate(this.LeftLeg.rotationPointX / 16.0F, this.LeftLeg.rotationPointY / 16.0F, this.LeftLeg.rotationPointZ / 16.0F);
			matrixStack.scale(0.6F, 0.6F, 0.6F);
			matrixStack.translate(-this.LeftLeg.rotationPointX / 16.0F, -this.LeftLeg.rotationPointY / 16.0F, -this.LeftLeg.rotationPointZ / 16.0F);
			this.LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();

			// Left Arm
			matrixStack.push();
			matrixStack.translate(this.LeftArm.rotationPointX / 16.0F, this.LeftArm.rotationPointY / 16.0F, this.LeftArm.rotationPointZ / 16.0F);
			matrixStack.scale(0.5F, 0.8F, 0.5F);
			matrixStack.translate(-this.LeftArm.rotationPointX / 16.0F, -this.LeftArm.rotationPointY / 16.0F, -this.LeftArm.rotationPointZ / 16.0F);
			this.LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();

			// Right Arm
			matrixStack.push();
			matrixStack.translate(this.RightArm.rotationPointX / 16.0F, this.RightArm.rotationPointY / 16.0F, this.RightArm.rotationPointZ / 16.0F);
			matrixStack.scale(0.5F, 0.8F, 0.5F);
			matrixStack.translate(-this.RightArm.rotationPointX / 16.0F, -this.RightArm.rotationPointY / 16.0F, -this.RightArm.rotationPointZ / 16.0F);
			this.RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			matrixStack.pop();
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}