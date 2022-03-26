package tech.thatgravyboat.forge.playdate.services;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
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
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.platform.services.IRegistryHelper;

import java.util.function.Supplier;

public class ForgeRegistryService implements IRegistryHelper {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Playdate.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Playdate.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Playdate.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Playdate.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Playdate.MODID);
    public static final DeferredRegister<PaintingMotive> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Playdate.MODID);
    public static final DeferredRegister<ScreenHandlerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Playdate.MODID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Playdate.MODID);

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return BLOCKS.register(id, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return ITEMS.register(id, item);
    }

    @Override
    public <T extends BlockEntityType<?>> Supplier<T> registerBlockEntity(String id, Supplier<T> blockEntity) {
        return BLOCKS_ENTITIES.register(id, blockEntity);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, EntityType.EntityFactory<T> factory, SpawnGroup group, float height, float width) {
        return ENTITIES.register(id, () -> EntityType.Builder.create(factory, group).setDimensions(width, height).build(id));
    }

    @Override
    public <E extends Recipe<?>, T extends RecipeSerializer<E>> Supplier<T> registerRecipe(String id, Supplier<T> serializer) {
        return RECIPES.register(id, serializer);
    }

    @Override
    public Supplier<SoundEvent> registerSound(String id, Supplier<SoundEvent> sound) {
        return SOUNDS.register(id, sound);
    }

    @Override
    public Supplier<PaintingMotive> registerPainting(String id, Supplier<PaintingMotive> serializer) {
        return PAINTINGS.register(id, serializer);
    }

    @Override
    public ItemGroup createItemGroup(Identifier id, Supplier<ItemStack> stack) {
        return new ItemGroup(id.getNamespace() +"."+id.getPath()) {
            @Override
            public ItemStack createIcon() {
                return stack.get();
            }
        };
    }

    @Override
    public <T extends ScreenHandler> Supplier<ScreenHandlerType<T>> registerContainer(String id, ContainerFactory<T> factory) {
        return CONTAINERS.register(id, () -> IForgeMenuType.create((syncId, inv, c) -> factory.create(syncId, inv)));
    }

    @Override
    public <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityFactory<E> factory, Block... blocks) {
        return BlockEntityType.Builder.create(factory::create, blocks).build(null);
    }
}
