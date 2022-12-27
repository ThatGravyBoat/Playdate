package tech.thatgravyboat.playdate.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import tech.thatgravyboat.playdate.client.PlaydateClient;

public class PlaydateFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PlaydateClient.init();
        PlaydateClient.onEntityRender(EntityRendererRegistry::register);
    }
}
