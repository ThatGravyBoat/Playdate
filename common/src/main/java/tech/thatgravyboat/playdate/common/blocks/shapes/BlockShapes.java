package tech.thatgravyboat.playdate.common.blocks.shapes;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import tech.thatgravyboat.playdate.common.blocks.shapes.ShapeGetter;

public final class BlockShapes {

    public static final ShapeGetter DINO = new ShapeGetter(Shapes.or(
            Block.box(4, 4, 5, 12, 12, 14),
            Block.box(6, 3.7, -1, 10, 9.7, 5),
            Block.box(5, 10, 10, 11, 16, 16),
            Block.box(5, 10, 16, 11, 15, 19),
            Block.box(2.5, 0, 6, 7.5, 8, 11),
            Block.box(8.5, 0, 6, 13.5, 8, 11)
    ), Shapes.or(
            Block.box(2, 4, 4, 11, 12, 12),
            Block.box(11, 3.7, 6, 17, 9.7, 10),
            Block.box(0, 10, 5, 6, 16, 11),
            Block.box(-3, 10, 5, 0, 15, 11),
            Block.box(5, 0, 2.5, 10, 8, 7.5),
            Block.box(5, 0, 8.5, 10, 8, 13.5)
    ), Shapes.or(
            Block.box(4, 4, 2, 12, 12, 11),
            Block.box(6, 3.7, 11, 10, 9.7, 17),
            Block.box(5, 10, 0, 11, 16, 6),
            Block.box(5, 10, -3, 11, 15, 0),
            Block.box(2.5, 0, 5, 7.5, 8, 10),
            Block.box(8.5, 0, 5, 13.5, 8, 10)
    ), Shapes.or(
            Block.box(5, 4, 4, 14, 12, 12),
            Block.box(-1, 3.7, 6, 5, 9.7, 10),
            Block.box(10, 10, 5, 16, 16, 11),
            Block.box(16, 10, 5, 19, 15, 11),
            Block.box(6, 0, 2.5, 11, 8, 7.5),
            Block.box(6, 0, 8.5, 11, 8, 13.5)
    ));

    public static final ShapeGetter RINO_TOWER = new ShapeGetter(Shapes.or(
            Block.box(7, 14, 7, 9, 16, 9),
            Block.box(2, 0, 2, 14, 2, 14),
            Block.box(3, 2, 3, 13, 5, 13),
            Block.box(4, 5, 4, 12, 8, 12),
            Block.box(5, 8, 5, 11, 11, 11),
            Block.box(6, 11, 6, 10, 14, 10)
    ));

    public static final ShapeGetter ROCKING_HORSE = new ShapeGetter(
            Shapes.or(
                    Block.box(5.5, 0, 1, 7.5, 2, 15),
                    Block.box(8.5, 0, 1, 10.5, 2, 15),
                    Block.box(5, 7, 3, 11, 13, 14),
                    Block.box(6, 13, 10, 10, 19, 14),
                    Block.box(6, 15, 14, 10, 19, 17),
                    Block.box(5.5, 2, 4, 10.5, 7, 13)
            ),
            Shapes.or(
                    Block.box(1, 0, 8.5, 15, 2, 10.5),
                    Block.box(1, 0, 5.5, 15, 2, 7.5),
                    Block.box(2, 7, 5, 13, 13, 11),
                    Block.box(2, 13, 6, 6, 19, 10),
                    Block.box(-1, 15, 6, 2, 19, 10),
                    Block.box(3, 2, 5.5, 12, 7, 10.5)
            ),
            Shapes.or(
                    Block.box(5.5, 0, 1, 7.5, 2, 15),
                    Block.box(8.5, 0, 1, 10.5, 2, 15),
                    Block.box(5, 7, 2, 11, 13, 13),
                    Block.box(6, 13, 2, 10, 19, 6),
                    Block.box(6, 15, -1, 10, 19, 2),
                    Block.box(5.5, 2, 3, 10.5, 7, 12)
            ),
            Shapes.or(
                    Block.box(1, 0, 8.5, 15, 2, 10.5),
                    Block.box(1, 0, 5.5, 15, 2, 7.5),
                    Block.box(3, 7, 5, 14, 13, 11),
                    Block.box(10, 13, 6, 14, 19, 10),
                    Block.box(14, 15, 6, 17, 19, 10),
                    Block.box(4, 2, 5.5, 13, 7, 10.5)
            )
    );

    public static final ShapeGetter TEDDY_BEAR = new ShapeGetter(Block.box(3, 0, 3, 13, 13, 13));

    public static final ShapeGetter TOY_BOAT = new ShapeGetter(
            Shapes.or(
                    Block.box(3, 0, 5, 13, 3, 11),
                    Block.box(2, 3, 4, 14, 5, 12)
            ),
            Shapes.or(
                    Block.box(5, 0, 3, 11, 3, 13),
                    Block.box(4, 3, 2, 12, 5, 14)
            )
    );

    public static final ShapeGetter TOY_TRAIN = new ShapeGetter(
            Block.box(1.5, 0, 3.5, 14.5, 13, 13.5),
            Block.box(3, 0, 2, 13, 13, 15)
    );

    public static final ShapeGetter MUSIC_BOX = new ShapeGetter(
            Shapes.or(
                    Block.box(6, 6, 3, 10, 12, 13),
                    Block.box(2, 0, 2, 14, 6, 14)
            ),
            Shapes.or(
                    Block.box(3, 6, 6, 13, 12, 10),
                    Block.box(2, 0, 2, 14, 6, 14)
            )
    );

    public static final ShapeGetter PIGGY_BANK = new ShapeGetter(
            Block.box(2.5, 0, 2, 13.5, 11, 14)
    );

}
