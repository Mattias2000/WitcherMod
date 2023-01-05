package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.model.ModelRotfiend;
import mattias.EersteMod.entity.EntityRotfiend;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRotfiend extends RenderLiving<EntityRotfiend> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/rotfiend.png");

	public RenderRotfiend(RenderManager manager) {
		super(manager, new ModelRotfiend(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityRotfiend entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityRotfiend entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
