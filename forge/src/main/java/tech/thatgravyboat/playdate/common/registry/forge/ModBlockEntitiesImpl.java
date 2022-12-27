package tech.thatgravyboat.playdate.common.registry.forge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import tech.thatgravyboat.playdate.common.registry.ModBlockEntities;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;

import java.util.Arrays;
import java.util.stream.Stream;

public class ModBlockEntitiesImpl {
    @SafeVarargs
    public static <T extends BlockEntity> BlockEntityType<T> type(ModBlockEntities.BlockEntitySupplier<T> supplier, RegistryEntry<? extends Block>... blocks) {
        Block[] mapped = Arrays.stream(blocks).map(RegistryEntry::get).toArray(Block[]::new);
        return BlockEntityType.Builder.of(supplier::create, mapped).build(null);
    }
}
