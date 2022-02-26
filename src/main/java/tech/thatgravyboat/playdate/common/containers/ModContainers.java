package tech.thatgravyboat.playdate.common.containers;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import tech.thatgravyboat.playdate.Playdate;

public class ModContainers {

    public static final ScreenHandlerType<PiggyBankContainer> PIGGY_BANK =
            ScreenHandlerRegistry.registerSimple(new Identifier(Playdate.MODID, "piggy_bank"), PiggyBankContainer::new);

    public static void register() {
        //Do Nothing but init the class.
    }

}
