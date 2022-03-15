package tech.thatgravyboat.playdate.client.rendering.cuddlecub;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.item.CuddleCubItem;

public class CuddleCubItemModel extends AnimatedGeoModel<CuddleCubItem> {
    @Override
    public ResourceLocation getModelLocation(CuddleCubItem item) {
        return item.plushie.model;
    }

    @Override
    public ResourceLocation getTextureLocation(CuddleCubItem item) {
        return item.getCuddleCub().texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CuddleCubItem item) {
        return item.plushie.animation;
    }
}

