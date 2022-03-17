package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;
import tech.thatgravyboat.playdate.common.blocks.custom.CreeperPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.CymbalMonkeyPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.EndermanPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.ToadstoolPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.piggybank.PiggyBankPlushieBlock;
import tech.thatgravyboat.playdate.common.constants.Letters;
import tech.thatgravyboat.playdate.common.entity.ModEntities;

import java.util.List;

public class ModBlocks {

    private static final BlockBehaviour.Properties PLUSHIE_SETTINGS = BlockBehaviour.Properties.of(Material.WOOL).strength(0.4f).sound(SoundType.WOOL);
    private static final BlockBehaviour.Properties METAL_SETTINGS = BlockBehaviour.Properties.of(Material.METAL).strength(0.4f).sound(SoundType.METAL);
    private static final BlockBehaviour.Properties GLASS_SETTINGS = BlockBehaviour.Properties.of(Material.GLASS).strength(0.4f).sound(SoundType.GLASS);
    private static final BlockBehaviour.Properties SLIME_SETTINGS = BlockBehaviour.Properties.of(Material.WOOL).strength(0.4f).sound(SoundType.SLIME_BLOCK);
    private static final BlockBehaviour.Properties WOOD_SETTINGS = BlockBehaviour.Properties.of(Material.WOOD).strength(0.4f).sound(SoundType.WOOD);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PlayDate.MODID);

    public static final RegistryObject<Block> SOFTWOOD = BLOCKS.register("softwood",
            () -> new LetterBlock(-2, BlockBehaviour.Properties.of(Material.WOOD).strength(1).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIGHT_SOFTWOOD = BLOCKS.register("light_softwood",
            () -> new LetterBlock(-1, BlockBehaviour.Properties.of(Material.WOOD).strength(1).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PETUNIA_PIG_TOY = BLOCKS.register("petunia_pig_toy",
            () -> new ToyBlock(ModEntities.PETUNIA_PIG, ModBlockEntities.PETUNIA_PIG_TOY, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> HAPPY_SUN_TOY = BLOCKS.register("happy_sun_toy",
            () -> new ToyBlock(ModEntities.HAPPY_SUN, ModBlockEntities.HAPPY_SUN_TOY, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> LOLLIPOP_CLOWN_TOY = BLOCKS.register("lollipop_clown_toy",
            () -> new ToyBlock(ModEntities.LOLLIPOP_CLOWN, ModBlockEntities.LOLLIPOP_CLOWN_TOY, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> STUFFIE_TOY = BLOCKS.register("stuffie_toy",
            () -> new ToyBlock(ModEntities.STUFFIE, ModBlockEntities.STUFFIE_TOY, PLUSHIE_SETTINGS));

    public static final RegistryObject<Block> CREEPER_PLUSHIE = BLOCKS.register("creeper_plush",
            () -> new CreeperPlushieBlock(ModBlockEntities.CREEPER_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> DINO_PLUSHIE = BLOCKS.register("dino_plush",
            () -> new PlushieBlock(ModBlockEntities.DINO_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> ENDERMAN_PLUSHIE = BLOCKS.register("enderman_plush",
            () -> new EndermanPlushieBlock(ModBlockEntities.ENDERMAN_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> HAPPY_SUN_PLUSHIE = BLOCKS.register("happy_sun_plush",
            () -> new PlushieBlock(ModBlockEntities.HAPPY_SUN_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> LOLLIPOP_CLOWN_PLUSHIE = BLOCKS.register("lollipop_clown_plush",
            () -> new PlushieBlock(ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> PETUNIA_PIG_PLUSHIE = BLOCKS.register("petunia_pig_plush",
            () -> new PlushieBlock(ModBlockEntities.PETUNIA_PIG_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> RUBBER_DUCKY_PLUSHIE = BLOCKS.register("rubber_ducky",
            () -> new PlushieBlock(ModBlockEntities.RUBBER_DUCKY_PLUSHIE, SLIME_SETTINGS));
    public static final RegistryObject<Block> TOADSTOOL_PLUSHIE = BLOCKS.register("toadstool_studios_plush",
            () -> new ToadstoolPlushieBlock(ModBlockEntities.TOADSTOOL_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> WHEELIE_PUP_PLUSHIE = BLOCKS.register("wheelie_pup",
            () -> new PlushieBlock(ModBlockEntities.WHEELIE_PUP_PLUSHIE, WOOD_SETTINGS));
    public static final RegistryObject<Block> ZOMBIE_PLUSHIE = BLOCKS.register("zombie_plush",
            () -> new PlushieBlock(ModBlockEntities.ZOMBIE_PLUSHIE, PLUSHIE_SETTINGS));

    public static final RegistryObject<Block> CYMBAL_MONKEY = BLOCKS.register("cymbal_monkey",
            () -> new CymbalMonkeyPlushieBlock(ModBlockEntities.CYMBAL_MONKEY, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> FOX_PLUSHIE = BLOCKS.register("fox_plush",
            () -> new PlushieBlock(ModBlockEntities.FOX_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> SNOWY_FOX_PLUSHIE = BLOCKS.register("snowy_fox_plush",
            () -> new PlushieBlock(ModBlockEntities.SNOWY_FOX_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> PIGGY_BANK = BLOCKS.register("piggy_bank",
            () -> new PiggyBankPlushieBlock(ModBlockEntities.PIGGY_BANK, GLASS_SETTINGS));
    public static final RegistryObject<Block> RABBIT_PLUSHIE = BLOCKS.register("rabbit_plush",
            () -> new PlushieBlock(ModBlockEntities.RABBIT_PLUSHIE, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> SOCK_MONKEY = BLOCKS.register("sock_monkey",
            () -> new ToyBlock(ModEntities.SOCK_MONKEY, ModBlockEntities.SOCK_MONKEY, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> ROBOT = BLOCKS.register("robot",
            () -> new PlushieBlock(ModBlockEntities.ROBOT, METAL_SETTINGS));

    //region Cuddle Cubs
    public static final RegistryObject<Block> AROMANTIC_CUB = BLOCKS.register("aromantic_cub",
            () -> new PlushieBlock(ModBlockEntities.AROMANTIC_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> ASEXUAL_CUB = BLOCKS.register("asexual_cub",
            () -> new PlushieBlock(ModBlockEntities.ASEXUAL_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> BISEXUAL_CUB = BLOCKS.register("bisexual_cub",
            () -> new PlushieBlock(ModBlockEntities.BISEXUAL_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> PRIDE_CUB = BLOCKS.register("pride_cub",
            () -> new PlushieBlock(ModBlockEntities.PRIDE_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> GENDERQUEER_CUB = BLOCKS.register("genderqueer_cub",
            () -> new PlushieBlock(ModBlockEntities.GENDERQUEER_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> LESBIAN_CUB = BLOCKS.register("lesbian_cub",
            () -> new PlushieBlock(ModBlockEntities.LESBIAN_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> NONBINARY_CUB = BLOCKS.register("nonbinary_cub",
            () -> new PlushieBlock(ModBlockEntities.NONBINARY_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> PANSEXUAL_CUB = BLOCKS.register("pansexual_cub",
            () -> new PlushieBlock(ModBlockEntities.PANSEXUAL_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> TRANS_CUB = BLOCKS.register("trans_cub",
            () -> new PlushieBlock(ModBlockEntities.TRANS_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> PANDA_CUB = BLOCKS.register("panda_cub",
            () -> new PlushieBlock(ModBlockEntities.PANDA_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> POLAR_CUB = BLOCKS.register("polar_cub",
            () -> new PlushieBlock(ModBlockEntities.POLAR_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> STUFFIE_CUB = BLOCKS.register("stuffie_cub",
            () -> new PlushieBlock(ModBlockEntities.STUFFIE_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> COOL_CUB = BLOCKS.register("cool_cub",
            () -> new PlushieBlock(ModBlockEntities.COOL_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> BROWN_CUB = BLOCKS.register("brown_cub",
            () -> new PlushieBlock(ModBlockEntities.BROWN_CUB, PLUSHIE_SETTINGS));
    public static final RegistryObject<Block> HONEY_CUB = BLOCKS.register("honey_cub",
            () -> new PlushieBlock(ModBlockEntities.HONEY_CUB, PLUSHIE_SETTINGS));
    //endregion

    public static final List<RegistryObject<Block>> LETTER_BLOCKS = Letters.createBlocks();

    public static final RegistryObject<Block> BALLPIT = BLOCKS.register("ballpit",
            () -> new BallPitBlock(BlockBehaviour.Properties.of(Material.WOOL).dynamicShape()));

    public static final RegistryObject<Block> MESH_WALL = BLOCKS.register("mesh_wall",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.3F)));
}
