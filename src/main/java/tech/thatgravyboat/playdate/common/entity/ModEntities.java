package tech.thatgravyboat.playdate.common.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.constants.PlushieEntity;
import tech.thatgravyboat.playdate.common.util.TrackedEnum;

public class ModEntities {

    public static final TrackedDataHandler<BalloonType> BALLOON_TYPE = new TrackedEnum<>(BalloonType.class);

    public static final EntityType<ToyEntity> PETUNIA_PIG = createToy(ModBlocks.PETUNIA_PIG_TOY, PlushieEntity.PETUNIA_PIG, 0.6875f, 1.7f);
    public static final EntityType<ToyEntity> HAPPY_SUN = createToy(ModBlocks.HAPPY_SUN_TOY, PlushieEntity.HAPPY_SUN, 0.8125f, 1.95f);
    public static final EntityType<ToyEntity> LOLLIPOP_CLOWN = createToy(ModBlocks.LOLLIPOP_CLOWN_TOY, PlushieEntity.LOLLIPOP_CLOWN, 1.25f, 2.95f);

    public static final EntityType<BalloonEntity> BALLOON = FabricEntityTypeBuilder.create(SpawnGroup.MISC, BalloonEntity::new)
            .dimensions(EntityDimensions.fixed(0.4375f, 0.625f)).build();

    public static void register() {
        TrackedDataHandlerRegistry.register(BALLOON_TYPE);
        Registry.register(Registry.ENTITY_TYPE, Playdate.modId("petunia_pig"), PETUNIA_PIG);
        Registry.register(Registry.ENTITY_TYPE, Playdate.modId("happy_sun"), HAPPY_SUN);
        Registry.register(Registry.ENTITY_TYPE, Playdate.modId("lollipop_clown"), LOLLIPOP_CLOWN);

        Registry.register(Registry.ENTITY_TYPE, Playdate.modId("balloon"), BALLOON);

        FabricDefaultAttributeRegistry.register(LOLLIPOP_CLOWN, ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        FabricDefaultAttributeRegistry.register(HAPPY_SUN, ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
        FabricDefaultAttributeRegistry.register(PETUNIA_PIG, ToyEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4));
    }

    private static EntityType<ToyEntity> createToy(Block toy, PlushieEntity plushie, float width, float height) {
        return FabricEntityTypeBuilder.<ToyEntity>create(SpawnGroup.MONSTER, (type, world) -> new ToyEntity(type, toy, world, plushie))
                .dimensions(EntityDimensions.fixed(width, height))
                .build();
    }
}
