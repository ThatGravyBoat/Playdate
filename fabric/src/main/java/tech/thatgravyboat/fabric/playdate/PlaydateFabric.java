package tech.thatgravyboat.fabric.playdate;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.registry.Registry;
import tech.thatgravyboat.fabric.playdate.services.FabricRegistryService;
import tech.thatgravyboat.playdate.Playdate;
import net.fabricmc.api.ModInitializer;

import java.util.HashMap;
import java.util.Map;

import static tech.thatgravyboat.playdate.Playdate.modId;

public class PlaydateFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Playdate.init();

        FabricRegistryService.BLOCK_ENTITIES.forEach((id, item) -> Registry.register(Registry.BLOCK_ENTITY_TYPE, modId(id), item.get()));
        FabricRegistryService.BLOCKS.forEach((id, item) -> Registry.register(Registry.BLOCK, modId(id), item.get()));
        FabricRegistryService.ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, modId(id), item.get()));
        FabricRegistryService.ENTITIES.forEach((id, item) -> Registry.register(Registry.ENTITY_TYPE, modId(id), item.get()));
        FabricRegistryService.PAINTINGS.forEach((id, item) -> Registry.register(Registry.PAINTING_MOTIVE, modId(id), item.get()));
        FabricRegistryService.CONTAINERS.forEach((id, item) -> Registry.register(Registry.SCREEN_HANDLER, modId(id), item.get()));
        FabricRegistryService.RECIPES.forEach((id, item) -> Registry.register(Registry.RECIPE_SERIALIZER, modId(id), item.get()));
        FabricRegistryService.SOUNDS.forEach((id, item) -> Registry.register(Registry.SOUND_EVENT, modId(id), item.get()));

        Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer.Builder> attributes = new HashMap<>();
        Playdate.addEntityAttributes(attributes);
        attributes.forEach(FabricDefaultAttributeRegistry::register);
    }
}
