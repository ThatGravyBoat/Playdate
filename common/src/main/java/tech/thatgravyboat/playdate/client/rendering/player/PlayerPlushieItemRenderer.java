package tech.thatgravyboat.playdate.client.rendering.player;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.common.items.PlayerPlushieItem;

public class PlayerPlushieItemRenderer<T extends PlayerPlushieItem> extends GeoItemRenderer<T> {

    public PlayerPlushieItemRenderer(AnimatedGeoModel<T> modelProvider) {
        super(modelProvider);
    }

    @Override
    public Identifier getTextureLocation(T instance) {
        return instance.getSkin(this.currentItemStack).path;
    }

    @Override
    public RenderLayer getRenderType(T animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }

    public static PlayerPlushieItemRenderer<PlayerPlushieItem> create() {
        return new PlayerPlushieItemRenderer<>(new PlayerPlushieItemModel());
    }
}

