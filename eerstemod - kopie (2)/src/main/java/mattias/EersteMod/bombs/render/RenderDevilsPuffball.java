package mattias.EersteMod.bombs.render;

import mattias.EersteMod.bombs.EntityDevilsPuffball;
import mattias.EersteMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDevilsPuffball extends RenderSnowball<EntityDevilsPuffball> {

	public static final Factory FACTORY = new Factory();
	
	
	public RenderDevilsPuffball(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, ModItems.DEVILS_PUFFBALL, itemRendererIn);
	}


	@Override
	public ItemStack getStackToRender(EntityDevilsPuffball entity) {
		return new ItemStack(this.item);
	}

	public static class Factory implements IRenderFactory<EntityDevilsPuffball> {

		@Override
		public Render<? super EntityDevilsPuffball> createRenderFor(RenderManager manager) {
			return new RenderDevilsPuffball(manager, Minecraft.getMinecraft().getRenderItem());
		}

	}

}