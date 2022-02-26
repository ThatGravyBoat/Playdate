package tech.thatgravyboat.playdate.client.rendering;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.world.LightType;
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

public class BalloonRenderer extends EntityRenderer<BalloonEntity> implements IGeoRenderer<BalloonEntity> {
    static {
        AnimationController.addModelFetcher((IAnimatable object) -> {
            if (object instanceof BalloonEntity) {
                return (IAnimatableModel<Object>) AnimationUtils.getGeoModelForEntity((BalloonEntity) object);
            }
            return null;
        });
    }

    private final AnimatedGeoModel<BalloonEntity> modelProvider = new BalloonModel();

    public VertexConsumerProvider rtb;
    public Identifier whTexture;

    public BalloonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @SuppressWarnings("resource")
    @Override
    public void render(BalloonEntity entity, float entityYaw, float partialTicks, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn) {
        stack.push();
        boolean shouldSit = entity.hasVehicle() && (entity.getVehicle() != null);
        EntityModelData entityModelData = new EntityModelData();
        entityModelData.isSitting = shouldSit;

        AnimationEvent<BalloonEntity> predicate = new AnimationEvent<>(entity, 0, 0, partialTicks, false, Collections.singletonList(entityModelData));
        GeoModel model = modelProvider.getModel(modelProvider.getModelLocation(entity));
        modelProvider.setLivingAnimations(entity, this.getUniqueID(entity), predicate);

        stack.translate(0, 0.01f, 0);
        MinecraftClient.getInstance().getTextureManager().bindTexture(getTexture(entity));
        RenderLayer renderType = getRenderType(entity, partialTicks, stack, bufferIn, null, packedLightIn, getTexture(entity));
        boolean invis = entity.isInvisibleTo(MinecraftClient.getInstance().player);

        var color = !entity.getTexture().colored ? 0xffffffff : entity.isRainbow() ? Color.RAINBOW.getRGBA() : entity.getColor();

        render(model, entity, partialTicks, renderType, stack, bufferIn, null, packedLightIn,
                OverlayTexture.getUv(OverlayTexture.getU(0), false),
                ColorHelper.Argb.getRed(color) / 255f, ColorHelper.Argb.getGreen(color) / 255f, ColorHelper.Argb.getBlue(color) / 255f,
                invis ? 0.0F : 1f);

        stack.pop();
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
        renderLeash(entity, partialTicks, stack, bufferIn);
    }

    @Override
    public Integer getUniqueID(BalloonEntity animatable) {
        return animatable.getUuid().hashCode();
    }

    @Override
    public void renderEarly(BalloonEntity animatable, MatrixStack stackIn, float ticks, VertexConsumerProvider renderTypeBuffer,
                            VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue,
                            float partialTicks) {
        this.rtb = renderTypeBuffer;
        this.whTexture = this.getTextureLocation(animatable);
        IGeoRenderer.super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn,
                packedOverlayIn, red, green, blue, partialTicks);
    }

    @Override
    public Identifier getTexture(BalloonEntity entity) {
        return getTextureLocation(entity);
    }

    @Override
    public GeoModelProvider<BalloonEntity> getGeoModelProvider() {
        return this.modelProvider;
    }

    @Override
    protected boolean hasLabel(BalloonEntity entity) {
        return false;
    }

    @Override
    public Identifier getTextureLocation(BalloonEntity instance) {
        return this.modelProvider.getTextureLocation(instance);
    }

    private void renderLeash(BalloonEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider provider) {
        Entity holder = entity.getHolder();
        matrices.push();
        Vec3d vec3d = holder == null ? new Vec3d(entity.getX() + 0.001, entity.getY() - entity.getRopeLength(), entity.getZ() + 0.001) : holder.getLeashPos(tickDelta);
        double g = MathHelper.lerp(tickDelta, entity.prevX, entity.getX());
        double h = MathHelper.lerp(tickDelta, entity.prevY, entity.getY());
        double i = MathHelper.lerp(tickDelta, entity.prevZ, entity.getZ());
        float j = (float)(vec3d.x - g);
        float k = (float)(vec3d.y - h);
        float l = (float)(vec3d.z - i);
        VertexConsumer vertexConsumer = provider.getBuffer(RenderLayer.getLeash());
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        float n = MathHelper.fastInverseSqrt(j * j + l * l) * 0.025F / 2.0F;
        float o = l * n;
        float p = j * n;
        BlockPos blockPos = new BlockPos(entity.getCameraPosVec(tickDelta));
        BlockPos blockPos2 = holder == null ? blockPos : new BlockPos(holder.getCameraPosVec(tickDelta));
        int q = this.getBlockLight(entity, blockPos);
        int r = holder != null && holder.isOnFire() ? 15 : entity.world.getLightLevel(LightType.BLOCK, blockPos2);
        int s = entity.world.getLightLevel(LightType.SKY, blockPos);
        int t = entity.world.getLightLevel(LightType.SKY, blockPos2);

        int u;
        for(u = 0; u <= 24; ++u) {
            renderLeashPiece(vertexConsumer, matrix4f, j, k, l, q, r, s, t, 0.025F, 0.025F, o, p, u, false);
        }

        for(u = 24; u >= 0; --u) {
            renderLeashPiece(vertexConsumer, matrix4f, j, k, l, q, r, s, t, 0.025F, 0.0F, o, p, u, true);
        }

        matrices.pop();
    }

    private static void renderLeashPiece(VertexConsumer vertexConsumer, Matrix4f positionMatrix, float f, float g, float h, int leashedEntityBlockLight, int holdingEntityBlockLight, int leashedEntitySkyLight, int holdingEntitySkyLight, float i, float j, float k, float l, int pieceIndex, boolean isLeashKnot) {
        float m = (float)pieceIndex / 24.0F;
        int n = (int) MathHelper.lerp(m, (float)leashedEntityBlockLight, (float)holdingEntityBlockLight);
        int o = (int)MathHelper.lerp(m, (float)leashedEntitySkyLight, (float)holdingEntitySkyLight);
        int p = LightmapTextureManager.pack(n, o);
        float q = pieceIndex % 2 == (isLeashKnot ? 1 : 0) ? 0.7F : 1.0F;
        float r = 0.5F * q;
        float s = 0.4F * q;
        float t = 0.3F * q;
        float u = f * m;
        float v = g > 0.0F ? g * m * m : g - g * (1.0F - m) * (1.0F - m);
        float w = h * m;
        vertexConsumer.vertex(positionMatrix, u - k, v + j, w + l).color(r, s, t, 1.0F).light(p).next();
        vertexConsumer.vertex(positionMatrix, u + k, v + i - j, w - l).color(r, s, t, 1.0F).light(p).next();
    }
}
