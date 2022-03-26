package tech.thatgravyboat.fabric.playdate.services;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import tech.thatgravyboat.playdate.common.blocks.BallPitBlock;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;
import tech.thatgravyboat.playdate.common.items.*;
import tech.thatgravyboat.playdate.platform.services.IPlatformHelper;

public class FabricPlatformService implements IPlatformHelper {

    @Override
    public PlushItem createPlush(Block block, PlushieItem plushie, Item.Settings settings) {
        return new PlushItem(block, plushie, settings);
    }

    @Override
    public CuddleCubItem createCub(Block block, CuddleCub cub, Item.Settings settings) {
        return new CuddleCubItem(block, cub, settings);
    }

    @Override
    public PlayerPlushieItem createPlayer(Block block, PlayerSkin defaultSkin, Item.Settings settings) {
        return new PlayerPlushieItem(block, defaultSkin, settings);
    }

    @Override
    public DollHouseItem createDollhouse(Block block, Doll defaultSkin, Item.Settings settings) {
        return new DollHouseItem(block, defaultSkin, settings);
    }

    @Override
    public DollItem createDoll(Block block, Doll doll, Item.Settings settings) {
        return new DollItem(block, doll, settings);
    }

    @Override
    public BallPitBlock createBallpitBlock(AbstractBlock.Settings settings) {
        return new BallPitBlock(AbstractBlock.Settings.of(Material.WOOL).dynamicBounds());
    }

    @Override
    public MusicBoxItem createMusicBox(Block block, Item.Settings settings) {
        return new MusicBoxItem(block, settings);
    }
}
