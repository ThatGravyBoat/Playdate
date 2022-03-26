package tech.thatgravyboat.playdate.platform;

import tech.thatgravyboat.playdate.platform.services.IPlatformHelper;
import tech.thatgravyboat.playdate.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class CommonServices {

    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
}
