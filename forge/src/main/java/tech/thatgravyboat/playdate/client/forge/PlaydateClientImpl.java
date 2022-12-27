package tech.thatgravyboat.playdate.client.forge;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import tech.thatgravyboat.playdate.client.PlaydateClient;

public class PlaydateClientImpl {
    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void registerScreen(MenuType<? extends M> menuType, PlaydateClient.ScreenConstructor<M, U> screenConstructor) {
        MenuScreens.register(menuType, screenConstructor::create);
    }

    public static void registerRenderType(RenderType type, Block... blocks) {
        for (Block block : blocks) {
            //noinspection removal
            ItemBlockRenderTypes.setRenderLayer(block, type);
        }
    }
}
