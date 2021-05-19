package mattias.EersteMod.util.handlers;

import mattias.EersteMod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	
	public static final ResourceLocation NEKKER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "nekker")); 
	public static final ResourceLocation GHOUL = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "ghoul")); 
	public static final ResourceLocation DROWNER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "drowner"));
	public static final ResourceLocation ARACHAS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "arachas"));
	public static final ResourceLocation FLEDER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "fleder"));
	public static final ResourceLocation ROTFIEND = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "rotfiend"));
	public static final ResourceLocation FOGLET = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "foglet"));

}
