package tech.thatgravyboat.forge.playdate.services;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Pair;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.forge.playdate.client.DollHouseBlockRenderer;
import tech.thatgravyboat.forge.playdate.client.MusicBoxBlockRenderer;
import tech.thatgravyboat.forge.playdate.client.PlushieBlockRenderer;
import tech.thatgravyboat.forge.playdate.client.ToyBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.ToyBlockModel;
import tech.thatgravyboat.playdate.client.rendering.dollhouse.DollHouseBlockModel;
import tech.thatgravyboat.playdate.client.rendering.musicbox.MusicBoxBlockModel;
import tech.thatgravyboat.playdate.client.rendering.player.PlayerPlushieBlockModel;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieBlockModel;
import tech.thatgravyboat.playdate.platform.services.IClientHelper;

import java.util.ArrayList;
import java.util.List;

public class ForgeClientService implements IClientHelper {

    public static final List<Pair<ItemColorProvider, Item[]>> COLOR_PROVIDERS = new ArrayList<>();

    @Override
    public void setRenderLayer(Block block, RenderLayer layer) {
        RenderLayers.setRenderLayer(block, layer);
    }

    @Override
    public <E extends Entity> void registerEntityRenderer(EntityType<E> type, EntityRendererFactory<E> factory) {
        EntityRenderers.register(type, factory);
    }

    @Override
    public <E extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<E> type, BlockEntityRendererFactory<E> factory) {
        BlockEntityRendererFactories.register(type, factory);
    }

    @Override
    public void registerItemRenderer(Item item, GeoItemRenderer renderer) {
        //Do nothing as forge handles this differently
    }

    @Override
    public void registerItemColor(ItemColorProvider provider, Item... items) {
        COLOR_PROVIDERS.add(new Pair<>(provider, items));
    }

    @Override
    public <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> void registerScreen(ScreenHandlerType<H> type, Factory<H, S> factory) {
        HandledScreens.register(type, factory::create);
    }

    @Override
    public void createPlushieRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new PlushieBlockRenderer<>(context, new PlushieBlockModel()));
    }

    @Override
    public void createPlayerPlushieRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new PlushieBlockRenderer<>(context, new PlayerPlushieBlockModel()));
    }

    @Override
    public void createToyRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new ToyBlockRenderer(context, new ToyBlockModel()));
    }

    @Override
    public void createDollHouseRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new DollHouseBlockRenderer(context, new DollHouseBlockModel()));
    }

    @Override
    public void createMusicBoxRenderer(BlockEntityType<?> type) {
        registerBlockEntityRenderer(type, (context) -> new MusicBoxBlockRenderer(context, new MusicBoxBlockModel()));
    }

}
