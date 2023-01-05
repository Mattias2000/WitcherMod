package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.EntityGhoul;
import mattias.EersteMod.entity.model.ModelGhoul;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGhoul extends RenderLiving<EntityGhoul>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ghoul.png");

	public RenderGhoul(RenderManager manager) {
		super(manager, new ModelGhoul(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityGhoul entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityGhoul entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
