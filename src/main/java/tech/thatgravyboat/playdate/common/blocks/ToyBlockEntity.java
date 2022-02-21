package tech.thatgravyboat.playdate.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
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

    public static void tick(World world, BlockPos pos, BlockState state, EntityType<?> creator) {
        if (world instanceof ServerWorld server && server.isNight() && state.get(ToyBlock.POSSESSED)) {
            world.removeBlock(pos, false);
            Entity spawn = creator.create(server, null, null, null, pos, SpawnReason.NATURAL, false, false);
            if (spawn != null) {
                var direction = state.get(HorizontalFacingBlock.FACING);
                spawn.setYaw(direction.asRotation());
                world.spawnEntity(spawn);
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
