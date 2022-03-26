package tech.thatgravyboat.fabric.playdate;

import net.fabricmc.api.ClientModInitializer;
import tech.thatgravyboat.playdate.client.PlaydateClient;

public class PlaydateFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PlaydateClient.init();
        PlaydateClient.initColors();
    }
}
