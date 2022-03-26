package tech.thatgravyboat.playdate.common.registry.base;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractRegistry<T> {

    protected final LinkedList<Supplier<T>> objects = new LinkedList<>();

    public abstract Supplier<T> register(String id, Supplier<T> supplier);

    public List<Supplier<T>> values() {
        return objects;
    }
}
