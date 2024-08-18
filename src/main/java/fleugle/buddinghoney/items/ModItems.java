package fleugle.buddinghoney.items;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.items.custom.CogswordItem;
import fleugle.buddinghoney.utility.ModToolMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item BEESTANITE = registerItem("beestanite", new Item(new Item.Settings()));

    public static final Item COGSWORD = registerItem("cogsword", new CogswordItem(ModToolMaterial.BEESTANITE,3.6f, 3.6f,new Item.Settings()));





    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Buddinghoney.MOD_ID,name), item);
    }

    public static void registerModItems(){

        //TOOLS AND UTILITIES TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

        });


        //INGREDIENTS TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });

        //FOOD_AND_DRINKS TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });

        //COMBAT TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            //armor & equipment




            //weapons
            entries.add(COGSWORD);


            //utility items



            //ammo


            //phylactery



        });//calling for the private method in order to  add item to the ingridient tab
    }
}
