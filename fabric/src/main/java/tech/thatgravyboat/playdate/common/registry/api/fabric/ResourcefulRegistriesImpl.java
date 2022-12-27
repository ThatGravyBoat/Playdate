package tech.thatgravyboat.playdate.common.registry.api.fabric;

import net.minecraft.core.Registry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ResourcefulRegistriesImpl {
    public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new FabricResourcefulRegistry<>(registry, id);
    }
}
