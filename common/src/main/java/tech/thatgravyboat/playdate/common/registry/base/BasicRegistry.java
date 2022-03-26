package tech.thatgravyboat.playdate.common.registry.base;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class BasicRegistry<T> extends AbstractRegistry<T> {

    private final BiFunction<String, Supplier<T>, Supplier<T>> register;

    public BasicRegistry(BiFunction<String, Supplier<T>, Supplier<T>> register) {
        this.register = register;
    }

    @Override
    public Supplier<T> register(String id, Supplier<T> supplier) {
        return register.apply(id, supplier);
    }
}
