package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.item.PlushItem;

public class PlushieItemModel extends AnimatedGeoModel<PlushItem> {
    @Override
    public ResourceLocation getModelLocation(PlushItem object) {
        return object.plushie.model;
    }

    @Override
    public ResourceLocation getTextureLocation(PlushItem object) {
        return object.plushie.texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PlushItem object) {
        return object.plushie.animation;
    }
}
