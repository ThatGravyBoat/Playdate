package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.resources.ResourceLocation;

import static tech.thatgravyboat.playdate.PlayDate.modId;

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

    public final ResourceLocation model;
    public final ResourceLocation texture;
    public final ResourceLocation animation;

    PlushieEntity(ResourceLocation model, ResourceLocation texture, ResourceLocation animation) {
        this.model = model;
        this.texture = texture;
        this.animation = animation;
    }
}
