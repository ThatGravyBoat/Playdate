package tech.thatgravyboat.playdate.common.menus;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.recipes.ToyBenchRecipe;
import tech.thatgravyboat.playdate.common.registry.ModBlocks;
import tech.thatgravyboat.playdate.common.registry.ModMenus;
import tech.thatgravyboat.playdate.common.registry.ModRecipes;

import java.util.Optional;

public class ToyBenchMenu extends AbstractContainerMenu {

    private final CraftingContainer craftSlots;
    private final ResultContainer resultSlots;
    private final ContainerLevelAccess access;
    private final Player player;

    public ToyBenchMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public ToyBenchMenu(int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(ModMenus.TOY_BENCH.get(), i);
        this.craftSlots = new CraftingContainer(this, 3, 3);
        this.resultSlots = new ResultContainer();
        this.access = containerLevelAccess;
        this.player = inventory.player;
        this.addSlot(new ResultSlot(inventory.player, this.craftSlots, this.resultSlots, 0, 124, 35));

        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 3; ++k) {
                this.addSlot(new Slot(this.craftSlots, k + j * 3, 30 + k * 18, 17 + j * 18));
            }
        }

        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for(int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

    }

    protected static void slotChangedCraftingGrid(AbstractContainerMenu abstractContainerMenu, Level level, Player player, CraftingContainer craftingContainer, ResultContainer resultContainer) {
        if (!level.isClientSide) {
            ServerPlayer serverPlayer = (ServerPlayer)player;
            ItemStack itemStack = ItemStack.EMPTY;
            Optional<ToyBenchRecipe> optional = level.getRecipeManager().getRecipeFor(ModRecipes.TOY_BENCH.get(), craftingContainer, level);
            if (optional.isPresent()) {
                ToyBenchRecipe craftingRecipe = optional.get();
                if (resultContainer.setRecipeUsed(level, serverPlayer, craftingRecipe)) {
                    itemStack = craftingRecipe.assemble(craftingContainer);
                }
            }

            resultContainer.setItem(0, itemStack);
            abstractContainerMenu.setRemoteSlot(0, itemStack);
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(abstractContainerMenu.containerId, abstractContainerMenu.incrementStateId(), 0, itemStack));
        }
    }

    @Override
    public void slotsChanged(@NotNull Container container) {
        this.access.execute((level, blockPos) -> slotChangedCraftingGrid(this, level, this.player, this.craftSlots, this.resultSlots));
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.access.execute((level, blockPos) -> {
            this.clearContainer(player, this.craftSlots);
        });
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.access, player, ModBlocks.TOY_BENCH.get());
    }

    @Override
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (i == 0) {
                this.access.execute((level, blockPos) -> {
                    itemStack2.getItem().onCraftedBy(itemStack2, level, player);
                });
                if (!this.moveItemStackTo(itemStack2, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack2, itemStack);
            } else if (i >= 10 && i < 46) {
                if (!this.moveItemStackTo(itemStack2, 1, 10, false)) {
                    if (i < 37) {
                        if (!this.moveItemStackTo(itemStack2, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemStack2, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemStack2, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack2);
            if (i == 0) {
                player.drop(itemStack2, false);
            }
        }

        return itemStack;
    }

    @Override
    public boolean canTakeItemForPickAll(@NotNull ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }
}