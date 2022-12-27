package tech.thatgravyboat.playdate.common.registry.fabric;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import tech.thatgravyboat.playdate.common.registry.ModMenus;

public class ModMenusImpl {
    public static <T extends AbstractContainerMenu> MenuType<T> createMenu(ModMenus.MenuSupplier<T> supplier) {
        return new MenuType<>(supplier::create);
    }
}
