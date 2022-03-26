package tech.thatgravyboat.playdate.common.items;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class DollItem extends PlushItem {

    private final Doll doll;

    public DollItem(Block block, Doll doll, Settings settings) {
        super(block, PlushieItem.DOLL, settings);
        this.doll = doll;
    }

    @Override
    public Identifier getTexture() {
        return doll.doll;
    }

    @Override
    public Identifier getModel() {
        return doll.dollModel;
    }
}
