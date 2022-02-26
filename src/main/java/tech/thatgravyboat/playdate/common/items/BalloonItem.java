package tech.thatgravyboat.playdate.common.items;

import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.util.Color;

public class BalloonItem extends Item implements DyeableItem {

    private final BalloonType type;

    public BalloonItem(BalloonType type, Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public int getColor(ItemStack stack) {
        return isRainbow(stack) ? Color.RAINBOW.getRGBA() : DyeableItem.super.getColor(stack);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld server) {
            var balloonEntity = ModEntities.BALLOON.create(server, null, null, user, user.getBlockPos().add(0, 3, 0), SpawnReason.TRIGGERED, false, false);
            var stack = user.getStackInHand(hand);
            NbtCompound nbt = stack.getNbt();
            if (balloonEntity != null) {
                float length = nbt != null ? nbt.getFloat("length") : 0f;
                balloonEntity.setColor(getColor(stack));
                balloonEntity.setRainbow(isRainbow(stack));
                balloonEntity.setTexture(this.type);
                balloonEntity.setRopeLength(length + 2f);
                world.spawnEntity(balloonEntity);
                balloonEntity.attachRope(user);

                user.setStackInHand(hand, ItemUsage.exchangeStack(stack, user, new ItemStack(ModItems.ROPE)));
            }
        }
        return super.use(world, user, hand);
    }

    private static boolean isRainbow(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        return (nbt != null && nbt.getBoolean("rainbow")) || stack.getName().asString().equals("jeb_");
    }
}
