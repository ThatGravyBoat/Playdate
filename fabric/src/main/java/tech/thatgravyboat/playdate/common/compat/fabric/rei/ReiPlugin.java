package tech.thatgravyboat.playdate.common.compat.fabric.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.ModRecipes;

public class ReiPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(ToyBenchRecipe.class, ModRecipes.TOY_BENCH.get(), ToyBenchCategory.ToyBenchDisplay::new);
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registerCategoryWithIcon(registry, new ToyBenchCategory());
    }

    private static void registerCategoryWithIcon(CategoryRegistry registry, DisplayCategory<?> category) {
        registry.add(category);
        if (!(category.getIcon() instanceof EntryStack<?> stack)) {
            throw new IllegalStateException("Category icon is not an entry stack!");
        }
        registry.addWorkstations(category.getCategoryIdentifier(), stack);
    }
}
