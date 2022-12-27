package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.playdate.common.blockentities.FiveSlotBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.shapes.ShapeGetter;
import tech.thatgravyboat.playdate.common.registry.ModBlockEntities;

public class FiveSlotToyBlock extends DirectionalToyBlock implements EntityBlock {

    public FiveSlotToyBlock(ShapeGetter shape, Properties properties) {
        super(shape, properties);
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        if (level.getBlockEntity(pos) instanceof FiveSlotBlockEntity blockEntity) {
            player.openMenu(blockEntity);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof FiveSlotBlockEntity blockEntity) {
                Containers.dropContents(level, pos, blockEntity);
            }
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModBlockEntities.FIVE_SLOT_ENTITY.get().create(pos, state);
    }
}
