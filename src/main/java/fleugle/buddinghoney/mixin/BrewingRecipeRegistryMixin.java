package fleugle.buddinghoney.mixin;


import com.google.common.collect.Lists;
import fleugle.buddinghoney.utility.BrewingRecipesHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Predicate;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {

    @Shadow
    private static final List<BrewingRecipeRegistry.Recipe<Potion>> POTION_RECIPES = Lists.<BrewingRecipeRegistry.Recipe<Potion>>newArrayList();


    @Shadow
    private static final List<BrewingRecipeRegistry.Recipe<Item>> ITEM_RECIPES = Lists.<BrewingRecipeRegistry.Recipe<Item>>newArrayList();

    @Shadow
    private static final List<Ingredient> POTION_TYPES = Lists.<Ingredient>newArrayList();

    @Shadow
    private static final Predicate<ItemStack> POTION_TYPE_PREDICATE = stack -> {
        for (Ingredient ingredient : POTION_TYPES) {
            if (ingredient.test(stack)) {
                return true;
            }
        }

        return false;
    };

    @Shadow
    protected static boolean hasPotionRecipe(ItemStack input, ItemStack ingredient) {
        Potion potion = PotionUtil.getPotion(input);
        int i = 0;

        for (int j = POTION_RECIPES.size(); i < j; i++) {
            BrewingRecipeRegistry.Recipe<Potion> recipe = (BrewingRecipeRegistry.Recipe<Potion>)POTION_RECIPES.get(i);
            if (recipe.input == potion && recipe.ingredient.test(ingredient)) {
                return true;
            }
        }

        return false;
    }

    @Shadow
    protected static boolean hasItemRecipe(ItemStack input, ItemStack ingredient) {
        Item item = input.getItem();
        int i = 0;

        for (int j = ITEM_RECIPES.size(); i < j; i++) {
            BrewingRecipeRegistry.Recipe<Item> recipe = (BrewingRecipeRegistry.Recipe<Item>)ITEM_RECIPES.get(i);
            if (recipe.input == item && recipe.ingredient.test(ingredient)) {
                return true;
            }
        }

        return false;
    }




    @Inject(at = @At("HEAD"), method = "registerItemRecipe", cancellable = true)
    private static void registerItemRecipe(Item input, Item ingredient, Item output, CallbackInfo ci) {

        ITEM_RECIPES.add(new BrewingRecipeRegistry.Recipe<>(input, Ingredient.ofItems(ingredient), output));

        ci.cancel();
    }


    @Inject(at = @At("HEAD"), method = "hasRecipe", cancellable = true)
    private static void hasRecipe(ItemStack input, ItemStack ingredient, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((POTION_TYPE_PREDICATE.test(input) || (BrewingRecipesHelper.getValidBrewingInputList().contains(input.getItem()) && BrewingRecipesHelper.getValidBrewingIngredientList().contains(ingredient.getItem()))) && (hasItemRecipe(input, ingredient) || hasPotionRecipe(input, ingredient)));
    }

}
