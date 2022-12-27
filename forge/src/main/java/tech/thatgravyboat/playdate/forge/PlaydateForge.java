package tech.thatgravyboat.playdate.forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tech.thatgravyboat.playdate.Playdate;

@Mod(Playdate.MOD_ID)
public class PlaydateForge {
    public PlaydateForge() {
        Playdate.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlaydateForge::onClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlaydateForgeClient::onEntityRenderer);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        PlaydateForgeClient.init();
    }
}