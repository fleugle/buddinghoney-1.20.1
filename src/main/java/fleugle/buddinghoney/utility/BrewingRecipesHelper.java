package fleugle.buddinghoney.utility;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public class BrewingRecipesHelper {

    private static List<Item> validBrewingIngredientList = new ArrayList<>();

    private static List<Item> validBrewingInputList = new ArrayList<>();

    private static List<Item> validBrewingFuelList = new ArrayList<>();

    public static void addToValidBrewingIngredientList(Item item){
        validBrewingIngredientList.add(item);
    }

    public static void addToValidBrewingInputList(Item item){
        validBrewingInputList.add(item);
    }

    public static void addToValidBrewingFuelList(Item item){
        validBrewingFuelList.add(item);
    }

    public static List<Item> getValidBrewingInputList(){
        return validBrewingInputList;
    }

    public static List<Item> getValidBrewingIngredientList(){
        return validBrewingIngredientList;
    }

    public static List<Item> getValidBrewingFuelList(){
        return validBrewingFuelList;
    }

    public static List<Item> getValidBrewingItemList(){

        List<Item> validItems = new ArrayList<>();

        validItems.addAll(validBrewingIngredientList);

        validItems.addAll(validBrewingInputList);

        //validItems.addAll(validBrewingFuelList);

        return validItems;
    }

}
