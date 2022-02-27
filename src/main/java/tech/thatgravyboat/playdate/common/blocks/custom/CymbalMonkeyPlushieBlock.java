package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class CymbalMonkeyPlushieBlock extends PlushieBlock {
    public CymbalMonkeyPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Properties settings) {
        super(blockEntityType, settings);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        var instruments = NoteBlockInstrument.values();
        var sound = instruments[level.random.nextInt(instruments.length)].getSoundEvent();
        level.playSound(player, pos, sound, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
