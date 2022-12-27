package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.entities.SittingEntity;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;


public class ModEntities {

    public static final ResourcefulRegistry<EntityType<?>> ENTITIES = ResourcefulRegistries.create(Registry.ENTITY_TYPE, Playdate.MOD_ID);

    public static final RegistryEntry<EntityType<SittingEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.of(SittingEntity::new, MobCategory.MISC).noSave().sized(0.5f, 0.8125f).fireImmune().build(""));
}
