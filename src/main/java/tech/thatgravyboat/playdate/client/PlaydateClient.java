package tech.thatgravyboat.playdate.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.*;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieEntityRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieItemRenderer;
import tech.thatgravyboat.playdate.client.screens.PiggyBankScreen;
import tech.thatgravyboat.playdate.common.blocks.ModBlockEntities;
import tech.thatgravyboat.playdate.common.containers.ModContainers;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.items.BalloonItem;
import tech.thatgravyboat.playdate.common.items.ModItems;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class PlaydateClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockEntityRendererRegistry.register(ModBlockEntities.CREEPER_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.CREEPER_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.DINO_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.DINO_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.ENDERMAN_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.ENDERMAN_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.HAPPY_SUN_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.HAPPY_SUN_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.LOLLIPOP_CLOWN_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.PETUNIA_PIG_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.PETUNIA_PIG_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.RUBBER_DUCKY_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.RUBBER_DUCKY_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.TOADSTOOL_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.TOADSTOOL_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.WHEELIE_PUP_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.WHEELIE_PUP_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.ZOMBIE_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.ZOMBIE_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.CYMBAL_MONKEY, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.CYMBAL_MONKEY, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.FOX_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.FOX_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.SNOWY_FOX_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.SNOWY_FOX_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.PIGGY_BANK, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.PIGGY_BANK, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.RABBIT_PLUSHIE, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.RABBIT_PLUSHIE, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.SOCK_MONKEY, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.SOCK_MONKEY, PlushieItemRenderer.create());

        BlockEntityRendererRegistry.register(ModBlockEntities.ROBOT, PlushieBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.ROBOT, PlushieItemRenderer.create());

        EntityRendererRegistry.register(ModEntities.PETUNIA_PIG, PlushieEntityRenderer::create);
        BlockEntityRendererRegistry.register(ModBlockEntities.PETUNIA_PIG_TOY, ToyBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.PETUNIA_PIG_TOY, PlushieItemRenderer.create());

        EntityRendererRegistry.register(ModEntities.HAPPY_SUN, PlushieEntityRenderer::create);
        BlockEntityRendererRegistry.register(ModBlockEntities.HAPPY_SUN_TOY, ToyBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.HAPPY_SUN_TOY, PlushieItemRenderer.create());

        EntityRendererRegistry.register(ModEntities.LOLLIPOP_CLOWN, PlushieEntityRenderer::create);
        BlockEntityRendererRegistry.register(ModBlockEntities.LOLLIPOP_CLOWN_TOY, ToyBlockRenderer::create);
        GeoItemRenderer.registerItemRenderer(ModItems.LOLLIPOP_CLOWN_TOY, PlushieItemRenderer.create());

        EntityRendererRegistry.register(ModEntities.BALLOON, BalloonRenderer::new);

        ScreenRegistry.register(ModContainers.PIGGY_BANK, PiggyBankScreen::new);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> tintIndex == 0 && stack.getItem() instanceof BalloonItem balloon ? balloon.getColor(stack) : 0xffffff,
                ModItems.BALLOON);

    }
}
