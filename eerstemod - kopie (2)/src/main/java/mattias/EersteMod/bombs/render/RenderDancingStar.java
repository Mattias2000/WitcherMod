package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntityDancingStar;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDancingStar extends RenderSnowball<EntityDancingStar> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderDancingStar(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.DANCING_STAR, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityDancingStar entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityDancingStar> {

		@Override
		public Render<? super EntityDancingStar> createRenderFor(RenderManager manager) {
			return new RenderDancingStar(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}