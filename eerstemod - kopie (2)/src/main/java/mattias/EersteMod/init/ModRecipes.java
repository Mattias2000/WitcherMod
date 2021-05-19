package mattias.EersteMod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.SILVER_ORE_BLOCK, new ItemStack(ModItems.SILVER_INGOT, 1), 1.0F);
	}

}
