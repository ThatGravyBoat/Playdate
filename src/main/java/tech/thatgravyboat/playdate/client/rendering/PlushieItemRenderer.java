package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.common.items.PlushItem;

public class PlushieItemRenderer extends GeoItemRenderer<PlushItem> {
    public PlushieItemRenderer(AnimatedGeoModel<PlushItem> modelProvider) {
        super(modelProvider);
    }

    @Override
    public RenderLayer getRenderType(PlushItem animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }

    public static PlushieItemRenderer create() {
        return new PlushieItemRenderer(new PlushieItemModel());
    }
}
