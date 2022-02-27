package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.ToyBlockEntity;

public class ToyBlockModel extends AnimatedGeoModel<ToyBlockEntity> {
    @Override
    public ResourceLocation getModelLocation(ToyBlockEntity object) {
        return object.getPlushie().model;
    }

    @Override
    public ResourceLocation getTextureLocation(ToyBlockEntity object) {
        return object.getPlushie().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ToyBlockEntity object) {
        return object.getPlushie().animation;
    }
}
