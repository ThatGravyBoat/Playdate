package tech.thatgravyboat.playdate.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blockentities.FiveSlotBlockEntity;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModBlockEntities {

    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITIES = ResourcefulRegistries.create(Registry.BLOCK_ENTITY_TYPE, Playdate.MOD_ID);

    public static final RegistryEntry<BlockEntityType<FiveSlotBlockEntity>> FIVE_SLOT_ENTITY = BLOCK_ENTITIES.register("five_slot_entity",
            () -> type(FiveSlotBlockEntity::new, ModBlocks.PIGGY_BANK));

    @SafeVarargs
    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> type(BlockEntitySupplier<T> supplier, RegistryEntry<? extends Block>... blocks) {
        throw new AssertionError();
    }

    @FunctionalInterface
    public interface BlockEntitySupplier<T extends BlockEntity> {
        T create(BlockPos blockPos, BlockState blockState);
    }
}
