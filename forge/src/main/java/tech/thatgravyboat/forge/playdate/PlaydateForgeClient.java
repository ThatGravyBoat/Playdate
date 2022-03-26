package tech.thatgravyboat.forge.playdate;

import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tech.thatgravyboat.forge.playdate.services.ForgeClientService;
import tech.thatgravyboat.playdate.client.PlaydateClient;

public class PlaydateForgeClient {

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlaydateForgeClient::onItemColors);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlaydateForgeClient::onClientInit);
    }

    public static void onClientInit(FMLCommonSetupEvent event) {
        PlaydateClient.init();
    }

    public static void onItemColors(ColorHandlerEvent.Item event) {
        PlaydateClient.initColors();
        ForgeClientService.COLOR_PROVIDERS.forEach(colors -> event.getItemColors().register(colors.getLeft(), colors.getRight()));
    }
}
