package tech.thatgravyboat.playdate.client;

import net.minecraft.client.render.RenderLayer;
import tech.thatgravyboat.playdate.client.rendering.BalloonRenderer;
import tech.thatgravyboat.playdate.client.rendering.dollhouse.DollHouseItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.musicbox.MusicBoxItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.player.PlayerPlushieItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieEntityRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieItemRenderer;
import tech.thatgravyboat.playdate.client.screens.Basic5SlotScreen;
import tech.thatgravyboat.playdate.common.items.BalloonItem;
import tech.thatgravyboat.playdate.common.registry.*;
import tech.thatgravyboat.playdate.platform.ClientServices;

public class PlaydateClient {

    public static void init() {

        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.CREEPER_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.DINO_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.ENDERMAN_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.HAPPY_SUN_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.PETUNIA_PIG_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.RUBBER_DUCKY_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.WHEELIE_PUP_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.ZOMBIE_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.CYMBAL_MONKEY.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.FOX_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.SNOWY_FOX_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.PIGGY_BANK.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.RABBIT_PLUSHIE.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.ROBOT.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.DUMMY.get());

        ClientServices.CLIENT.registerItemRenderer(ModItems.CREEPER_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.DINO_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ENDERMAN_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.HAPPY_SUN_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.LOLLIPOP_CLOWN_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PETUNIA_PIG_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.RUBBER_DUCKY_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.WHEELIE_PUP_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ZOMBIE_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.CYMBAL_MONKEY.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.FOX_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.SNOWY_FOX_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PIGGY_BANK.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.RABBIT_PLUSHIE.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ROBOT.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.DUMMY.get(), PlushieItemRenderer.create());

        //region Cuddle Cubs
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.AROMANTIC_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.ASEXUAL_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.BISEXUAL_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.PRIDE_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.GENDERQUEER_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.LESBIAN_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.NONBINARY_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.PANSEXUAL_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.TRANS_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.PANDA_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.POLAR_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.STUFFIE_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.COOL_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.BROWN_CUB.get());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.HONEY_CUB.get());

        ClientServices.CLIENT.registerItemRenderer(ModItems.AROMANTIC_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ASEXUAL_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.BISEXUAL_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PRIDE_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.GENDERQUEER_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.LESBIAN_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.NONBINARY_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PANSEXUAL_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.TRANS_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PANDA_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.POLAR_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.STUFFIE_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.COOL_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.BROWN_CUB.get(), PlushieItemRenderer.create());
        ClientServices.CLIENT.registerItemRenderer(ModItems.HONEY_CUB.get(), PlushieItemRenderer.create());
        //endregion

        //region Player Plushies
        ClientServices.CLIENT.createPlayerPlushieRenderer(ModBlockEntities.STEVE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.STEVE.get(), PlayerPlushieItemRenderer.create());

        ClientServices.CLIENT.createPlayerPlushieRenderer(ModBlockEntities.ALEX.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ALEX.get(), PlayerPlushieItemRenderer.create());
        //endregion

        //region Dolls
        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.OAK_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.OAK_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.OAK_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.OAK_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.BIRCH_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.BIRCH_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.BIRCH_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.BIRCH_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.SPRUCE_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.SPRUCE_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.SPRUCE_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.SPRUCE_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.DARK_OAK_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.DARK_OAK_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.DARK_OAK_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.DARK_OAK_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.ACACIA_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ACACIA_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.ACACIA_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.ACACIA_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.JUNGLE_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.JUNGLE_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.JUNGLE_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.JUNGLE_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.CRIMSON_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.CRIMSON_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.CRIMSON_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.CRIMSON_DOLL.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.createDollHouseRenderer(ModBlockEntities.WARPED_DOLLHOUSE.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.WARPED_DOLLHOUSE.get(), DollHouseItemRenderer.create());
        ClientServices.CLIENT.createPlushieRenderer(ModBlockEntities.WARPED_DOLL.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.WARPED_DOLL.get(), PlushieItemRenderer.create());
        //endregion

        ClientServices.CLIENT.createMusicBoxRenderer(ModBlockEntities.MUSIC_BOX.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.MUSIC_BOX.get(), MusicBoxItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.PETUNIA_PIG.get(), PlushieEntityRenderer::create);
        ClientServices.CLIENT.createToyRenderer(ModBlockEntities.PETUNIA_PIG_TOY.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.PETUNIA_PIG_TOY.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.HAPPY_SUN.get(), PlushieEntityRenderer::create);
        ClientServices.CLIENT.createToyRenderer(ModBlockEntities.HAPPY_SUN_TOY.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.HAPPY_SUN_TOY.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.LOLLIPOP_CLOWN.get(), PlushieEntityRenderer::create);
        ClientServices.CLIENT.createToyRenderer(ModBlockEntities.LOLLIPOP_CLOWN_TOY.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.LOLLIPOP_CLOWN_TOY.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.STUFFIE.get(), PlushieEntityRenderer::create);
        ClientServices.CLIENT.createToyRenderer(ModBlockEntities.STUFFIE_TOY.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.STUFFIE_TOY.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.SOCK_MONKEY.get(), PlushieEntityRenderer::create);
        ClientServices.CLIENT.createToyRenderer(ModBlockEntities.SOCK_MONKEY.get());
        ClientServices.CLIENT.registerItemRenderer(ModItems.SOCK_MONKEY.get(), PlushieItemRenderer.create());

        ClientServices.CLIENT.registerEntityRenderer(ModEntities.BALLOON.get(), BalloonRenderer::new);
        ClientServices.CLIENT.registerScreen(ModContainers.BASIC_CONTAINER.get(), Basic5SlotScreen::new);
        ClientServices.CLIENT.setRenderLayer(ModBlocks.MESH_WALL.get(), RenderLayer.getCutout());
    }

    public static void initColors() {
        ClientServices.CLIENT.registerItemColor(
                (stack, tintIndex) -> tintIndex == 0 && stack.getItem() instanceof BalloonItem balloon ? balloon.getColor(stack) : 0xffffff,
                ModItems.BALLOON.get());
    }
}
