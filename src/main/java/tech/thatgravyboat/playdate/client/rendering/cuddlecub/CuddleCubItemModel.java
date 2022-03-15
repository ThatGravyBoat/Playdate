package tech.thatgravyboat.playdate.client.rendering.cuddlecub;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.items.CuddleCubItem;

public class CuddleCubItemModel extends AnimatedGeoModel<CuddleCubItem> {
    @Override
    public Identifier getModelLocation(CuddleCubItem item) {
        return item.plushie.model;
    }

    @Override
    public Identifier getTextureLocation(CuddleCubItem item) {
        return item.getCuddleCub().texture;
    }

    @Override
    public Identifier getAnimationFileLocation(CuddleCubItem item) {
        return item.plushie.animation;
    }
}

