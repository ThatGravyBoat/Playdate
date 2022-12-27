package tech.thatgravyboat.playdate.common.recipes;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.registry.ModRecipeSerializers;
import tech.thatgravyboat.playdate.common.registry.ModRecipes;

import java.util.function.Predicate;

public record ToyBenchRecipe(ResourceLocation id, NonNullList<Ingredient> items, ItemStack result, int width, int height) implements Recipe<CraftingContainer> {

    @Override
    public boolean matches(CraftingContainer arg, @NotNull Level level) {
        for(int i = 0; i <= arg.getWidth() - this.width; ++i) {
            for(int j = 0; j <= arg.getHeight() - this.height; ++j) {
                if (this.matches(arg, i, j, true)) {
                    return true;
                }

                if (this.matches(arg, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(CraftingContainer arg, int x, int y, boolean bl) {
        for(int i = 0; i < arg.getWidth(); ++i) {
            for(int j = 0; j < arg.getHeight(); ++j) {
                int k = i - x;
                int l = j - y;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    ingredient = this.items.get(bl ? this.width - k - 1 + l * this.width : k + l * this.width);
                }

                if (!ingredient.test(arg.getItem(i + j * arg.getWidth()))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ItemStack assemble(@NotNull CraftingContainer container) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return i >= this.width && j >= this.height;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.items;
    }

    @Override
    public ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean isIncomplete() {
        NonNullList<Ingredient> list = this.getIngredients();
        if (list.isEmpty()) return true;
        return list.stream()
                .filter(Predicate.not(Ingredient::isEmpty))
                .anyMatch(ingredient -> ingredient.getItems().length == 0);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.TOY_BENCH.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TOY_BENCH.get();
    }

    public static class Serializer implements RecipeSerializer<ToyBenchRecipe> {

        @Override
        public ToyBenchRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject object) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromJson(id, object);
            return new ToyBenchRecipe(id, recipe.getIngredients(), recipe.getResultItem(), recipe.getWidth(), recipe.getHeight());
        }

        @Override
        public ToyBenchRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromNetwork(id, buffer);
            return new ToyBenchRecipe(id, recipe.getIngredients(), recipe.getResultItem(), recipe.getWidth(), recipe.getHeight());
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull ToyBenchRecipe toyRecipe) {
            ShapedRecipe recipe = new ShapedRecipe(toyRecipe.getId(), toyRecipe.getGroup(), toyRecipe.width(), toyRecipe.height(), toyRecipe.getIngredients(), toyRecipe.getResultItem());
            RecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe);
        }
    }
}
