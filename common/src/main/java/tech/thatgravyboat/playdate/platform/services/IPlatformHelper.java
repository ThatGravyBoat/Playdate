package tech.thatgravyboat.playdate.platform.services;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import tech.thatgravyboat.playdate.common.blocks.BallPitBlock;
import tech.thatgravyboat.playdate.common.blocks.musicbox.MusicBoxBlock;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;
import tech.thatgravyboat.playdate.common.items.*;

/*
    The create item methods in here exist for the sole purpose of on forge we need to add a method for item models.
 */
public interface IPlatformHelper {

    PlushItem createPlush(Block block, PlushieItem plushie, Item.Settings settings);

    CuddleCubItem createCub(Block block, CuddleCub cub, Item.Settings settings);

    PlayerPlushieItem createPlayer(Block block, PlayerSkin defaultSkin, Item.Settings settings);

    DollHouseItem createDollhouse(Block block, Doll defaultSkin, Item.Settings settings);

    DollItem createDoll(Block block, Doll defaultSkin, Item.Settings settings);

    BallPitBlock createBallpitBlock(AbstractBlock.Settings settings);

    MusicBoxItem createMusicBox(Block block, Item.Settings settings);
}
