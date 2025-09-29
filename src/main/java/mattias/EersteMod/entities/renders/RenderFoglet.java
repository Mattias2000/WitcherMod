package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityFoglet;
import mattias.EersteMod.entities.models.ModelFoglet;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFoglet extends MobRenderer<EntityFoglet, ModelFoglet<EntityFoglet>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/foglet.png");

    public RenderFoglet(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelFoglet<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(EntityFoglet entity) {
        return TEXTURE;
    }
}