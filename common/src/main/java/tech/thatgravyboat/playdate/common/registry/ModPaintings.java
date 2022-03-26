package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.function.Supplier;

public class ModPaintings {

    public static final Supplier<PaintingMotive> PLAYDATE_POSTER = CommonServices.REGISTRY.registerPainting("playdate_poster",
            () -> new PaintingMotive(32, 32));
    public static final Supplier<PaintingMotive> LOLLIPOP_POSTER = CommonServices.REGISTRY.registerPainting("lollipop_poster",
            () -> new PaintingMotive(16, 32));
    public static final Supplier<PaintingMotive> PETUNIA_POSTER = CommonServices.REGISTRY.registerPainting("petunia_poster",
            () -> new PaintingMotive(16, 32));
    public static final Supplier<PaintingMotive> HAPPY_SUN_POSTER = CommonServices.REGISTRY.registerPainting("happy_sun_poster",
            () -> new PaintingMotive(16, 32));

    public static void register() {
        //Initialize class.
    }
}
