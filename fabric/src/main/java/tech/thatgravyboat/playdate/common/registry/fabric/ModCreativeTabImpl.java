package tech.thatgravyboat.playdate.common.registry.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModCreativeTabImpl {
    public static CreativeModeTab createTab(ResourceLocation id, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(id, icon);
    }
}
