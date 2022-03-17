package tech.thatgravyboat.playdate.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
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
        BlockEntityRenderers.register(ModBlockEntities.ROBOT.get(), PlushieBlockRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.AROMANTIC_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.ASEXUAL_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.BISEXUAL_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.PRIDE_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.GENDERQUEER_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.LESBIAN_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.NONBINARY_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.PANSEXUAL_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.TRANS_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.PANDA_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.POLAR_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.STUFFIE_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.COOL_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.BROWN_CUB.get(), PlushieBlockRenderer::createCuddleCub);
        BlockEntityRenderers.register(ModBlockEntities.HONEY_CUB.get(), PlushieBlockRenderer::createCuddleCub);

        EntityRenderers.register(ModEntities.PETUNIA_PIG.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.PETUNIA_PIG_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.HAPPY_SUN.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.HAPPY_SUN_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.LOLLIPOP_CLOWN.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.LOLLIPOP_CLOWN_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.STUFFIE.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.STUFFIE_TOY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.SOCK_MONKEY.get(), PlushieEntityRenderer::create);
        BlockEntityRenderers.register(ModBlockEntities.SOCK_MONKEY.get(), ToyBlockRenderer::create);

        EntityRenderers.register(ModEntities.BALLOON.get(), BalloonEntityRenderer::new);

        MenuScreens.register(ModContainers.PIGGY_BANK.get(), PiggyBankScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MESH_WALL.get(), RenderType.cutout());
    }

    public static void onItemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().register(
                (stack, tint) -> tint == 0 && stack.getItem() instanceof BalloonItem balloon ? balloon.getColor(stack) : 0xffffffff,
                ModItems.BALLOON.get());
    }
}
