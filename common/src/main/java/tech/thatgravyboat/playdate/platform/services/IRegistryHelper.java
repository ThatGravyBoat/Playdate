package tech.thatgravyboat.playdate.platform.services;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.Supplier;

public interface IRegistryHelper {

    <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block);

    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> block);

    <T extends BlockEntityType<?>> Supplier<T> registerBlockEntity(String id, Supplier<T> blockEntity);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, EntityType.EntityFactory<T> factory, SpawnGroup group, float height, float width);

    <E extends Recipe<?>, T extends RecipeSerializer<E>> Supplier<T> registerRecipe(String id, Supplier<T> serializer);

    Supplier<SoundEvent> registerSound(String id, Supplier<SoundEvent> serializer);

    Supplier<PaintingMotive> registerPainting(String id, Supplier<PaintingMotive> serializer);

    ItemGroup createItemGroup(Identifier id, Supplier<ItemStack> stack);

    <T extends ScreenHandler> Supplier<ScreenHandlerType<T>> registerContainer(String id, ContainerFactory<T> block);

    @FunctionalInterface
    interface ContainerFactory<T extends ScreenHandler> {
        T create(int syncId, PlayerInventory inventory);
    }

    <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityFactory<E> factory, Block... blocks);

    @FunctionalInterface
    interface BlockEntityFactory<T extends BlockEntity> {
        T create(BlockPos pos, BlockState state);
    }
}
