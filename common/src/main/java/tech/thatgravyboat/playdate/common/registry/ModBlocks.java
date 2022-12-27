package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.*;
import tech.thatgravyboat.playdate.common.blocks.shapes.BlockShapes;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModBlocks {

    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(Registry.BLOCK, Playdate.MOD_ID);

    public static final RegistryEntry<Block> TOY_BENCH = BLOCKS.register("toy_bench", () -> new ToyBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> DINO = BLOCKS.register("dino", () -> new DirectionalToyBlock(BlockShapes.DINO, BlockBehaviour.Properties.copy(Blocks.GREEN_WOOL)));
    public static final RegistryEntry<Block> TEDDY_BEAR = BLOCKS.register("teddy_bear", () -> new DirectionalToyBlock(BlockShapes.TEDDY_BEAR, BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL)));
    public static final RegistryEntry<Block> RING_TOWER = BLOCKS.register("ring_tower", () -> new ToyBlock(BlockShapes.RINO_TOWER, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> ROCKING_HORSE = BLOCKS.register("rocking_horse", () -> new SittingToyBlock(BlockShapes.ROCKING_HORSE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> TOY_BOAT = BLOCKS.register("toy_boat", () -> new DirectionalToyBlock(BlockShapes.TOY_BOAT, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> TOY_TRAIN = BLOCKS.register("toy_train", () -> new DirectionalToyBlock(BlockShapes.TOY_TRAIN, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> PIGGY_BANK = BLOCKS.register("piggy_bank", () -> new FiveSlotToyBlock(BlockShapes.PIGGY_BANK, BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.GLASS).strength(2.0F, 3.0F)));
    public static final RegistryEntry<Block> MUSIC_BOX = BLOCKS.register("music_box", () -> new MusicBoxBlock(BlockShapes.MUSIC_BOX, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
}
