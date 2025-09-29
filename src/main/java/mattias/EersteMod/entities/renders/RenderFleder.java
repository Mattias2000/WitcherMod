package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityFleder;
import mattias.EersteMod.entities.models.ModelFleder;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFleder extends MobRenderer<EntityFleder, ModelFleder<EntityFleder>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/fleder.png");

    public RenderFleder(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelFleder<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(EntityFleder entity) {
        return TEXTURE;
    }
}