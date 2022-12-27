package tech.thatgravyboat.playdate.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.menus.Basic5SlotMenu;
import tech.thatgravyboat.playdate.common.menus.ToyBenchMenu;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModMenus {

    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(Registry.MENU, Playdate.MOD_ID);

    public static final RegistryEntry<MenuType<ToyBenchMenu>> TOY_BENCH = MENUS.register("toy_bench", () -> createMenu(ToyBenchMenu::new));
    public static final RegistryEntry<MenuType<Basic5SlotMenu>> BASIC_5 = MENUS.register("basic_5", () -> createMenu(Basic5SlotMenu::new));

    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> createMenu(MenuSupplier<T> supplier) {
        throw new AssertionError();
    }

    public interface MenuSupplier<T extends AbstractContainerMenu> {
        T create(int i, Inventory inventory);
    }
}
