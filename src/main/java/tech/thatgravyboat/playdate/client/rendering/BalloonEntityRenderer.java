package tech.thatgravyboat.playdate.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimatableModel;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
import software.bernie.geckolib3.util.AnimationUtils;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;
import tech.thatgravyboat.playdate.common.util.Color;

import java.util.Collections;

public class BalloonEntityRenderer extends EntityRenderer<BalloonEntity> implements IGeoRenderer<BalloonEntity> {
    static {
        AnimationController.addModelFetcher((IAnimatable object) -> {
            if (object instanceof BalloonEntity) {
                return (IAnimatableModel<Object>) AnimationUtils.getGeoModelForEntity((BalloonEntity) object);
            }
            return null;
        });
    }

    private final AnimatedGeoModel<BalloonEntity> modelProvider = new BalloonModel();

    public MultiBufferSource rtb;
    public ResourceLocation whTexture;

    public BalloonEntityRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public void render(@NotNull BalloonEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
        stack.pushPose();
        boolean shouldSit = entity.isPassenger()
                && (entity.getVehicle() != null && entity.getVehicle().shouldRiderSit());
        EntityModelData entityModelData = new EntityModelData();
        entityModelData.isSitting = shouldSit;

        AnimationEvent<BalloonEntity> predicate = new AnimationEvent<>(entity, 0, 0, partialTicks, false, Collections.singletonList(entityModelData));
        GeoModel model = modelProvider.getModel(modelProvider.getModelLocation(entity));
        modelProvider.setLivingAnimations(entity, this.getUniqueID(entity), predicate);

        stack.translate(0, 0.01f, 0);
        stack.mulPose(Vector3f.YN.rotationDegrees(entity.getUUID().getLeastSignificantBits() % 360));
        Minecraft.getInstance().getTextureManager().bindForSetup(getTextureLocation(entity));
        RenderType renderType = getRenderType(entity, partialTicks, stack, bufferIn, null, packedLightIn, getTextureLocation(entity));
        boolean invis = entity.isInvisibleTo(Minecraft.getInstance().player);

        var color = !entity.getTexture().colored ? 0xffffffff : entity.isRainbow() ? Color.RAINBOW.getRGBA() : entity.getColor();

        render(model, entity, partialTicks, renderType, stack, bufferIn, null, packedLightIn,
                OverlayTexture.pack(OverlayTexture.u(0), false),
                (float) FastColor.ARGB32.red(color) / 255f, (float) FastColor.ARGB32.green(color) / 255f, (float) FastColor.ARGB32.blue(color) / 255f,
                invis ? 0.0F : 1f);

        stack.popPose();
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
        renderLeash(entity, partialTicks, stack, bufferIn);
    }

    @Override
    public Integer getUniqueID(BalloonEntity animatable) {
        return animatable.getUUID().hashCode();
    }

    @Override
    public void renderEarly(BalloonEntity animatable, PoseStack stackIn, float ticks, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        this.rtb = renderTypeBuffer;
        this.whTexture = this.getTextureLocation(animatable);
        IGeoRenderer.super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, partialTicks);
    }

    @Override
    protected boolean shouldShowName(@NotNull BalloonEntity entity) {
        return false;
    }

    @Override
    public GeoModelProvider<BalloonEntity> getGeoModelProvider() {
        return modelProvider;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BalloonEntity instance) {
        return this.modelProvider.getTextureLocation(instance);
    }

    private void renderLeash(BalloonEntity entity, float tickDelta, @NotNull PoseStack stack, @NotNull MultiBufferSource bufferIn) {
        Entity holder = entity.getHolder();
        stack.pushPose();
        Vec3 vec3d = holder == null ? new Vec3(entity.getX() + 0.001, entity.getY() - entity.getRopeLength(), entity.getZ() + 0.001) : holder.getRopeHoldPosition(tickDelta);
        double g = Mth.lerp(tickDelta, entity.xOld, entity.getX());
        double h = Mth.lerp(tickDelta, entity.yOld, entity.getY());
        double i = Mth.lerp(tickDelta, entity.zOld, entity.getZ());
        float j = (float)(vec3d.x - g);
        float k = (float)(vec3d.y - h);
        float l = (float)(vec3d.z - i);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(RenderType.leash());
        Matrix4f matrix4f = stack.last().pose();
        float n = Mth.fastInvSqrt(j * j + l * l) * 0.025F / 2.0F;
        float o = l * n;
        float p = j * n;
        BlockPos blockPos = new BlockPos(entity.getEyePosition(tickDelta));
        BlockPos blockPos2 = holder == null ? blockPos : new BlockPos(holder.getEyePosition(tickDelta));
        int q = this.getBlockLightLevel(entity, blockPos);
        int r = holder != null && holder.isOnFire() ? 15 : entity.level.getBrightness(LightLayer.BLOCK, blockPos2);
        int s = entity.level.getBrightness(LightLayer.SKY, blockPos);
        int t = entity.level.getBrightness(LightLayer.SKY, blockPos2);

        int u;
        for(u = 0; u <= 24; ++u) {
            renderLeashPiece(vertexConsumer, matrix4f, j, k, l, q, r, s, t, 0.025F, 0.025F, o, p, u, false);
        }

        for(u = 24; u >= 0; --u) {
            renderLeashPiece(vertexConsumer, matrix4f, j, k, l, q, r, s, t, 0.025F, 0.0F, o, p, u, true);
        }

        stack.popPose();
    }

    private static void renderLeashPiece(VertexConsumer vertexConsumer, Matrix4f positionMatrix, float f, float g, float h, int leashedEntityBlockLight, int holdingEntityBlockLight, int leashedEntitySkyLight, int holdingEntitySkyLight, float i, float j, float k, float l, int pieceIndex, boolean isLeashKnot) {
        float m = (float)pieceIndex / 24.0F;
        int n = (int) Mth.lerp(m, (float)leashedEntityBlockLight, (float)holdingEntityBlockLight);
        int o = (int)Mth.lerp(m, (float)leashedEntitySkyLight, (float)holdingEntitySkyLight);
        int p = LightTexture.pack(n, o);
        float q = pieceIndex % 2 == (isLeashKnot ? 1 : 0) ? 0.7F : 1.0F;
        float r = 0.5F * q;
        float s = 0.4F * q;
        float t = 0.3F * q;
        float u = f * m;
        float v = g > 0.0F ? g * m * m : g - g * (1.0F - m) * (1.0F - m);
        float w = h * m;
        vertexConsumer.vertex(positionMatrix, u - k, v + j, w + l).color(r, s, t, 1.0F).uv2(p).endVertex();
        vertexConsumer.vertex(positionMatrix, u + k, v + i - j, w - l).color(r, s, t, 1.0F).uv2(p).endVertex();
    }
}
