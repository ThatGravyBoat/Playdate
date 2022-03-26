package tech.thatgravyboat.playdate.client.rendering.dollhouse;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.common.items.DollHouseItem;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class DollHouseItemModel extends AnimatedGeoModel<DollHouseItem> {
    @Override
    public Identifier getModelLocation(DollHouseItem object) {
        return object.doll.houseModel;
    }

    @Override
    public Identifier getTextureLocation(DollHouseItem object) {
        return object.doll.house;
    }

    @Override
    public Identifier getAnimationFileLocation(DollHouseItem animatable) {
        return modId("animations/empty.animation.json");
    }
}
