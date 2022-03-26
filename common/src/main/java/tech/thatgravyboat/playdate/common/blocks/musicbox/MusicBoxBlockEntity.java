package tech.thatgravyboat.playdate.common.blocks.musicbox;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.registry.ModSounds;

public class MusicBoxBlockEntity extends BlockEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private int time = 0;

    public MusicBoxBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (blockEntity instanceof MusicBoxBlockEntity musicBoxBlock) {
            if (MusicBoxBlock.isPlaying(state)) {
                if (musicBoxBlock.time == 0) {
                    world.addSyncedBlockEvent(pos, state.getBlock(), 1, 0);
                }
                musicBoxBlock.time++;
            }else {
                musicBoxBlock.time = 0;
            }

            if (musicBoxBlock.time == 681) {
                world.setBlockState(pos, state.with(MusicBoxBlock.PLAYING, false));
                musicBoxBlock.time = 0;
            }
        }
    }

    @Override
    public boolean onSyncedBlockEvent(int type, int data) {
        if (type == 1) {
            playSong();
            return true;
        }
        return super.onSyncedBlockEvent(type, data);
    }

    @Environment(EnvType.CLIENT)
    private void playSong() {
        MinecraftClient.getInstance().worldRenderer.playSong(ModSounds.MUSIC_BOX.get(), this.pos);
    }

    protected  <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (MusicBoxBlock.isPlaying(this.getCachedState())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("spin", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        var controller = new AnimationController<>(this, "controller", 0, this::predicate);
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
