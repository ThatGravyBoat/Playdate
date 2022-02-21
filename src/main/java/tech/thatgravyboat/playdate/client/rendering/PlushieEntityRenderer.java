package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;

public class PlushieEntityRenderer extends GeoEntityRenderer<ToyEntity> {

    public PlushieEntityRenderer(EntityRendererFactory.Context ctx, AnimatedGeoModel<ToyEntity> modelProvider) {
        super(ctx, modelProvider);
    }

    @Override
    public RenderLayer getRenderType(ToyEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }

    public static PlushieEntityRenderer create(EntityRendererFactory.Context ctx) {
        return new PlushieEntityRenderer(ctx, new PlushieEntityModel());
    }


}
