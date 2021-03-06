package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;

import static tech.thatgravyboat.playdate.Playdate.modId;

public enum PlushieEntity {
    HAPPY_SUN(
            modId("geo/happy_sun.geo.json"),
            modId("textures/entity/happy_sun_possessed.png"),
            modId("animations/happy_sun.animation.json")
    ),
    LOLLIPOP_CLOWN(
            modId("geo/lollipop_clown.geo.json"),
            modId("textures/entity/lollipop_clown_possessed.png"),
            modId("animations/lollipop_clown.animation.json")
    ),
    PETUNIA_PIG(
            modId("geo/princess.geo.json"),
            modId("textures/entity/possessed_petunia_pig.png"),
            modId("animations/petunia.animation.json")
    ),
    STUFFIE(
            modId("geo/stuffie.geo.json"),
            modId("textures/entity/stuffie_possessed.png"),
            modId("animations/stuffie.animation.json")
    ),
    SOCK_MONKEY(
            modId("geo/sock_monkey_possessed.geo.json"),
            modId("textures/entity/sock_monkey_possessed.png"),
            modId("animations/sock_monkey.animation.json")
    );

    public final Identifier model;
    public final Identifier texture;
    public final Identifier animation;

    PlushieEntity(Identifier model, Identifier texture, Identifier animation) {
        this.model = model;
        this.texture = texture;
        this.animation = animation;
    }
}
