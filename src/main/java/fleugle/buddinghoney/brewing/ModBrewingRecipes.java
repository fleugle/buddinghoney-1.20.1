package fleugle.buddinghoney.brewing;

import fleugle.buddinghoney.items.ModItems;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;

public class ModBrewingRecipes {

    public static void registerBrewingRecipes(){
        BrewingRecipeRegistry.registerItemRecipe(Items.AMETHYST_SHARD, Items.HONEY_BOTTLE, ModItems.AMETHYST_CATALYST);
    }

}
