package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.sound.SoundEvent;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.function.Supplier;

public class ModSounds {

    public static final Supplier<SoundEvent> MUSIC_BOX = CommonServices.REGISTRY.registerSound("music_box", () -> new SoundEvent(Playdate.modId("music_box")));

    public static void register() {
        //Init class
    }
}
