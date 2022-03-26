package tech.thatgravyboat.playdate.client.rendering.dollhouse;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.common.items.DollHouseItem;

public class DollHouseItemRenderer extends GeoItemRenderer<DollHouseItem> {
    public DollHouseItemRenderer(AnimatedGeoModel<DollHouseItem> modelProvider) {
        super(modelProvider);
    }

    @Override
    public RenderLayer getRenderType(DollHouseItem animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }

    public static DollHouseItemRenderer create() {
        return new DollHouseItemRenderer(new DollHouseItemModel());
    }
}
