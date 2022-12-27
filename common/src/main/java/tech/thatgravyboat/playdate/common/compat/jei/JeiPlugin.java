package tech.thatgravyboat.playdate.common.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.registry.ModItems;
import tech.thatgravyboat.playdate.common.registry.ModRecipes;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ToyBenchCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.TOY_BENCH.get()), ToyBenchCategory.RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        ClientLevel clientWorld = Minecraft.getInstance().level;
        if (clientWorld != null) {
            RecipeManager recipeManager = clientWorld.getRecipeManager();
            registration.addRecipes(ToyBenchCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(ModRecipes.TOY_BENCH.get()));
        }
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Playdate.MOD_ID, "jei");
    }
}
