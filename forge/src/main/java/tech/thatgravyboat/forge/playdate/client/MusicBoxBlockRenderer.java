package tech.thatgravyboat.forge.playdate.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import tech.thatgravyboat.playdate.common.blocks.dollhouse.DollHouseBlockEntity;
import tech.thatgravyboat.playdate.common.blocks.musicbox.MusicBoxBlockEntity;

public class MusicBoxBlockRenderer extends GeoBlockRenderer<MusicBoxBlockEntity> {
    public MusicBoxBlockRenderer(BlockEntityRendererFactory.Context ctx, AnimatedGeoModel<MusicBoxBlockEntity> modelProvider) {
        super(ctx, modelProvider);
    }

    @Override
    public RenderLayer getRenderType(MusicBoxBlockEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(textureLocation);
    }
}