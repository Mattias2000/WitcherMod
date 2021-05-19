package mattias.EersteMod.signs.render;

import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityAxii;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAxii extends RenderSnowball<EntityAxii>{
	
	public static final Factory FACTORY = new Factory();
	
	
	public RenderAxii(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.AXII, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityAxii entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityAxii> {

		@Override
		public Render<? super EntityAxii> createRenderFor(RenderManager manager) {
			return new RenderAxii(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}
}