package tech.thatgravyboat.forge.playdate;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tech.thatgravyboat.forge.playdate.services.ForgeRegistryService;
import tech.thatgravyboat.playdate.Playdate;

import java.util.HashMap;
import java.util.Map;

@Mod(Playdate.MODID)
public class PlaydateForge {

    public PlaydateForge() {
        Playdate.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlaydateForge::addEntityAttributes);
        MinecraftForge.EVENT_BUS.addListener(PlaydateForge::onItemUse);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ForgeRegistryService.BLOCKS_ENTITIES.register(bus);
        ForgeRegistryService.BLOCKS.register(bus);
        ForgeRegistryService.ITEMS.register(bus);
        ForgeRegistryService.ENTITIES.register(bus);
        ForgeRegistryService.PAINTINGS.register(bus);
        ForgeRegistryService.CONTAINERS.register(bus);
        ForgeRegistryService.RECIPES.register(bus);
        ForgeRegistryService.SOUNDS.register(bus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> PlaydateForgeClient::init);
    }

    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer.Builder> attributes = new HashMap<>();
        Playdate.addEntityAttributes(attributes);
        attributes.forEach((entity, builder) -> event.put(entity, builder.build()));
    }

    public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
        var result = Playdate.onItemUse(event.getPlayer(), event.getItemStack(), event.getWorld(), event.getHand());
        if (result.getResult().isAccepted()) {
            event.setCancellationResult(result.getResult());
            event.setCanceled(true);
        }
    }
}
