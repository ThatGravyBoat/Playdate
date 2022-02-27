package tech.thatgravyboat.playdate.common.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PlayDate.MODID);

    public static final RegistryObject<RecipeSerializer<?>> EXTENDING_ROPE = RECIPE_SERIALIZERS.register("extending_rope",
            () -> new SimpleRecipeSerializer<>(ExtendingRopeRecipe::new));


}
