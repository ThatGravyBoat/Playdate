package tech.thatgravyboat.playdate.client.rendering.plushie;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import tech.thatgravyboat.playdate.client.rendering.cuddlecub.CuddleCubBlockModel;
import tech.thatgravyboat.playdate.common.blocks.CuddleCubBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.EightDirectionProperty;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.PlushieBlockEntity;

public class PlushieBlockRenderer<T extends PlushieBlockEntity> extends GeoBlockRenderer<T> {
    public PlushieBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn, AnimatedGeoModel<T> modelProvider) {
        super(rendererDispatcherIn, modelProvider);
    }

    @Override
    public void renderEarly(T animatable, PoseStack stack, float ticks, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stack, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, partialTicks);
        EightDirectionProperty.Direction direction;
        BlockState blockState = animatable.getBlockState();
        if (blockState.hasProperty(PlushieBlock.FACING)) {
            direction = blockState.getValue(PlushieBlock.FACING);
        } else {
            direction = EightDirectionProperty.Direction.NORTH;
        }
        switch (direction) {
            case NORTH -> stack.mulPose(Vector3f.YP.rotationDegrees(0));
            case NORTH_WEST -> stack.mulPose(Vector3f.YP.rotationDegrees(45));
            case WEST -> stack.mulPose(Vector3f.YP.rotationDegrees(90));
            case SOUTH_WEST -> stack.mulPose(Vector3f.YP.rotationDegrees(135));
            case SOUTH -> stack.mulPose(Vector3f.YP.rotationDegrees(180));
            case SOUTH_EAST -> stack.mulPose(Vector3f.YP.rotationDegrees(225));
            case EAST -> stack.mulPose(Vector3f.YP.rotationDegrees(270));
            case NORTH_EAST -> stack.mulPose(Vector3f.YP.rotationDegrees(315));
        }
    }

    @Override
    public RenderType getRenderType(PlushieBlockEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    public static @NotNull PlushieBlockRenderer<PlushieBlockEntity> create(BlockEntityRendererProvider.Context context) {
        return new PlushieBlockRenderer<>(context, new PlushieBlockModel());
    }

    public static @NotNull PlushieBlockRenderer<CuddleCubBlockEntity> createCuddleCub(BlockEntityRendererProvider.Context context) {
        return new PlushieBlockRenderer<>(context, new CuddleCubBlockModel());
    }
}
