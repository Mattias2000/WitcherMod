package mattias.EersteMod.entity.render;

import mattias.EersteMod.entity.EntityWeb;
import mattias.EersteMod.init.ModItems;
import mattias.EersteMod.signs.EntityAard;
import mattias.EersteMod.signs.render.RenderAard;
import mattias.EersteMod.signs.render.RenderAard.Factory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWeb extends RenderSnowball<EntityWeb>{
	
	public static final Factory FACTORY = new Factory();
	
	
	public RenderWeb(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.WEB, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityWeb entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityWeb> {

		@Override
		public Render<? super EntityWeb> createRenderFor(RenderManager manager) {
			return new RenderWeb(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}
}