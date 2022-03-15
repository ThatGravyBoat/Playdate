package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;
import tech.thatgravyboat.playdate.common.blocks.custom.piggybank.PiggyBankPlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.concurrent.atomic.AtomicReference;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PlayDate.MODID);

    public static final RegistryObject<BlockEntityType<?>> PETUNIA_PIG_TOY = BLOCK_ENTITY_TYPES.register("petunia_pig_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.PETUNIA_PIG_TOY, ModBlocks.PETUNIA_PIG_TOY.get()));
    public static final RegistryObject<BlockEntityType<?>> HAPPY_SUN_TOY = BLOCK_ENTITY_TYPES.register("happy_sun_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.HAPPY_SUN_TOY, ModBlocks.HAPPY_SUN_TOY.get()));
    public static final RegistryObject<BlockEntityType<?>> LOLLIPOP_CLOWN_TOY = BLOCK_ENTITY_TYPES.register("lollipop_clown_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN_TOY, ModBlocks.LOLLIPOP_CLOWN_TOY.get()));
    public static final RegistryObject<BlockEntityType<?>> STUFFIE_TOY = BLOCK_ENTITY_TYPES.register("stuffie_toy_entity", () ->
            createBlock(ToyBlockEntity::new, PlushieItem.STUFFIE_TOY, ModBlocks.STUFFIE_TOY.get()));

    public static final RegistryObject<BlockEntityType<?>> CREEPER_PLUSHIE = BLOCK_ENTITY_TYPES.register("creeper_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.CREEPER, ModBlocks.CREEPER_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> DINO_PLUSHIE = BLOCK_ENTITY_TYPES.register("dino_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.DINO, ModBlocks.DINO_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> ENDERMAN_PLUSHIE = BLOCK_ENTITY_TYPES.register("enderman_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.ENDERMAN, ModBlocks.ENDERMAN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> HAPPY_SUN_PLUSHIE = BLOCK_ENTITY_TYPES.register("happy_sun_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.HAPPY_SUN, ModBlocks.HAPPY_SUN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> LOLLIPOP_CLOWN_PLUSHIE = BLOCK_ENTITY_TYPES.register("lollipop_clown_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN, ModBlocks.LOLLIPOP_CLOWN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> PETUNIA_PIG_PLUSHIE = BLOCK_ENTITY_TYPES.register("petunia_pig_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.PETUNIA_PIG, ModBlocks.PETUNIA_PIG_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> RUBBER_DUCKY_PLUSHIE = BLOCK_ENTITY_TYPES.register("rubber_ducky_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.RUBBER_DUCKY, ModBlocks.RUBBER_DUCKY_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> TOADSTOOL_PLUSHIE = BLOCK_ENTITY_TYPES.register("toadstool_studios_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.TOADSTOOL, ModBlocks.TOADSTOOL_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> WHEELIE_PUP_PLUSHIE = BLOCK_ENTITY_TYPES.register("wheelie_pup_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.WHEELIE_PUP, ModBlocks.WHEELIE_PUP_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> ZOMBIE_PLUSHIE = BLOCK_ENTITY_TYPES.register("zombie_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.ZOMBIE, ModBlocks.ZOMBIE_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> CYMBAL_MONKEY = BLOCK_ENTITY_TYPES.register("cymbal_monkey_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.CYMBAL_MONKEY, ModBlocks.CYMBAL_MONKEY.get()));
    public static final RegistryObject<BlockEntityType<?>> FOX_PLUSHIE = BLOCK_ENTITY_TYPES.register("fox_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.FOX, ModBlocks.FOX_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> SNOWY_FOX_PLUSHIE = BLOCK_ENTITY_TYPES.register("snowy_fox_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.SNOWY_FOX, ModBlocks.SNOWY_FOX_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> PIGGY_BANK = BLOCK_ENTITY_TYPES.register("piggy_bank_entity",
            () -> createBlock(PiggyBankPlushieBlockEntity::new, PlushieItem.PIGGY_BANK, ModBlocks.PIGGY_BANK.get()));
    public static final RegistryObject<BlockEntityType<?>> RABBIT_PLUSHIE = BLOCK_ENTITY_TYPES.register("rabbit_plush_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.RABBIT, ModBlocks.RABBIT_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> SOCK_MONKEY = BLOCK_ENTITY_TYPES.register("sock_monkey_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.SOCK_MONKEY, ModBlocks.SOCK_MONKEY.get()));
    public static final RegistryObject<BlockEntityType<?>> ROBOT = BLOCK_ENTITY_TYPES.register("robot_entity",
            () -> createBlock(PlushieBlockEntity::new, PlushieItem.ROBOT, ModBlocks.ROBOT.get()));

    //region Cuddle Cubs
    public static final RegistryObject<BlockEntityType<?>> AROMANTIC_CUB = BLOCK_ENTITY_TYPES.register("aromantic_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.AROMANTIC, ModBlocks.AROMANTIC_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> ASEXUAL_CUB = BLOCK_ENTITY_TYPES.register("asexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.ASEXUAL, ModBlocks.ASEXUAL_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> BISEXUAL_CUB = BLOCK_ENTITY_TYPES.register("bisexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.BISEXUAL, ModBlocks.BISEXUAL_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> PRIDE_CUB = BLOCK_ENTITY_TYPES.register("pride_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PRIDE, ModBlocks.PRIDE_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> GENDERQUEER_CUB = BLOCK_ENTITY_TYPES.register("genderqueer_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.GENDERQUEER, ModBlocks.GENDERQUEER_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> LESBIAN_CUB = BLOCK_ENTITY_TYPES.register("lesbian_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.LESBIAN, ModBlocks.LESBIAN_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> NONBINARY_CUB = BLOCK_ENTITY_TYPES.register("nonbinary_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.NONBINARY, ModBlocks.NONBINARY_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> PANSEXUAL_CUB = BLOCK_ENTITY_TYPES.register("pansexual_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PANSEXUAL, ModBlocks.PANSEXUAL_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> TRANS_CUB = BLOCK_ENTITY_TYPES.register("trans_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.TRANS, ModBlocks.TRANS_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> PANDA_CUB = BLOCK_ENTITY_TYPES.register("panda_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.PANDA, ModBlocks.PANDA_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> POLAR_CUB = BLOCK_ENTITY_TYPES.register("polar_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.POLAR, ModBlocks.POLAR_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> STUFFIE_CUB = BLOCK_ENTITY_TYPES.register("stuffie_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.STUFFIE, ModBlocks.STUFFIE_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> COOL_CUB = BLOCK_ENTITY_TYPES.register("cool_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.COOL, ModBlocks.COOL_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> BROWN_CUB = BLOCK_ENTITY_TYPES.register("brown_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.BROWN, ModBlocks.BROWN_CUB.get()));
    public static final RegistryObject<BlockEntityType<?>> HONEY_CUB = BLOCK_ENTITY_TYPES.register("honey_cub",
            () -> createBlock(CuddleCubBlockEntity::new, CuddleCub.HONEY, ModBlocks.HONEY_CUB.get()));
    //endregion

    private static <T> BlockEntityType<?> createBlock(BlockEntityCreation<T> creator, T item, Block... blocks) {
        AtomicReference<BlockEntityType<?>> type = new AtomicReference<>();
        type.set(BlockEntityType.Builder.of((pos, state) -> creator.create(item, type.get(), pos, state), blocks).build(null));
        return type.get();
    }

    @FunctionalInterface
    private interface BlockEntityCreation<T> {
        BlockEntity create(T item, BlockEntityType<?> type, BlockPos pos, BlockState state);
    }
}
