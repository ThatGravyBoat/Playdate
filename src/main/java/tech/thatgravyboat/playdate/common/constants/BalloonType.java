package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.resources.ResourceLocation;

import static tech.thatgravyboat.playdate.PlayDate.modId;

public enum BalloonType {
    SUN(
            "happy_sun",
            modId("geo/balloon.geo.json"),
            modId("textures/entity/happy_sun_balloon.png"),
            false
    ),
    COLORED(
            "colored",
            modId("geo/balloon.geo.json"),
            modId("textures/entity/balloon.png"),
            true
    );

    public final String id;
    public final ResourceLocation texture;
    public final ResourceLocation model;
    public final boolean colored;

    BalloonType(String id, ResourceLocation model, ResourceLocation texture, boolean colored) {
        this.id = id;
        this.model = model;
        this.texture = texture;
        this.colored = colored;
    }

    public static BalloonType getTypeFromId(String id) {
        for (BalloonType value : values()) if (value.id.equals(id)) return value;
        return BalloonType.COLORED;
    }
}

