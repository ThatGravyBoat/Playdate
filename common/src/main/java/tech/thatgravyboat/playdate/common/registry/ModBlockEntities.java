package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollHouseBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.musicbox.MusicBoxBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.CuddleCubBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.ToyBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.piggybank.PiggyBankPlushieBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.player.PlayerPlushieBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.powered.PoweredPlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;
import tech.thatgravyboat.playdate.common.registry.base.BasicRegistry;
import tech.thatgravyboat.playdate.platform.CommonServices;
import tech.thatgravyboat.playdate.platform.services.IRegistryHelper;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class ModBlockEntities {

    public static final BasicRegistry<BlockEntityType<?>> TOYS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlockEntity);

    public static final Supplier<BlockEntityType<?>> PETUNIA_PIG_TOY = TOYS.register("petunia_pig_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.PETUNIA_PIG_TOY, ModBlocks.PETUNIA_PIG_TOY.get()));
    public static final Supplier<BlockEntityType<?>> HAPPY_SUN_TOY = TOYS.register("happy_sun_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.HAPPY_SUN_TOY, ModBlocks.HAPPY_SUN_TOY.get()));
    public static final Supplier<BlockEntityType<?>> LOLLIPOP_CLOWN_TOY = TOYS.register("lollipop_clown_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN_TOY, ModBlocks.LOLLIPOP_CLOWN_TOY.get()));
    public static final Supplier<BlockEntityType<?>> STUFFIE_TOY = TOYS.register("stuffie_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.STUFFIE_TOY, ModBlocks.STUFFIE_TOY.get()));

    public static final BasicRegistry<BlockEntityType<?>> PLUSHIES = new BasicRegistry<>(CommonServices.REGISTRY::registerBlockEntity);

    public static final Supplier<BlockEntityType<?>> CREEPER_PLUSHIE = PLUSHIES.register("creeper_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.CREEPER, ModBlocks.CREEPER_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> DINO_PLUSHIE = PLUSHIES.register("dino_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.DINO, ModBlocks.DINO_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> ENDERMAN_PLUSHIE = PLUSHIES.register("enderman_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.ENDERMAN, ModBlocks.ENDERMAN_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> HAPPY_SUN_PLUSHIE = PLUSHIES.register("happy_sun_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.HAPPY_SUN, ModBlocks.HAPPY_SUN_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> LOLLIPOP_CLOWN_PLUSHIE = PLUSHIES.register("lollipop_clown_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN, ModBlocks.LOLLIPOP_CLOWN_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> PETUNIA_PIG_PLUSHIE = PLUSHIES.register("petunia_pig_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.PETUNIA_PIG, ModBlocks.PETUNIA_PIG_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> RUBBER_DUCKY_PLUSHIE = PLUSHIES.register("rubber_ducky_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.RUBBER_DUCKY, ModBlocks.RUBBER_DUCKY_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> WHEELIE_PUP_PLUSHIE = PLUSHIES.register("wheelie_pup_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.WHEELIE_PUP, ModBlocks.WHEELIE_PUP_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> ZOMBIE_PLUSHIE = PLUSHIES.register("zombie_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.ZOMBIE, ModBlocks.ZOMBIE_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> CYMBAL_MONKEY = PLUSHIES.register("cymbal_monkey_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.CYMBAL_MONKEY, ModBlocks.CYMBAL_MONKEY.get()));
    public static final Supplier<BlockEntityType<?>> FOX_PLUSHIE = PLUSHIES.register("fox_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.FOX, ModBlocks.FOX_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> SNOWY_FOX_PLUSHIE = PLUSHIES.register("snowy_fox_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.SNOWY_FOX, ModBlocks.SNOWY_FOX_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> PIGGY_BANK = PLUSHIES.register("piggy_bank_entity",
            () -> createBlock(PiggyBankPlushieBlockEntity::new, PlushieItem.PIGGY_BANK, ModBlocks.PIGGY_BANK.get()));
    public static final Supplier<BlockEntityType<?>> RABBIT_PLUSHIE = PLUSHIES.register("rabbit_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.RABBIT, ModBlocks.RABBIT_PLUSHIE.get()));
    public static final Supplier<BlockEntityType<?>> SOCK_MONKEY = TOYS.register("sock_monkey_entity",
            () -> createBlock(ToyBlockEntity::new, PlushieItem.SOCK_MONKEY, ModBlocks.SOCK_MONKEY.get()));
    public static final Supplier<BlockEntityType<?>> ROBOT = PLUSHIES.register("robot_entity",
            () -> createBlock((item, type, pos, state) -> new PoweredPlushieBlockEntity(item, type, pos, state, "dance"), PlushieItem.ROBOT, ModBlocks.ROBOT.get()));

    //region Cuddle Cubs

    public static final BasicRegistry<BlockEntityType<?>> CUBS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlockEntity);

    public static final Supplier<BlockEntityType<?>> AROMANTIC_CUB = CUBS.register("aromantic_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.AROMANTIC, ModBlocks.AROMANTIC_CUB.get()));
    public static final Supplier<BlockEntityType<?>> ASEXUAL_CUB = CUBS.register("asexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.ASEXUAL, ModBlocks.ASEXUAL_CUB.get()));
    public static final Supplier<BlockEntityType<?>> BISEXUAL_CUB = CUBS.register("bisexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.BISEXUAL, ModBlocks.BISEXUAL_CUB.get()));
    public static final Supplier<BlockEntityType<?>> PRIDE_CUB = CUBS.register("pride_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PRIDE, ModBlocks.PRIDE_CUB.get()));
    public static final Supplier<BlockEntityType<?>> GENDERQUEER_CUB = CUBS.register("genderqueer_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.GENDERQUEER, ModBlocks.GENDERQUEER_CUB.get()));
    public static final Supplier<BlockEntityType<?>> LESBIAN_CUB = CUBS.register("lesbian_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.LESBIAN, ModBlocks.LESBIAN_CUB.get()));
    public static final Supplier<BlockEntityType<?>> NONBINARY_CUB = CUBS.register("nonbinary_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.NONBINARY, ModBlocks.NONBINARY_CUB.get()));
    public static final Supplier<BlockEntityType<?>> PANSEXUAL_CUB = CUBS.register("pansexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PANSEXUAL, ModBlocks.PANSEXUAL_CUB.get()));
    public static final Supplier<BlockEntityType<?>> TRANS_CUB = CUBS.register("trans_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.TRANS, ModBlocks.TRANS_CUB.get()));
    public static final Supplier<BlockEntityType<?>> PANDA_CUB = CUBS.register("panda_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PANDA, ModBlocks.PANDA_CUB.get()));
    public static final Supplier<BlockEntityType<?>> POLAR_CUB = CUBS.register("polar_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.POLAR, ModBlocks.POLAR_CUB.get()));
    public static final Supplier<BlockEntityType<?>> STUFFIE_CUB = CUBS.register("stuffie_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.STUFFIE, ModBlocks.STUFFIE_CUB.get()));
    public static final Supplier<BlockEntityType<?>> COOL_CUB = CUBS.register("cool_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.COOL, ModBlocks.COOL_CUB.get()));
    public static final Supplier<BlockEntityType<?>> BROWN_CUB = CUBS.register("brown_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.BROWN, ModBlocks.BROWN_CUB.get()));
    public static final Supplier<BlockEntityType<?>> HONEY_CUB = CUBS.register("honey_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.HONEY, ModBlocks.HONEY_CUB.get()));
    //endregion

    //region Players
    public static final Supplier<BlockEntityType<?>> STEVE = CommonServices.REGISTRY.registerBlockEntity("steve_plush",
            () -> createBlock(PlayerPlushieBlockEntity::new, PlayerSkin.STEVE, ModBlocks.STEVE.get()));
    public static final Supplier<BlockEntityType<?>> ALEX = CommonServices.REGISTRY.registerBlockEntity("alex_plush",
            () -> createBlock(PlayerPlushieBlockEntity::new, PlayerSkin.ALEX, ModBlocks.ALEX.get()));
    //endregion

    //region Dolls

    public static final BasicRegistry<BlockEntityType<?>> DOLLHOUSES = new BasicRegistry<>(CommonServices.REGISTRY::registerBlockEntity);
    public static final BasicRegistry<BlockEntityType<?>> DOLLS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlockEntity);

    public static final Supplier<BlockEntityType<?>> OAK_DOLLHOUSE = DOLLHOUSES.register("oak_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.OAK, ModBlocks.OAK_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> BIRCH_DOLLHOUSE = DOLLHOUSES.register("birch_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.BIRCH, ModBlocks.BIRCH_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> SPRUCE_DOLLHOUSE = DOLLHOUSES.register("spruce_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.SPRUCE, ModBlocks.SPRUCE_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> DARK_OAK_DOLLHOUSE = DOLLHOUSES.register("dark_oak_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.DARK_OAK, ModBlocks.DARK_OAK_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> ACACIA_DOLLHOUSE = DOLLHOUSES.register("acacia_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.ACACIA, ModBlocks.ACACIA_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> JUNGLE_DOLLHOUSE = DOLLHOUSES.register("jungle_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.JUNGLE, ModBlocks.JUNGLE_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> CRIMSON_DOLLHOUSE = DOLLHOUSES.register("crimson_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.CRIMSON, ModBlocks.CRIMSON_DOLLHOUSE.get()));
    public static final Supplier<BlockEntityType<?>> WARPED_DOLLHOUSE = DOLLHOUSES.register("warped_dollhouse",
            () -> createBlock(DollHouseBlockEntity::new, Doll.WARPED, ModBlocks.WARPED_DOLLHOUSE.get()));

    public static final Supplier<BlockEntityType<?>> OAK_DOLL = DOLLS.register("oak_doll",
            () -> createBlock(DollBlockEntity::new, Doll.OAK, ModBlocks.OAK_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> BIRCH_DOLL = DOLLS.register("birch_doll",
            () -> createBlock(DollBlockEntity::new, Doll.BIRCH, ModBlocks.BIRCH_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> SPRUCE_DOLL = DOLLS.register("spruce_doll",
            () -> createBlock(DollBlockEntity::new, Doll.SPRUCE, ModBlocks.SPRUCE_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> DARK_OAK_DOLL = DOLLS.register("dark_oak_doll",
            () -> createBlock(DollBlockEntity::new, Doll.DARK_OAK, ModBlocks.DARK_OAK_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> JUNGLE_DOLL = DOLLS.register("jungle_doll",
            () -> createBlock(DollBlockEntity::new, Doll.JUNGLE, ModBlocks.JUNGLE_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> ACACIA_DOLL = DOLLS.register("acacia_doll",
            () -> createBlock(DollBlockEntity::new, Doll.ACACIA, ModBlocks.ACACIA_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> CRIMSON_DOLL = DOLLS.register("crimson_doll",
            () -> createBlock(DollBlockEntity::new, Doll.CRIMSON, ModBlocks.CRIMSON_DOLL.get()));
    public static final Supplier<BlockEntityType<?>> WARPED_DOLL = DOLLS.register("warped_doll",
            () -> createBlock(DollBlockEntity::new, Doll.WARPED, ModBlocks.WARPED_DOLL.get()));
    //endregion

    public static final Supplier<BlockEntityType<?>> MUSIC_BOX = DOLLS.register("music_box", () -> createBlock(MusicBoxBlockEntity::new, ModBlocks.MUSIC_BOX.get()));
    public static final Supplier<BlockEntityType<?>> DUMMY = PLUSHIES.register("dummy",
            () -> createBlock((item, type, pos, state) -> new PoweredPlushieBlockEntity(item, type, pos, state, "chatter"), PlushieItem.DUMMY, ModBlocks.DUMMY.get()));

    private static BlockEntityType<?> createBlock(BlockEntityCreationWithType factory, Block... blocks) {
        AtomicReference<BlockEntityType<?>> type = new AtomicReference<>();
        type.set(CommonServices.REGISTRY.createBlockEntityType((pos, state) -> factory.create(type.get(), pos, state), blocks));
        return type.get();
    }

    private static <I> BlockEntityType<?> createBlock(BlockEntityCreation<I> creator, I item, Block... blocks) {
        return createBlock((type, pos, state) -> creator.create(item, type, pos, state), blocks);
    }

    @FunctionalInterface
    private interface BlockEntityCreation<I> {
        BlockEntity create(I item, BlockEntityType<?> type, BlockPos pos, BlockState state);
    }

    @FunctionalInterface
    private interface BlockEntityCreationWithType {
        BlockEntity create(BlockEntityType<?> type, BlockPos pos, BlockState state);
    }

    public static void register() {
        //Initialize class.
    }
}
