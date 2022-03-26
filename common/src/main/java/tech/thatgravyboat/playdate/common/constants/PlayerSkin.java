package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static tech.thatgravyboat.playdate.Playdate.modId;

public enum PlayerSkin implements StringIdentifiable {
    ALEX(modId("textures/block/players/alex.png")),
    STEVE(modId("textures/block/players/steve.png")),
    THATGRAVYBOAT(modId("textures/block/players/thatgravyboat.png")),
    FROGIPHER(modId("textures/block/players/frogipher.png"));

    private static final Map<String, PlayerSkin> MAP = new HashMap<>();

    public final Identifier path;

    PlayerSkin(Identifier path) {
        this.path = path;
    }

    public boolean isDefault() {
        return this == ALEX || this == STEVE;
    }

    @Override
    public String asString() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static PlayerSkin getSkin(String name, PlayerSkin defaultSkin) {
        if (MAP.isEmpty()) {
            for (PlayerSkin value : values()) {
                MAP.put(value.name().toLowerCase(Locale.ROOT), value);
            }
        }
        return MAP.getOrDefault(name.toLowerCase(Locale.ROOT), defaultSkin);
    }
}
