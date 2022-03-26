package tech.thatgravyboat.playdate.common.blocks.toys.custom.player;

import net.minecraft.state.property.EnumProperty;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;

import java.util.List;

public class PlayerSkinProperty extends EnumProperty<PlayerSkin> {
    protected PlayerSkinProperty() {
        super("skin", PlayerSkin.class, List.of(PlayerSkin.values()));
    }
}
