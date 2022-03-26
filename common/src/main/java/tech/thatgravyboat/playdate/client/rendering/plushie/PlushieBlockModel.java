package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;

public class PlushieBlockModel extends AnimatedGeoModel<PlushieBlockEntity> {

    @Override
    public Identifier getModelLocation(PlushieBlockEntity block) {
        return block.getModel();
    }

    @Override
    public Identifier getTextureLocation(PlushieBlockEntity block) {
        return block.getTexture();
    }

    @Override
    public Identifier getAnimationFileLocation(PlushieBlockEntity block) {
        return block.getPlushie().animation;
    }
}
