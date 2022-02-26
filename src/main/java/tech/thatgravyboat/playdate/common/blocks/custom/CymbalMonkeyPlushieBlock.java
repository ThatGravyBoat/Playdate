package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class CymbalMonkeyPlushieBlock extends PlushieBlock {

    public CymbalMonkeyPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var instruments = Instrument.values();
        var sound = instruments[world.random.nextInt(instruments.length)].getSound();
        world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.success(world.isClient);
    }
}
