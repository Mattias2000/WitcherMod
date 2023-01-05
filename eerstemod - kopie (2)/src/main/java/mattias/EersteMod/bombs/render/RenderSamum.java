package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntitySamum;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSamum extends RenderSnowball<EntitySamum> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderSamum(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.SAMUM, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntitySamum entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntitySamum> {

		@Override
		public Render<? super EntitySamum> createRenderFor(RenderManager manager) {
			return new RenderSamum(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}