package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.constants.Letters;

import java.util.Locale;

public class LetterBlock extends Block {

    private final int id;

    public LetterBlock(int id, Settings settings) {
        super(settings);
        this.id = id;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var stack = player.getStackInHand(hand);
        if (stack.getItem() instanceof ShearsItem) {
            if (!world.isClient) {
                if (id == -2) {
                    stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, ModBlocks.LIGHT_SOFTWOOD.getDefaultState());
                } else {
                    Block block = null;
                    String name = stack.getName().getString().toLowerCase(Locale.ROOT);
                    if (name.length() == 1) {
                        block = Letters.getLetterBlock(name.charAt(0));
                    }
                    if (block == null) {
                        block = ModBlocks.LETTER_BLOCKS.get((id + 1) % ModBlocks.LETTER_BLOCKS.size());
                    }
                    world.setBlockState(pos, block.getDefaultState());
                }
            }
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
