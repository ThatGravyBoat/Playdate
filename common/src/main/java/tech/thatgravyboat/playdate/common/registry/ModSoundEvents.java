package tech.thatgravyboat.playdate.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import tech.thatgravyboat.playdate.Playdate;
import tech.thatgravyboat.playdate.common.registry.api.RegistryEntry;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistries;
import tech.thatgravyboat.playdate.common.registry.api.ResourcefulRegistry;

public class ModSoundEvents {

    public static final ResourcefulRegistry<SoundEvent> SOUNDS = ResourcefulRegistries.create(Registry.SOUND_EVENT, Playdate.MOD_ID);

    public static final RegistryEntry<SoundEvent> MUSIC = SOUNDS.register("music_box", () -> new SoundEvent(new ResourceLocation(Playdate.MOD_ID, "music_box")));
}
