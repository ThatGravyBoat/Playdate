package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.common.blocks.LetterBlock;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.item.ModItems;

import java.util.ArrayList;
import java.util.List;

public class Letters {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static List<RegistryObject<Block>> createBlocks() {
        List<RegistryObject<Block>> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            int finalI = i;
            blocks.add(ModBlocks.BLOCKS.register(formatFromId(i),
                    () -> new LetterBlock(finalI, BlockBehaviour.Properties.of(Material.WOOD).strength(1).sound(SoundType.WOOD))));
        }
        return blocks;
    }

    public static List<RegistryObject<BlockItem>> createBlockItems() {
        List<RegistryObject<BlockItem>> blocks = new ArrayList<>(LETTERS.length());
        for (int i = 0; i < LETTERS.length(); i++) {
            int finalI = i;
            blocks.add(ModItems.ITEMS.register(formatFromId(i),
                    () -> new BlockItem(ModBlocks.LETTER_BLOCKS.get(finalI).get(), ModItems.GROUP_SETTINGS)));
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
