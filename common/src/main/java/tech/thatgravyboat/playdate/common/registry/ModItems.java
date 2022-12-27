package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModItems {

    private static final TagKey<BannerPattern> SMIELY_TAG = TagKey.create(Registry.BANNER_PATTERN_REGISTRY, new ResourceLocation(Playdate.MOD_ID, "smiley"));

    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, Playdate.MOD_ID);

    public static final RegistryEntry<Item> TOY_BENCH = ITEMS.register("toy_bench", () -> new BlockItem(ModBlocks.TOY_BENCH.get(), defaultProperties()));
    public static final RegistryEntry<Item> DINO = ITEMS.register("dino", () -> new BlockItem(ModBlocks.DINO.get(), defaultProperties()));
    public static final RegistryEntry<Item> TEDDY_BEAR = ITEMS.register("teddy_bear", () -> new BlockItem(ModBlocks.TEDDY_BEAR.get(), defaultProperties()));
    public static final RegistryEntry<Item> RING_TOWER = ITEMS.register("ring_tower", () -> new BlockItem(ModBlocks.RING_TOWER.get(), defaultProperties()));
    public static final RegistryEntry<Item> ROCKING_HORSE = ITEMS.register("rocking_horse", () -> new BlockItem(ModBlocks.ROCKING_HORSE.get(), defaultProperties()));
    public static final RegistryEntry<Item> TOY_BOAT = ITEMS.register("toy_boat", () -> new BlockItem(ModBlocks.TOY_BOAT.get(), defaultProperties()));
    public static final RegistryEntry<Item> TOY_TRAIN = ITEMS.register("toy_train", () -> new BlockItem(ModBlocks.TOY_TRAIN.get(), defaultProperties()));
    public static final RegistryEntry<Item> PIGGY_BANK = ITEMS.register("piggy_bank", () -> new BlockItem(ModBlocks.PIGGY_BANK.get(), defaultProperties()));
    public static final RegistryEntry<Item> MUSIC_BOX = ITEMS.register("music_box", () -> new BlockItem(ModBlocks.MUSIC_BOX.get(), defaultProperties()));
    public static final RegistryEntry<Item> SMILEY_PATTERN = ITEMS.register("smiley_banner_pattern", () -> new BannerPatternItem(SMIELY_TAG, defaultProperties()));

    private static Item.Properties defaultProperties() {
        return new Item.Properties().tab(ModCreativeTab.TAB);
    }
}
