package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.resources.ResourceLocation;

import static tech.thatgravyboat.playdate.PlayDate.modId;

public enum CuddleCub {
    //Pride Collection
    AROMANTIC(modId("textures/block/cuddlecubs/aromantic.png")),
    ASEXUAL(modId("textures/block/cuddlecubs/asexual.png")),
    BISEXUAL(modId("textures/block/cuddlecubs/bisexual.png")),
    PRIDE(modId("textures/block/cuddlecubs/pride.png")),
    GENDERQUEER(modId("textures/block/cuddlecubs/genderqueer.png")),
    LESBIAN(modId("textures/block/cuddlecubs/lesbian.png")),
    NONBINARY(modId("textures/block/cuddlecubs/nonbinary.png")),
    PANSEXUAL(modId("textures/block/cuddlecubs/pansexual.png")),
    TRANS(modId("textures/block/cuddlecubs/trans.png")),
    //Others
    PANDA(modId("textures/block/cuddlecubs/panda_bear.png")),
    POLAR(modId("textures/block/cuddlecubs/polar_bear.png")),
    COOL(modId("textures/block/cuddlecubs/cool.png")),
    BROWN(modId("textures/block/cuddlecubs/brown_bear.png")),
    HONEY(modId("textures/block/cuddlecubs/honey_bear.png")),
    STUFFIE(modId("textures/block/cuddlecubs/stuffie_plush.png"));


    public final ResourceLocation texture;

    CuddleCub(ResourceLocation texture) {
        this.texture = texture;
    }
}
