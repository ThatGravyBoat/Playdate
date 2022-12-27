package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModRecipeSerializers {

    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(Registry.RECIPE_SERIALIZER, Playdate.MOD_ID);

    public static final RegistryEntry<RecipeSerializer<ToyBenchRecipe>> TOY_BENCH = RECIPE_SERIALIZERS.register("toy_bench", ToyBenchRecipe.Serializer::new);
}
