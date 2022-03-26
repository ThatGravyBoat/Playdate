package tech.thatgravyboat.playdate.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.blocks.toys.ToyBlock;
import tech.thatgravyboat.playdate.common.constants.PlushieEntity;

public class ToyEntity extends HostileEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    private final PlushieEntity plushie;
    private final Block block;

    public ToyEntity(EntityType<ToyEntity> entityType, Block block, World world, PlushieEntity plushie) {
        super(entityType, world);
        this.plushie = plushie;
        this.block = block;
        ((MobNavigation)this.getNavigation()).setCanPathThroughDoors(true);
        ((MobNavigation)this.getNavigation()).setCanEnterOpenDoors(true);
    }

    public PlushieEntity getPlushie() {
        return plushie;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new AttackGoal(this));
        this.goalSelector.add(3, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        if (this.world instanceof ServerWorld server && server.isDay()) {
            this.discard();
            var blockPos = this.getBlockPos();
            if (this.world.getBlockState(blockPos).getMaterial().isReplaceable()) {
                this.world.setBlockState(blockPos, block.getDefaultState().with(ToyBlock.POSSESSED, true));
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
