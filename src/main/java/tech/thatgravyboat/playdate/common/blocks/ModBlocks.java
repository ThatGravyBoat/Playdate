package tech.thatgravyboat.playdate.common.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.custom.CreeperPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.CymbalMonkeyPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.EndermanPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.ToadstoolPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.piggybank.PiggyBankPlushieBlock;
import tech.thatgravyboat.playdate.common.constants.Letters;
import tech.thatgravyboat.playdate.common.entity.ModEntities;

import java.util.List;

public class ModBlocks {

    private static final FabricBlockSettings PLUSHIE_SETTINGS = FabricBlockSettings.of(Material.WOOL).strength(0.4f).sounds(BlockSoundGroup.WOOL);
    private static final FabricBlockSettings METAL_SETTINGS = FabricBlockSettings.of(Material.METAL).strength(0.4f).sounds(BlockSoundGroup.METAL);
    private static final FabricBlockSettings GLASS_SETTINGS = FabricBlockSettings.of(Material.GLASS).strength(0.4f).sounds(BlockSoundGroup.GLASS);
    private static final FabricBlockSettings SLIME_SETTINGS = FabricBlockSettings.of(Material.WOOL).strength(0.4f).sounds(BlockSoundGroup.SLIME);
    private static final FabricBlockSettings WOOD_SETTINGS = FabricBlockSettings.of(Material.WOOD).strength(0.4f).sounds(BlockSoundGroup.WOOD);

    public static final Block SOFTWOOD = new LetterBlock(-2, FabricBlockSettings.of(Material.WOOD).strength(1).sounds(BlockSoundGroup.WOOD));
    public static final Block LIGHT_SOFTWOOD = new LetterBlock(-1, FabricBlockSettings.of(Material.WOOD).strength(1).sounds(BlockSoundGroup.WOOD));

    //region Toys
    public static final Block PETUNIA_PIG_TOY = new ToyBlock(() -> ModEntities.PETUNIA_PIG, () -> ModBlockEntities.PETUNIA_PIG_TOY, PLUSHIE_SETTINGS);
    public static final Block HAPPY_SUN_TOY = new ToyBlock(() -> ModEntities.HAPPY_SUN, () -> ModBlockEntities.HAPPY_SUN_TOY, PLUSHIE_SETTINGS);
    public static final Block LOLLIPOP_CLOWN_TOY = new ToyBlock(() -> ModEntities.LOLLIPOP_CLOWN, () -> ModBlockEntities.LOLLIPOP_CLOWN_TOY, PLUSHIE_SETTINGS);
    public static final Block STUFFIE_TOY = new ToyBlock(() -> ModEntities.STUFFIE, () -> ModBlockEntities.STUFFIE_TOY, PLUSHIE_SETTINGS);
    //endregion

    //region Plushies
    public static final Block CREEPER_PLUSHIE = new CreeperPlushieBlock(() -> ModBlockEntities.CREEPER_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block DINO_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.DINO_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block ENDERMAN_PLUSHIE = new EndermanPlushieBlock(() -> ModBlockEntities.ENDERMAN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block HAPPY_SUN_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.HAPPY_SUN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block LOLLIPOP_CLOWN_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block PETUNIA_PIG_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.PETUNIA_PIG_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block RUBBER_DUCKY_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.RUBBER_DUCKY_PLUSHIE, SLIME_SETTINGS);
    public static final Block TOADSTOOL_PLUSHIE = new ToadstoolPlushieBlock(() -> ModBlockEntities.TOADSTOOL_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block WHEELIE_PUP_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.WHEELIE_PUP_PLUSHIE, WOOD_SETTINGS);
    public static final Block ZOMBIE_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.ZOMBIE_PLUSHIE, PLUSHIE_SETTINGS);

    public static final Block CYMBAL_MONKEY = new CymbalMonkeyPlushieBlock(() -> ModBlockEntities.CYMBAL_MONKEY, PLUSHIE_SETTINGS);
    public static final Block FOX_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.FOX_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block SNOWY_FOX_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.SNOWY_FOX_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block PIGGY_BANK = new PiggyBankPlushieBlock(() -> ModBlockEntities.PIGGY_BANK, GLASS_SETTINGS);
    public static final Block RABBIT_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.RABBIT_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block SOCK_MONKEY = new ToyBlock(() -> ModEntities.SOCK_MONKEY, () -> ModBlockEntities.SOCK_MONKEY, PLUSHIE_SETTINGS);
    public static final Block ROBOT = new PlushieBlock(() -> ModBlockEntities.ROBOT, METAL_SETTINGS);
    //endregion

    //region Cuddle Cubs
    public static final Block AROMANTIC_CUB = new PlushieBlock(() -> ModBlockEntities.AROMANTIC_CUB, METAL_SETTINGS);
    public static final Block ASEXUAL_CUB = new PlushieBlock(() -> ModBlockEntities.ASEXUAL_CUB, METAL_SETTINGS);
    public static final Block BISEXUAL_CUB = new PlushieBlock(() -> ModBlockEntities.BISEXUAL_CUB, METAL_SETTINGS);
    public static final Block PRIDE_CUB = new PlushieBlock(() -> ModBlockEntities.PRIDE_CUB, METAL_SETTINGS);
    public static final Block GENDERQUEER_CUB = new PlushieBlock(() -> ModBlockEntities.GENDERQUEER_CUB, METAL_SETTINGS);
    public static final Block LESBIAN_CUB = new PlushieBlock(() -> ModBlockEntities.LESBIAN_CUB, METAL_SETTINGS);
    public static final Block NONBINARY_CUB = new PlushieBlock(() -> ModBlockEntities.NONBINARY_CUB, METAL_SETTINGS);
    public static final Block PANSEXUAL_CUB = new PlushieBlock(() -> ModBlockEntities.PANSEXUAL_CUB, METAL_SETTINGS);
    public static final Block TRANS_CUB = new PlushieBlock(() -> ModBlockEntities.TRANS_CUB, METAL_SETTINGS);
    public static final Block PANDA_CUB = new PlushieBlock(() -> ModBlockEntities.PANDA_CUB, METAL_SETTINGS);
    public static final Block POLAR_CUB = new PlushieBlock(() -> ModBlockEntities.POLAR_CUB, METAL_SETTINGS);
    public static final Block STUFFIE_CUB = new PlushieBlock(() -> ModBlockEntities.STUFFIE_CUB, METAL_SETTINGS);
    public static final Block COOL_CUB = new PlushieBlock(() -> ModBlockEntities.COOL_CUB, METAL_SETTINGS);
    public static final Block BROWN_CUB = new PlushieBlock(() -> ModBlockEntities.BROWN_CUB, METAL_SETTINGS);
    public static final Block HONEY_CUB = new PlushieBlock(() -> ModBlockEntities.HONEY_CUB, METAL_SETTINGS);
    //endregion

    public static final List<Block> LETTER_BLOCKS = Letters.createBlocks();

    public static final BallPitBlock BALLPIT = new BallPitBlock(FabricBlockSettings.of(Material.WOOL).dynamicBounds());
    public static final PaneBlock MESH_WALL = new PaneBlock(FabricBlockSettings.of(Material.WOOL).strength(0.3F)){};

    public static void register() {
        Registry.register(Registry.BLOCK, Playdate.modId("softwood"), SOFTWOOD);
        Registry.register(Registry.BLOCK, Playdate.modId("light_softwood"), LIGHT_SOFTWOOD);
        Registry.register(Registry.BLOCK, Playdate.modId("ballpit"), BALLPIT);
        Registry.register(Registry.BLOCK, Playdate.modId("mesh_wall"), MESH_WALL);

        Registry.register(Registry.BLOCK, Playdate.modId("petunia_pig_toy"), PETUNIA_PIG_TOY);
        Registry.register(Registry.BLOCK, Playdate.modId("happy_sun_toy"), HAPPY_SUN_TOY);
        Registry.register(Registry.BLOCK, Playdate.modId("lollipop_clown_toy"), LOLLIPOP_CLOWN_TOY);
        Registry.register(Registry.BLOCK, Playdate.modId("stuffie_toy"), STUFFIE_TOY);

        Registry.register(Registry.BLOCK, Playdate.modId("creeper_plush"), CREEPER_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("dino_plush"), DINO_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("enderman_plush"), ENDERMAN_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("happy_sun_plush"), HAPPY_SUN_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("lollipop_clown_plush"), LOLLIPOP_CLOWN_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("petunia_pig_plush"), PETUNIA_PIG_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("rubber_ducky"), RUBBER_DUCKY_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("toadstool_studios_plush"), TOADSTOOL_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("wheelie_pup"), WHEELIE_PUP_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("zombie_plush"), ZOMBIE_PLUSHIE);

        Registry.register(Registry.BLOCK, Playdate.modId("cymbal_monkey"), CYMBAL_MONKEY);
        Registry.register(Registry.BLOCK, Playdate.modId("fox_plush"), FOX_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("snowy_fox_plush"), SNOWY_FOX_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("piggy_bank"), PIGGY_BANK);
        Registry.register(Registry.BLOCK, Playdate.modId("rabbit_plush"), RABBIT_PLUSHIE);
        Registry.register(Registry.BLOCK, Playdate.modId("sock_monkey"), SOCK_MONKEY);
        Registry.register(Registry.BLOCK, Playdate.modId("robot"), ROBOT);

        //region Cuddle Cubs
        Registry.register(Registry.BLOCK, Playdate.modId("aromantic_cub"), AROMANTIC_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("asexual_cub"), ASEXUAL_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("bisexual_cub"), BISEXUAL_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("pride_cub"), PRIDE_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("genderqueer_cub"), GENDERQUEER_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("lesbian_cub"), LESBIAN_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("nonbinary_cub"), NONBINARY_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("pansexual_cub"), PANSEXUAL_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("trans_cub"), TRANS_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("panda_cub"), PANDA_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("polar_cub"), POLAR_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("stuffie_cub"), STUFFIE_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("cool_cub"), COOL_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("brown_cub"), BROWN_CUB);
        Registry.register(Registry.BLOCK, Playdate.modId("honey_cub"), HONEY_CUB);
        //endregion

        for (int i = 0; i < LETTER_BLOCKS.size(); i++) {
            Registry.register(Registry.BLOCK, Letters.formatFromId(i), LETTER_BLOCKS.get(i));
        }
    }
}
