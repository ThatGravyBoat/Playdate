package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.items.PlushItem;

public class PlushieItemModel extends AnimatedGeoModel<PlushItem> {
    @Override
    public Identifier getModelLocation(PlushItem item) {
        return item.getModel();
    }

    @Override
    public Identifier getTextureLocation(PlushItem item) {
        return item.getTexture();
    }

    @Override
    public Identifier getAnimationFileLocation(PlushItem item) {
        return item.plushie.animation;
    }
}
