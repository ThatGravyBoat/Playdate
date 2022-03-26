package tech.thatgravyboat.playdate.client.rendering.musicbox;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollHouseBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.musicbox.MusicBoxBlockEntity;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class MusicBoxBlockModel extends AnimatedGeoModel<MusicBoxBlockEntity> {
    @Override
    public Identifier getModelLocation(MusicBoxBlockEntity object) {
        return Playdate.modId("geo/music_box.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MusicBoxBlockEntity object) {
        return Playdate.modId("textures/block/music_box.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MusicBoxBlockEntity animatable) {
        return modId("animations/music_box.animation.json");
    }
}
