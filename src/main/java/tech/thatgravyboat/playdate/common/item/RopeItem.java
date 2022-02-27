package tech.thatgravyboat.playdate.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;

public class RopeItem extends Item {

    public RopeItem(Properties p_41383_) {
        super(p_41383_);
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        if (level.getBlockState(blockpos).is(BlockTags.FENCES)) {
            if (!level.isClientSide) {
                boolean shouldConsume = attachBalloonToFence(context.getPlayer(), level, blockpos);
                if (shouldConsume) {
                    context.getPlayer().getItemInHand(context.getHand()).shrink(1);
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    public static boolean attachBalloonToFence(Player player, Level level, BlockPos pos) {
        if (player == null) return false;
        LeashFenceKnotEntity knot = null;

        for(BalloonEntity balloonEntity : level.getEntitiesOfClass(BalloonEntity.class, new AABB(pos).inflate(7))) {
            if (balloonEntity.getHolder() == player) {
                if (knot == null) {
                    knot = LeashFenceKnotEntity.getOrCreateKnot(level, pos);
                    knot.playPlacementSound();
                }

                balloonEntity.attachRope(knot);
            }
        }

        return knot != null;
    }
}
