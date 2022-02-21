package tech.thatgravyboat.playdate.common.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.custom.CreeperPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.EndermanPlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.custom.ToadstoolPlushieBlock;
import tech.thatgravyboat.playdate.common.entity.ModEntities;

public class ModBlocks {

    private static final FabricBlockSettings PLUSHIE_SETTINGS = FabricBlockSettings.of(Material.WOOL).strength(0.4f).sounds(BlockSoundGroup.WOOL).breakByHand(true);

    public static final Block SOFTWOOD = new Block(FabricBlockSettings.of(Material.WOOD).strength(1).breakByHand(true).sounds(BlockSoundGroup.WOOD));

    public static final Block PETUNIA_PIG_TOY = new ToyBlock(() -> ModEntities.PETUNIA_PIG, () -> ModBlockEntities.PETUNIA_PIG_TOY, PLUSHIE_SETTINGS);
    public static final Block HAPPY_SUN_TOY = new ToyBlock(() -> ModEntities.HAPPY_SUN, () -> ModBlockEntities.HAPPY_SUN_TOY, PLUSHIE_SETTINGS);
    public static final Block LOLLIPOP_CLOWN_TOY = new ToyBlock(() -> ModEntities.LOLLIPOP_CLOWN, () -> ModBlockEntities.LOLLIPOP_CLOWN_TOY, PLUSHIE_SETTINGS);

    public static final Block CREEPER_PLUSHIE = new CreeperPlushieBlock(() -> ModBlockEntities.CREEPER_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block DINO_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.DINO_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block ENDERMAN_PLUSHIE = new EndermanPlushieBlock(() -> ModBlockEntities.ENDERMAN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block HAPPY_SUN_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.HAPPY_SUN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block LOLLIPOP_CLOWN_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.LOLLIPOP_CLOWN_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block PETUNIA_PIG_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.PETUNIA_PIG_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block RUBBER_DUCKY_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.RUBBER_DUCKY_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block TOADSTOOL_PLUSHIE = new ToadstoolPlushieBlock(() -> ModBlockEntities.TOADSTOOL_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block WHEELIE_PUP_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.WHEELIE_PUP_PLUSHIE, PLUSHIE_SETTINGS);
    public static final Block ZOMBIE_PLUSHIE = new PlushieBlock(() -> ModBlockEntities.ZOMBIE_PLUSHIE, PLUSHIE_SETTINGS);

    public static void register() {
        Registry.register(Registry.BLOCK, Playdate.modId("softwood"), SOFTWOOD);
        Registry.register(Registry.BLOCK, Playdate.modId("petunia_pig_toy"), PETUNIA_PIG_TOY);
        Registry.register(Registry.BLOCK, Playdate.modId("happy_sun_toy"), HAPPY_SUN_TOY);
        Registry.register(Registry.BLOCK, Playdate.modId("lollipop_clown_toy"), LOLLIPOP_CLOWN_TOY);

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
    }
}
