package tech.thatgravyboat.playdate.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import tech.thatgravyboat.playdate.client.screens.Basic5SlotScreen;
import tech.thatgravyboat.playdate.client.screens.ToyBenchScreen;
import tech.thatgravyboat.playdate.common.registry.ModBlocks;
import tech.thatgravyboat.playdate.common.registry.ModEntities;
import tech.thatgravyboat.playdate.common.registry.ModMenus;

public class PlaydateClient {

    public static void init() {
        initScreens();
        initRenderTypes();
    }

    public static void initScreens() {
        registerScreen(ModMenus.TOY_BENCH.get(), ToyBenchScreen::new);
        registerScreen(ModMenus.BASIC_5.get(), Basic5SlotScreen::new);
    }

    public static void onEntityRender(Renderers renderers) {
        renderers.registerEntity(ModEntities.SEAT.get(), NoopRenderer::new);
    }

    public static void initRenderTypes() {
        registerRenderType(RenderType.cutout(), ModBlocks.MUSIC_BOX.get(), ModBlocks.DINO.get(), ModBlocks.MUSIC_BOX.get());
    }

    @ExpectPlatform
    public static void registerRenderType(RenderType type, Block... blocks) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void registerScreen(MenuType<? extends M> menuType, ScreenConstructor<M, U> screenConstructor) {
        throw new AssertionError();
    }

    @FunctionalInterface
    public interface ScreenConstructor<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> {
        U create(T abstractContainerMenu, Inventory inventory, Component component);
    }

    public interface Renderers {

        <T extends Entity> void registerEntity(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
