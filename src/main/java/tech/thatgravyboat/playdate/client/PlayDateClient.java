package tech.thatgravyboat.playdate.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.thatgravyboat.playdate.client.rendering.BalloonEntityRenderer;
import tech.thatgravyboat.playdate.client.rendering.ToyBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieEntityRenderer;
import tech.thatgravyboat.playdate.client.screens.PiggyBankScreen;
import tech.thatgravyboat.playdate.common.blocks.ModBlockEntities;
import tech.thatgravyboat.playdate.common.containers.ModContainers;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.item.BalloonItem;
import tech.thatgravyboat.playdate.common.item.ModItems;

public class PlayDateClient {

    public static void init(final FMLClientSetupEvent event) {
        BlockEntityRenderers.register(ModBlockEntities.CREEPER_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.DINO_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.ENDERMAN_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.HAPPY_SUN_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.PETUNIA_PIG_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.RUBBER_DUCKY_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.TOADSTOOL_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.WHEELIE_PUP_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.ZOMBIE_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.CYMBAL_MONKEY.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.FOX_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.SNOWY_FOX_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.PIGGY_BANK.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.RABBIT_PLUSHIE.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.SOCK_MONKEY.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.ROBOT.get(), PlushieBlockRenderer::create);

        EntityRenderers.register(ModEntities.PETUNIA_PIG.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.PETUNIA_PIG_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.HAPPY_SUN.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.HAPPY_SUN_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.LOLLIPOP_CLOWN.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.LOLLIPOP_CLOWN_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.BALLOON.get(), BalloonEntityRenderer::new);

        MenuScreens.register(ModContainers.PIGGY_BANK.get(), PiggyBankScreen::new);
    }

    public static void onItemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().register(
                (stack, tint) -> tint == 0 && stack.getItem() instanceof BalloonItem balloon ? balloon.getColor(stack) : 0xffffffff,
                ModItems.BALLOON.get());
    }
}
