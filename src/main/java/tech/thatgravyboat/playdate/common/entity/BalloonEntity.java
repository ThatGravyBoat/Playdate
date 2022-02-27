package tech.thatgravyboat.playdate.common.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.constants.BalloonType;

public class BalloonEntity extends Entity implements IAnimatable {

    private static final EntityDataAccessor<BalloonType> TEXTURE = SynchedEntityData.defineId(BalloonEntity.class, ModEntities.BALLOON_TYPE);
    private static final EntityDataAccessor<Boolean> RAINBOW = SynchedEntityData.defineId(BalloonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(BalloonEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HOLDER_ID = SynchedEntityData.defineId(BalloonEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> ROPE_LENGTH = SynchedEntityData.defineId(BalloonEntity.class, EntityDataSerializers.FLOAT);

    private final AnimationFactory factory = new AnimationFactory(this);
    private Entity holder;
    private CompoundTag rope;

    public BalloonEntity(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        this.xOld = this.getX();
        this.yOld = this.getY();
        this.zOld = this.getZ();

        if (this.rope != null) {
            readRopeData();
        }

        if (this.rope == null) {
            if (this.holder != null && (!this.holder.isAlive() || !this.isAlive())){
                this.detachRope();
            }

            if (holder != null) {
                var distance = distanceToHolder();
                if (distance < getRopeLength() + 2f) {
                    var multiply = this.holder.getEyePosition().subtract(this.position()).normalize().scale(distance * 0.1);
                    this.setDeltaMovement(multiply.x, 0, multiply.z);
                }
            }

            if (holder == null || (distanceToHolder() < getRopeLength() || distanceToHolder() > getRopeLength() + 2f)) {
                var deltaMovement = getDeltaMovement();
                setDeltaMovement(deltaMovement.x, Mth.clamp(deltaMovement.y * 1.08f, 0.01f, 0.15f), deltaMovement.z);
            }

            var x = (Mth.cos(this.tickCount + (this.getId() * 5) % 189503) / 160) * Math.PI;
            var z = (Mth.sin(this.tickCount + (this.getId() * 5) % 189503) / 160) * Math.PI;
            push(x, 0, z);

            move(MoverType.SELF, getDeltaMovement());

            if (this.holder != null && distanceToHolder() > getRopeLength() + 2f) {
                detachRope();
            }

            if (level.isOutsideBuildHeight(blockPosition())) {
                this.pop();
            }
        }
    }

    private double distanceToHolder() {
        if (this.holder == null) return 0;
        return Math.sqrt(this.distanceToSqr(this.holder.getEyePosition()));
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand hand) {
        if (this.isAlive()) {
            if (this.getHolder() == null) {
                this.attachRope(player);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else if (this.getHolder() == player) {
                this.detachRope();
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }
        }
        return super.interact(player, hand);
    }

    private void pop() {
        //TODO ADD POP SOUND!
        this.discard();
        for (int i = 0; i < 10; i++) {
            this.level.addParticle(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 0d, 0d, 0d);
        }
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        if (source.isMagic()) return false;
        this.pop();
        return true;
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(TEXTURE, BalloonType.COLORED);
        this.entityData.define(COLOR, 0xffffffff);
        this.entityData.define(RAINBOW, false);
        this.entityData.define(HOLDER_ID, 0);
        this.entityData.define(ROPE_LENGTH, 2f);
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> data) {
        super.onSyncedDataUpdated(data);
        if (HOLDER_ID.equals(data) && this.level.isClientSide) {
            var holder = this.level.getEntity(this.entityData.get(HOLDER_ID));
            if (holder != null) {
                this.holder = holder;
            }
        }
    }

    public float getRopeLength() {
        return this.entityData.get(ROPE_LENGTH);
    }

    public void setRopeLength(float value) {
        this.entityData.set(ROPE_LENGTH, value);
    }

    public boolean isRainbow() {
        return this.entityData.get(RAINBOW);
    }

    public void setRainbow(boolean value) {
        this.entityData.set(RAINBOW, value);
    }

    public int getColor() {
        return this.entityData.get(COLOR);
    }

    public void setColor(int value) {
        this.entityData.set(COLOR, value);
    }

    public BalloonType getTexture() {
        return this.entityData.get(TEXTURE);
    }

    public void setTexture(BalloonType value) {
        this.entityData.set(TEXTURE, value);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        setRainbow(tag.getBoolean("rainbow"));
        setColor(tag.getInt("color"));
        setTexture(BalloonType.getTypeFromId(tag.getString("texture")));
        this.rope = tag.getCompound("rope");
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        tag.putBoolean("rainbow", isRainbow());
        tag.putInt("color", getColor());
        tag.putString("texture", getTexture().id);

        if (this.holder != null) {
            CompoundTag ropeData = new CompoundTag();
            if (this.holder instanceof LivingEntity) {
                ropeData.putUUID("uuid", this.holder.getUUID());
            } else if (this.holder instanceof HangingEntity decor) {
                ropeData.put("pos", NbtUtils.writeBlockPos(decor.getPos()));
            }
            tag.put("rope", ropeData);
        } else if (this.rope != null) {
            tag.put("rope", this.rope.copy());
        }
    }

    private void readRopeData() {
        if (this.rope != null && this.level instanceof ServerLevel server) {
            if (this.rope.hasUUID("uuid")) {
                Entity entity = server.getEntity(this.rope.getUUID("uuid"));
                if (entity != null) {
                    this.attachRope(entity);
                    return;
                }
            } else if (this.rope.contains("pos", Tag.TAG_COMPOUND)) {
                var blockPos = NbtUtils.readBlockPos(this.rope.getCompound("pos"));
                var orCreate = LeashFenceKnotEntity.getOrCreateKnot(server, blockPos);
                this.attachRope(orCreate);
                return;
            }

            if (this.tickCount > 100) {
                this.rope = null;
            }
        }
    }

    public void attachRope(Entity entity) {
        this.holder = entity;
        this.rope = null;
        if (!this.level.isClientSide) {
            this.entityData.set(HOLDER_ID, entity.getId());
        }
    }

    private void detachRope() {
        if (this.holder != null && this.tickCount > 100) {
            this.holder = null;
            this.rope = null;

            this.entityData.set(HOLDER_ID, 0);
        }
    }

    @Nullable
    public Entity getHolder() {
        int holdingId = this.entityData.get(HOLDER_ID);
        if (this.holder == null && holdingId != 0 && this.level.isClientSide) {
            this.holder = this.level.getEntity(holdingId);
        }

        return this.holder;
    }


    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    public void registerControllers(AnimationData data) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
