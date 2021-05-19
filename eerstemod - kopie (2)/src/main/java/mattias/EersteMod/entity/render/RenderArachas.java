package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.model.ModelArachas;
import mattias.EersteMod.entity.EntityArachas;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArachas extends RenderLiving<EntityArachas> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/arachas.png");

	public RenderArachas(RenderManager manager) {
		super(manager, new ModelArachas(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityArachas entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityArachas entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
