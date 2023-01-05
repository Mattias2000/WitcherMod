package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntityStenchbulb;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStenchbulb extends RenderSnowball<EntityStenchbulb> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderStenchbulb(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.STENCHBULB, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityStenchbulb entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityStenchbulb> {

		@Override
		public Render<? super EntityStenchbulb> createRenderFor(RenderManager manager) {
			return new RenderStenchbulb(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}