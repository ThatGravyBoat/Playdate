package tech.thatgravyboat.playdate.common.items;

import net.minecraft.entity.decoration.LeashKnotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;

public class RopeItem extends Item {

    public RopeItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        if (world.getBlockState(blockPos).isIn(BlockTags.FENCES)) {
            if (!world.isClient) {
                boolean shouldConsume = attachBalloonToFence(context.getPlayer(), world, blockPos);
                if (shouldConsume) {
                    context.getPlayer().getStackInHand(context.getHand()).decrement(1);
                }
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }

    public static boolean attachBalloonToFence(PlayerEntity player, World world, BlockPos pos) {
        if (player == null) return false;
        LeashKnotEntity knot = null;

        for (BalloonEntity balloonEntity : world.getNonSpectatingEntities(BalloonEntity.class, new Box(pos).expand(7))) {
            if (balloonEntity.getHolder() == player) {
                if (knot == null) {
                    knot = LeashKnotEntity.getOrCreate(world, pos);
                    knot.onPlace();
                }
                balloonEntity.attachRope(knot);
            }
        }
        return knot != null;
    }
}

