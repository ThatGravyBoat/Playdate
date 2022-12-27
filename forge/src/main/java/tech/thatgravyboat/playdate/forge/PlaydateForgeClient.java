package tech.thatgravyboat.playdate.forge;

import net.minecraftforge.client.event.EntityRenderersEvent;
import tech.thatgravyboat.playdate.client.PlaydateClient;

public class PlaydateForgeClient {

    public static void init() {
        PlaydateClient.init();
    }

    public static void onEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        PlaydateClient.onEntityRender(event::registerEntityRenderer);
    }
}
