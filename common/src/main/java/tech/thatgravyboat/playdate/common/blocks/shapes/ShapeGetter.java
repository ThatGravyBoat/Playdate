package tech.thatgravyboat.playdate.common.blocks.shapes;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ShapeGetter {

    private final VoxelShape[] shapes;

    public ShapeGetter(VoxelShape... shapes) {
        this.shapes = shapes;
    }

    public VoxelShape getShape(@Nullable Direction direction) {
        if (shapes == null || shapes.length == 0) {
            return Shapes.block();
        }
        if (shapes.length == 1 || direction == null) {
            return shapes[0];
        }
        if (shapes.length == 2) {
            return direction.getAxis() == Direction.Axis.X ? shapes[0] : shapes[1];
        }
        return shapes[direction.get2DDataValue()];
    }
}
