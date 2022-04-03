package tech.thatgravyboat.playdate.common.constants;

import net.minecraft.util.Identifier;

import static tech.thatgravyboat.playdate.Playdate.modId;

public enum PlushieItem {
    CREEPER(
            modId("geo/creeper_plush.geo.json"),
            modId("textures/block/creeper_plush.png"),
            modId("animations/empty.animation.json")
    ),
    DINO(
            modId("geo/dino_plush.geo.json"),
            modId("textures/block/dino_plush.png"),
            modId("animations/empty.animation.json")
    ),
    ENDERMAN(
            modId("geo/enderman_plush.geo.json"),
            modId("textures/block/enderman_plush.png"),
            modId("animations/empty.animation.json")
    ),
    HAPPY_SUN(
        modId("geo/happy_sun_plush.geo.json"),
        modId("textures/block/happy_sun_plush.png"),
        modId("animations/empty.animation.json")
    ),
    HAPPY_SUN_TOY(
            modId("geo/happy_sun_toy.geo.json"),
            modId("textures/block/happy_sun_toy.png"),
            modId("animations/happy_sun.animation.json")
    ),
    LOLLIPOP_CLOWN(
            modId("geo/lollipop_clown_plush.geo.json"),
            modId("textures/block/lollipop_clown_plush.png"),
            modId("animations/empty.animation.json")
    ),
    LOLLIPOP_CLOWN_TOY(
            modId("geo/lollipop_clown.geo.json"),
            modId("textures/block/lollipop_clown_toy.png"),
            modId("animations/empty.animation.json")
    ),
    PETUNIA_PIG(
            modId("geo/petunia_pig_plush.geo.json"),
            modId("textures/block/petunia_pig_plush.png"),
            modId("animations/empty.animation.json")
    ),
    PETUNIA_PIG_TOY(
            modId("geo/princess.geo.json"),
            modId("textures/block/petunia_pig_toy.png"),
            modId("animations/petunia.animation.json")
    ),
    RUBBER_DUCKY(
            modId("geo/rubber_ducky.geo.json"),
            modId("textures/block/rubber_ducky.png"),
            modId("animations/empty.animation.json")
    ),
    WHEELIE_PUP(
            modId("geo/wheelie_pup.geo.json"),
            modId("textures/block/wheelie_pup.png"),
            modId("animations/empty.animation.json")
    ),
    ZOMBIE(
            modId("geo/humanoid.geo.json"),
            modId("textures/block/zombie_plush.png"),
            modId("animations/empty.animation.json")
    ),
    CYMBAL_MONKEY(
            modId("geo/cymbal_banging_monkey.geo.json"),
            modId("textures/block/cymbal_monkey.png"),
            modId("animations/empty.animation.json")
    ),
    FOX(
            modId("geo/fox_plush.geo.json"),
            modId("textures/block/fox_plush.png"),
            modId("animations/empty.animation.json")
    ),
    SNOWY_FOX(
            modId("geo/fox_plush.geo.json"),
            modId("textures/block/snowy_fox_plush.png"),
            modId("animations/empty.animation.json")
    ),
    PIGGY_BANK(
            modId("geo/piggy_bank.geo.json"),
            modId("textures/block/piggy_bank.png"),
            modId("animations/empty.animation.json")
    ),
    RABBIT(
            modId("geo/rabbit_plush.geo.json"),
            modId("textures/block/rabbit_plush.png"),
            modId("animations/empty.animation.json")
    ),
    SOCK_MONKEY(
            modId("geo/sock_monkey.geo.json"),
            modId("textures/block/sock_monkey.png"),
            modId("animations/empty.animation.json")
    ),
    ROBOT(
            modId("geo/wind_up_robot.geo.json"),
            modId("textures/block/robot.png"),
            modId("animations/empty.animation.json")
    ),
    CUDDLE_CUB(
            modId("geo/teddy_bear.geo.json"),
            modId("textures/block/cuddlecubs/stuffie_plush.png"), //Not used as overridden in custom cuddle cub model
            modId("animations/empty.animation.json")
    ),
    STUFFIE_TOY(
            modId("geo/stuffie.geo.json"),
            modId("textures/block/stuffie.png"),
            modId("animations/empty.animation.json")
    ),
    PLAYER(
            modId("geo/humanoid.geo.json"),
            modId("textures/block/players/steve.png"),
            modId("animations/empty.animation.json")
    ),
    DOLL(
            modId("geo/humanoid.geo.json"), //Does not matter gets overrode later.
            modId("textures/block/players/steve.png"), //Does not matter gets overrode later.
            modId("animations/empty.animation.json")
    ),
    DUMMY(
            modId("geo/dummy.geo.json"),
            modId("textures/block/dummy.png"),
            modId("animations/dummy.animation.json")
    );

    public final Identifier model;
    public final Identifier texture;
    public final Identifier animation;

    PlushieItem(Identifier model, Identifier texture, Identifier animation) {
        this.model = model;
        this.texture = texture;
        this.animation = animation;
    }
}