package tech.thatgravyboat.playdate.client.rendering.musicbox;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.items.MusicBoxItem;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class MusicBoxItemModel extends AnimatedGeoModel<MusicBoxItem> {
    @Override
    public Identifier getModelLocation(MusicBoxItem object) {
        return Playdate.modId("geo/music_box.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MusicBoxItem object) {
        return Playdate.modId("textures/block/music_box.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MusicBoxItem animatable) {
        return modId("animations/music_box.animation.json");
    }
}
