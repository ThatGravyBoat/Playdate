package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import tech.thatgravyboat.playdate.common.blocks.LetterBlock;
import tech.thatgravyboat.playdate.common.registry.ModBlocks;
import tech.thatgravyboat.playdate.common.registry.ModItems;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Letters {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static List<Supplier<Block>> createBlocks() {
        List<Supplier<Block>> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            int finalI = i;
            blocks.add(CommonServices.REGISTRY.registerBlock(formatFromId(i), () -> new LetterBlock(finalI, ModBlocks.SOFTWOOD_SETTINGS)));
        }
        return blocks;
    }

    public static List<Supplier<BlockItem>> createBlockItems() {
        List<Supplier<BlockItem>> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            int finalI = i;
            blocks.add(CommonServices.REGISTRY.registerItem(formatFromId(i), () -> new BlockItem(ModBlocks.LETTER_BLOCKS.get(finalI).get(), ModItems.GROUP_SETTINGS)));
        }
        return blocks;
    }

    public static String formatFromId(int id) {
        return "letter_"+LETTERS.charAt(id);
    }

    public static Block getLetterBlock(char character) {
        var i = LETTERS.indexOf(character);
        if (i == -1) return null;
        return ModBlocks.LETTER_BLOCKS.get(i).get();
    }
}
