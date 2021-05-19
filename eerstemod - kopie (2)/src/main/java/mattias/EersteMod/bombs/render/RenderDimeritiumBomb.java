package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntityDimeritiumBomb;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDimeritiumBomb extends RenderSnowball<EntityDimeritiumBomb> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderDimeritiumBomb(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.DIMERITIUM_BOMB, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityDimeritiumBomb entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityDimeritiumBomb> {

		@Override
		public Render<? super EntityDimeritiumBomb> createRenderFor(RenderManager manager) {
			return new RenderDimeritiumBomb(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}