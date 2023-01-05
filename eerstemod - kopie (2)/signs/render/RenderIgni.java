package mattias.EersteMod.signs.render;

import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityIgni;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderIgni extends RenderSnowball<EntityIgni>{
	
	public static final Factory FACTORY = new Factory();
	
	
	public RenderIgni(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.IGNI, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityIgni entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityIgni> {

		@Override
		public Render<? super EntityIgni> createRenderFor(RenderManager manager) {
			return new RenderIgni(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}
}