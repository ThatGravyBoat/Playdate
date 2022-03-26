package tech.thatgravyboat.playdate.common.blocks.toys.custom.powered;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlock;

import java.util.function.Supplier;

public class PoweredPlushieBlock extends PlushieBlock {
    public PoweredPlushieBlock(Supplier<BlockEntityType<? extends BlockEntity>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
        this.setDefaultState(getDefaultState().with(Properties.POWERED, false));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        if (!world.isClient) {
            if (state.get(Properties.POWERED) != world.isReceivingRedstonePower(pos)) {
                world.setBlockState(pos, state.cycle(Properties.POWERED), 2);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.POWERED);
    }
}
