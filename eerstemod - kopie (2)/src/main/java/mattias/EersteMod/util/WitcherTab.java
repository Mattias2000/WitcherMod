package mattias.EersteMod.util;

import mattias.EersteMod.util.handlers.RegistryHandler;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class WitcherTab extends ItemGroup {
    public WitcherTab() {
        super("witchertab");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(RegistryHandler.MEDALLION.get());
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}
