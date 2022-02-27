package tech.thatgravyboat.playdate.common.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.PlayDate;

public class ModItemGroups {

    public static final CreativeModeTab GROUP = new CreativeModeTab(PlayDate.MODID + ".playdate_group") {

        @Override
        @NotNull
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STUFFING.get());
        }
    };
}
