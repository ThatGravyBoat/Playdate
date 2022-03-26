package tech.thatgravyboat.playdate.client.rendering.player;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.toys.custom.player.PlayerPlushieBlockEntity;

public class PlayerPlushieBlockModel extends AnimatedGeoModel<PlayerPlushieBlockEntity> {

    @Override
    public Identifier getModelLocation(PlayerPlushieBlockEntity object) {
        return object.getPlushie().model;
    }

    @Override
    public Identifier getTextureLocation(PlayerPlushieBlockEntity object) {
        return object.getSkin().path;
    }

    @Override
    public Identifier getAnimationFileLocation(PlayerPlushieBlockEntity object) {
        return object.getPlushie().animation;
    }
}
