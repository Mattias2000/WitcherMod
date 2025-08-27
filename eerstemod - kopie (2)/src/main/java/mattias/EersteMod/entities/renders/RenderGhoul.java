package mattias.EersteMod.entities.renders;

import mattias.EersteMod.Main;
import mattias.EersteMod.entities.EntityGhoul;
import mattias.EersteMod.entities.models.ModelGhoul;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderGhoul extends MobRenderer<EntityGhoul, ModelGhoul<EntityGhoul>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/ghoul.png");

    public RenderGhoul(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelGhoul<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(EntityGhoul entity) {
        return TEXTURE;
    }
}