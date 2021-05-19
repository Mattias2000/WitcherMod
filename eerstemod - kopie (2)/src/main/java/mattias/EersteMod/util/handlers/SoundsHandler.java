package mattias.EersteMod.util.handlers;

import mattias.EersteMod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

	public static SoundEvent ENTITY_NEKKER_AMBIENT1, ENTITY_NEKKER_AMBIENT2,
	ENTITY_NEKKER_AMBIENT3, ENTITY_NEKKER_AMBIENT4, ENTITY_NEKKER_HURT1, ENTITY_NEKKER_HURT2,
	 ENTITY_NEKKER_HURT3, ENTITY_NEKKER_HURT4, ENTITY_NEKKER_DEATH, ENTITY_GHOUL_AMBIENT1, ENTITY_GHOUL_AMBIENT2,
		ENTITY_GHOUL_AMBIENT3, ENTITY_GHOUL_AMBIENT4, ENTITY_GHOUL_HURT1, ENTITY_GHOUL_HURT2,
		 ENTITY_GHOUL_HURT3, ENTITY_GHOUL_HURT4, ENTITY_GHOUL_DEATH, ENTITY_DROWNER_AMBIENT1, ENTITY_DROWNER_AMBIENT2,
			ENTITY_DROWNER_AMBIENT3, ENTITY_DROWNER_AMBIENT4, ENTITY_DROWNER_HURT1, ENTITY_DROWNER_HURT2,
			 ENTITY_DROWNER_HURT3, ENTITY_DROWNER_HURT4, ENTITY_DROWNER_DEATH, ENTITY_ARACHAS_AMBIENT1, ENTITY_ARACHAS_AMBIENT2,
				ENTITY_ARACHAS_AMBIENT3, ENTITY_ARACHAS_HURT1, ENTITY_ARACHAS_HURT2,
				 ENTITY_ARACHAS_HURT3, ENTITY_ARACHAS_HURT4, ENTITY_ARACHAS_HURT5, ENTITY_ARACHAS_DEATH, ENTITY_ARACHAS_SHOOT, ENTITY_ARACHAS_WARNING, 
				 ENTITY_FOGLET_AMBIENT1, ENTITY_FOGLET_AMBIENT2,
					ENTITY_FOGLET_AMBIENT3, ENTITY_FOGLET_AMBIENT4, ENTITY_FOGLET_HURT1, ENTITY_FOGLET_HURT2,
					 ENTITY_FOGLET_HURT3, ENTITY_FOGLET_HURT4, ENTITY_FOGLET_DEATH,
	 ENTITY_ROTFIEND_AMBIENT1, ENTITY_ROTFIEND_AMBIENT2,
		ENTITY_ROTFIEND_AMBIENT3, ENTITY_ROTFIEND_AMBIENT4, ENTITY_ROTFIEND_HURT1, ENTITY_ROTFIEND_HURT2,
		 ENTITY_ROTFIEND_HURT3, ENTITY_ROTFIEND_DEATH,
		 ENTITY_FLEDER_AMBIENT1, ENTITY_FLEDER_AMBIENT2,
			ENTITY_FLEDER_AMBIENT3, ENTITY_FLEDER_AMBIENT4, ENTITY_FLEDER_HURT1, ENTITY_FLEDER_HURT2,
			 ENTITY_FLEDER_HURT3, ENTITY_FLEDER_HURT4, ENTITY_FLEDER_DEATH;
	public static void registerSounds()
	{
		ENTITY_NEKKER_AMBIENT1 = registerSound("entity.nekker.ambient1");
		ENTITY_NEKKER_AMBIENT2 = registerSound("entity.nekker.ambient2");
		ENTITY_NEKKER_AMBIENT3 = registerSound("entity.nekker.ambient3");
		ENTITY_NEKKER_AMBIENT4 = registerSound("entity.nekker.ambient4");
		ENTITY_NEKKER_HURT1 = registerSound("entity.nekker.hurt1");
		ENTITY_NEKKER_HURT2 = registerSound("entity.nekker.hurt2");
		ENTITY_NEKKER_HURT3 = registerSound("entity.nekker.hurt3");
		ENTITY_NEKKER_HURT4 = registerSound("entity.nekker.hurt4");
		ENTITY_NEKKER_DEATH = registerSound("entity.nekker.death");
		ENTITY_GHOUL_AMBIENT1 = registerSound("entity.ghoul.ambient1");
		ENTITY_GHOUL_AMBIENT2 = registerSound("entity.ghoul.ambient2");
		ENTITY_GHOUL_AMBIENT3 = registerSound("entity.ghoul.ambient3");
		ENTITY_GHOUL_AMBIENT4 = registerSound("entity.ghoul.ambient4");
		ENTITY_GHOUL_HURT1 = registerSound("entity.ghoul.hurt1");
		ENTITY_GHOUL_HURT2 = registerSound("entity.ghoul.hurt2");
		ENTITY_GHOUL_HURT3 = registerSound("entity.ghoul.hurt3");
		ENTITY_GHOUL_HURT4 = registerSound("entity.ghoul.hurt4");
		ENTITY_GHOUL_DEATH = registerSound("entity.ghoul.death");
		ENTITY_DROWNER_AMBIENT1 = registerSound("entity.drowner.ambient1");
		ENTITY_DROWNER_AMBIENT2 = registerSound("entity.drowner.ambient2");
		ENTITY_DROWNER_AMBIENT3 = registerSound("entity.drowner.ambient3");
		ENTITY_DROWNER_AMBIENT4 = registerSound("entity.drowner.ambient4");
		ENTITY_DROWNER_HURT1 = registerSound("entity.drowner.hurt1");
		ENTITY_DROWNER_HURT2 = registerSound("entity.drowner.hurt2");
		ENTITY_DROWNER_HURT3 = registerSound("entity.drowner.hurt3");
		ENTITY_DROWNER_HURT4 = registerSound("entity.drowner.hurt4");
		ENTITY_DROWNER_DEATH = registerSound("entity.drowner.death");
		ENTITY_ARACHAS_AMBIENT1 = registerSound("entity.arachas.ambient1");
		ENTITY_ARACHAS_AMBIENT2 = registerSound("entity.arachas.ambient2");
		ENTITY_ARACHAS_AMBIENT3 = registerSound("entity.arachas.ambient3");
		ENTITY_ARACHAS_HURT1 = registerSound("entity.arachas.hurt1");
		ENTITY_ARACHAS_HURT2 = registerSound("entity.arachas.hurt2");
		ENTITY_ARACHAS_HURT3 = registerSound("entity.arachas.hurt3");
		ENTITY_ARACHAS_HURT4 = registerSound("entity.arachas.hurt4");
		ENTITY_ARACHAS_HURT5 = registerSound("entity.arachas.hurt5");
		ENTITY_ARACHAS_DEATH = registerSound("entity.arachas.death");
		ENTITY_ARACHAS_SHOOT =  registerSound("entity.arachas.shoot");
		ENTITY_ARACHAS_WARNING =  registerSound("entity.arachas.warning");
		ENTITY_FOGLET_AMBIENT1 = registerSound("entity.foglet.ambient1");
		ENTITY_FOGLET_AMBIENT2 = registerSound("entity.foglet.ambient2");
		ENTITY_FOGLET_AMBIENT3 = registerSound("entity.foglet.ambient3");
		ENTITY_FOGLET_AMBIENT4 = registerSound("entity.foglet.ambient4");
		ENTITY_FOGLET_HURT1 = registerSound("entity.foglet.hurt1");
		ENTITY_FOGLET_HURT2 = registerSound("entity.foglet.hurt2");
		ENTITY_FOGLET_HURT3 = registerSound("entity.foglet.hurt3");
		ENTITY_FOGLET_HURT4 = registerSound("entity.foglet.hurt4");
		ENTITY_FOGLET_DEATH = registerSound("entity.foglet.death");
		ENTITY_ROTFIEND_AMBIENT1 = registerSound("entity.rotfiend.ambient1");
		ENTITY_ROTFIEND_AMBIENT2 = registerSound("entity.rotfiend.ambient2");
		ENTITY_ROTFIEND_AMBIENT3 = registerSound("entity.rotfiend.ambient3");
		ENTITY_ROTFIEND_AMBIENT4 = registerSound("entity.rotfiend.ambient4");
		ENTITY_ROTFIEND_HURT1 = registerSound("entity.rotfiend.hurt1");
		ENTITY_ROTFIEND_HURT2 = registerSound("entity.rotfiend.hurt2");
		ENTITY_ROTFIEND_HURT3 = registerSound("entity.rotfiend.hurt3");
		ENTITY_ROTFIEND_DEATH = registerSound("entity.rotfiend.death");
		ENTITY_FLEDER_AMBIENT1 = registerSound("entity.fleder.ambient1");
		ENTITY_FLEDER_AMBIENT2 = registerSound("entity.fleder.ambient2");
		ENTITY_FLEDER_AMBIENT3 = registerSound("entity.fleder.ambient3");
		ENTITY_FLEDER_AMBIENT4 = registerSound("entity.fleder.ambient4");
		ENTITY_FLEDER_HURT1 = registerSound("entity.fleder.hurt1");
		ENTITY_FLEDER_HURT2 = registerSound("entity.fleder.hurt2");
		ENTITY_FLEDER_HURT3 = registerSound("entity.fleder.hurt3");
		ENTITY_FLEDER_HURT4 = registerSound("entity.fleder.hurt4");
		ENTITY_FLEDER_DEATH = registerSound("entity.fleder.death");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
