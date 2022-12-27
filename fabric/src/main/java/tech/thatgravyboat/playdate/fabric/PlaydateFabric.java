package tech.thatgravyboat.playdate.fabric;

import tech.thatgravyboat.playdate.Playdate;
import net.fabricmc.api.ModInitializer;

public class PlaydateFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Playdate.init();
    }
}