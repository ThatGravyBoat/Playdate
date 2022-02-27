package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;

import static tech.thatgravyboat.playdate.PlayDate.modId;

public class BalloonModel extends AnimatedGeoModel<BalloonEntity> {
    @Override
    public ResourceLocation getModelLocation(BalloonEntity object) {
        return object.getTexture().model;
    }

    @Override
    public ResourceLocation getTextureLocation(BalloonEntity object) {
        return object.getTexture().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BalloonEntity animatable) {
        return modId("animations/empty.animation.json");
    }
}
