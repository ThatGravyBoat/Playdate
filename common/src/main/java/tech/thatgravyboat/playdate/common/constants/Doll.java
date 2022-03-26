package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;

import static tech.thatgravyboat.playdate.Playdate.modId;

public enum Doll {
    OAK(
        modId("textures/block/dolls/oak_doll.png"),
        modId("geo/dolls/oak_doll.geo.json"),
        modId("textures/block/dolls/oak_dollhouse.png"),
        modId("geo/dolls/oak_dollhouse.geo.json")
    ),
    BIRCH(
        modId("textures/block/dolls/birch_doll.png"),
        modId("geo/dolls/birch_doll.geo.json"),
        modId("textures/block/dolls/birch_dollhouse.png"),
        modId("geo/dolls/birch_dollhouse.geo.json")
    ),
    SPRUCE(
        modId("textures/block/dolls/spruce_doll.png"),
        modId("geo/dolls/spruce_doll.geo.json"),
        modId("textures/block/dolls/spruce_dollhouse.png"),
        modId("geo/dolls/spruce_dollhouse.geo.json")
    ),
    DARK_OAK(
        modId("textures/block/dolls/dark_oak_doll.png"),
        modId("geo/dolls/dark_oak_doll.geo.json"),
        modId("textures/block/dolls/dark_oak_dollhouse.png"),
        modId("geo/dolls/dark_oak_dollhouse.geo.json")
    ),
    ACACIA(
            modId("textures/block/dolls/acacia_doll.png"),
            modId("geo/dolls/acacia_doll.geo.json"),
            modId("textures/block/dolls/acacia_dollhouse.png"),
            modId("geo/dolls/acacia_dollhouse.geo.json")
    ),
    JUNGLE(
            modId("textures/block/dolls/jungle_doll.png"),
            modId("geo/dolls/jungle_doll.geo.json"),
            modId("textures/block/dolls/jungle_dollhouse.png"),
            modId("geo/dolls/jungle_dollhouse.geo.json")
    ),
    CRIMSON(
            modId("textures/block/dolls/crimson_doll.png"),
            modId("geo/dolls/crimson_doll.geo.json"),
            modId("textures/block/dolls/crimson_dollhouse.png"),
            modId("geo/dolls/crimson_dollhouse.geo.json")
    ),
    WARPED(
            modId("textures/block/dolls/warped_doll.png"),
            modId("geo/dolls/warped_doll.geo.json"),
            modId("textures/block/dolls/warped_dollhouse.png"),
            modId("geo/dolls/warped_dollhouse.geo.json")
    );

    public final Identifier doll;
    public final Identifier dollModel;
    public final Identifier house;
    public final Identifier houseModel;

    Doll(Identifier doll, Identifier dollModel, Identifier house, Identifier houseModel) {
        this.doll = doll;
        this.dollModel = dollModel;
        this.house = house;
        this.houseModel = houseModel;
    }

}
