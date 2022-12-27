package tech.thatgravyboat.playdate.common.registry.api.fabric;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntries;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

import java.util.Collection;
import java.util.function.Supplier;

public class FabricResourcefulRegistry<T> implements ResourcefulRegistry<T> {

    private final RegistryEntries<T> entries = new RegistryEntries<>();
    private final Registry<T> registry;
    private final String id;

    public FabricResourcefulRegistry(Registry<T> registry, String id) {
        this.registry = registry;
        this.id = id;
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return entries.add(FabricRegistryEntry.of(this.registry, new ResourceLocation(this.id, id), supplier));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void init() {
        // NO-OP
    }
}
