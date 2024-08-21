package fleugle.buddinghoney.datagen;

import fleugle.buddinghoney.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SMALL_COG, 1)
			.pattern(" S ")
			.pattern("SHS")
			.pattern(" S ")
			.input('S', ModItems.BEESTANITE)
			.input('H', Items.HONEYCOMB)

			.criterion(hasItem(ModItems.BEESTANITE), conditionsFromItem(ModItems.BEESTANITE))
			.offerTo(exporter, new Identifier(getRecipeName( ModItems.SMALL_COG)));

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HONEYCOMB_CORE, 1)
				.pattern("SBS")
				.pattern("SHS")
				.pattern("SBS")
				.input('S', Blocks.HONEY_BLOCK)
				.input('H', Items.HONEYCOMB)
				.input('B', ModItems.XENOTIME)


				.criterion(hasItem(ModItems.XENOTIME), conditionsFromItem(ModItems.XENOTIME))
				.offerTo(exporter, new Identifier(getRecipeName( ModItems.HONEYCOMB_CORE)));

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.C_HONEYCOMB_CORE, 1)
				.pattern("SSS")
				.pattern("SHS")
				.pattern("SSS")
				.input('S', ModItems.BEESTANITE)
				.input('H', ModItems.HONEYCOMB_CORE)


				.criterion(hasItem(ModItems.BEESTANITE), conditionsFromItem(ModItems.BEESTANITE))
				.offerTo(exporter, new Identifier(getRecipeName( ModItems.C_HONEYCOMB_CORE)));


		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HONEYCOMB_SHOTGUN, 1)
				.pattern("SHA")
				.pattern("BC ")
				.input('S', ModItems.C_HONEYCOMB_CORE)
				.input('H', ModItems.BEESTANITE)
				.input('A', Items.HONEYCOMB)
				.input('B', ModItems.XENOTIME)
				.input('C', Items.TRIPWIRE_HOOK)



				.criterion(hasItem(ModItems.BEESTANITE), conditionsFromItem(ModItems.BEESTANITE))
				.offerTo(exporter, new Identifier(getRecipeName( ModItems.HONEYCOMB_SHOTGUN)));





		/*ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_DOOR)
			.ingredient(ModBlocks.COPPER_DOOR)
			.ingredient(Items.HONEYCOMB)
			.criterion(hasItem(ModBlocks.COPPER_DOOR), conditionsFromItem(ModBlocks.COPPER_DOOR))
			.offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WAXED_COPPER_DOOR)));*/


	}
}
