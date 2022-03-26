package tech.thatgravyboat.playdate.common.blocks.toys;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.thatgravyboat.playdate.common.registry.ModItems;

import java.util.function.Supplier;

public class ToyBlock extends BlockWithEntity {

    public static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 26, 13);

    public static BooleanProperty POSSESSED = BooleanProperty.of("possessed");
    private final Supplier<EntityType<?>> toyEntity;
    private final Supplier<BlockEntityType<?>> blockEntityType;

    public ToyBlock(Supplier<EntityType<?>> toyEntity, Supplier<BlockEntityType<?>> blockEntityType, Settings settings) {
        super(settings);
        this.toyEntity = toyEntity;
        this.blockEntityType = blockEntityType;
        this.setDefaultState(this.getDefaultState().with(POSSESSED, false));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(HorizontalFacingBlock.FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(HorizontalFacingBlock.FACING, rotation.rotate(state.get(HorizontalFacingBlock.FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(HorizontalFacingBlock.FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HorizontalFacingBlock.FACING, POSSESSED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var stack = player.getStackInHand(hand);
        if (stack.isOf(ModItems.BOTTLED_SOUL.get()) && !state.get(POSSESSED) && !world.getDifficulty().equals(Difficulty.PEACEFUL)) {
            ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE));
            world.setBlockState(pos, state.with(POSSESSED, true));
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return blockEntityType.get().instantiate(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World tickingWorld, BlockState blockState, BlockEntityType<T> type) {
        return checkType(type, blockEntityType.get(), (world, pos, state, entity) -> ToyBlockEntity.tick(world, pos, state, toyEntity.get()));
    }
}
