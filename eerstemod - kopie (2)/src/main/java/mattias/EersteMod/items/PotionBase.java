package mattias.EersteMod.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class PotionBase extends Item {

    private final EffectInstance effect;
    private final EffectInstance effect2;
    private final ItemStack[] rewards;
    private final boolean clearsEffects;

    public PotionBase(EffectInstance effect, EffectInstance effect2, boolean clearsEffects, ItemStack... rewards) {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.BREWING));
        this.effect = effect;
        this.effect2 = effect2;
        this.rewards = rewards;
        this.clearsEffects = clearsEffects;

    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entityLiving) {
        PlayerEntity player = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;

        if (player instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) player, stack);
        }

        if (!world.isRemote) {
            if (effect != null) {
                entityLiving.addPotionEffect(new EffectInstance(effect));
            }
            if (effect2 != null) {
                entityLiving.addPotionEffect(new EffectInstance(effect2));
            }
            // Give reward items if defined
            if (rewards != null && player != null) {
                for (ItemStack reward : rewards) {
                    player.inventory.addItemStackToInventory(reward.copy());
                }
            }
            if (clearsEffects) {
                entityLiving.clearActivePotions();
            }
        }

        if (player == null || !player.abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (player == null || !player.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        player.setActiveHand(hand);
        return new ActionResult<>(ActionResultType.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
