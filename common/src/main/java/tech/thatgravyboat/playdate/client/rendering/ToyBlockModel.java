package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.toys.ToyBlockEntity;

public class ToyBlockModel extends AnimatedGeoModel<ToyBlockEntity> {

    @Override
    public Identifier getModelLocation(ToyBlockEntity block) {
        return block.getPlushie().model;
    }

    @Override
    public Identifier getTextureLocation(ToyBlockEntity block) {
        return block.getPlushie().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(ToyBlockEntity block) {
        return block.getPlushie().animation;
    }
}
