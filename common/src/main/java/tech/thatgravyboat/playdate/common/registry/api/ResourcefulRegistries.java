package tech.thatgravyboat.playdate.common.registry.api;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;

public class ResourcefulRegistries {

    public static <T> ResourcefulRegistry<T> create(ResourcefulRegistry<T> parent) {
        return new ResourcefulRegistryChild<>(parent);
    }

    @ExpectPlatform
    public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        throw new AssertionError();
    }
}
