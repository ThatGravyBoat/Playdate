package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BallPitBlock extends FallingBlock {

    public BallPitBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Entity entity) {
        if (entity.isSprinting() && world.random.nextInt(10) == 0) world.addDestroyBlockEffect(pos, state);
        super.entityInside(state, world, pos, entity);
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (context instanceof EntityCollisionContext entityShapeContext) {
            Entity entity = entityShapeContext.getEntity();
            if (entity != null) {
                if (!(entity instanceof FallingBlockEntity) && entity.fallDistance > 2.5F) {
                    return Shapes.empty();
                }

                if (entity instanceof FallingBlockEntity || (context.isAbove(Shapes.block(), pos, false) && !context.isDescending())) {
                    return super.getCollisionShape(state, world, pos, context);
                }
            }
        }

        return Shapes.empty();
    }

    @Override
    public boolean isScaffolding(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }
}
