package tech.thatgravyboat.playdate.client.rendering.cuddlecub;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.CuddleCubBlockEntity;

public class CuddleCubBlockModel extends AnimatedGeoModel<CuddleCubBlockEntity> {

    @Override
    public ResourceLocation getModelLocation(CuddleCubBlockEntity block) {
        return block.getPlushie().model;
    }

    @Override
    public ResourceLocation getTextureLocation(CuddleCubBlockEntity block) {
        return block.getCuddleCub().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CuddleCubBlockEntity block) {
        return block.getPlushie().animation;
    }
}
