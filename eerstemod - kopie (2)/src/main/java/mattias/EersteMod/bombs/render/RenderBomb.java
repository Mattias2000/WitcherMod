package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntityBomb;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBomb extends RenderSnowball<EntityBomb> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderBomb(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.BOMB, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityBomb entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityBomb> {

		@Override
		public Render<? super EntityBomb> createRenderFor(RenderManager manager) {
			return new RenderBomb(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}