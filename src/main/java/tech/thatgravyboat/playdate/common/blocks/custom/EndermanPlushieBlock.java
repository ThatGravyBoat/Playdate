package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class EndermanPlushieBlock extends PlushieBlock {
    public EndermanPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        for (int i = 0; i < 10; ++i) {
            world.addParticle(ParticleTypes.PORTAL,
                    pos.getX() + world.random.nextDouble(), pos.getY() + world.random.nextDouble(), pos.getZ() + world.random.nextDouble(),
                    (world.random.nextDouble() - 0.5D) * 2.0D, -world.random.nextDouble(), (world.random.nextDouble() - 0.5D) * 2.0D);
        }
        world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 0.5F, 1.0F);
        return ActionResult.success(world.isClient);
    }
}
