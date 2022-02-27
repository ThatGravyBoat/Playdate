package tech.thatgravyboat.playdate.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.util.Color;

public class BalloonItem extends Item implements DyeableLeatherItem {

    private final BalloonType type;

    public BalloonItem(BalloonType type, Properties p_41383_) {
        super(p_41383_);
        this.type = type;
    }

    @Override
    public int getColor(@NotNull ItemStack stack) {
        return isRainbow(stack) ? Color.RAINBOW.getRGBA() : DyeableLeatherItem.super.getColor(stack);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (level instanceof ServerLevel server) {
            var balloonEntity = ModEntities.BALLOON.get().create(server, null, null, player, player.blockPosition().offset(0, 3,0), MobSpawnType.TRIGGERED, false, false);
            var stack = player.getItemInHand(hand);
            CompoundTag tag = stack.getTag();
            if (balloonEntity != null) {
                float length = tag != null ? tag.getFloat("length") : 0f;
                balloonEntity.setColor(getColor(stack));
                balloonEntity.setRainbow(isRainbow(stack));
                balloonEntity.setTexture(this.type);
                balloonEntity.setRopeLength(length + 2f);
                level.addFreshEntity(balloonEntity);
                balloonEntity.attachRope(player);

                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(ModItems.ROPE.get())));
            }
        }
        return super.use(level, player, hand);
    }

    private static boolean isRainbow(ItemStack stack) {
        CompoundTag nbt = stack.getTag();
        return (nbt != null && nbt.getBoolean("rainbow")) || stack.getDisplayName().getString().equals("jeb_");
    }
}
