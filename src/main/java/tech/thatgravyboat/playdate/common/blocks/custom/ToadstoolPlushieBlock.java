package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class ToadstoolPlushieBlock extends PlushieBlock {

    public ToadstoolPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            Vec3d vec3d = entity.getVelocity();
            if (vec3d.y < 0.0D) {
                double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
                entity.setVelocity(vec3d.x, -vec3d.y * 0.9 * d, vec3d.z);
            }
        }

    }
}
