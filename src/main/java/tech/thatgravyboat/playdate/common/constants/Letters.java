package tech.thatgravyboat.playdate.common.constants;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.LetterBlock;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.items.ModItems;

import java.util.ArrayList;
import java.util.List;

public class Letters {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            blocks.add(new LetterBlock(i, FabricBlockSettings.of(Material.WOOD).strength(1).sounds(BlockSoundGroup.WOOD)));
        }
        return blocks;
    }

    public static List<BlockItem> createBlockItems() {
        List<BlockItem> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            blocks.add(new BlockItem(ModBlocks.LETTER_BLOCKS.get(i), ModItems.GROUP_SETTINGS));
        }
        return blocks;
    }

    public static Identifier formatFromId(int id) {
        return Playdate.modId("letter_"+LETTERS.charAt(id));
    }

    public static Block getLetterBlock(char character) {
        var i = LETTERS.indexOf(character);
        if (i == -1) return null;
        return ModBlocks.LETTER_BLOCKS.get(i);
    }
}
