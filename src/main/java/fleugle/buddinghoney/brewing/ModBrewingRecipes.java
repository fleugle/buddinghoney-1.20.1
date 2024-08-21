package fleugle.buddinghoney.brewing;

import fleugle.buddinghoney.items.ModItems;
import fleugle.buddinghoney.utility.BrewingRecipesHelper;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;

public class ModBrewingRecipes {

    public static void registerBrewingRecipes(){
        //BrewingRecipeRegistry.registerItemRecipe(Items.AMETHYST_SHARD, Items.HONEY_BOTTLE, ModItems.AMETHYST_CATALYST);

        BrewingRecipeRegistry.registerItemRecipe(Items.HONEY_BOTTLE, Items.AMETHYST_SHARD, ModItems.AMETHYST_CATALYST);
        BrewingRecipesHelper.addToValidBrewingInputList(Items.HONEY_BOTTLE);
        BrewingRecipesHelper.addToValidBrewingIngredientList(Items.AMETHYST_SHARD);


        BrewingRecipeRegistry.registerItemRecipe(ModItems.AMETHYST_CATALYST, Items.IRON_INGOT, ModItems.CHAROITE);
        BrewingRecipesHelper.addToValidBrewingInputList(ModItems.AMETHYST_CATALYST);
        BrewingRecipesHelper.addToValidBrewingIngredientList(Items.IRON_INGOT);


    }

}
