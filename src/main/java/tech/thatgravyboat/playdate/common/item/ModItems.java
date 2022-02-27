package tech.thatgravyboat.playdate.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class ModItems {

    public static final Item.Properties GROUP_SETTINGS = new Item.Properties().tab(ModItemGroups.GROUP);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PlayDate.MODID);

    public static final RegistryObject<Item> STUFFING = ITEMS.register("stuffing", () -> new Item(GROUP_SETTINGS));
    public static final RegistryObject<Item> SOFTWOOD = ITEMS.register("softwood", () -> new BlockItem(ModBlocks.SOFTWOOD.get(), GROUP_SETTINGS));
    public static final RegistryObject<Item> BOTTLED_SOUL = ITEMS.register("bottled_soul", () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroups.GROUP)));
    public static final RegistryObject<Item> BALLOON = ITEMS.register("balloon", () -> new BalloonItem(BalloonType.COLORED, GROUP_SETTINGS));
    public static final RegistryObject<Item> SUN_BALLOON = ITEMS.register("happy_sun_balloon", () -> new BalloonItem(BalloonType.SUN, GROUP_SETTINGS));
    public static final RegistryObject<Item> ROPE = ITEMS.register("rope", () -> new RopeItem(GROUP_SETTINGS));

    public static final RegistryObject<Item> PETUNIA_PIG_TOY = ITEMS.register("petunia_pig_toy", () -> new PlushItem(ModBlocks.PETUNIA_PIG_TOY.get(), PlushieItem.PETUNIA_PIG_TOY, GROUP_SETTINGS));
    public static final RegistryObject<Item> HAPPY_SUN_TOY = ITEMS.register("happy_sun_toy", () -> new PlushItem(ModBlocks.HAPPY_SUN_TOY.get(), PlushieItem.HAPPY_SUN_TOY, GROUP_SETTINGS));
    public static final RegistryObject<Item> LOLLIPOP_CLOWN_TOY = ITEMS.register("lollipop_clown_toy", () -> new PlushItem(ModBlocks.LOLLIPOP_CLOWN_TOY.get(), PlushieItem.LOLLIPOP_CLOWN_TOY, GROUP_SETTINGS));

    public static final RegistryObject<Item> CREEPER_PLUSHIE = ITEMS.register("creeper_plush", () -> new PlushItem(ModBlocks.CREEPER_PLUSHIE.get(), PlushieItem.CREEPER, GROUP_SETTINGS));
    public static final RegistryObject<Item> DINO_PLUSHIE = ITEMS.register("dino_plush", () -> new PlushItem(ModBlocks.DINO_PLUSHIE.get(), PlushieItem.DINO, GROUP_SETTINGS));
    public static final RegistryObject<Item> ENDERMAN_PLUSHIE = ITEMS.register("enderman_plush", () -> new PlushItem(ModBlocks.ENDERMAN_PLUSHIE.get(), PlushieItem.ENDERMAN, GROUP_SETTINGS));
    public static final RegistryObject<Item> HAPPY_SUN_PLUSHIE = ITEMS.register("happy_sun_plush", () -> new PlushItem(ModBlocks.HAPPY_SUN_PLUSHIE.get(), PlushieItem.HAPPY_SUN, GROUP_SETTINGS));
    public static final RegistryObject<Item> LOLLIPOP_CLOWN_PLUSHIE = ITEMS.register("lollipop_clown_plush", () -> new PlushItem(ModBlocks.LOLLIPOP_CLOWN_PLUSHIE.get(), PlushieItem.LOLLIPOP_CLOWN, GROUP_SETTINGS));
    public static final RegistryObject<Item> PETUNIA_PIG_PLUSHIE = ITEMS.register("petunia_pig_plush", () -> new PlushItem(ModBlocks.PETUNIA_PIG_PLUSHIE.get(), PlushieItem.PETUNIA_PIG, GROUP_SETTINGS));
    public static final RegistryObject<Item> RUBBER_DUCKY_PLUSHIE = ITEMS.register("rubber_ducky", () -> new PlushItem(ModBlocks.RUBBER_DUCKY_PLUSHIE.get(), PlushieItem.RUBBER_DUCKY, GROUP_SETTINGS));
    public static final RegistryObject<Item> TOADSTOOL_PLUSHIE = ITEMS.register("toadstool_studios_plush", () -> new PlushItem(ModBlocks.TOADSTOOL_PLUSHIE.get(), PlushieItem.TOADSTOOL, GROUP_SETTINGS));
    public static final RegistryObject<Item> WHEELIE_PUP_PLUSHIE = ITEMS.register("wheelie_pup", () -> new PlushItem(ModBlocks.WHEELIE_PUP_PLUSHIE.get(), PlushieItem.WHEELIE_PUP, GROUP_SETTINGS));
    public static final RegistryObject<Item> ZOMBIE_PLUSHIE = ITEMS.register("zombie_plush", () -> new PlushItem(ModBlocks.ZOMBIE_PLUSHIE.get(), PlushieItem.ZOMBIE, GROUP_SETTINGS));
    public static final RegistryObject<Item> CYMBAL_MONKEY = ITEMS.register("cymbal_monkey", () -> new PlushItem(ModBlocks.CYMBAL_MONKEY.get(), PlushieItem.CYMBAL_MONKEY, GROUP_SETTINGS));
    public static final RegistryObject<Item> FOX_PLUSHIE = ITEMS.register("fox_plush", () -> new PlushItem(ModBlocks.FOX_PLUSHIE.get(), PlushieItem.FOX, GROUP_SETTINGS));
    public static final RegistryObject<Item> SNOWY_FOX_PLUSHIE = ITEMS.register("snowy_fox_plush", () -> new PlushItem(ModBlocks.SNOWY_FOX_PLUSHIE.get(), PlushieItem.SNOWY_FOX, GROUP_SETTINGS));
    public static final RegistryObject<Item> PIGGY_BANK = ITEMS.register("piggy_bank", () -> new PlushItem(ModBlocks.PIGGY_BANK.get(), PlushieItem.PIGGY_BANK, GROUP_SETTINGS));
    public static final RegistryObject<Item> RABBIT_PLUSHIE = ITEMS.register("rabbit_plush", () -> new PlushItem(ModBlocks.RABBIT_PLUSHIE.get(), PlushieItem.RABBIT, GROUP_SETTINGS));
    public static final RegistryObject<Item> SOCK_MONKEY = ITEMS.register("sock_monkey", () -> new PlushItem(ModBlocks.SOCK_MONKEY.get(), PlushieItem.SOCK_MONKEY, GROUP_SETTINGS));
    public static final RegistryObject<Item> ROBOT = ITEMS.register("robot", () -> new PlushItem(ModBlocks.ROBOT.get(), PlushieItem.ROBOT, GROUP_SETTINGS));

}
