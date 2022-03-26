package tech.thatgravyboat.playdate.client.rendering.dollhouse;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollHouseBlockEntity;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class DollHouseBlockModel extends AnimatedGeoModel<DollHouseBlockEntity> {
    @Override
    public Identifier getModelLocation(DollHouseBlockEntity object) {
        return object.doll.houseModel;
    }

    @Override
    public Identifier getTextureLocation(DollHouseBlockEntity object) {
        return object.doll.house;
    }

    @Override
    public Identifier getAnimationFileLocation(DollHouseBlockEntity animatable) {
        return modId("animations/empty.animation.json");
    }
}
