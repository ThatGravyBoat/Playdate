package tech.thatgravyboat.playdate.common.registry.api.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;

public class ForgeRegistryEntry<T> implements RegistryEntry<T> {

    private final RegistryObject<T> object;

    public ForgeRegistryEntry(RegistryObject<T> object) {
        this.object = object;
    }

    @Override
    public T get() {
        return object.get();
    }

    @Override
    public ResourceLocation getId() {
        return object.getId();
    }
}
