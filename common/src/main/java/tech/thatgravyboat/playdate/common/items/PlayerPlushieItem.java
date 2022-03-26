package tech.thatgravyboat.playdate.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class PlayerPlushieItem extends PlushItem {

    private final PlayerSkin defaultSkin;

    public PlayerPlushieItem(Block block, PlayerSkin defaultSkin, Settings settings) {
        super(block, PlushieItem.PLAYER, settings);
        this.defaultSkin = defaultSkin;
    }

    public PlayerSkin getSkin(ItemStack stack) {
        return stack != null ? PlayerSkin.getSkin(stack.getName().asString(), defaultSkin) : defaultSkin;
    }
}
