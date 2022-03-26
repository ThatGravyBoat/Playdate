package tech.thatgravyboat.playdate.common.registry;

import com.google.common.base.Suppliers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.sound.BlockSoundGroup;
import tech.thatgravyboat.playdate.common.blocks.LetterBlock;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollHouseBlock;
import tech.thatgravyboat.playdate.common.blocks.musicbox.MusicBoxBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.ToyBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.CreeperPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.CymbalMonkeyPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.EndermanPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.piggybank.PiggyBankPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.player.PlayerPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.powered.PoweredPlushieBlock;
import tech.thatgravyboat.playdate.common.constants.Letters;
import tech.thatgravyboat.playdate.common.registry.base.BasicRegistry;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.List;
import java.util.function.Supplier;

//For some reason the suppliers are null, so we just wrap the supplier in another supplier.
@SuppressWarnings({"Convert2MethodRef"})
public class ModBlocks {

    public static final AbstractBlock.Settings PLUSHIE_SETTINGS = AbstractBlock.Settings.of(Material.WOOL).strength(0.4f).sounds(BlockSoundGroup.WOOL);
    public static final AbstractBlock.Settings METAL_SETTINGS = AbstractBlock.Settings.of(Material.METAL).strength(0.4f).sounds(BlockSoundGroup.METAL);
    public static final AbstractBlock.Settings GLASS_SETTINGS = AbstractBlock.Settings.of(Material.GLASS).strength(0.4f).sounds(BlockSoundGroup.GLASS);
    public static final AbstractBlock.Settings SLIME_SETTINGS = AbstractBlock.Settings.of(Material.WOOL).strength(0.4f).sounds(BlockSoundGroup.SLIME);
    public static final AbstractBlock.Settings WOOD_SETTINGS = AbstractBlock.Settings.of(Material.WOOD).strength(0.4f).sounds(BlockSoundGroup.WOOD);

    public static final AbstractBlock.Settings SOFTWOOD_SETTINGS = AbstractBlock.Settings.of(Material.WOOD).strength(1f).sounds(BlockSoundGroup.WOOD);

    public static final Supplier<Block> SOFTWOOD = CommonServices.REGISTRY.registerBlock("softwood", () -> new LetterBlock(-2, SOFTWOOD_SETTINGS));
    public static final Supplier<Block> LIGHT_SOFTWOOD = CommonServices.REGISTRY.registerBlock("light_softwood", () -> new LetterBlock(-1, SOFTWOOD_SETTINGS));


    //region Toy
    public static final BasicRegistry<Block> TOYS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlock);

    public static final Supplier<Block> PETUNIA_PIG_TOY = TOYS.register("petunia_pig_toy",
            () -> new ToyBlock(ModEntities.PETUNIA_PIG::get, Suppliers.memoize(() -> ModBlockEntities.PETUNIA_PIG_TOY.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> HAPPY_SUN_TOY = TOYS.register("happy_sun_toy",
            () -> new ToyBlock(ModEntities.HAPPY_SUN::get, Suppliers.memoize(() -> ModBlockEntities.HAPPY_SUN_TOY.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> LOLLIPOP_CLOWN_TOY = TOYS.register("lollipop_clown_toy",
            () -> new ToyBlock(ModEntities.LOLLIPOP_CLOWN::get, Suppliers.memoize(() -> ModBlockEntities.LOLLIPOP_CLOWN_TOY.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> STUFFIE_TOY = TOYS.register("stuffie_toy",
            () -> new ToyBlock(ModEntities.STUFFIE::get, Suppliers.memoize(() -> ModBlockEntities.STUFFIE_TOY.get()), PLUSHIE_SETTINGS));
    //endregion

    //region Plushies
    public static final BasicRegistry<Block> PLUSHIES = new BasicRegistry<>(CommonServices.REGISTRY::registerBlock);

    public static final Supplier<Block> CREEPER_PLUSHIE = PLUSHIES.register("creeper_plush",
            () -> new CreeperPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.CREEPER_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> DINO_PLUSHIE = PLUSHIES.register("dino_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.DINO_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> ENDERMAN_PLUSHIE = PLUSHIES.register("enderman_plush",
            () -> new EndermanPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ENDERMAN_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> HAPPY_SUN_PLUSHIE = PLUSHIES.register("happy_sun_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.HAPPY_SUN_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> LOLLIPOP_CLOWN_PLUSHIE = PLUSHIES.register("lollipop_clown_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> PETUNIA_PIG_PLUSHIE = PLUSHIES.register("petunia_pig_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.PETUNIA_PIG_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> RUBBER_DUCKY_PLUSHIE = PLUSHIES.register("rubber_ducky",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.RUBBER_DUCKY_PLUSHIE.get()), SLIME_SETTINGS));
    public static final Supplier<Block> WHEELIE_PUP_PLUSHIE = PLUSHIES.register("wheelie_pup",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.WHEELIE_PUP_PLUSHIE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> ZOMBIE_PLUSHIE = PLUSHIES.register("zombie_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ZOMBIE_PLUSHIE.get()), PLUSHIE_SETTINGS));

    public static final Supplier<Block> CYMBAL_MONKEY = PLUSHIES.register("cymbal_monkey",
            () -> new CymbalMonkeyPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.CYMBAL_MONKEY.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> FOX_PLUSHIE = PLUSHIES.register("fox_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.FOX_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> SNOWY_FOX_PLUSHIE = PLUSHIES.register("snowy_fox_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.SNOWY_FOX_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> PIGGY_BANK = PLUSHIES.register("piggy_bank",
            () -> new PiggyBankPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.PIGGY_BANK.get()), GLASS_SETTINGS));
    public static final Supplier<Block> RABBIT_PLUSHIE = PLUSHIES.register("rabbit_plush",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.RABBIT_PLUSHIE.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> SOCK_MONKEY = PLUSHIES.register("sock_monkey",
            () -> new ToyBlock(ModEntities.SOCK_MONKEY::get, Suppliers.memoize(() -> ModBlockEntities.SOCK_MONKEY.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> ROBOT = PLUSHIES.register("robot",
            () -> new PoweredPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ROBOT.get()), METAL_SETTINGS));
    //endregion

    //region Cuddle Cubs
    public static final BasicRegistry<Block> CUBS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlock);

    public static final Supplier<Block> AROMANTIC_CUB = CUBS.register("aromantic_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.AROMANTIC_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> ASEXUAL_CUB = CUBS.register("asexual_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ASEXUAL_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> BISEXUAL_CUB = CUBS.register("bisexual_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.BISEXUAL_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> PRIDE_CUB = CUBS.register("pride_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.PRIDE_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> GENDERQUEER_CUB = CUBS.register("genderqueer_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.GENDERQUEER_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> LESBIAN_CUB = CUBS.register("lesbian_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.LESBIAN_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> NONBINARY_CUB = CUBS.register("nonbinary_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.NONBINARY_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> PANSEXUAL_CUB = CUBS.register("pansexual_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.PANSEXUAL_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> TRANS_CUB = CUBS.register("trans_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.TRANS_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> PANDA_CUB = CUBS.register("panda_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.PANDA_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> POLAR_CUB = CUBS.register("polar_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.POLAR_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> STUFFIE_CUB =CUBS.register("stuffie_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.STUFFIE_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> COOL_CUB = CUBS.register("cool_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.COOL_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> BROWN_CUB = CUBS.register("brown_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.BROWN_CUB.get()), PLUSHIE_SETTINGS));
    public static final Supplier<Block> HONEY_CUB = CUBS.register("honey_cub",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.HONEY_CUB.get()), PLUSHIE_SETTINGS));
    //endregion

    public static final List<Supplier<Block>> LETTER_BLOCKS = Letters.createBlocks();

    public static final Supplier<Block> BALLPIT = CommonServices.REGISTRY.registerBlock("ballpit",
            () -> CommonServices.PLATFORM.createBallpitBlock(AbstractBlock.Settings.of(Material.WOOL).dynamicBounds()));

    public static final Supplier<Block> MESH_WALL = CommonServices.REGISTRY.registerBlock("mesh_wall",
            () -> new PaneBlock(AbstractBlock.Settings.of(Material.WOOL).strength(0.3F)){});

    public static final Supplier<Block> STEVE = CommonServices.REGISTRY.registerBlock("steve_plush",
            () -> new PlayerPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.STEVE.get()), PLUSHIE_SETTINGS));

    public static final Supplier<Block> ALEX = CommonServices.REGISTRY.registerBlock("alex_plush",
            () -> new PlayerPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ALEX.get()), PLUSHIE_SETTINGS));

    //region Dolls

    public static final BasicRegistry<Block> DOLLS = new BasicRegistry<>(CommonServices.REGISTRY::registerBlock);
    public static final BasicRegistry<Block> DOLLHOUSES = new BasicRegistry<>(CommonServices.REGISTRY::registerBlock);

    public static final Supplier<Block> OAK_DOLLHOUSE = DOLLHOUSES.register("oak_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.OAK_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> BIRCH_DOLLHOUSE = DOLLHOUSES.register("birch_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.BIRCH_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> SPRUCE_DOLLHOUSE = DOLLHOUSES.register("spruce_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.SPRUCE_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> DARK_OAK_DOLLHOUSE = DOLLHOUSES.register("dark_oak_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.DARK_OAK_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> JUNGLE_DOLLHOUSE = DOLLHOUSES.register("jungle_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.JUNGLE_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> ACACIA_DOLLHOUSE = DOLLHOUSES.register("acacia_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.ACACIA_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> CRIMSON_DOLLHOUSE = DOLLHOUSES.register("crimson_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.CRIMSON_DOLLHOUSE.get()), WOOD_SETTINGS));
    public static final Supplier<Block> WARPED_DOLLHOUSE = DOLLHOUSES.register("warped_dollhouse",
            () -> new DollHouseBlock(Suppliers.memoize(() -> ModBlockEntities.WARPED_DOLLHOUSE.get()), WOOD_SETTINGS));

    public static final Supplier<Block> OAK_DOLL = DOLLS.register("oak_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.OAK_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> BIRCH_DOLL = DOLLS.register("birch_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.BIRCH_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> SPRUCE_DOLL = DOLLS.register("spruce_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.SPRUCE_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> DARK_OAK_DOLL = DOLLS.register("dark_oak_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.DARK_OAK_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> JUNGLE_DOLL = DOLLS.register("jungle_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.JUNGLE_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> ACACIA_DOLL = DOLLS.register("acacia_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.ACACIA_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> CRIMSON_DOLL = DOLLS.register("crimson_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.CRIMSON_DOLL.get()), WOOD_SETTINGS));
    public static final Supplier<Block> WARPED_DOLL = DOLLS.register("warped_doll",
            () -> new PlushieBlock(Suppliers.memoize(() -> ModBlockEntities.WARPED_DOLL.get()), WOOD_SETTINGS));
    //endregion

    public static final Supplier<Block> MUSIC_BOX = CommonServices.REGISTRY.registerBlock("music_box",
            () -> new MusicBoxBlock(Suppliers.memoize(() -> ModBlockEntities.MUSIC_BOX.get()), WOOD_SETTINGS));

    public static final Supplier<Block> DUMMY = PLUSHIES.register("dummy",
            () -> new PoweredPlushieBlock(Suppliers.memoize(() -> ModBlockEntities.DUMMY.get()), PLUSHIE_SETTINGS));

    public static void register() {
        //Initialize class.
    }
}
