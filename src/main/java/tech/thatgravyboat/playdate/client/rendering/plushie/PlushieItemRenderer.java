package tech.thatgravyboat.playdate.client.rendering.plushie;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.cuddlecub.CuddleCubItemModel;
import tech.thatgravyboat.playdate.common.item.CuddleCubItem;
import tech.thatgravyboat.playdate.common.item.PlushItem;

public class PlushieItemRenderer<T extends PlushItem> extends GeoItemRenderer<T> {
    public PlushieItemRenderer(AnimatedGeoModel<T> modelProvider) {
        super(modelProvider);
    }

    @Override
    public RenderType getRenderType(T animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    public static PlushieItemRenderer<PlushItem> create() {
        return new PlushieItemRenderer<>(new PlushieItemModel());
    }

    public static PlushieItemRenderer<CuddleCubItem> createCuddleCub() {
        return new PlushieItemRenderer<>(new CuddleCubItemModel());
    }
}
