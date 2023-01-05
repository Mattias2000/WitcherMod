package mattias.EersteMod.util.handlers;

import mattias.EersteMod.bombs.EntityBomb;
import mattias.EersteMod.bombs.EntityDancingStar;
import mattias.EersteMod.bombs.EntityDevilsPuffball;
import mattias.EersteMod.bombs.EntityDimeritiumBomb;
import mattias.EersteMod.bombs.EntitySamum;
import mattias.EersteMod.bombs.EntityStenchbulb;
import mattias.EersteMod.bombs.render.RenderBomb;
import mattias.EersteMod.bombs.render.RenderDancingStar;
import mattias.EersteMod.bombs.render.RenderDevilsPuffball;
import mattias.EersteMod.bombs.render.RenderDimeritiumBomb;
import mattias.EersteMod.bombs.render.RenderSamum;
import mattias.EersteMod.bombs.render.RenderStenchbulb;
import mattias.EersteMod.entity.EntityArachas;
import mattias.EersteMod.entity.EntityDrowner;
import mattias.EersteMod.entity.EntityFleder;
import mattias.EersteMod.entity.EntityFledermaus;
import mattias.EersteMod.entity.EntityFoglet;
import mattias.EersteMod.entity.EntityGhoul;
import mattias.EersteMod.entity.EntityNekker;
import mattias.EersteMod.entity.EntityRotfiend;
import mattias.EersteMod.entity.EntityWeb;
import mattias.EersteMod.entity.render.RenderArachas;
import mattias.EersteMod.entity.render.RenderDrowner;
import mattias.EersteMod.entity.render.RenderFleder;
import mattias.EersteMod.entity.render.RenderFledermaus;
import mattias.EersteMod.entity.render.RenderFoglet;
import mattias.EersteMod.entity.render.RenderGhoul;
import mattias.EersteMod.entity.render.RenderNekker;
import mattias.EersteMod.entity.render.RenderRotfiend;
import mattias.EersteMod.entity.render.RenderWeb;
import mattias.EersteMod.signs.EntityAard;
import mattias.EersteMod.signs.EntityAxii;
import mattias.EersteMod.signs.EntityIgni;
import mattias.EersteMod.signs.EntityYrden;
import mattias.EersteMod.signs.render.RenderAard;
import mattias.EersteMod.signs.render.RenderAxii;
import mattias.EersteMod.signs.render.RenderIgni;
import mattias.EersteMod.signs.render.RenderYrden;
import mattias.EersteMod.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class RenderHandler {
	
	@SubscribeEvent
		public static void registerRenderers(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, RenderBomb.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityDancingStar.class, RenderDancingStar.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntitySamum.class, RenderSamum.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityDevilsPuffball.class, RenderDevilsPuffball.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityStenchbulb.class, RenderStenchbulb.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityDimeritiumBomb.class, RenderDimeritiumBomb.FACTORY);
			
			RenderingRegistry.registerEntityRenderingHandler(EntityAard.class, RenderAard.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityIgni.class, RenderIgni.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityYrden.class, RenderYrden.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityAxii.class, RenderAxii.FACTORY);
			RenderingRegistry.registerEntityRenderingHandler(EntityWeb.class, RenderWeb.FACTORY);
		}
	
	
	
	public static void registerEntityRenders()
	{

		
		
	
		
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNekker.class, new IRenderFactory<EntityNekker>()
	{

		@Override
		public Render<? super EntityNekker> createRenderFor(RenderManager manager) {
		
			return new RenderNekker(manager);
		}
			
	}
		);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new IRenderFactory<EntityGhoul>()
		{

			@Override
			public Render<? super EntityGhoul> createRenderFor(RenderManager manager) {
			
				return new RenderGhoul(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityDrowner.class, new IRenderFactory<EntityDrowner>()
		{

			@Override
			public Render<? super EntityDrowner> createRenderFor(RenderManager manager) {
			
				return new RenderDrowner(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityArachas.class, new IRenderFactory<EntityArachas>()
		{

			@Override
			public Render<? super EntityArachas> createRenderFor(RenderManager manager) {
			
				return new RenderArachas(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityFleder.class, new IRenderFactory<EntityFleder>()
		{

			@Override
			public Render<? super EntityFleder> createRenderFor(RenderManager manager) {
			
				return new RenderFleder(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityFoglet.class, new IRenderFactory<EntityFoglet>()
		{

			@Override
			public Render<? super EntityFoglet> createRenderFor(RenderManager manager) {
			
				return new RenderFoglet(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityRotfiend.class, new IRenderFactory<EntityRotfiend>()
		{

			@Override
			public Render<? super EntityRotfiend> createRenderFor(RenderManager manager) {
			
				return new RenderRotfiend(manager);
			}
				
		}
			);
		RenderingRegistry.registerEntityRenderingHandler(EntityFledermaus.class, new IRenderFactory<EntityFledermaus>()
		{

			@Override
			public Render<? super EntityFledermaus> createRenderFor(RenderManager manager) {
			
				return new RenderFledermaus(manager);
			}
				
		}
			);		
	}
}
