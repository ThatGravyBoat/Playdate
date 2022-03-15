package tech.thatgravyboat.playdate.common.items;

import net.minecraft.block.Block;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class CuddleCubItem extends PlushItem {

    private final CuddleCub cuddleCub;

    public CuddleCubItem(Block block, CuddleCub cub, Settings settings) {
        super(block, PlushieItem.CUDDLE_CUB, settings);
        this.cuddleCub = cub;
    }

    public CuddleCub getCuddleCub() {
        return cuddleCub;
    }
}
