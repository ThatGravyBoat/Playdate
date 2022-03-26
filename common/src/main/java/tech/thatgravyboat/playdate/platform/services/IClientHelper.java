package tech.thatgravyboat.playdate.platform.services;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public interface IClientHelper {

    void setRenderLayer(Block block, RenderLayer layer);

    <E extends Entity> void registerEntityRenderer(EntityType<E> type, EntityRendererFactory<E> factory);

    <E extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<E> type, BlockEntityRendererFactory<E> factory);

    void registerItemRenderer(Item item, GeoItemRenderer renderer);

    void registerItemColor(ItemColorProvider provider, Item... items);

    <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> void registerScreen(ScreenHandlerType<H> type, Factory<H, S> factory);

    @FunctionalInterface
    interface Factory<H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> {
        @NotNull S create(H handler, PlayerInventory inventory, Text title);
    }

    void createPlushieRenderer(BlockEntityType<?> type);

    void createPlayerPlushieRenderer(BlockEntityType<?> type);

    void createToyRenderer(BlockEntityType<?> type);

    void createDollHouseRenderer(BlockEntityType<?> type);

    void createMusicBoxRenderer(BlockEntityType<?> type);
}
