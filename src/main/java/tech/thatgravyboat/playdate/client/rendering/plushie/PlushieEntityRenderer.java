package tech.thatgravyboat.playdate.client.rendering.plushie;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;

public class PlushieEntityRenderer extends GeoEntityRenderer<ToyEntity> {
    protected PlushieEntityRenderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<ToyEntity> modelProvider) {
        super(renderManager, modelProvider);
    }

    @Override
    public RenderType getRenderType(ToyEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    public static @NotNull PlushieEntityRenderer create(EntityRendererProvider.Context renderManager) {
        return new PlushieEntityRenderer(renderManager, new PlushieEntityModel());
    }
}
