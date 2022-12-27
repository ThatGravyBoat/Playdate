package tech.thatgravyboat.playdate.common.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.blocks.shapes.ShapeGetter;
import tech.thatgravyboat.playdate.common.registry.ModSoundEvents;
import tech.thatgravyboat.playdate.mixins.client.LevelRendererAccessor;

public class MusicBoxBlock extends DirectionalToyBlock {

    public MusicBoxBlock(ShapeGetter shape, Properties properties) {
        super(shape, properties);
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        level.blockEvent(pos, this, 1, 0);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            level.levelEvent(1010, pos, 0);
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    public boolean triggerEvent(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, int i, int j) {
        if (i == 1 && level.isClientSide) {
            playMusic(pos);
        }
        return super.triggerEvent(state, level, pos, i, j);
    }

    @Environment(EnvType.CLIENT)
    public void playMusic(BlockPos pos) {
        LevelRendererAccessor accessor = (LevelRendererAccessor) Minecraft.getInstance().levelRenderer;
        SoundInstance instance = accessor.getPlayingRecords().get(pos);
        SoundManager manager = Minecraft.getInstance().getSoundManager();
        if (instance == null || !manager.isActive(instance)) {
            Minecraft.getInstance().levelRenderer.playStreamingMusic(ModSoundEvents.MUSIC.get(), pos);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        LevelRendererAccessor accessor = (LevelRendererAccessor) Minecraft.getInstance().levelRenderer;
        if (random.nextFloat() <= 0.4) {
            SoundInstance instance = accessor.getPlayingRecords().get(pos);
            SoundManager manager = Minecraft.getInstance().getSoundManager();
            if (instance != null && manager.isActive(instance)) {

                int num = random.nextInt(24);
                level.addParticle(ParticleTypes.NOTE, pos.getX() + 0.2 + random.nextDouble() / 2d, pos.getY() + 0.7, pos.getZ() + 0.2 + random.nextDouble() / 2d, num / 24f, 0.0, 0.0);
            }
        }
    }
}
