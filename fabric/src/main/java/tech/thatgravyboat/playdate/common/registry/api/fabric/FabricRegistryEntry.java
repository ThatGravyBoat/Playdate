package tech.thatgravyboat.playdate.common.registry.api.fabric;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;

import java.util.function.Supplier;

public class FabricRegistryEntry<T> implements RegistryEntry<T> {

    private final ResourceLocation id;
    private final T value;

    private FabricRegistryEntry(ResourceLocation id, T value) {
        this.id = id;
        this.value = value;
    }

    public static <T, I extends T> FabricRegistryEntry<I> of(Registry<T> registry, ResourceLocation id, Supplier<I> supplier) {
        return new FabricRegistryEntry<>(id, Registry.register(registry, id, supplier.get()));
    }

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }
}
