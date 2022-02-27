package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class CreeperPlushieBlock extends PlushieBlock {
    public CreeperPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Properties settings) {
        super(blockEntityType, settings);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            level.explode(null, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, .5f, Explosion.BlockInteraction.NONE);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
