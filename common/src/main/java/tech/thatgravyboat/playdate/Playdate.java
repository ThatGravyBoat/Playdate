package tech.thatgravyboat.playdate;

import tech.thatgravyboat.playdate.common.registry.*;

public class Playdate {
    public static final String MOD_ID = "playdate";

    public static void init() {
        ModItems.ITEMS.init();
        ModBlocks.BLOCKS.init();
        ModEntities.ENTITIES.init();
        ModBannerPatterns.PATTERNS.init();
        ModBlockEntities.BLOCK_ENTITIES.init();
        ModMenus.MENUS.init();
        ModRecipes.RECIPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
        ModSoundEvents.SOUNDS.init();
    }
}