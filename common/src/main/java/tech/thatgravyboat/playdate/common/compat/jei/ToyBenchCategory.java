package tech.thatgravyboat.playdate.common.compat.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.ModBlocks;

import java.util.List;

public class ToyBenchCategory implements IRecipeCategory<ToyBenchRecipe> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");

    public static final RecipeType<ToyBenchRecipe> RECIPE_TYPE = new RecipeType<>(new ResourceLocation(Playdate.MOD_ID, "toy_bench"), ToyBenchRecipe.class);

    private final ICraftingGridHelper craftingGridHelper;
    private final IDrawable background;
    private final IDrawable icon;

    public ToyBenchCategory(IGuiHelper helper) {
        this.craftingGridHelper = helper.createCraftingGridHelper();
        this.background = helper.createDrawable(TEXTURE, 0, 60, 116, 54);
        this.icon = helper.createDrawableItemStack(new ItemStack(ModBlocks.TOY_BENCH.get()));
    }

    @Override
    public RecipeType<ToyBenchRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.playdate.toy_bench");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull ToyBenchRecipe recipe, @NotNull IFocusGroup focuses) {
        List<List<ItemStack>> inputs = recipe.getIngredients().stream()
                .map(ingredient -> List.of(ingredient.getItems()))
                .toList();
        this.craftingGridHelper.createAndSetInputs(builder, inputs, 3, 3);
        this.craftingGridHelper.createAndSetOutputs(builder, List.of(recipe.getResultItem()));
    }
}
