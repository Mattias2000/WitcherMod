package mattias.EersteMod.signs.render;

import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityYrden;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderYrden extends RenderSnowball<EntityYrden>{
	
	public static final Factory FACTORY = new Factory();
	
	
	public RenderYrden(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.YRDEN, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityYrden entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityYrden> {

		@Override
		public Render<? super EntityYrden> createRenderFor(RenderManager manager) {
			return new RenderYrden(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}
}