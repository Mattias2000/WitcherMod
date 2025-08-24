package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityArachas;
import mattias.EersteMod.entities.models.ModelArachas;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderArachas extends MobRenderer<EntityArachas, ModelArachas<EntityArachas>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/arachas.png");

    public RenderArachas(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelArachas<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(EntityArachas entity) {
        return TEXTURE;
    }
}