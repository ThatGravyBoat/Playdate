package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlockEntity;

public class PlushieBlockModel extends AnimatedGeoModel<PlushieBlockEntity> {
    @Override
    public ResourceLocation getModelLocation(PlushieBlockEntity object) {
        return object.getPlushie().model;
    }

    @Override
    public ResourceLocation getTextureLocation(PlushieBlockEntity object) {
        return object.getPlushie().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PlushieBlockEntity object) {
        return object.getPlushie().animation;
    }
}
