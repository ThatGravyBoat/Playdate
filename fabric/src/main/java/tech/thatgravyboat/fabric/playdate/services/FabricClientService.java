package tech.thatgravyboat.fabric.playdate.services;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.fabric.playdate.client.DollHouseBlockRenderer;
import tech.thatgravyboat.fabric.playdate.client.MusicBoxBlockRenderer;
import tech.thatgravyboat.fabric.playdate.client.PlushieBlockRenderer;
import tech.thatgravyboat.fabric.playdate.client.ToyBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.ToyBlockModel;
import tech.thatgravyboat.playdate.client.rendering.dollhouse.DollHouseBlockModel;
import tech.thatgravyboat.playdate.client.rendering.musicbox.MusicBoxBlockModel;
import tech.thatgravyboat.playdate.client.rendering.player.PlayerPlushieBlockModel;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieBlockModel;
import tech.thatgravyboat.playdate.platform.services.IClientHelper;

public class FabricClientService implements IClientHelper {

    @Override
    public void setRenderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }

    @Override
    public <E extends Entity> void registerEntityRenderer(EntityType<E> type, EntityRendererFactory<E> factory) {
        EntityRendererRegistry.register(type, factory);
    }

    @Override
    public <E extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<E> type, BlockEntityRendererFactory<E> factory) {
        BlockEntityRendererRegistry.register(type, factory);
    }

    @Override
    public void registerItemRenderer(Item item, GeoItemRenderer renderer) {
        GeoItemRenderer.registerItemRenderer(item, renderer);
    }

    @Override
    public void registerItemColor(ItemColorProvider provider, Item... items) {
        ColorProviderRegistry.ITEM.register(provider, items);
    }

    @Override
    public <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> void registerScreen(ScreenHandlerType<H> type, Factory<H, S> factory) {
        HandledScreens.register(type, factory::create);
    }

    @Override
    public void createPlushieRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new PlushieBlockRenderer<>(new PlushieBlockModel()));
    }

    @Override
    public void createPlayerPlushieRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new PlushieBlockRenderer<>(new PlayerPlushieBlockModel()));
    }

    @Override
    public void createToyRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new ToyBlockRenderer(new ToyBlockModel()));
    }

    @Override
    public void createDollHouseRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new DollHouseBlockRenderer(new DollHouseBlockModel()));
    }

    @Override
    public void createMusicBoxRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new MusicBoxBlockRenderer(new MusicBoxBlockModel()));
    }

}
