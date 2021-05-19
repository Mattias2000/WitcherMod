package mattias.EersteMod.init;

import mattias.EersteMod.Main;
import mattias.EersteMod.bombs.EntityBomb;
import mattias.EersteMod.bombs.EntityDancingStar;
import mattias.EersteMod.bombs.EntityDevilsPuffball;
import mattias.EersteMod.bombs.EntityDimeritiumBomb;
import mattias.EersteMod.bombs.EntitySamum;
import mattias.EersteMod.bombs.EntityStenchbulb;
import mattias.EersteMod.entity.EntityArachas;
import mattias.EersteMod.entity.EntityDrowner;
import mattias.EersteMod.entity.EntityFleder;
import mattias.EersteMod.entity.EntityFledermaus;
import mattias.EersteMod.entity.EntityFoglet;
import mattias.EersteMod.entity.EntityGhoul;
import mattias.EersteMod.entity.EntityNekker;
import mattias.EersteMod.entity.EntityRotfiend;
import mattias.EersteMod.entity.EntityWeb;
import mattias.EersteMod.signs.EntityAard;
import mattias.EersteMod.signs.EntityAxii;
import mattias.EersteMod.signs.EntityIgni;
import mattias.EersteMod.signs.EntityYrden;
import mattias.EersteMod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	
	
	public static void registerEntities()
	{
		registerEntity("nekker", EntityNekker.class, Reference.ENTITY_NEKKER, 50, 11437146, 000000);
		registerEntity("ghoul", EntityGhoul.class, Reference.ENTITY_GHOUL, 50, 10193263, 8873793);
		registerEntity("drowner", EntityDrowner.class, Reference.ENTITY_DROWNER, 50, 9732779, 6936552);
		registerEntity("arachas", EntityArachas.class, Reference.ENTITY_ARACHAS, 50, 0xff99cc, 0x99ffcc);
		registerEntity("fleder", EntityFleder.class, Reference.ENTITY_FLEDER, 50, 7033908, 2169358);
		registerEntity("fledermaus", EntityFledermaus.class, Reference.ENTITY_FLEDERMAUS, 50, 2169358, 7033908);
		registerEntity("foglet", EntityFoglet.class, Reference.ENTITY_FOGLET, 50, 13685955, 14802881);
		registerEntity("rotfiend", EntityRotfiend.class, Reference.ENTITY_ROTFIEND, 50, 15101791, 13019229);
		
		EntityRegistry.addSpawn(EntityGhoul.class, 120, 3, 6, EnumCreatureType.MONSTER, Biomes.PLAINS);
		EntityRegistry.addSpawn(EntityDrowner.class, 120, 2, 5, EnumCreatureType.MONSTER, Biomes.SWAMPLAND);
		EntityRegistry.addSpawn(EntityNekker.class, 120, 4, 10, EnumCreatureType.MONSTER, Biomes.FOREST);
		EntityRegistry.addSpawn(EntityArachas.class, 120, 1, 3, EnumCreatureType.MONSTER, Biomes.DESERT);
		EntityRegistry.addSpawn(EntityFledermaus.class, 120, 1, 1, EnumCreatureType.AMBIENT);
		EntityRegistry.addSpawn(EntityRotfiend.class, 120, 1, 3, EnumCreatureType.MONSTER, Biomes.PLAINS);
		EntityRegistry.addSpawn(EntityFoglet.class, 120, 3, 4, EnumCreatureType.MONSTER, Biomes.SWAMPLAND);
		
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_bomb"), EntityBomb.class, "Entity_Bomb", -1, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_dancing_star"), EntityDancingStar.class, "Entity_Dancing_Star", -3, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_samum"), EntitySamum.class, "Entity_Samum", -4, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_devils_puffball"), EntityDevilsPuffball.class, "Entity_Devils_Puffball", -5, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_stenchbulb"), EntityStenchbulb.class, "Entity_Stenchbulb", -6, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_dimeritium_bomb"), EntityDimeritiumBomb.class, "Entity_Dimeritium_Bomb", -7, Main.instance, 64, 1, true);
		
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_aard"), EntityAard.class, "Entity_Aard", -2, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_igni"), EntityIgni.class, "Entity_Igni", -8, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_yrden"), EntityYrden.class, "Entity_Yrden", -11, Main.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_axii"), EntityAxii.class, "Entity_Axii", -12, Main.instance, 64, 1, true);
		
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":entity_web"), EntityWeb.class, "Entity_Web", -13, Main.instance, 64, 1, true);
	}
	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 3, true, color1, color2);
	}
}