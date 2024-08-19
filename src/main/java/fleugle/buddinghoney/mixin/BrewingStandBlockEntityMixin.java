package fleugle.buddinghoney.mixin;


import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(BrewingStandBlockEntity.class)
public class BrewingStandBlockEntityMixin {

    @Shadow
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    @Shadow
    public ItemStack getStack(int slot) {
        return slot >= 0 && slot < this.inventory.size() ? this.inventory.get(slot) : ItemStack.EMPTY;
    }






    @Inject(at = @At("HEAD"), method = "isValid", cancellable = true)
    public void isValid(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        List<Item> validItemsList = new ArrayList<>();

        validItemsList.add(Items.AMETHYST_SHARD);
        validItemsList.add(Items.HONEY_BOTTLE);
        //validItemsList.add(Items.AMETHYST_SHARD);


        if (slot == 3) {
            cir.setReturnValue(BrewingRecipeRegistry.isValidIngredient(stack));
        } else {
            boolean debug = slot == 4
                    ? stack.isOf(Items.BLAZE_POWDER)
                    : (stack.isOf(Items.POTION) || stack.isOf(Items.SPLASH_POTION) || stack.isOf(Items.LINGERING_POTION) || stack.isOf(Items.GLASS_BOTTLE)
                    || validItemsList.contains(stack.getItem()))
                    && this.getStack(slot).isEmpty();

            cir.setReturnValue(slot == 4
                    ? stack.isOf(Items.BLAZE_POWDER)
                    : (stack.isOf(Items.POTION) || stack.isOf(Items.SPLASH_POTION) || stack.isOf(Items.LINGERING_POTION) || stack.isOf(Items.GLASS_BOTTLE)
                    || validItemsList.contains(stack.getItem()))
                    && this.getStack(slot).isEmpty());
        }
    }

    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void injectCanInsertItem(int slot, ItemStack stack, Direction dir, CallbackInfoReturnable<Boolean> cir) {
        // Check if the item is your custom item
        List<Item> validItemsList = new ArrayList<>();

        validItemsList.add(Items.AMETHYST_SHARD);
        validItemsList.add(Items.HONEY_BOTTLE);
        if (validItemsList.contains(stack.getItem())) {
            cir.setReturnValue(true);
        }
    }

}
