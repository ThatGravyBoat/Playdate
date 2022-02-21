package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;

import static tech.thatgravyboat.playdate.Playdate.modId;

public enum PlushieItem {
    CREEPER(
            modId("geo/creeper_plush.geo.json"),
            modId("textures/block/creeper_plush.png"),
            modId("animations/creeper_plush.animation.json")
    ),
    DINO(
            modId("geo/dino_plush.geo.json"),
            modId("textures/block/dino_plush.png"),
            modId("animations/dino_plush.animation.json")
    ),
    ENDERMAN(
            modId("geo/enderman_plush.geo.json"),
            modId("textures/block/enderman_plush.png"),
            modId("animations/enderman_plush.animation.json")
    ),
    HAPPY_SUN(
        modId("geo/happy_sun_plush.geo.json"),
        modId("textures/block/happy_sun_plush.png"),
        modId("animations/happy_sun_plush.animation.json")
    ),
    HAPPY_SUN_TOY(
            modId("geo/happy_sun_toy.geo.json"),
            modId("textures/block/happy_sun_toy.png"),
            modId("animations/happy_sun.animation.json")
    ),
    LOLLIPOP_CLOWN(
            modId("geo/lollipop_clown_plush.geo.json"),
            modId("textures/block/lollipop_clown_plush.png"),
            modId("animations/lollipop_clown_plush.animation.json")
    ),
    LOLLIPOP_CLOWN_TOY(
            modId("geo/lollipop_clown.geo.json"),
            modId("textures/block/lollipop_clown_toy.png"),
            modId("animations/lollipop_clown_plush.animation.json")
    ),
    PETUNIA_PIG(
            modId("geo/petunia_pig_plush.geo.json"),
            modId("textures/block/petunia_pig_plush.png"),
            modId("animations/petunia_pig_plush.animation.json")
    ),
    PETUNIA_PIG_TOY(
            modId("geo/princess.geo.json"),
            modId("textures/block/petunia_pig_toy.png"),
            modId("animations/petunia.animation.json")
    ),
    RUBBER_DUCKY(
            modId("geo/rubber_ducky.geo.json"),
            modId("textures/block/rubber_ducky.png"),
            modId("animations/rubber_ducky.animation.json")
    ),
    TOADSTOOL(
            modId("geo/toadstool_studios_plush.geo.json"),
            modId("textures/block/toadstool_studios_plush.png"),
            modId("animations/toadstool_studios_plush.animation.json")
    ),
    WHEELIE_PUP(
            modId("geo/wheelie_pup.geo.json"),
            modId("textures/block/wheelie_pup.png"),
            modId("animations/wheelie_pup.animation.json")
    ),
    ZOMBIE(
            modId("geo/zombie_plush.geo.json"),
            modId("textures/block/zombie_plush.png"),
            modId("animations/zombie_plush.animation.json")
    );

    public final Identifier model;
    public final Identifier texture;
    public final Identifier animation;

    PlushieItem(Identifier model, Identifier texture, Identifier animation) {
        this.model = model;
        this.texture = texture;
        this.animation = animation;
    }
}