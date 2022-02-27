package tech.thatgravyboat.playdate.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import tech.thatgravyboat.playdate.common.blocks.ToyBlockEntity;

public class ToyBlockRenderer extends GeoBlockRenderer<ToyBlockEntity> {
    public ToyBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn, AnimatedGeoModel<ToyBlockEntity> modelProvider) {
        super(rendererDispatcherIn, modelProvider);
    }

    @Override
    public RenderType getRenderType(ToyBlockEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    public static @NotNull ToyBlockRenderer create(BlockEntityRendererProvider.Context context) {
        return new ToyBlockRenderer(context, new ToyBlockModel());
    }
}
