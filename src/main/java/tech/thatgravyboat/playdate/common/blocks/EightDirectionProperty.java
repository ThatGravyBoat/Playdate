package tech.thatgravyboat.playdate.common.blocks;

import com.google.common.collect.Lists;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

public class EightDirectionProperty extends EnumProperty<EightDirectionProperty.Direction> {

    protected EightDirectionProperty() {
        super("facing", EightDirectionProperty.Direction.class, Lists.newArrayList(EightDirectionProperty.Direction.VALUES));
    }

    public enum Direction implements StringRepresentable {
        NORTH("north"),
        NORTH_EAST("north_east"),
        EAST("east"),
        SOUTH_EAST("south_east"),
        SOUTH("south"),
        SOUTH_WEST("south_west"),
        WEST("west"),
        NORTH_WEST("north_west");

        public static final Direction[] VALUES = values();

        private final String name;

        Direction(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }
}
