package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tech.thatgravyboat.playdate.common.entities.SittingEntity;

public interface SittingBlock {

    default boolean canSitOn(Level level, BlockPos pos, Player player, Direction direction, boolean canRotate) {
        if (!SittingEntity.getMap(level).contains(pos) && !level.isClientSide()) {
            SittingEntity seat = SittingEntity.of(level, pos, direction, canRotate);
            level.addFreshEntity(seat);
            player.startRiding(seat);
            return true;
        }
        return false;
    }
}