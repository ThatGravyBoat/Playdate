package tech.thatgravyboat.playdate;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import software.bernie.geckolib3.GeckoLib;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;
import tech.thatgravyboat.playdate.common.registry.*;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.Map;

public class Playdate {
    public static final String MODID = "playdate";
    public static final ItemGroup ITEM_GROUP = CommonServices.REGISTRY.createItemGroup(modId("playdate_group"), () -> new ItemStack(ModItems.STUFFING.get()));
    
    public static void init() {
        GeckoLib.initialize();
        ModBlockEntities.register();
        ModBlocks.register();
        ModItems.register();
        ModEntities.register();
        ModPaintings.register();
        ModContainers.register();
        ModRecipes.register();
        ModSounds.register();
    }

    public static void addEntityAttributes(Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer.Builder> attributes) {
        attributes.put(ModEntities.LOLLIPOP_CLOWN.get(), ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        attributes.put(ModEntities.HAPPY_SUN.get(), ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        attributes.put(ModEntities.PETUNIA_PIG.get(), ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        attributes.put(ModEntities.STUFFIE.get(), ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        attributes.put(ModEntities.SOCK_MONKEY.get(), ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3));
    }

    public static TypedActionResult<ItemStack> onItemUse(PlayerEntity player, ItemStack stack, World world, Hand hand) {
        if (stack.isOf(Items.GLASS_BOTTLE)) {
            BlockHitResult result = raycast(world, player);

            if (result.getType().equals(HitResult.Type.BLOCK)) {
                var blockPos = result.getBlockPos();
                if (world.getBlockState(blockPos).isOf(Blocks.SOUL_SAND)) {
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SOUL_SAND_BREAK, SoundCategory.NEUTRAL, 1, 1);
                    world.setBlockState(blockPos, Blocks.SOUL_SOIL.getDefaultState());
                    world.playSound(player, blockPos, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, SoundCategory.NEUTRAL, 1, 1);
                    player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                    return TypedActionResult.success(ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BOTTLED_SOUL.get())));
                }
            }
        }

        return TypedActionResult.pass(stack);
    }

    protected static BlockHitResult raycast(World world, PlayerEntity player) {
        float f = player.getPitch();
        float g = player.getYaw();
        Vec3d vec3d = player.getEyePos();
        float h = MathHelper.cos(-g * 0.017453292F - 3.1415927F);
        float i = MathHelper.sin(-g * 0.017453292F - 3.1415927F);
        float j = -MathHelper.cos(-f * 0.017453292F);
        float k = MathHelper.sin(-f * 0.017453292F);
        float l = i * j;
        float n = h * j;
        Vec3d vec3d2 = vec3d.add((double)l * 5.0D, (double)k * 5.0D, (double)n * 5.0D);
        return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.SOURCE_ONLY, player));
    }

    public static Identifier modId(String path) {
        return new Identifier(MODID, path);
    }
}
