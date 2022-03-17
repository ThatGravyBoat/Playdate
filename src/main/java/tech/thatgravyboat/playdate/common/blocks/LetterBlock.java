package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.constants.Letters;

import java.util.Locale;

public class LetterBlock extends Block {

    private final int id;

    public LetterBlock(int id, Properties p_49795_) {
        super(p_49795_);
        this.id = id;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        if (stack.getItem() instanceof ShearsItem) {
            if (!level.isClientSide) {
                if (id == -2) {
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                    level.setBlockAndUpdate(pos, ModBlocks.LIGHT_SOFTWOOD.get().defaultBlockState());
                } else {
                    Block block = null;
                    var name = stack.getHoverName().getString().toLowerCase(Locale.ROOT);
                    if (name.length() == 1) {
                        block = Letters.getLetterBlock(name.charAt(0));
                    }
                    if (block == null) {
                        block = ModBlocks.LETTER_BLOCKS.get((id + 1) % ModBlocks.LETTER_BLOCKS.size()).get();
                    }
                    level.setBlockAndUpdate(pos, block.defaultBlockState());
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hit);
    }
}
