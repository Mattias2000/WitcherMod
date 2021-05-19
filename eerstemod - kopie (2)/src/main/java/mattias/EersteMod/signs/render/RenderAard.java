package mattias.EersteMod.signs.render;

import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityAard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAard extends RenderSnowball<EntityAard>{
	
	public static final Factory FACTORY = new Factory();
	
	
	public RenderAard(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.AARD, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityAard entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityAard> {

		@Override
		public Render<? super EntityAard> createRenderFor(RenderManager manager) {
			return new RenderAard(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}
}