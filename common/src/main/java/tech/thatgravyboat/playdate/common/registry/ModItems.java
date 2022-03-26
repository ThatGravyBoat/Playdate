package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.constants.*;
import tech.thatgravyboat.playdate.common.items.*;
import tech.thatgravyboat.playdate.common.registry.base.BasicRegistry;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {

    public static final Item.Settings GROUP_SETTINGS = new Item.Settings().group(Playdate.ITEM_GROUP);

    public static final Supplier<Item> STUFFING = CommonServices.REGISTRY.registerItem("stuffing", () -> new Item(GROUP_SETTINGS));
    public static final Supplier<Item> SOFTWOOD = CommonServices.REGISTRY.registerItem("softwood", () -> new BlockItem(ModBlocks.SOFTWOOD.get(), GROUP_SETTINGS));
    public static final Supplier<Item> LIGHT_SOFTWOOD = CommonServices.REGISTRY.registerItem("light_softwood", () -> new BlockItem(ModBlocks.LIGHT_SOFTWOOD.get(), GROUP_SETTINGS));
    public static final Supplier<Item> MESH_WALL = CommonServices.REGISTRY.registerItem("mesh_wall", () -> new BlockItem(ModBlocks.MESH_WALL.get(), GROUP_SETTINGS));
    public static final Supplier<Item> BALLPIT = CommonServices.REGISTRY.registerItem("ballpit", () -> new BlockItem(ModBlocks.BALLPIT.get(), GROUP_SETTINGS));
    public static final Supplier<Item> BOTTLED_SOUL = CommonServices.REGISTRY.registerItem("bottled_soul", () -> new Item(new Item.Settings().maxCount(1).group(Playdate.ITEM_GROUP)));
    public static final Supplier<Item> BALLOON = CommonServices.REGISTRY.registerItem("balloon", () -> new BalloonItem(BalloonType.COLORED, GROUP_SETTINGS));
    public static final Supplier<Item> SUN_BALLOON = CommonServices.REGISTRY.registerItem("happy_sun_balloon", () -> new BalloonItem(BalloonType.SUN, GROUP_SETTINGS));
    public static final Supplier<Item> ROPE = CommonServices.REGISTRY.registerItem("rope", () -> new RopeItem(GROUP_SETTINGS));

    public static final BasicRegistry<Item> TOYS = new BasicRegistry<>(CommonServices.REGISTRY::registerItem);

    public static final Supplier<Item> PETUNIA_PIG_TOY = TOYS.register("petunia_pig_toy", () -> createPlush(ModBlocks.PETUNIA_PIG_TOY.get(), PlushieItem.PETUNIA_PIG_TOY));
    public static final Supplier<Item> HAPPY_SUN_TOY = TOYS.register("happy_sun_toy", () -> createPlush(ModBlocks.HAPPY_SUN_TOY.get(), PlushieItem.HAPPY_SUN_TOY));
    public static final Supplier<Item> LOLLIPOP_CLOWN_TOY = TOYS.register("lollipop_clown_toy", () -> createPlush(ModBlocks.LOLLIPOP_CLOWN_TOY.get(), PlushieItem.LOLLIPOP_CLOWN_TOY));
    public static final Supplier<Item> STUFFIE_TOY = TOYS.register("stuffie_toy", () -> createPlush(ModBlocks.STUFFIE_TOY.get(), PlushieItem.STUFFIE_TOY));

    //region Plushies
    public static final BasicRegistry<Item> PLUSHIES = new BasicRegistry<>(CommonServices.REGISTRY::registerItem);

    public static final Supplier<Item> CREEPER_PLUSHIE = PLUSHIES.register("creeper_plush", () -> createPlush(ModBlocks.CREEPER_PLUSHIE.get(), PlushieItem.CREEPER));
    public static final Supplier<Item> DINO_PLUSHIE = PLUSHIES.register("dino_plush", () -> createPlush(ModBlocks.DINO_PLUSHIE.get(), PlushieItem.DINO));
    public static final Supplier<Item> ENDERMAN_PLUSHIE = PLUSHIES.register("enderman_plush", () -> createPlush(ModBlocks.ENDERMAN_PLUSHIE.get(), PlushieItem.ENDERMAN));
    public static final Supplier<Item> HAPPY_SUN_PLUSHIE = PLUSHIES.register("happy_sun_plush", () -> createPlush(ModBlocks.HAPPY_SUN_PLUSHIE.get(), PlushieItem.HAPPY_SUN));
    public static final Supplier<Item> LOLLIPOP_CLOWN_PLUSHIE = PLUSHIES.register("lollipop_clown_plush", () -> createPlush(ModBlocks.LOLLIPOP_CLOWN_PLUSHIE.get(), PlushieItem.LOLLIPOP_CLOWN));
    public static final Supplier<Item> PETUNIA_PIG_PLUSHIE = PLUSHIES.register("petunia_pig_plush", () -> createPlush(ModBlocks.PETUNIA_PIG_PLUSHIE.get(), PlushieItem.PETUNIA_PIG));
    public static final Supplier<Item> RUBBER_DUCKY_PLUSHIE = PLUSHIES.register("rubber_ducky", () -> createPlush(ModBlocks.RUBBER_DUCKY_PLUSHIE.get(), PlushieItem.RUBBER_DUCKY));
    public static final Supplier<Item> WHEELIE_PUP_PLUSHIE = PLUSHIES.register("wheelie_pup", () -> createPlush(ModBlocks.WHEELIE_PUP_PLUSHIE.get(), PlushieItem.WHEELIE_PUP));
    public static final Supplier<Item> ZOMBIE_PLUSHIE = PLUSHIES.register("zombie_plush", () -> createPlush(ModBlocks.ZOMBIE_PLUSHIE.get(), PlushieItem.ZOMBIE));
    public static final Supplier<Item> CYMBAL_MONKEY = PLUSHIES.register("cymbal_monkey", () -> createPlush(ModBlocks.CYMBAL_MONKEY.get(), PlushieItem.CYMBAL_MONKEY));
    public static final Supplier<Item> FOX_PLUSHIE = PLUSHIES.register("fox_plush", () -> createPlush(ModBlocks.FOX_PLUSHIE.get(), PlushieItem.FOX));
    public static final Supplier<Item> SNOWY_FOX_PLUSHIE = PLUSHIES.register("snowy_fox_plush", () -> createPlush(ModBlocks.SNOWY_FOX_PLUSHIE.get(), PlushieItem.SNOWY_FOX));
    public static final Supplier<Item> PIGGY_BANK = PLUSHIES.register("piggy_bank", () -> createPlush(ModBlocks.PIGGY_BANK.get(), PlushieItem.PIGGY_BANK));
    public static final Supplier<Item> RABBIT_PLUSHIE = PLUSHIES.register("rabbit_plush", () -> createPlush(ModBlocks.RABBIT_PLUSHIE.get(), PlushieItem.RABBIT));
    public static final Supplier<Item> SOCK_MONKEY = TOYS.register("sock_monkey", () -> createPlush(ModBlocks.SOCK_MONKEY.get(), PlushieItem.SOCK_MONKEY));
    public static final Supplier<Item> ROBOT = PLUSHIES.register("robot", () -> createPlush(ModBlocks.ROBOT.get(), PlushieItem.ROBOT));
    //endregion

    //region Cuddle Cubs
    public static final Supplier<Item> CUDDLE_HEART = CommonServices.REGISTRY.registerItem("cuddle_heart", () -> new Item(GROUP_SETTINGS));

    public static final BasicRegistry<Item> CUDDLE_CUBS = new BasicRegistry<>(CommonServices.REGISTRY::registerItem);

    public static final Supplier<Item> AROMANTIC_CUB = CUDDLE_CUBS.register("aromantic_cub", () -> createCub(ModBlocks.AROMANTIC_CUB.get(), CuddleCub.AROMANTIC));
    public static final Supplier<Item> ASEXUAL_CUB = CUDDLE_CUBS.register("asexual_cub", () -> createCub(ModBlocks.ASEXUAL_CUB.get(), CuddleCub.ASEXUAL));
    public static final Supplier<Item> BISEXUAL_CUB = CUDDLE_CUBS.register("bisexual_cub", () -> createCub(ModBlocks.BISEXUAL_CUB.get(), CuddleCub.BISEXUAL));
    public static final Supplier<Item> PRIDE_CUB = CUDDLE_CUBS.register("pride_cub", () -> createCub(ModBlocks.PRIDE_CUB.get(), CuddleCub.PRIDE));
    public static final Supplier<Item> GENDERQUEER_CUB = CUDDLE_CUBS.register("genderqueer_cub", () -> createCub(ModBlocks.GENDERQUEER_CUB.get(), CuddleCub.GENDERQUEER));
    public static final Supplier<Item> LESBIAN_CUB = CUDDLE_CUBS.register("lesbian_cub", () -> createCub(ModBlocks.LESBIAN_CUB.get(), CuddleCub.LESBIAN));
    public static final Supplier<Item> NONBINARY_CUB = CUDDLE_CUBS.register("nonbinary_cub", () -> createCub(ModBlocks.NONBINARY_CUB.get(), CuddleCub.NONBINARY));
    public static final Supplier<Item> PANSEXUAL_CUB = CUDDLE_CUBS.register("pansexual_cub", () -> createCub(ModBlocks.PANSEXUAL_CUB.get(), CuddleCub.PANSEXUAL));
    public static final Supplier<Item> TRANS_CUB = CUDDLE_CUBS.register("trans_cub", () -> createCub(ModBlocks.TRANS_CUB.get(), CuddleCub.TRANS));
    public static final Supplier<Item> PANDA_CUB = CUDDLE_CUBS.register("panda_cub", () -> createCub(ModBlocks.PANDA_CUB.get(), CuddleCub.PANDA));
    public static final Supplier<Item> POLAR_CUB = CUDDLE_CUBS.register("polar_cub", () -> createCub(ModBlocks.POLAR_CUB.get(), CuddleCub.POLAR));
    public static final Supplier<Item> STUFFIE_CUB = CUDDLE_CUBS.register("stuffie_cub", () -> createCub(ModBlocks.STUFFIE_CUB.get(), CuddleCub.STUFFIE));
    public static final Supplier<Item> COOL_CUB = CUDDLE_CUBS.register("cool_cub", () -> createCub(ModBlocks.COOL_CUB.get(), CuddleCub.COOL));
    public static final Supplier<Item> BROWN_CUB = CUDDLE_CUBS.register("brown_cub", () -> createCub(ModBlocks.BROWN_CUB.get(), CuddleCub.BROWN));
    public static final Supplier<Item> HONEY_CUB = CUDDLE_CUBS.register("honey_cub", () -> createCub(ModBlocks.HONEY_CUB.get(), CuddleCub.HONEY));
    //endregion

    public static final Supplier<Item> STEVE = CommonServices.REGISTRY.registerItem("steve_plush", () -> createPlayer(ModBlocks.STEVE.get(), PlayerSkin.STEVE));
    public static final Supplier<Item> ALEX = CommonServices.REGISTRY.registerItem("alex_plush", () -> createPlayer(ModBlocks.ALEX.get(), PlayerSkin.ALEX));

    //region Dolls
    public static final BasicRegistry<Item> DOLLS = new BasicRegistry<>(CommonServices.REGISTRY::registerItem);
    public static final BasicRegistry<Item> DOLLHOUSES = new BasicRegistry<>(CommonServices.REGISTRY::registerItem);

    public static final Supplier<Item> OAK_DOLLHOUSE = DOLLHOUSES.register("oak_dollhouse", () -> createDollhouse(ModBlocks.OAK_DOLLHOUSE.get(), Doll.OAK));
    public static final Supplier<Item> BIRCH_DOLLHOUSE = DOLLHOUSES.register("birch_dollhouse", () -> createDollhouse(ModBlocks.BIRCH_DOLLHOUSE.get(), Doll.BIRCH));
    public static final Supplier<Item> SPRUCE_DOLLHOUSE = DOLLHOUSES.register("spruce_dollhouse", () -> createDollhouse(ModBlocks.SPRUCE_DOLLHOUSE.get(), Doll.SPRUCE));
    public static final Supplier<Item> DARK_OAK_DOLLHOUSE = DOLLHOUSES.register("dark_oak_dollhouse", () -> createDollhouse(ModBlocks.DARK_OAK_DOLLHOUSE.get(), Doll.DARK_OAK));
    public static final Supplier<Item> ACACIA_DOLLHOUSE = DOLLHOUSES.register("acacia_dollhouse", () -> createDollhouse(ModBlocks.ACACIA_DOLLHOUSE.get(), Doll.ACACIA));
    public static final Supplier<Item> JUNGLE_DOLLHOUSE = DOLLHOUSES.register("jungle_dollhouse", () -> createDollhouse(ModBlocks.JUNGLE_DOLLHOUSE.get(), Doll.JUNGLE));
    public static final Supplier<Item> CRIMSON_DOLLHOUSE = DOLLHOUSES.register("crimson_dollhouse", () -> createDollhouse(ModBlocks.CRIMSON_DOLLHOUSE.get(), Doll.CRIMSON));
    public static final Supplier<Item> WARPED_DOLLHOUSE = DOLLHOUSES.register("warped_dollhouse", () -> createDollhouse(ModBlocks.WARPED_DOLLHOUSE.get(), Doll.WARPED));

    public static final Supplier<Item> OAK_DOLL = DOLLS.register("oak_doll", () -> createDoll(ModBlocks.OAK_DOLL.get(), Doll.OAK));
    public static final Supplier<Item> BIRCH_DOLL = DOLLS.register("birch_doll", () -> createDoll(ModBlocks.BIRCH_DOLL.get(), Doll.BIRCH));
    public static final Supplier<Item> SPRUCE_DOLL = DOLLS.register("spruce_doll", () -> createDoll(ModBlocks.SPRUCE_DOLL.get(), Doll.SPRUCE));
    public static final Supplier<Item> DARK_OAK_DOLL = DOLLS.register("dark_oak_doll", () -> createDoll(ModBlocks.DARK_OAK_DOLL.get(), Doll.DARK_OAK));
    public static final Supplier<Item> JUNGLE_DOLL = DOLLS.register("jungle_doll", () -> createDoll(ModBlocks.JUNGLE_DOLL.get(), Doll.JUNGLE));
    public static final Supplier<Item> ACACIA_DOLL = DOLLS.register("acacia_doll", () -> createDoll(ModBlocks.ACACIA_DOLL.get(), Doll.ACACIA));
    public static final Supplier<Item> CRIMSON_DOLL = DOLLS.register("crimson_doll", () -> createDoll(ModBlocks.CRIMSON_DOLL.get(), Doll.CRIMSON));
    public static final Supplier<Item> WARPED_DOLL = DOLLS.register("warped_doll", () -> createDoll(ModBlocks.WARPED_DOLL.get(), Doll.WARPED));
    //endregion

    public static final Supplier<MusicBoxItem> MUSIC_BOX = CommonServices.REGISTRY.registerItem("music_box",
            () -> CommonServices.PLATFORM.createMusicBox(ModBlocks.MUSIC_BOX.get(), ModItems.GROUP_SETTINGS));

    public static final Supplier<Item> DUMMY = PLUSHIES.register("dummy", () -> createPlush(ModBlocks.DUMMY.get(), PlushieItem.DUMMY));

    public static final List<Supplier<BlockItem>> LETTER_BLOCKS = Letters.createBlockItems();

    public static void register() {
        //Initialize class.
    }

    private static PlushItem createPlush(Block block, PlushieItem item) {
        return CommonServices.PLATFORM.createPlush(block, item, ModItems.GROUP_SETTINGS);
    }

    private static CuddleCubItem createCub(Block block, CuddleCub cub) {
        return CommonServices.PLATFORM.createCub(block, cub, ModItems.GROUP_SETTINGS);
    }

    private static PlayerPlushieItem createPlayer(Block block, PlayerSkin skin) {
        return CommonServices.PLATFORM.createPlayer(block, skin, ModItems.GROUP_SETTINGS);
    }

    private static DollHouseItem createDollhouse(Block block, Doll doll) {
        return CommonServices.PLATFORM.createDollhouse(block, doll, ModItems.GROUP_SETTINGS);
    }

    private static DollItem createDoll(Block block, Doll doll) {
        return CommonServices.PLATFORM.createDoll(block, doll, ModItems.GROUP_SETTINGS);
    }

}
