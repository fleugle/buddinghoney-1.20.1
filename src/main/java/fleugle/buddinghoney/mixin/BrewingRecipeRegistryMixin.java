package fleugle.buddinghoney.mixin;


import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.PotionItem;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {

    @Shadow
    private static final List<BrewingRecipeRegistry.Recipe<Item>> ITEM_RECIPES = Lists.<BrewingRecipeRegistry.Recipe<Item>>newArrayList();

    @Inject(at = @At("HEAD"), method = "registerItemRecipe", cancellable = true)
    private static void registerItemRecipe(Item input, Item ingredient, Item output, CallbackInfo ci) {
        if (!(input instanceof PotionItem)) {
            throw new IllegalArgumentException("Expected a potion, got: " + Registries.ITEM.getId(input));
        } else if (!(output instanceof PotionItem)) {
            throw new IllegalArgumentException("Expected a potion, got: " + Registries.ITEM.getId(output));
        } else {
            ITEM_RECIPES.add(new BrewingRecipeRegistry.Recipe<>(input, Ingredient.ofItems(ingredient), output));
        }
    }
}
