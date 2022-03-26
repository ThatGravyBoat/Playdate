package tech.thatgravyboat.playdate.common.blocks.toys.custom.player;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlock;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;

import java.util.function.Supplier;

public class PlayerPlushieBlock extends PlushieBlock {

    public static final PlayerSkinProperty SKIN = new PlayerSkinProperty();

    public PlayerPlushieBlock(Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(blockEntityType, settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBlockEntity(pos) instanceof PlayerPlushieBlockEntity plushie) {
            String name = itemStack.hasCustomName() ? itemStack.getName().asString() : "";
            world.setBlockState(pos, state.with(SKIN, PlayerSkin.getSkin(name, plushie.getDefaultSkin())));
        }
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PlayerPlushieBlockEntity plushieBlock && !plushieBlock.getSkin().isDefault()) {
            var pickStack = super.getPickStack(world, pos, state);
            pickStack.setCustomName(new LiteralText(plushieBlock.getSkin().asString()));
            return pickStack;
        }
        return super.getPickStack(world, pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SKIN);
    }
}
