package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class ToyBlockEntity extends BlockEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    private final PlushieItem plushie;


    public ToyBlockEntity(PlushieItem plushie, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.plushie = plushie;
    }

    public PlushieItem getPlushie() {
        return plushie;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, EntityType<?> creator) {
        if (level instanceof ServerLevel server && server.isNight() && state.getValue(ToyBlock.POSSESSED)) {
            level.removeBlock(pos, false);
            Entity spawn = creator.create(server, null, null, null, pos, MobSpawnType.NATURAL, false, false);
            if (spawn != null) {
                var direction = state.getValue(HorizontalDirectionalBlock.FACING);
                spawn.setYRot(direction.toYRot());
                level.addFreshEntity(spawn);
            }
        }
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
