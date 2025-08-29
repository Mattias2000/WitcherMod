package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityRotfiend;
import mattias.EersteMod.entities.models.ModelRotfiend;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderRotfiend extends MobRenderer<EntityRotfiend, ModelRotfiend<EntityRotfiend>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/rotfiend.png");

    public RenderRotfiend(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelRotfiend<>(), 0.7F);
    }

@Override
    public ResourceLocation getEntityTexture(EntityRotfiend entity) {
        return TEXTURE;
    }
}