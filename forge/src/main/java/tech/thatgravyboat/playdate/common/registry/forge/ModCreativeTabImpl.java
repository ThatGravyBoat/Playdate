package tech.thatgravyboat.playdate.common.registry.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModCreativeTabImpl {
    public static CreativeModeTab createTab(ResourceLocation id, Supplier<ItemStack> icon) {
        return new CreativeModeTab(String.format("%s.%s", id.getNamespace(), id.getPath())) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }
        };
    }
}
