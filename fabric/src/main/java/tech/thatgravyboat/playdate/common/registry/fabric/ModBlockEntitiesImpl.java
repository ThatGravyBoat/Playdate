package tech.thatgravyboat.playdate.common.registry.fabric;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import tech.thatgravyboat.playdate.common.registry.ModBlockEntities;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;

import java.util.stream.Stream;

public class ModBlockEntitiesImpl {
    @SafeVarargs
    public static <T extends BlockEntity> BlockEntityType<T> type(ModBlockEntities.BlockEntitySupplier<T> supplier, RegistryEntry<? extends Block>... blocks) {
        var builder = FabricBlockEntityTypeBuilder.create(supplier::create);
        Stream.of(blocks).map(RegistryEntry::get).forEach(builder::addBlock);
        return builder.build();
    }
}
