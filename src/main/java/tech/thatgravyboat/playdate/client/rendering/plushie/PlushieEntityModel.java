package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;

public class PlushieEntityModel extends AnimatedGeoModel<ToyEntity> {

    @Override
    public Identifier getModelLocation(ToyEntity plushie) {
        return plushie.getPlushie().model;
    }

    @Override
    public Identifier getTextureLocation(ToyEntity plushie) {
        return plushie.getPlushie().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(ToyEntity plushie) {
        return plushie.getPlushie().animation;
    }
}
