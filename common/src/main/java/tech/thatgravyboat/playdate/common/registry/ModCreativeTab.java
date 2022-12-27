package tech.thatgravyboat.playdate.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import tech.thatgravyboat.playdate.Playdate;

import java.util.function.Supplier;

public class ModCreativeTab {

    public static final CreativeModeTab TAB = createTab(new ResourceLocation(Playdate.MOD_ID, Playdate.MOD_ID), () -> new ItemStack(ModItems.TOY_BENCH.get()));

    @ExpectPlatform
    public static CreativeModeTab createTab(ResourceLocation id, Supplier<ItemStack> icon) {
        throw new AssertionError();
    }
}
