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
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.concurrent.atomic.AtomicReference;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PlayDate.MODID);

    public static final RegistryObject<BlockEntityType<?>> PETUNIA_PIG_TOY = BLOCK_ENTITY_TYPES.register("petunia_pig_toy_entity", () ->
            createBlockPlushie(ToyBlockEntity::new, PlushieItem.PETUNIA_PIG_TOY, ModBlocks.PETUNIA_PIG_TOY.get()));
    public static final RegistryObject<BlockEntityType<?>> HAPPY_SUN_TOY = BLOCK_ENTITY_TYPES.register("happy_sun_toy_entity", () ->
            createBlockPlushie(ToyBlockEntity::new, PlushieItem.HAPPY_SUN_TOY, ModBlocks.HAPPY_SUN_TOY.get()));
    public static final RegistryObject<BlockEntityType<?>> LOLLIPOP_CLOWN_TOY = BLOCK_ENTITY_TYPES.register("lollipop_clown_toy_entity", () ->
            createBlockPlushie(ToyBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN_TOY, ModBlocks.LOLLIPOP_CLOWN_TOY.get()));


    public static final RegistryObject<BlockEntityType<?>> CREEPER_PLUSHIE = BLOCK_ENTITY_TYPES.register("creeper_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.CREEPER, ModBlocks.CREEPER_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> DINO_PLUSHIE = BLOCK_ENTITY_TYPES.register("dino_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.DINO, ModBlocks.DINO_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> ENDERMAN_PLUSHIE = BLOCK_ENTITY_TYPES.register("enderman_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ENDERMAN, ModBlocks.ENDERMAN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> HAPPY_SUN_PLUSHIE = BLOCK_ENTITY_TYPES.register("happy_sun_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.HAPPY_SUN, ModBlocks.HAPPY_SUN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> LOLLIPOP_CLOWN_PLUSHIE = BLOCK_ENTITY_TYPES.register("lollipop_clown_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN, ModBlocks.LOLLIPOP_CLOWN_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> PETUNIA_PIG_PLUSHIE = BLOCK_ENTITY_TYPES.register("petunia_pig_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.PETUNIA_PIG, ModBlocks.PETUNIA_PIG_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> RUBBER_DUCKY_PLUSHIE = BLOCK_ENTITY_TYPES.register("rubber_ducky_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.RUBBER_DUCKY, ModBlocks.RUBBER_DUCKY_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> TOADSTOOL_PLUSHIE = BLOCK_ENTITY_TYPES.register("toadstool_studios_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.TOADSTOOL, ModBlocks.TOADSTOOL_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> WHEELIE_PUP_PLUSHIE = BLOCK_ENTITY_TYPES.register("wheelie_pup_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.WHEELIE_PUP, ModBlocks.WHEELIE_PUP_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> ZOMBIE_PLUSHIE = BLOCK_ENTITY_TYPES.register("zombie_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ZOMBIE, ModBlocks.ZOMBIE_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> CYMBAL_MONKEY = BLOCK_ENTITY_TYPES.register("cymbal_monkey_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.CYMBAL_MONKEY, ModBlocks.CYMBAL_MONKEY.get()));
    public static final RegistryObject<BlockEntityType<?>> FOX_PLUSHIE = BLOCK_ENTITY_TYPES.register("fox_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.FOX, ModBlocks.FOX_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> SNOWY_FOX_PLUSHIE = BLOCK_ENTITY_TYPES.register("snowy_fox_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.SNOWY_FOX, ModBlocks.SNOWY_FOX_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> PIGGY_BANK = BLOCK_ENTITY_TYPES.register("piggy_bank_entity",
            () -> createBlockPlushie(PiggyBankPlushieBlockEntity::new, PlushieItem.PIGGY_BANK, ModBlocks.PIGGY_BANK.get()));
    public static final RegistryObject<BlockEntityType<?>> RABBIT_PLUSHIE = BLOCK_ENTITY_TYPES.register("rabbit_plush_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.RABBIT, ModBlocks.RABBIT_PLUSHIE.get()));
    public static final RegistryObject<BlockEntityType<?>> SOCK_MONKEY = BLOCK_ENTITY_TYPES.register("sock_monkey_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.SOCK_MONKEY, ModBlocks.SOCK_MONKEY.get()));
    public static final RegistryObject<BlockEntityType<?>> ROBOT = BLOCK_ENTITY_TYPES.register("robot_entity",
            () -> createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ROBOT, ModBlocks.ROBOT.get()));

    private static BlockEntityType<?> createBlockPlushie(PlushieBlockEntityCreation creator, PlushieItem item, Block... blocks) {
        AtomicReference<BlockEntityType<?>> type = new AtomicReference<>();
        type.set(BlockEntityType.Builder.of((pos, state) -> creator.create(item, type.get(), pos, state), blocks).build(null));
        return type.get();
    }

    @FunctionalInterface
    private interface PlushieBlockEntityCreation {
        BlockEntity create(PlushieItem item, BlockEntityType<?> type, BlockPos pos, BlockState state);
    }
}
