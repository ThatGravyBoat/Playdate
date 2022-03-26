package tech.thatgravyboat.fabric.playdate.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import tech.thatgravyboat.playdate.common.blocks.EightDirectionProperty;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlock;
import tech.thatgravyboat.playdate.common.blocks.toys.PlushieBlockEntity;

public class PlushieBlockRenderer<T extends PlushieBlockEntity> extends GeoBlockRenderer<T> {
    public PlushieBlockRenderer(AnimatedGeoModel<T> modelProvider) {
        super(modelProvider);
    }

    @Override
    public void renderEarly(T animatable, MatrixStack stack, float ticks, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stack, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, partialTicks);
        EightDirectionProperty.Direction direction;
        BlockState blockState = animatable.getCachedState();
        if (blockState.contains(PlushieBlock.FACING)) {
            direction = blockState.get(PlushieBlock.FACING);
        } else {
            direction = EightDirectionProperty.Direction.NORTH;
        }
        switch (direction) {
            case NORTH -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
            case NORTH_WEST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(45));
            case WEST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
            case SOUTH_WEST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(135));
            case SOUTH -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
            case SOUTH_EAST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(225));
            case EAST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270));
            case NORTH_EAST -> stack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(315));
        }
    }

    @Override
    public RenderLayer getRenderType(PlushieBlockEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }
}
