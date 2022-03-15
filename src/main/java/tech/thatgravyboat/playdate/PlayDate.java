package tech.thatgravyboat.playdate;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import tech.thatgravyboat.playdate.client.PlayDateClient;
import tech.thatgravyboat.playdate.common.blocks.ModBlockEntities;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.containers.ModContainers;
import tech.thatgravyboat.playdate.common.entity.ModEntities;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;
import tech.thatgravyboat.playdate.common.item.ModItems;
import tech.thatgravyboat.playdate.common.paintings.ModPaintings;
import tech.thatgravyboat.playdate.common.recipes.ModRecipes;
import tech.thatgravyboat.playdate.mixin.ItemAccessor;

@Mod(PlayDate.MODID)
public class PlayDate {

    public static final String MODID = "playdate";

    public PlayDate() {
        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlayDate::addEntityAttributes);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlayDateClient::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(PlayDateClient::onItemColors));

        MinecraftForge.EVENT_BUS.addListener(PlayDate::onItemuse);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModRecipes.RECIPE_SERIALIZERS.register(bus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModEntities.ENTITY_TYPES.register(bus);
        ModContainers.MENUS.register(bus);
        ModPaintings.PAINTINGS.register(bus);

    }

    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LOLLIPOP_CLOWN.get(), ToyEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.FOLLOW_RANGE, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.4).build());
        event.put(ModEntities.HAPPY_SUN.get(), ToyEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.FOLLOW_RANGE, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.4).build());
        event.put(ModEntities.PETUNIA_PIG.get(), ToyEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.FOLLOW_RANGE, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.4).build());
        event.put(ModEntities.STUFFIE.get(), ToyEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.FOLLOW_RANGE, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.4).build());
    }

    public static void onItemuse(PlayerInteractEvent.RightClickItem event) {
        var stack = event.getItemStack();
        if (stack.is(Items.GLASS_BOTTLE)) {
            var world = event.getWorld();
            HitResult hit = ItemAccessor.invokeGetPlayerPOVHitResult(world, event.getPlayer(), ClipContext.Fluid.SOURCE_ONLY);

            if (hit.getType().equals(HitResult.Type.BLOCK) && hit instanceof BlockHitResult blockHit) {
                var blockPos = blockHit.getBlockPos();
                if (world.getBlockState(blockPos).is(Blocks.SOUL_SAND)) {
                    world.playSound(event.getPlayer(), blockPos, SoundEvents.SOUL_SAND_BREAK, SoundSource.NEUTRAL, 1, 1);
                    world.setBlockAndUpdate(blockPos, Blocks.SOUL_SOIL.defaultBlockState());
                    world.playSound(event.getPlayer(), blockPos, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, SoundSource.NEUTRAL, 1, 1);
                    event.getPlayer().awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    event.getPlayer().setItemInHand(event.getHand(), ItemUtils.createFilledResult(stack, event.getPlayer(), new ItemStack(ModItems.BOTTLED_SOUL.get())));
                    event.setCancellationResult(InteractionResult.sidedSuccess(world.isClientSide));
                    event.setCanceled(true);
                }
            }
        }
    }

    public static ResourceLocation modId(String path) {
        return new ResourceLocation(MODID, path);
    }
}
