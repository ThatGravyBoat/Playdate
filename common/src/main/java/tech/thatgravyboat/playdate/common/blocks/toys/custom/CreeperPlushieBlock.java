package tech.thatgravyboat.playdate.common.blocks.toys.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlock;

import java.util.function.Supplier;

public class CreeperPlushieBlock extends PlushieBlock {
    public CreeperPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.createExplosion(null, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, .5f, Explosion.DestructionType.NONE);
        }
        return ActionResult.success(world.isClient);
    }
}
