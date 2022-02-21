package tech.thatgravyboat.playdate.common;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;

public class ModPaintings {

    public static final PaintingMotive PLAYDATE_POSTER = new PaintingMotive(32, 32);
    public static final PaintingMotive LOLLIPOP_POSTER = new PaintingMotive(16, 32);
    public static final PaintingMotive PETUNIA_POSTER = new PaintingMotive(16, 32);
    public static final PaintingMotive HAPPY_SUN_POSTER = new PaintingMotive(16, 32);

    public static void register() {
        Registry.register(Registry.PAINTING_MOTIVE, Playdate.modId("playdate_poster"), PLAYDATE_POSTER);
        Registry.register(Registry.PAINTING_MOTIVE, Playdate.modId("lollipop_poster"), LOLLIPOP_POSTER);
        Registry.register(Registry.PAINTING_MOTIVE, Playdate.modId("petunia_poster"), PETUNIA_POSTER);
        Registry.register(Registry.PAINTING_MOTIVE, Playdate.modId("happy_sun_poster"), HAPPY_SUN_POSTER);
    }
}
