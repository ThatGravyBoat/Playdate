package tech.thatgravyboat.playdate.common.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.Letters;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.List;

public class ModItems {

    public static final FabricItemSettings GROUP_SETTINGS = new FabricItemSettings().group(Playdate.ITEM_GROUP);

    public static final Item STUFFING = new Item(GROUP_SETTINGS);
    public static final Item SOFTWOOD = new BlockItem(ModBlocks.SOFTWOOD, GROUP_SETTINGS);
    public static final Item LIGHT_SOFTWOOD = new BlockItem(ModBlocks.LIGHT_SOFTWOOD, GROUP_SETTINGS);
    public static final Item BALLPIT = new BlockItem(ModBlocks.BALLPIT, GROUP_SETTINGS);
    public static final Item MESH_WALL = new BlockItem(ModBlocks.MESH_WALL, GROUP_SETTINGS);
    public static final Item BOTTLED_SOUL = new Item(new FabricItemSettings().maxCount(1).group(Playdate.ITEM_GROUP));
    public static final Item BALLOON = new BalloonItem(BalloonType.COLORED, GROUP_SETTINGS);
    public static final Item SUN_BALLOON = new BalloonItem(BalloonType.SUN, GROUP_SETTINGS);
    public static final Item ROPE = new RopeItem(GROUP_SETTINGS);

    public static final PlushItem PETUNIA_PIG_TOY = new PlushItem(ModBlocks.PETUNIA_PIG_TOY, PlushieItem.PETUNIA_PIG_TOY, GROUP_SETTINGS);
    public static final PlushItem HAPPY_SUN_TOY = new PlushItem(ModBlocks.HAPPY_SUN_TOY, PlushieItem.HAPPY_SUN_TOY, GROUP_SETTINGS);
    public static final PlushItem LOLLIPOP_CLOWN_TOY = new PlushItem(ModBlocks.LOLLIPOP_CLOWN_TOY, PlushieItem.LOLLIPOP_CLOWN_TOY, GROUP_SETTINGS);
    public static final PlushItem STUFFIE_TOY = new PlushItem(ModBlocks.STUFFIE_TOY, PlushieItem.STUFFIE_TOY, GROUP_SETTINGS);

    public static final PlushItem CREEPER_PLUSHIE = new PlushItem(ModBlocks.CREEPER_PLUSHIE, PlushieItem.CREEPER, GROUP_SETTINGS);
    public static final PlushItem DINO_PLUSHIE = new PlushItem(ModBlocks.DINO_PLUSHIE, PlushieItem.DINO, GROUP_SETTINGS);
    public static final PlushItem ENDERMAN_PLUSHIE = new PlushItem(ModBlocks.ENDERMAN_PLUSHIE, PlushieItem.ENDERMAN, GROUP_SETTINGS);
    public static final PlushItem HAPPY_SUN_PLUSHIE = new PlushItem(ModBlocks.HAPPY_SUN_PLUSHIE, PlushieItem.HAPPY_SUN, GROUP_SETTINGS);
    public static final PlushItem LOLLIPOP_CLOWN_PLUSHIE = new PlushItem(ModBlocks.LOLLIPOP_CLOWN_PLUSHIE, PlushieItem.LOLLIPOP_CLOWN, GROUP_SETTINGS);
    public static final PlushItem PETUNIA_PIG_PLUSHIE = new PlushItem(ModBlocks.PETUNIA_PIG_PLUSHIE, PlushieItem.PETUNIA_PIG, GROUP_SETTINGS);
    public static final PlushItem RUBBER_DUCKY_PLUSHIE = new PlushItem(ModBlocks.RUBBER_DUCKY_PLUSHIE, PlushieItem.RUBBER_DUCKY, GROUP_SETTINGS);
    public static final PlushItem TOADSTOOL_PLUSHIE = new PlushItem(ModBlocks.TOADSTOOL_PLUSHIE, PlushieItem.TOADSTOOL, GROUP_SETTINGS);
    public static final PlushItem WHEELIE_PUP_PLUSHIE = new PlushItem(ModBlocks.WHEELIE_PUP_PLUSHIE, PlushieItem.WHEELIE_PUP, GROUP_SETTINGS);
    public static final PlushItem ZOMBIE_PLUSHIE = new PlushItem(ModBlocks.ZOMBIE_PLUSHIE, PlushieItem.ZOMBIE, GROUP_SETTINGS);

    public static final PlushItem CYMBAL_MONKEY = new PlushItem(ModBlocks.CYMBAL_MONKEY, PlushieItem.CYMBAL_MONKEY, GROUP_SETTINGS);
    public static final PlushItem FOX_PLUSHIE = new PlushItem(ModBlocks.FOX_PLUSHIE, PlushieItem.FOX, GROUP_SETTINGS);
    public static final PlushItem SNOWY_FOX_PLUSHIE = new PlushItem(ModBlocks.SNOWY_FOX_PLUSHIE, PlushieItem.SNOWY_FOX, GROUP_SETTINGS);
    public static final PlushItem PIGGY_BANK = new PlushItem(ModBlocks.PIGGY_BANK, PlushieItem.PIGGY_BANK, GROUP_SETTINGS);
    public static final PlushItem RABBIT_PLUSHIE = new PlushItem(ModBlocks.RABBIT_PLUSHIE, PlushieItem.RABBIT, GROUP_SETTINGS);
    public static final PlushItem SOCK_MONKEY = new PlushItem(ModBlocks.SOCK_MONKEY, PlushieItem.SOCK_MONKEY, GROUP_SETTINGS);
    public static final PlushItem ROBOT = new PlushItem(ModBlocks.ROBOT, PlushieItem.ROBOT, GROUP_SETTINGS);

    //region Cuddle Cubs
    public static final Item CUDDLE_HEART = new Item(GROUP_SETTINGS);
    public static final CuddleCubItem AROMANTIC_CUB = new CuddleCubItem(ModBlocks.AROMANTIC_CUB, CuddleCub.AROMANTIC, GROUP_SETTINGS);
    public static final CuddleCubItem ASEXUAL_CUB = new CuddleCubItem(ModBlocks.ASEXUAL_CUB, CuddleCub.ASEXUAL, GROUP_SETTINGS);
    public static final CuddleCubItem BISEXUAL_CUB = new CuddleCubItem(ModBlocks.BISEXUAL_CUB, CuddleCub.BISEXUAL, GROUP_SETTINGS);
    public static final CuddleCubItem PRIDE_CUB = new CuddleCubItem(ModBlocks.PRIDE_CUB, CuddleCub.PRIDE, GROUP_SETTINGS);
    public static final CuddleCubItem GENDERQUEER_CUB = new CuddleCubItem(ModBlocks.GENDERQUEER_CUB, CuddleCub.GENDERQUEER, GROUP_SETTINGS);
    public static final CuddleCubItem LESBIAN_CUB = new CuddleCubItem(ModBlocks.LESBIAN_CUB, CuddleCub.LESBIAN, GROUP_SETTINGS);
    public static final CuddleCubItem NONBINARY_CUB = new CuddleCubItem(ModBlocks.NONBINARY_CUB, CuddleCub.NONBINARY, GROUP_SETTINGS);
    public static final CuddleCubItem PANSEXUAL_CUB = new CuddleCubItem(ModBlocks.PANSEXUAL_CUB, CuddleCub.PANSEXUAL, GROUP_SETTINGS);
    public static final CuddleCubItem TRANS_CUB = new CuddleCubItem(ModBlocks.TRANS_CUB, CuddleCub.TRANS, GROUP_SETTINGS);
    public static final CuddleCubItem PANDA_CUB = new CuddleCubItem(ModBlocks.PANDA_CUB, CuddleCub.PANDA, GROUP_SETTINGS);
    public static final CuddleCubItem POLAR_CUB = new CuddleCubItem(ModBlocks.POLAR_CUB, CuddleCub.POLAR, GROUP_SETTINGS);
    public static final CuddleCubItem STUFFIE_CUB = new CuddleCubItem(ModBlocks.STUFFIE_CUB, CuddleCub.STUFFIE, GROUP_SETTINGS);
    public static final CuddleCubItem COOL_CUB = new CuddleCubItem(ModBlocks.COOL_CUB, CuddleCub.COOL, GROUP_SETTINGS);
    public static final CuddleCubItem BROWN_CUB = new CuddleCubItem(ModBlocks.BROWN_CUB, CuddleCub.BROWN, GROUP_SETTINGS);
    public static final CuddleCubItem HONEY_CUB = new CuddleCubItem(ModBlocks.HONEY_CUB, CuddleCub.HONEY, GROUP_SETTINGS);
    //endregion

    public static final List<BlockItem> LETTER_BLOCKS = Letters.createBlockItems();

    public static void register() {
        Registry.register(Registry.ITEM, Playdate.modId("softwood"), SOFTWOOD);
        Registry.register(Registry.ITEM, Playdate.modId("light_softwood"), LIGHT_SOFTWOOD);
        Registry.register(Registry.ITEM, Playdate.modId("ballpit"), BALLPIT);
        Registry.register(Registry.ITEM, Playdate.modId("mesh_wall"), MESH_WALL);
        Registry.register(Registry.ITEM, Playdate.modId("stuffing"), STUFFING);
        Registry.register(Registry.ITEM, Playdate.modId("bottled_soul"), BOTTLED_SOUL);
        Registry.register(Registry.ITEM, Playdate.modId("balloon"), BALLOON);
        Registry.register(Registry.ITEM, Playdate.modId("happy_sun_balloon"), SUN_BALLOON);
        Registry.register(Registry.ITEM, Playdate.modId("rope"), ROPE);

        Registry.register(Registry.ITEM, Playdate.modId("creeper_plush"), CREEPER_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("dino_plush"), DINO_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("enderman_plush"), ENDERMAN_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("happy_sun_plush"), HAPPY_SUN_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("lollipop_clown_plush"), LOLLIPOP_CLOWN_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("petunia_pig_plush"), PETUNIA_PIG_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("rubber_ducky"), RUBBER_DUCKY_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("toadstool_studios_plush"), TOADSTOOL_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("wheelie_pup"), WHEELIE_PUP_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("zombie_plush"), ZOMBIE_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("petunia_pig_toy"), PETUNIA_PIG_TOY);
        Registry.register(Registry.ITEM, Playdate.modId("happy_sun_toy"), HAPPY_SUN_TOY);
        Registry.register(Registry.ITEM, Playdate.modId("lollipop_clown_toy"), LOLLIPOP_CLOWN_TOY);
        Registry.register(Registry.ITEM, Playdate.modId("stuffie_toy"), STUFFIE_TOY);

        Registry.register(Registry.ITEM, Playdate.modId("cymbal_monkey"), CYMBAL_MONKEY);
        Registry.register(Registry.ITEM, Playdate.modId("fox_plush"), FOX_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("snowy_fox_plush"), SNOWY_FOX_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("piggy_bank"), PIGGY_BANK);
        Registry.register(Registry.ITEM, Playdate.modId("rabbit_plush"), RABBIT_PLUSHIE);
        Registry.register(Registry.ITEM, Playdate.modId("sock_monkey"), SOCK_MONKEY);
        Registry.register(Registry.ITEM, Playdate.modId("robot"), ROBOT);

        //region Cuddle Cubs
        Registry.register(Registry.ITEM, Playdate.modId("cuddle_heart"), CUDDLE_HEART);
        Registry.register(Registry.ITEM, Playdate.modId("aromantic_cub"), AROMANTIC_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("asexual_cub"), ASEXUAL_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("bisexual_cub"), BISEXUAL_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("pride_cub"), PRIDE_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("genderqueer_cub"), GENDERQUEER_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("lesbian_cub"), LESBIAN_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("nonbinary_cub"), NONBINARY_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("pansexual_cub"), PANSEXUAL_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("trans_cub"), TRANS_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("panda_cub"), PANDA_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("polar_cub"), POLAR_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("stuffie_cub"), STUFFIE_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("cool_cub"), COOL_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("brown_cub"), BROWN_CUB);
        Registry.register(Registry.ITEM, Playdate.modId("honey_cub"), HONEY_CUB);
        //endregion

        for (int i = 0; i < LETTER_BLOCKS.size(); i++) {
            Registry.register(Registry.ITEM, Letters.formatFromId(i), LETTER_BLOCKS.get(i));
        }
    }


}
