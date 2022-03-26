package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;

import static tech.thatgravyboat.playdate.Playdate.modId;

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
    public final Identifier texture;
    public final Identifier model;
    public final boolean colored;

    BalloonType(String id, Identifier model, Identifier texture, boolean colored) {
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
