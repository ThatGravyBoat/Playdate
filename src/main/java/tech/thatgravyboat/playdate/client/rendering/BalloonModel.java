package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;

public class BalloonModel extends AnimatedGeoModel<BalloonEntity> {
    @Override
    public Identifier getModelLocation(BalloonEntity object) {
        return object.getTexture().model;
    }

    @Override
    public Identifier getTextureLocation(BalloonEntity object) {
        return object.getTexture().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(BalloonEntity animatable) {
        return new Identifier(Playdate.MODID, "animations/empty.animation.json");
    }
}
