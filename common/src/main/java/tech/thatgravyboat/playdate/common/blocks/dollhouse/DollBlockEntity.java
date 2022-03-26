package tech.thatgravyboat.playdate.common.blocks.dollhouse;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class DollBlockEntity extends PlushieBlockEntity {

    private final Doll doll;

    public DollBlockEntity(Doll doll, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(PlushieItem.DOLL, type, pos, state);
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
