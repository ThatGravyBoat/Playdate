package tech.thatgravyboat.playdate.common.blocks;

import com.google.common.collect.Lists;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class EightDirectionProperty extends EnumProperty<EightDirectionProperty.Direction> {

    protected EightDirectionProperty() {
        super("facing", EightDirectionProperty.Direction.class, Lists.newArrayList(EightDirectionProperty.Direction.VALUES));
    }

    public enum Direction implements StringIdentifiable {
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
        public String asString() {
            return this.name;
        }
    }
}
