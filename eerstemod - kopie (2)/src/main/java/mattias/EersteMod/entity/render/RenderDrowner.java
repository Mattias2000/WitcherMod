package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.EntityDrowner;
import mattias.EersteMod.entity.model.ModelDrowner;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDrowner extends RenderLiving<EntityDrowner> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/drowner.png");

	public RenderDrowner(RenderManager manager) {
		super(manager, new ModelDrowner(), 0.5F);
	}
	

@Override
protected ResourceLocation getEntityTexture(EntityDrowner entity) {
	return TEXTURES;
}

@Override
protected void applyRotations(EntityDrowner entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
	super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
}
}
