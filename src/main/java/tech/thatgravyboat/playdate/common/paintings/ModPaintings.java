package tech.thatgravyboat.playdate.common.paintings;

import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;

public class ModPaintings {

    public static final DeferredRegister<Motive> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PlayDate.MODID);

    public static final RegistryObject<Motive> PLAYDATE_POSTER = PAINTINGS.register("playdate_poster", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> LOLLIPOP_POSTER = PAINTINGS.register("lollipop_poster", () -> new Motive(16, 32));
    public static final RegistryObject<Motive> PETUNIA_POSTER = PAINTINGS.register("petunia_poster", () -> new Motive(16, 32));
    public static final RegistryObject<Motive> HAPPY_SUN_POSTER = PAINTINGS.register("happy_sun_poster", () -> new Motive(16, 32));

}
