package tech.thatgravyboat.playdate.common.compat.fabric.rei;

import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Slot;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplayMerger;
import me.shedaniel.rei.api.common.display.SimpleGridMenuDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.ModItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToyBenchCategory implements DisplayCategory<ToyBenchCategory.ToyBenchDisplay> {

    public static final CategoryIdentifier<ToyBenchDisplay> ID = CategoryIdentifier.of(Playdate.MOD_ID,  "toy_bench");

    @Override
    public CategoryIdentifier<? extends ToyBenchDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.playdate.toy_bench");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModItems.TOY_BENCH.get());
    }

    @Override
    public List<Widget> setupDisplay(ToyBenchDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 58, bounds.getCenterY() - 27);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 60, startPoint.y + 18)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 95, startPoint.y + 19)));
        List<Slot> slots = new ArrayList<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                slots.add(Widgets.createSlot(new Point(startPoint.x + 1 + x * 18, startPoint.y + 1 + y * 18)).markInput());
            }
        }
        display.getInputIngredients().forEach(ingredient -> slots.get(ingredient.getIndex()).entries(ingredient.get()));
        widgets.addAll(slots);
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 95, startPoint.y + 19)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    @Nullable
    public DisplayMerger<ToyBenchDisplay> getDisplayMerger() {
        return DisplayCategory.getContentMerger();
    }

    public record ToyBenchDisplay(ToyBenchRecipe recipe) implements SimpleGridMenuDisplay {

        @Override
        public List<EntryIngredient> getInputEntries() {
            return EntryIngredients.ofIngredients(recipe.getIngredients());
        }

        @Override
        public List<EntryIngredient> getOutputEntries() {
            return List.of(EntryIngredients.of(recipe.getResultItem()));
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return ID;
        }

        @Override
        public int getWidth() {
            return recipe.width();
        }

        @Override
        public int getHeight() {
            return recipe.height();
        }

        public List<InputIngredient<EntryStack<?>>> getInputIngredients() {
            Map<IntIntPair, InputIngredient<EntryStack<?>>> grid = new HashMap<>();

            List<EntryIngredient> inputEntries = getInputEntries();
            for (int i = 0; i < inputEntries.size(); i++) {
                EntryIngredient stacks = inputEntries.get(i);
                if (!stacks.isEmpty()) {
                    int index = 3 * ((i - (i % getWidth())) / getWidth()) + (i % getWidth());
                    grid.put(new IntIntImmutablePair(i % getWidth(), i / getWidth()), InputIngredient.of(index, stacks));
                }
            }

            List<InputIngredient<EntryStack<?>>> list = new ArrayList<>(9);
            for (int i = 0; i < 9; i++) {
                list.add(InputIngredient.empty(i));
            }

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    InputIngredient<EntryStack<?>> ingredient = grid.get(new IntIntImmutablePair(x, y));
                    if (ingredient != null) {
                        list.set(3 * y + x, ingredient);
                    }
                }
            }

            return list;
        }
    }
}
