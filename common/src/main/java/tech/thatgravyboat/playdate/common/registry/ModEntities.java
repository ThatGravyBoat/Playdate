package tech.thatgravyboat.playdate.common.registry;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import tech.thatgravyboat.playdate.common.constants.BalloonType;
import tech.thatgravyboat.playdate.common.constants.PlushieEntity;
import tech.thatgravyboat.playdate.common.entity.BalloonEntity;
import tech.thatgravyboat.playdate.common.entity.ToyEntity;
import tech.thatgravyboat.playdate.common.utils.TrackedEnum;
import tech.thatgravyboat.playdate.platform.CommonServices;

import java.util.function.Supplier;

//For some reason the suppliers are null, so we just wrap the supplier in another supplier.
@SuppressWarnings({"Convert2MethodRef"})
public class ModEntities {

    public static final TrackedDataHandler<BalloonType> BALLOON_TYPE = new TrackedEnum<>(BalloonType.class);
    static {
        TrackedDataHandlerRegistry.register(BALLOON_TYPE);
    }

    public static final Supplier<EntityType<BalloonEntity>> BALLOON = CommonServices.REGISTRY.registerEntity("balloon",
            BalloonEntity::new, SpawnGroup.MISC, 0.4375f, 0.625f);

    public static final Supplier<EntityType<ToyEntity>> PETUNIA_PIG = createToy("petunia_pig",
            Suppliers.memoize(() -> ModBlocks.PETUNIA_PIG_TOY.get()), PlushieEntity.PETUNIA_PIG, 0.6875f, 1.7f);
    public static final Supplier<EntityType<ToyEntity>> HAPPY_SUN = createToy("happy_sun",
            Suppliers.memoize(() -> ModBlocks.HAPPY_SUN_TOY.get()), PlushieEntity.HAPPY_SUN, 0.8125f, 1.95f);
    public static final Supplier<EntityType<ToyEntity>> LOLLIPOP_CLOWN = createToy("lollipop_clown",
            Suppliers.memoize(() -> ModBlocks.LOLLIPOP_CLOWN_TOY.get()), PlushieEntity.LOLLIPOP_CLOWN, 1.25f, 2.95f);
    public static final Supplier<EntityType<ToyEntity>> STUFFIE = createToy("stuffie",
            Suppliers.memoize(() -> ModBlocks.STUFFIE_TOY.get()), PlushieEntity.STUFFIE, 1.25f, 2.95f);
    public static final Supplier<EntityType<ToyEntity>> SOCK_MONKEY = createToy("sock_monkey",
            Suppliers.memoize(() -> ModBlocks.SOCK_MONKEY.get()), PlushieEntity.SOCK_MONKEY, 0.9f, 0.9f);

    private static Supplier<EntityType<ToyEntity>> createToy(String id, Supplier<Block> toy, PlushieEntity plushie, float width, float height) {
        return CommonServices.REGISTRY.registerEntity(id, (type, world) -> new ToyEntity(type, toy.get(), world, plushie), SpawnGroup.MONSTER, height, width);
    }

    public static void register() {
        //Initialize class.
    }
}
