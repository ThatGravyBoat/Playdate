package tech.thatgravyboat.playdate.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.LeashKnotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import tech.thatgravyboat.playdate.common.constants.BalloonType;

public class BalloonEntity extends Entity implements IAnimatable {

    private static final TrackedData<BalloonType> TEXTURE = DataTracker.registerData(BalloonEntity.class, ModEntities.BALLOON_TYPE);
    private static final TrackedData<Boolean> RAINBOW = DataTracker.registerData(BalloonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(BalloonEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> HOLDER_ID = DataTracker.registerData(BalloonEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> ROPE_LENGTH = DataTracker.registerData(BalloonEntity.class, TrackedDataHandlerRegistry.FLOAT);

    private final AnimationFactory factory = new AnimationFactory(this);
    private Entity holder;
    private NbtCompound rope;

    public BalloonEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public void tick() {
        super.tick();
        this.prevX = this.getX();
        this.prevY = this.getY();
        this.prevZ = this.getZ();

        if (this.rope != null) {
            readRopeData();
        }

        if (this.rope == null) {
            if (this.holder != null && (!this.holder.isAlive() || !this.isAlive())) {
                this.detachRope();
            }

            if (holder != null) {
                var distance = distanceToHolder();
                if (distance < getRopeLength() + 2f) {
                    var multiply = this.holder.getEyePos().subtract(this.getPos()).normalize().multiply(distance * 0.1);
                    this.setVelocity(multiply.x, 0, multiply.z);
                }
            }

            if (this.holder == null || (distanceToHolder() < getRopeLength() || distanceToHolder() > getRopeLength() + 2f)) {
                Vec3d velocity = getVelocity();
                setVelocity(velocity.x, MathHelper.clamp(velocity.y * 1.08f, 0.01f, 0.15f), velocity.z);
            }

            var x = (MathHelper.cos(this.age + (this.getId() * 5) % 189503) / 160) * Math.PI;
            var z = (MathHelper.sin(this.age + (this.getId() * 5) % 189503) / 160) * Math.PI;
            addVelocity(x, 0, z);

            move(MovementType.SELF, getVelocity());

            if (this.holder != null && distanceToHolder() > getRopeLength() + 2f) {
                detachRope();
            }

            if (world.isOutOfHeightLimit(getBlockPos())) {
                this.pop();
            }
        }
    }

    private double distanceToHolder() {
        if (this.holder == null) return 0;
        return Math.sqrt(this.squaredDistanceTo(this.holder.getEyePos()));
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (this.isAlive()) {
            if (this.getHolder() == null) {
                this.attachRope(player);
                return ActionResult.success(this.world.isClient);
            } else if (this.getHolder() == player) {
                this.detachRope();
                return ActionResult.success(this.world.isClient);
            }
        }
        return super.interact(player, hand);
    }

    private void pop() {
        //TODO ADD POP SOUND!
        this.discard();
        for (int i = 0; i < 10; i++) {
            this.world.addParticle(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 0d, 0d, 0d);
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        if (source.isMagic()) return false;
        this.pop();
        return true;
    }

    @Override
    public boolean collides() {
        return !this.isRemoved();
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    //region Data Trackers

    @Override
    protected void initDataTracker() {
        this.getDataTracker().startTracking(RAINBOW, false);
        this.getDataTracker().startTracking(COLOR, 0xffffffff);
        this.getDataTracker().startTracking(TEXTURE, BalloonType.COLORED);
        this.getDataTracker().startTracking(HOLDER_ID, 0);
        this.getDataTracker().startTracking(ROPE_LENGTH, 2f);
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        if (HOLDER_ID.equals(data) && this.world.isClient) {
            var holder = this.world.getEntityById(this.getDataTracker().get(HOLDER_ID));
            if (holder != null) {
                this.holder = holder;
            }
        }
    }

    public float getRopeLength() {
        return this.getDataTracker().get(ROPE_LENGTH);
    }

    public void setRopeLength(float value) {
        this.getDataTracker().set(ROPE_LENGTH, value);
    }

    public boolean isRainbow() {
        return this.getDataTracker().get(RAINBOW);
    }

    public void setRainbow(boolean value) {
        this.getDataTracker().set(RAINBOW, value);
    }

    public int getColor() {
        return this.getDataTracker().get(COLOR);
    }

    public void setColor(int value) {
        this.getDataTracker().set(COLOR, value);
    }

    public BalloonType getTexture() {
        return this.getDataTracker().get(TEXTURE);
    }

    public void setTexture(BalloonType value) {
        this.getDataTracker().set(TEXTURE, value);
    }

    //endregion

    //region NBT

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        setRainbow(nbt.getBoolean("rainbow"));
        setColor(nbt.getInt("color"));
        setTexture(BalloonType.getTypeFromId(nbt.getString("texture")));
        this.rope = nbt.getCompound("rope");
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putBoolean("rainbow", isRainbow());
        nbt.putInt("color", getColor());
        nbt.putString("texture", getTexture().id);

        if (this.holder != null) {
            NbtCompound ropeData = new NbtCompound();
            if (this.holder instanceof LivingEntity) {
                ropeData.putUuid("uuid", this.holder.getUuid());
            } else if (this.holder instanceof AbstractDecorationEntity decor) {
                ropeData.put("pos", NbtHelper.fromBlockPos(decor.getDecorationBlockPos()));
            }
            nbt.put("rope", ropeData);
        } else if (this.rope != null) {
            nbt.put("rope", this.rope.copy());
        }
    }

    private void readRopeData() {
        if (this.rope != null && this.world instanceof ServerWorld server) {
            if (this.rope.containsUuid("uuid")) {
                Entity entity = server.getEntity(this.rope.getUuid("uuid"));
                if (entity != null) {
                    this.attachRope(entity);
                    return;
                }
            } else if (this.rope.contains("pos", NbtElement.COMPOUND_TYPE)) {
                var blockPos = NbtHelper.toBlockPos(this.rope.getCompound("pos"));
                var orCreate = LeashKnotEntity.getOrCreate(this.world, blockPos);
                this.attachRope(orCreate);
                return;
            }

            if (this.age > 100) {
                this.rope = null;
            }
        }
    }

    //endregion

    //region Rope Handling
    public void attachRope(Entity entity) {
        this.holder = entity;
        this.rope = null;
        if (!this.world.isClient) {
            this.getDataTracker().set(HOLDER_ID, entity.getId());
        }
    }

    private void detachRope() {
        if (this.holder != null && this.age > 100) {
            this.holder = null;
            this.rope = null;

            this.getDataTracker().set(HOLDER_ID, 0);
        }
    }

    @Nullable
    public Entity getHolder() {
        var holdingId = this.getDataTracker().get(HOLDER_ID);
        if (this.holder == null && holdingId != 0 && this.world.isClient) {
            this.holder = this.world.getEntityById(holdingId);
        }

        return this.holder;
    }

    //endregion

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    public void registerControllers(AnimationData animationData) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
