package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import tech.thatgravyboat.playdate.common.recipes.ExtendingRopeRecipe;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.function.Supplier;

public class ModRecipes {

    public static final Supplier<RecipeSerializer<ExtendingRopeRecipe>> EXTENDING_ROPE = CommonServices.REGISTRY.registerRecipe("extending_rope",
            () -> new SpecialRecipeSerializer<>(ExtendingRopeRecipe::new));

    public static void register() {
        //Initialize class.
    }
}
