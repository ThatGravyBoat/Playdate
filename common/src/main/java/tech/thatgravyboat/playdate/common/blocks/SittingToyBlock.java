package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.shapes.ShapeGetter;

public class SittingToyBlock extends DirectionalToyBlock implements SittingBlock {

    public SittingToyBlock(ShapeGetter shape, Properties properties) {
        super(shape, properties);
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if (canSitOn(level, pos, player, state.getValue(BlockStateProperties.HORIZONTAL_FACING), false)) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
