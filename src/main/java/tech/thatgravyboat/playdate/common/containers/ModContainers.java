package tech.thatgravyboat.playdate.common.containers;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;

public class ModContainers {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, PlayDate.MODID);

    public static final RegistryObject<MenuType<PiggyBankContainer>> PIGGY_BANK = MENUS.register("piggy_bank",
            () -> IForgeMenuType.create(PiggyBankContainer::new));

}
