package tech.thatgravyboat.playdate.common.blocks.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;

import java.util.function.Supplier;

public class ToadstoolPlushieBlock extends PlushieBlock {
    public ToadstoolPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Properties settings) {
        super(blockEntityType, settings);
    }

    @Override
    public void updateEntityAfterFallOn(@NotNull BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        } else {
            Vec3 vec3d = entity.getDeltaMovement();
            if (vec3d.y < 0.0D) {
                entity.setDeltaMovement(vec3d.x, -vec3d.y * (entity instanceof LivingEntity ? 0.9D : 0.72D), vec3d.z);
            }
        }

    }
}
