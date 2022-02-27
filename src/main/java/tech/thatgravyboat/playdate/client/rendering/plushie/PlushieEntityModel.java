package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;

public class PlushieEntityModel extends AnimatedGeoModel<ToyEntity> {
    @Override
    public ResourceLocation getModelLocation(ToyEntity object) {
        return object.getPlushie().model;
    }

    @Override
    public ResourceLocation getTextureLocation(ToyEntity object) {
        return object.getPlushie().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ToyEntity object) {
        return object.getPlushie().animation;
    }
}
