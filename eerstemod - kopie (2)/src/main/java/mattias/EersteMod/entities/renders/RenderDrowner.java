package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityDrowner;
import mattias.EersteMod.entities.models.ModelDrowner;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDrowner extends MobRenderer<EntityDrowner, ModelDrowner<EntityDrowner>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/drowner.png");

    public RenderDrowner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDrowner<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(EntityDrowner entity) {
        return TEXTURE;
    }
}