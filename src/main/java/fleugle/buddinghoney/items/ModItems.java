package fleugle.buddinghoney.items;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.items.custom.CogswordItem;
import fleugle.buddinghoney.items.custom.HoneycombShotgunItem;
import fleugle.buddinghoney.utility.ModToolMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModItems {


    public static final Item BEESTANITE = registerItem("beestanite", new Item(new Item.Settings()));

    public static final Item BEESTANITE_BULLET = registerItem("beestanite_bullet",  new Item(new Item.Settings()));

    public static final Item AMETHYST_BULLET = registerItem("amethyst_bullet",  new Item(new Item.Settings()));

    public static final Item COGSWORD = registerItem("cogsword", new CogswordItem(ModToolMaterial.BEESTANITE,2.6f, -2.4f,new Item.Settings(), false));

    public static final Item AMETHYST_COGSWORD = registerItem("amethyst_cogsword", new CogswordItem(ModToolMaterial.BEESTANITE,2.6f, -2.4f,new Item.Settings(), true));

    public static final Item HONEYCOMB_SHOTGUN = registerItem("honeycomb_shotgun", new HoneycombShotgunItem(new Item.Settings(), false));

    public static final Item AMETHYST_SHOTGUN = registerItem("amethyst_shotgun", new HoneycombShotgunItem(new Item.Settings(), true));


    public static final Item AMETHYST_UPGRADE_SMITHING_TEMPLATE = registerItem("amethyst_upgrade_smithing_template", new SmithingTemplateItem(
            Text.translatable(
                    Util.createTranslationKey("item", Buddinghoney.id("smithing_template.amethyst_upgrade.applies_to"))
            ).formatted(Formatting.BLUE),
            Text.translatable(
                    Util.createTranslationKey("item", Buddinghoney.id("smithing_template.amethyst_upgrade.ingredients"))
            ).formatted(Formatting.BLUE),
            Text.translatable(
                    Util.createTranslationKey("upgrade", Buddinghoney.id("amethyst_upgrade"))
            ).formatted(Formatting.GRAY),
            Text.translatable(
                    Util.createTranslationKey("item", Buddinghoney.id("smithing_template.amethyst_upgrade.base_slot_description"))
            ),
            Text.translatable(
                    Util.createTranslationKey("item", Buddinghoney.id("smithing_template.amethyst_upgrade.additions_slot_description"))
            ),
            List.of(new Identifier("item/empty_slot_sword")),
            List.of(new Identifier("item/empty_slot_amethyst_shard"))
    ));

    public static final Item AMETHYST_CATALYST = registerItem("amethyst_catalyst", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Buddinghoney.MOD_ID,name), item);
    }

    public static void registerModItems(){

        //TOOLS AND UTILITIES TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

        });


        //INGREDIENTS TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            entries.add(BEESTANITE);

            entries.add(AMETHYST_UPGRADE_SMITHING_TEMPLATE);

        });

        //FOOD_AND_DRINKS TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });

        //COMBAT TAB ITEMS REGISTRY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            //armor & equipment




            //weapons
            entries.add(COGSWORD);
            entries.add(AMETHYST_COGSWORD);

            entries.add(HONEYCOMB_SHOTGUN);
            entries.add(BEESTANITE_BULLET);


            //utility items



            //ammo


            //phylactery



        });//calling for the private method in order to  add item to the ingridient tab
    }
}
