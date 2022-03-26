package tech.thatgravyboat.playdate.client.rendering.player;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.items.PlayerPlushieItem;

public class PlayerPlushieItemModel extends AnimatedGeoModel<PlayerPlushieItem> {

    @Override
    public Identifier getModelLocation(PlayerPlushieItem object) {
        return object.plushie.model;
    }

    @Override
    public Identifier getTextureLocation(PlayerPlushieItem object) {
        return object.plushie.texture;
    }

    @Override
    public Identifier getAnimationFileLocation(PlayerPlushieItem object) {
        return object.plushie.animation;
    }
}

