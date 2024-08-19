package fleugle.buddinghoney.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(BrewingStandScreenHandler.PotionSlot.class)
public class PotionSlotMixin {

    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    private static void injectMatches(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        // List of valid items to add
        List<Item> validItemsList = new ArrayList<>();
        validItemsList.add(Items.AMETHYST_SHARD);
        validItemsList.add(Items.HONEY_BOTTLE);


        cir.setReturnValue(stack.isOf(Items.POTION) ||
                stack.isOf(Items.SPLASH_POTION) ||
                stack.isOf(Items.LINGERING_POTION) ||
                stack.isOf(Items.GLASS_BOTTLE) ||
                validItemsList.contains(stack.getItem()));

    }
}