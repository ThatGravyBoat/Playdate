package tech.thatgravyboat.playdate.common.blocks.toys.custom.powered;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

public class PoweredPlushieBlockEntity extends PlushieBlockEntity {

    private final String poweredAnimation;

    public PoweredPlushieBlockEntity(PlushieItem plushie, BlockEntityType<?> type, BlockPos pos, BlockState state, String poweredAnimation) {
        super(plushie, type, pos, state);
        this.poweredAnimation = poweredAnimation;
    }

    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.world != null) {
            var blockState = this.world.getBlockState(this.pos);
            //Disable until we add the animations
            if (false && blockState.contains(Properties.POWERED) && blockState.get(Properties.POWERED)) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation(poweredAnimation));
                return PlayState.CONTINUE;
            }
        }
        return super.predicate(event);
    }
}
