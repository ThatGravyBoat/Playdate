package tech.thatgravyboat.playdate.common.recipes;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class ModRecipes {

    public static final RecipeSerializer<ExtendingRopeRecipe> EXTENDING_ROPE = new SpecialRecipeSerializer<>(ExtendingRopeRecipe::new);

    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, modId("extending_rope"), EXTENDING_ROPE);
    }

}
