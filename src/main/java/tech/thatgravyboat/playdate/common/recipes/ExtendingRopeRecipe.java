package tech.thatgravyboat.playdate.common.recipes;

import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.item.BalloonItem;
import tech.thatgravyboat.playdate.common.item.ModItems;

public class ExtendingRopeRecipe extends CustomRecipe {

    public ExtendingRopeRecipe(ResourceLocation p_43833_) {
        super(p_43833_);
    }

    @Override
    public boolean matches(@NotNull CraftingContainer craft, @NotNull Level level) {
        boolean foundBalloon = false;
        int length = 0;
        int ropes = 0;
        for (int i = 0; i < craft.getContainerSize(); i++) {
            var stack = craft.getItem(i);
            if (stack.isEmpty()) continue;
            if (stack.is(ModItems.ROPE.get())) ropes++;
            else if (stack.getItem() instanceof BalloonItem) {
                if (foundBalloon) return false;
                foundBalloon = true;
                length = stack.getTag() != null ? stack.getTag().getInt("length") : 0;
                if (length + ropes > 8) {
                    return false;
                }
            }
            else return false;
        }
        return length + ropes <= 8;
    }

    @Override
    public @NotNull ItemStack assemble(CraftingContainer craft) {
        ItemStack balloon = ItemStack.EMPTY;
        int length = 0;
        int ropes = 0;
        for (int i = 0; i < craft.getContainerSize(); i++) {
            var stack = craft.getItem(i);
            if (stack.isEmpty()) continue;
            if (stack.is(ModItems.ROPE.get())) ropes++;
            if (stack.getItem() instanceof BalloonItem) {
                balloon = stack;
                length = stack.getTag() != null ? stack.getTag().getInt("length") : 0;
            }
        }
        balloon = balloon.copy();
        balloon.getOrCreateTag().putInt("length", length + ropes);
        balloon.setCount(1);
        return balloon;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipes.EXTENDING_ROPE.get();
    }
}
