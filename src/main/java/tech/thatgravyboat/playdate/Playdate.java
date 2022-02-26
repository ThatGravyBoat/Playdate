package tech.thatgravyboat.playdate;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.RaycastContext;
import software.bernie.geckolib3.GeckoLib;
import tech.thatgravyboat.playdate.common.ModPaintings;
import tech.thatgravyboat.playdate.common.blocks.ModBlockEntities;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.containers.ModContainers;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.items.ModItems;
import tech.thatgravyboat.playdate.common.recipes.ModRecipes;
import tech.thatgravyboat.playdate.mixin.ItemAccessor;

public class Playdate implements ModInitializer {

    public static final String MODID = "playdate";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(modId("playdate_group"), () -> new ItemStack(ModItems.STUFFING));

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModBlockEntities.register();
        ModBlocks.register();
        ModItems.register();
        ModEntities.register();
        ModPaintings.register();
        ModContainers.register();
        ModRecipes.register();

        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.isOf(Items.GLASS_BOTTLE)) {
                HitResult result = ItemAccessor.invokeRaycast(world, player, RaycastContext.FluidHandling.SOURCE_ONLY);

                if (result.getType().equals(HitResult.Type.BLOCK) && result instanceof BlockHitResult blockResult) {
                    var blockPos = blockResult.getBlockPos();
                    if (world.getBlockState(blockPos).isOf(Blocks.SOUL_SAND)) {
                        world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SOUL_SAND_BREAK, SoundCategory.NEUTRAL, 1, 1);
                        world.setBlockState(blockPos, Blocks.SOUL_SOIL.getDefaultState());
                        world.playSound(player, blockPos, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, SoundCategory.NEUTRAL, 1, 1);
                        player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                        return TypedActionResult.success(ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BOTTLED_SOUL)));
                    }
                }
            }

            return TypedActionResult.pass(stack);
        });
    }

    public static Identifier modId(String path) {
        return new Identifier(MODID, path);
    }
}
