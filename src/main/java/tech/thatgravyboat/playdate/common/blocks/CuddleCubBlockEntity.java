package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class CuddleCubBlockEntity extends PlushieBlockEntity {

    private final CuddleCub cuddleCub;

    public CuddleCubBlockEntity(CuddleCub cub, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(PlushieItem.CUDDLE_CUB, type, pos, state);
        this.cuddleCub = cub;
    }

    public CuddleCub getCuddleCub() {
        return cuddleCub;
    }
}
