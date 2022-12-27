package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BannerPattern;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModBannerPatterns {

    public static final ResourcefulRegistry<BannerPattern> PATTERNS = ResourcefulRegistries.create(Registry.BANNER_PATTERN, Playdate.MOD_ID);

    public static final RegistryEntry<BannerPattern> SMILEY = PATTERNS.register("smiley", () -> new BannerPattern("smiley"));
}
