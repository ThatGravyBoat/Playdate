package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.screen.ScreenHandlerType;
import tech.thatgravyboat.playdate.common.containers.Basic5SlotContainer;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.function.Supplier;

public class ModContainers {

    public static final Supplier<ScreenHandlerType<Basic5SlotContainer>> BASIC_CONTAINER = CommonServices.REGISTRY.registerContainer("basic_container", Basic5SlotContainer::new);

    public static void register() {
        //Initialize class.
    }
}
