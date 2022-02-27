package tech.thatgravyboat.playdate.common.entity;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.playdate.PlayDate;
import tech.thatgravyboat.playdate.common.blocks.ModBlocks;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.constants.PlushieEntity;
import tech.thatgravyboat.playdate.common.util.TrackedEnum;

import java.util.function.Supplier;

public class ModEntities {

    public static final EntityDataSerializer<BalloonType> BALLOON_TYPE = new TrackedEnum<>(BalloonType.class);
    static {
        EntityDataSerializers.registerSerializer(BALLOON_TYPE);
    }

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, PlayDate.MODID);

    public static final RegistryObject<EntityType<BalloonEntity>> BALLOON = ENTITY_TYPES.register("balloon", () -> EntityType.Builder
                    .of(BalloonEntity::new, MobCategory.MISC).sized(0.4375f, 0.625f).build("balloon"));

    public static final RegistryObject<EntityType<ToyEntity>> PETUNIA_PIG = createToy("petunia_pig",
            ModBlocks.PETUNIA_PIG_TOY, PlushieEntity.PETUNIA_PIG, 0.6875f, 1.7f);
    public static final RegistryObject<EntityType<ToyEntity>> HAPPY_SUN = createToy("happy_sun",
            ModBlocks.HAPPY_SUN_TOY, PlushieEntity.HAPPY_SUN, 0.8125f, 1.95f);
    public static final RegistryObject<EntityType<ToyEntity>> LOLLIPOP_CLOWN = createToy("lollipop_clown",
            ModBlocks.LOLLIPOP_CLOWN_TOY, PlushieEntity.LOLLIPOP_CLOWN, 1.25f, 2.95f);

    private static RegistryObject<EntityType<ToyEntity>> createToy(String id, Supplier<Block> toy, PlushieEntity plushie, float width, float height) {
        return ENTITY_TYPES.register(id, () -> EntityType.Builder.<ToyEntity>of((type, world) -> new ToyEntity(type, toy.get(), world, plushie), MobCategory.MONSTER)
                .sized(width, height)
                .build(id));
    }
}
