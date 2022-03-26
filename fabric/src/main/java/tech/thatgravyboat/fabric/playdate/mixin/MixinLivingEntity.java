package tech.thatgravyboat.fabric.playdate.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tech.thatgravyboat.playdate.common.registry.ModBlocks;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Redirect(method = "applyClimbingSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    public boolean redirectApplyClimbingSpeed(BlockState instance, Block block) {
        return instance.isOf(block) || instance.isOf(ModBlocks.BALLPIT.get());
    }
}
