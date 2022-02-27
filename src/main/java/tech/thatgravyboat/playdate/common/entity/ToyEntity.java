package tech.thatgravyboat.playdate.common.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.blocks.ToyBlock;
import tech.thatgravyboat.playdate.common.constants.PlushieEntity;

public class ToyEntity extends Monster implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    private final PlushieEntity plushie;
    private final Block block;

    protected ToyEntity(EntityType<ToyEntity> entityType, Block block, Level world, PlushieEntity plushie) {
        super(entityType, world);
        this.plushie = plushie;
        this.block = block;
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        ((GroundPathNavigation)this.getNavigation()).setCanPassDoors(true);
    }

    public PlushieEntity getPlushie() {
        return plushie;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new OcelotAttackGoal(this));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        if (this.level instanceof ServerLevel server && server.isDay()) {
            this.discard();
            var blockPos = this.blockPosition();
            if (this.level.getBlockState(blockPos).getMaterial().isReplaceable()) {
                this.level.setBlockAndUpdate(blockPos, block.defaultBlockState().setValue(ToyBlock.POSSESSED, true));
            }
        }
        super.tick();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation(event.isMoving() ? "walk" : "entity_idle", true));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 10, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
