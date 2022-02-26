package tech.thatgravyboat.playdate.common.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.custom.piggybank.PiggyBankPlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.concurrent.atomic.AtomicReference;

public class ModBlockEntities {

    public static final BlockEntityType<?> PETUNIA_PIG_TOY = createBlockPlushie(ToyBlockEntity::new, PlushieItem.PETUNIA_PIG_TOY, ModBlocks.PETUNIA_PIG_TOY);
    public static final BlockEntityType<?> HAPPY_SUN_TOY = createBlockPlushie(ToyBlockEntity::new, PlushieItem.HAPPY_SUN_TOY, ModBlocks.HAPPY_SUN_TOY);
    public static final BlockEntityType<?> LOLLIPOP_CLOWN_TOY = createBlockPlushie(ToyBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN_TOY, ModBlocks.LOLLIPOP_CLOWN_TOY);

    public static final BlockEntityType<?> CREEPER_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.CREEPER, ModBlocks.CREEPER_PLUSHIE);
    public static final BlockEntityType<?> DINO_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.DINO, ModBlocks.DINO_PLUSHIE);
    public static final BlockEntityType<?> ENDERMAN_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ENDERMAN, ModBlocks.ENDERMAN_PLUSHIE);
    public static final BlockEntityType<?> HAPPY_SUN_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.HAPPY_SUN, ModBlocks.HAPPY_SUN_PLUSHIE);
    public static final BlockEntityType<?> LOLLIPOP_CLOWN_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.LOLLIPOP_CLOWN, ModBlocks.LOLLIPOP_CLOWN_PLUSHIE);
    public static final BlockEntityType<?> PETUNIA_PIG_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.PETUNIA_PIG, ModBlocks.PETUNIA_PIG_PLUSHIE);
    public static final BlockEntityType<?> RUBBER_DUCKY_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.RUBBER_DUCKY, ModBlocks.RUBBER_DUCKY_PLUSHIE);
    public static final BlockEntityType<?> TOADSTOOL_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.TOADSTOOL, ModBlocks.TOADSTOOL_PLUSHIE);
    public static final BlockEntityType<?> WHEELIE_PUP_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.WHEELIE_PUP, ModBlocks.WHEELIE_PUP_PLUSHIE);
    public static final BlockEntityType<?> ZOMBIE_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ZOMBIE, ModBlocks.ZOMBIE_PLUSHIE);
    public static final BlockEntityType<?> CYMBAL_MONKEY = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.CYMBAL_MONKEY, ModBlocks.CYMBAL_MONKEY);
    public static final BlockEntityType<?> FOX_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.FOX, ModBlocks.FOX_PLUSHIE);
    public static final BlockEntityType<?> SNOWY_FOX_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.SNOWY_FOX, ModBlocks.SNOWY_FOX_PLUSHIE);
    public static final BlockEntityType<?> PIGGY_BANK = createBlockPlushie(PiggyBankPlushieBlockEntity::new, PlushieItem.PIGGY_BANK, ModBlocks.PIGGY_BANK);
    public static final BlockEntityType<?> RABBIT_PLUSHIE = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.RABBIT, ModBlocks.RABBIT_PLUSHIE);
    public static final BlockEntityType<?> SOCK_MONKEY = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.SOCK_MONKEY, ModBlocks.SOCK_MONKEY);
    public static final BlockEntityType<?> ROBOT = createBlockPlushie(PlushieBlockEntity::new, PlushieItem.ROBOT, ModBlocks.ROBOT);

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("creeper_plush_entity"), CREEPER_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("dino_plush_entity"), DINO_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("enderman_plush_entity"), ENDERMAN_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("happy_sun_plush_entity"), HAPPY_SUN_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("lollipop_clown_plush_entity"), LOLLIPOP_CLOWN_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("petunia_pig_plush_entity"), PETUNIA_PIG_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("rubber_ducky_entity"), RUBBER_DUCKY_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("toadstool_studios_plush_entity"), TOADSTOOL_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("wheelie_pup_entity"), WHEELIE_PUP_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("zombie_plush_entity"), ZOMBIE_PLUSHIE);

        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("cymbal_monkey_entity"), CYMBAL_MONKEY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("fox_plush_entity"), FOX_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("snowy_fox_plush_entity"), SNOWY_FOX_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("piggy_bank_entity"), PIGGY_BANK);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("rabbit_plush_entity"), RABBIT_PLUSHIE);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("sock_monkey_entity"), SOCK_MONKEY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("robot_entity"), ROBOT);

        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("petunia_pig_toy_entity"), PETUNIA_PIG_TOY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("happy_sun_toy_entity"), HAPPY_SUN_TOY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Playdate.modId("lollipop_clown_toy_entity"), LOLLIPOP_CLOWN_TOY);
    }

    private static BlockEntityType<?> createBlockPlushie(PlushieBlockEntityCreation creator, PlushieItem item, Block... blocks) {
        AtomicReference<BlockEntityType<?>> type = new AtomicReference<>();
        type.set(FabricBlockEntityTypeBuilder.create((pos, state) -> creator.create(item, type.get(), pos, state), blocks).build());
        return type.get();
    }

    @FunctionalInterface
    private interface PlushieBlockEntityCreation {
        BlockEntity create(PlushieItem item, BlockEntityType<?> type, BlockPos pos, BlockState state);
    }
}
