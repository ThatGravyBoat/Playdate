package tech.thatgravyboat.playdate.common.blocks.custom.piggybank;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class PiggyBankPlushieBlock extends PlushieBlock {
    public PiggyBankPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Properties settings) {
        super(blockEntityType, settings);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof PiggyBankPlushieBlockEntity screen) {
            player.openMenu(screen);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
