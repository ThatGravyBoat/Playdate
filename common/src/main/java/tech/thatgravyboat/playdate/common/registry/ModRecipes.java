package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModRecipes {

    public static final ResourcefulRegistry<RecipeType<?>> RECIPES = ResourcefulRegistries.create(Registry.RECIPE_TYPE, Playdate.MOD_ID);

    public static final RegistryEntry<RecipeType<ToyBenchRecipe>> TOY_BENCH = RECIPES.register("toy_bench", () -> new RecipeType<>() {
        @Override
        public String toString() {
            return Playdate.MOD_ID + ":toy_bench";
        }
    });
}
