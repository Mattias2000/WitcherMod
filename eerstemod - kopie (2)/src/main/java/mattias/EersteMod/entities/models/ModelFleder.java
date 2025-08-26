package mattias.EersteMod.entities.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mattias.EersteMod.entities.EntityFleder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelFleder<f> extends EntityModel<EntityFleder> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer innerleftwing;
	private final ModelRenderer outerleftwing;
	private final ModelRenderer innerrightwing;
	private final ModelRenderer outterrightwing;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer rightear;
	private final ModelRenderer leftear;

	public ModelFleder() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, -11.0F, -0.3F);
		setRotationAngle(head, 0.0F, -0.0349F, 3.1416F);
		head.setTextureOffset(0, 0).addBox(-5.3F, -0.1F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(2.5F, 12.1F, 0.0F);
		setRotationAngle(body, 3.1416F, -3.2289F, 0.0F);
		body.setTextureOffset(0, 30).addBox(-3.0F, 4.0F, -3.0F, 9.0F, 19.0F, 6.0F, 0.0F, false);

		innerleftwing = new ModelRenderer(this);
		innerleftwing.setRotationPoint(-2.0F, 4.2F, 3.0F);
		body.addChild(innerleftwing);
		setRotationAngle(innerleftwing, -0.1571F, -0.4538F, 0.0F);
		innerleftwing.setTextureOffset(42, 0).addBox(-12.0F, 1.0F, 1.5F, 10.0F, 18.0F, 1.0F, 0.0F, false);

		outerleftwing = new ModelRenderer(this);
		outerleftwing.setRotationPoint(-12.0F, 1.0F, 1.5F);
		innerleftwing.addChild(outerleftwing);
		setRotationAngle(outerleftwing, 0.0F, -0.596F, 0.0F);
		outerleftwing.setTextureOffset(40, 45).addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);

		innerrightwing = new ModelRenderer(this);
		innerrightwing.setRotationPoint(4.3F, 4.0F, 3.0F);
		body.addChild(innerrightwing);
		setRotationAngle(innerrightwing, -0.1571F, 0.0175F, 0.0F);
		innerrightwing.setTextureOffset(42, 0).addBox(2.0F, 1.0F, 1.5F, 10.0F, 18.0F, 1.0F, 0.0F, true);

		outterrightwing = new ModelRenderer(this);
		outterrightwing.setRotationPoint(9.5F, -11.1F, 1.5F);
		innerrightwing.addChild(outterrightwing);
		setRotationAngle(outterrightwing, 0.0F, 0.99F, 0.0F);
		outterrightwing.setTextureOffset(40, 45).addBox(0.0F, 13.3F, 2.0F, 9.0F, 12.0F, 1.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(1.2F, 7.8F, 1.9F);
		setRotationAngle(leftleg, 0.0F, 3.1175F, 0.0F);
		leftleg.setTextureOffset(41, 20).addBox(0.0F, 0.0F, 0.0F, 5.0F, 16.0F, 5.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.9F, 8.1F, 0.4F);
		rightleg.setTextureOffset(41, 20).addBox(0.3F, -0.3F, -2.9F, 5.0F, 16.0F, 5.0F, 0.0F, false);

		rightear = new ModelRenderer(this);
		rightear.setRotationPoint(1.0F, -11.0F, -0.3F);
		rightear.setTextureOffset(24, 49).addBox(3.1F, -13.8F, -4.9F, 2.0F, 4.0F, 10.0F, 0.0F, false);

		leftear = new ModelRenderer(this);
		leftear.setRotationPoint(1.0F, -11.0F, -0.3F);
		leftear.setTextureOffset(24, 49).addBox(-4.8F, -13.7F, -4.9F, 2.0F, 4.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityFleder entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * -0.017453292F;
		this.leftear.rotateAngleY = netHeadYaw * -0.017453292F;
		this.leftear.rotateAngleX = headPitch * 0.017453292F;
		this.rightear.rotateAngleY = netHeadYaw * -0.017453292F;
		this.rightear.rotateAngleX = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}