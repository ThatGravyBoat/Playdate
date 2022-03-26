package tech.thatgravyboat.fabric.playdate.services;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import tech.thatgravyboat.playdate.platform.services.IRegistryHelper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FabricRegistryService implements IRegistryHelper {

    public static final Map<String, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<String, Supplier<Item>> ITEMS = new LinkedHashMap<>();
    public static final Map<String, Supplier<BlockEntityType<?>>> BLOCK_ENTITIES = new LinkedHashMap<>();
    public static final Map<String, Supplier<EntityType<?>>> ENTITIES = new LinkedHashMap<>();
    public static final Map<String, Supplier<RecipeSerializer<?>>> RECIPES = new LinkedHashMap<>();
    public static final Map<String, Supplier<PaintingMotive>> PAINTINGS = new LinkedHashMap<>();
    public static final Map<String, Supplier<ScreenHandlerType<?>>> CONTAINERS = new LinkedHashMap<>();
    public static final Map<String, Supplier<SoundEvent>> SOUNDS = new LinkedHashMap<>();

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        var object = block.get();
        BLOCKS.put(id, () -> object);
        return () -> object;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        var object = item.get();
        ITEMS.put(id, () -> object);
        return () -> object;
    }

    @Override
    public <T extends BlockEntityType<?>> Supplier<T> registerBlockEntity(String id, Supplier<T> blockEntity) {
        var object = blockEntity.get();
        BLOCK_ENTITIES.put(id, () -> object);
        return () -> object;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, EntityType.EntityFactory<T> factory, SpawnGroup group, float height, float width) {
        var object = FabricEntityTypeBuilder.create(group, factory).dimensions(EntityDimensions.fixed(width, height)).build();
        ENTITIES.put(id, () -> object);
        return () -> object;
    }

    @Override
    public <E extends Recipe<?>, T extends RecipeSerializer<E>> Supplier<T> registerRecipe(String id, Supplier<T> serializer) {
        var object = serializer.get();
        RECIPES.put(id, () -> object);
        return () -> object;
    }

    @Override
    public Supplier<SoundEvent> registerSound(String id, Supplier<SoundEvent> sound) {
        var object = sound.get();
        SOUNDS.put(id, sound);
        return () -> object;
    }

    @Override
    public Supplier<PaintingMotive> registerPainting(String id, Supplier<PaintingMotive> motive) {
        var object = motive.get();
        PAINTINGS.put(id, motive);
        return () -> object;
    }

    @Override
    public ItemGroup createItemGroup(Identifier id, Supplier<ItemStack> stack) {
        return FabricItemGroupBuilder.build(id, stack);
    }

    @Override
    public <T extends ScreenHandler> Supplier<ScreenHandlerType<T>> registerContainer(String id, ContainerFactory<T> factory) {
        var object = new ScreenHandlerType<>(factory::create);
        CONTAINERS.put(id, () -> object);
        return () -> object;
    }

    @Override
    public <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityFactory<E> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory::create, blocks).build();
    }
}
