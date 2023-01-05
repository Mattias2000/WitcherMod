package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.model.ModelFoglet;
import mattias.EersteMod.entity.EntityFoglet;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFoglet extends RenderLiving<EntityFoglet> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/foglet.png");

	public RenderFoglet(RenderManager manager) {
		super(manager, new ModelFoglet(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityFoglet entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityFoglet entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
