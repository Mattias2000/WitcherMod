package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityNekker;
import mattias.EersteMod.entities.models.ModelNekker;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNekker extends MobRenderer<EntityNekker, ModelNekker<EntityNekker>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/nekker.png");

    public RenderNekker(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelNekker<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityNekker entity) {
        return TEXTURE;
    }
}