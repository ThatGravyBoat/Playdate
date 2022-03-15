package tech.thatgravyboat.playdate.client.rendering.cuddlecub;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.CuddleCubBlockEntity;

public class CuddleCubBlockModel extends AnimatedGeoModel<CuddleCubBlockEntity> {

    @Override
    public Identifier getModelLocation(CuddleCubBlockEntity block) {
        return block.getPlushie().model;
    }

    @Override
    public Identifier getTextureLocation(CuddleCubBlockEntity block) {
        return block.getCuddleCub().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(CuddleCubBlockEntity block) {
        return block.getPlushie().animation;
    }
}

