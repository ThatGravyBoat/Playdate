package tech.thatgravyboat.playdate.common.recipes;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.items.BalloonItem;
import tech.thatgravyboat.playdate.common.items.ModItems;

public class ExtendingRopeRecipe extends SpecialCraftingRecipe {

    public ExtendingRopeRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory craft, World world) {
        boolean foundBalloon = false;
        int length = 0;
        int ropes = 0;
        for (int i = 0; i < craft.size(); i++) {
            var stack = craft.getStack(i);
            if (stack.isEmpty()) continue;
            if (stack.isOf(ModItems.ROPE)) ropes++;
            else if (stack.getItem() instanceof BalloonItem) {
                if (foundBalloon) return false;
                foundBalloon = true;
                length = stack.getNbt() != null ? stack.getNbt().getInt("length") : 0;
                if (length + ropes > 8) {
                    return false;
                }
            }
            else return false;
        }
        return length + ropes <= 8;
    }

    @Override
    public ItemStack craft(CraftingInventory craft) {
        ItemStack balloon = ItemStack.EMPTY;
        int length = 0;
        int ropes = 0;
        for (int i = 0; i < craft.size(); i++) {
            var stack = craft.getStack(i);
            if (stack.isEmpty()) continue;
            if (stack.isOf(ModItems.ROPE)) ropes++;
            if (stack.getItem() instanceof BalloonItem) {
                balloon = stack;
                length = stack.getNbt() != null ? stack.getNbt().getInt("length") : 0;
            }
        }
        balloon = balloon.copy();
        balloon.getOrCreateNbt().putInt("length", length + ropes);
        balloon.setCount(1);
        return balloon;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.EXTENDING_ROPE;
    }
}
