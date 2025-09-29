package mattias.EersteMod.entities.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mattias.EersteMod.entities.EntityFoglet;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelFoglet<f> extends EntityModel<EntityFoglet> {
	private final ModelRenderer field_178723_h;
	private final ModelRenderer field_178721_j;
	private final ModelRenderer field_78116_c;
	private final ModelRenderer field_78115_e;
	private final ModelRenderer field_178724_i;
	private final ModelRenderer field_178722_k;

	public ModelFoglet() {
		textureWidth = 64;
		textureHeight = 64;

		field_178723_h = new ModelRenderer(this);
		field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(field_178723_h, 0.0494F, -0.1F, 0.1F);
		field_178723_h.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		field_178721_j = new ModelRenderer(this);
		field_178721_j.setRotationPoint(-1.9F, 12.0F, 0.1F);
		field_178721_j.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		field_78116_c = new ModelRenderer(this);
		field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
		field_78116_c.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		field_78115_e = new ModelRenderer(this);
		field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
		field_78115_e.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		field_178724_i = new ModelRenderer(this);
		field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(field_178724_i, 0.0364F, 0.1F, -0.1258F);
		field_178724_i.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		field_178722_k = new ModelRenderer(this);
		field_178722_k.setRotationPoint(1.9F, 12.0F, 0.1F);
		field_178722_k.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(EntityFoglet entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.field_178722_k.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.field_178721_j.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.field_178724_i.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI)) * 1.4F * limbSwingAmount;
		this.field_178723_h.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F)) * 1.4F * limbSwingAmount;
		this.field_78116_c.rotateAngleY = netHeadYaw * 0.017453292F;
		this.field_78116_c.rotateAngleX = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		field_178723_h.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		field_178721_j.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		field_78116_c.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		field_78115_e.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		field_178724_i.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		field_178722_k.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}