package tech.thatgravyboat.playdate.client.rendering.plushie;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.cuddlecub.CuddleCubItemModel;
import tech.thatgravyboat.playdate.common.items.CuddleCubItem;
import tech.thatgravyboat.playdate.common.items.PlushItem;

public class PlushieItemRenderer<T extends PlushItem> extends GeoItemRenderer<T> {
    public PlushieItemRenderer(AnimatedGeoModel<T> modelProvider) {
        super(modelProvider);
    }

    @Override
    public RenderLayer getRenderType(T animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }

    public static PlushieItemRenderer<PlushItem> create() {
        return new PlushieItemRenderer<>(new PlushieItemModel());
    }

    public static PlushieItemRenderer<CuddleCubItem> createCuddleCub() {
        return new PlushieItemRenderer<>(new CuddleCubItemModel());
    }
}
