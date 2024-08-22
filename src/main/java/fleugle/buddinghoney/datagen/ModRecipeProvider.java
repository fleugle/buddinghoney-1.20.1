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

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BEESTANITE_BULLET, 1)
				.pattern("S")
				.pattern("H")
				.input('S', ModItems.CHAROITE)
				.input('H', ModItems.BEESTANITE)


				.criterion(hasItem(ModItems.BEESTANITE), conditionsFromItem(ModItems.BEESTANITE))
				.offerTo(exporter, new Identifier(getRecipeName( ModItems.BEESTANITE_BULLET)));


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





		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEESTANITE)
			.input(ModItems.XENOTIME)
			.input(Items.HONEYCOMB)
				.criterion(hasItem(ModItems.XENOTIME), conditionsFromItem(ModItems.XENOTIME))
			.offerTo(exporter, new Identifier(getRecipeName(ModItems.BEESTANITE)));


		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.QWARTZATHYST)
				.input(Items.AMETHYST_SHARD)
				.input(Items.QUARTZ)
				.criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.QWARTZATHYST)));

		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE)
				.input(ModItems.QWARTZATHYST)
				.input(ModItems.BEESTANITE)
				.criterion(hasItem(ModItems.QWARTZATHYST), conditionsFromItem(ModItems.QWARTZATHYST))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE)));



	}
}
