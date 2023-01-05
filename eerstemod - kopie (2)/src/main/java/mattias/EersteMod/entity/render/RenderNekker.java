package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.EntityNekker;
import mattias.EersteMod.entity.model.ModelNekker;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNekker extends RenderLiving<EntityNekker> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/nekker.png");

	public RenderNekker(RenderManager manager) {
		super(manager, new ModelNekker(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityNekker entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityNekker entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
