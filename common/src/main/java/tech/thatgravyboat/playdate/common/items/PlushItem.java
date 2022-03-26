package tech.thatgravyboat.playdate.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class PlushItem extends BlockItem implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    public final PlushieItem plushie;

    public PlushItem(Block block, PlushieItem plushie, Settings settings) {
        super(block, settings);
        this.plushie = plushie;
    }

    public Identifier getModel() {
        return plushie.model;
    }

    public Identifier getTexture() {
        return plushie.texture;
    }

    private <P extends BlockItem & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
