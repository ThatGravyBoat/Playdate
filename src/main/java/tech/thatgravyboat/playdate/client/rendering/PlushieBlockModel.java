package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlockEntity;

public class PlushieBlockModel extends AnimatedGeoModel<PlushieBlockEntity> {

    @Override
    public Identifier getModelLocation(PlushieBlockEntity block) {
        return block.getPlushie().model;
    }

    @Override
    public Identifier getTextureLocation(PlushieBlockEntity block) {
        return block.getPlushie().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(PlushieBlockEntity block) {
        return block.getPlushie().animation;
    }
}
