package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.model.ModelFleder;
import mattias.EersteMod.entity.EntityFleder;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFleder extends RenderLiving<EntityFleder> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/fleder.png");

	public RenderFleder(RenderManager manager) {
		super(manager, new ModelFleder(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityFleder entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityFleder entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
