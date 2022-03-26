package tech.thatgravyboat.forge.playdate.services;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraftforge.client.IItemRenderProperties;
import tech.thatgravyboat.playdate.client.rendering.dollhouse.DollHouseItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.musicbox.MusicBoxItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.player.PlayerPlushieItemRenderer;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieItemRenderer;
import tech.thatgravyboat.playdate.common.blocks.BallPitBlock;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.Doll;
import tech.thatgravyboat.playdate.common.constants.PlayerSkin;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;
import tech.thatgravyboat.playdate.common.items.*;
import tech.thatgravyboat.playdate.platform.services.IPlatformHelper;

import java.util.function.Consumer;

public class ForgePlatformService implements IPlatformHelper {

    public static void createPlushieRenderer(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private final BuiltinModelItemRenderer renderer = PlushieItemRenderer.create();

            @Override
            public BuiltinModelItemRenderer getItemStackRenderer() {
                return renderer;
            }
        });
    }

    @Override
    public PlushItem createPlush(Block block, PlushieItem plushie, Item.Settings settings) {
        return new PlushItem(block, plushie, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                createPlushieRenderer(consumer);
            }
        };
    }

    @Override
    public CuddleCubItem createCub(Block block, CuddleCub cub, Item.Settings settings) {
        return new CuddleCubItem(block, cub, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                createPlushieRenderer(consumer);
            }
        };
    }

    @Override
    public PlayerPlushieItem createPlayer(Block block, PlayerSkin defaultSkin, Item.Settings settings) {
        return new PlayerPlushieItem(block, defaultSkin, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                consumer.accept(new IItemRenderProperties() {
                    private final BuiltinModelItemRenderer renderer = PlayerPlushieItemRenderer.create();

                    @Override
                    public BuiltinModelItemRenderer getItemStackRenderer() {
                        return renderer;
                    }
                });
            }
        };
    }

    @Override
    public DollHouseItem createDollhouse(Block block, Doll defaultSkin, Item.Settings settings) {
        return new DollHouseItem(block, defaultSkin, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                consumer.accept(new IItemRenderProperties() {
                    private final BuiltinModelItemRenderer renderer = DollHouseItemRenderer.create();

                    @Override
                    public BuiltinModelItemRenderer getItemStackRenderer() {
                        return renderer;
                    }
                });
            }
        };
    }

    @Override
    public DollItem createDoll(Block block, Doll doll, Item.Settings settings) {
        return new DollItem(block, doll, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                createPlushieRenderer(consumer);
            }
        };
    }

    @Override
    public BallPitBlock createBallpitBlock(AbstractBlock.Settings settings) {
        return new BallPitBlock(AbstractBlock.Settings.of(Material.WOOL).dynamicBounds()) {
            @Override
            public boolean isScaffolding(BlockState state, WorldView level, BlockPos pos, LivingEntity entity) {
                return true;
            }
        };
    }

    @Override
    public MusicBoxItem createMusicBox(Block block, Item.Settings settings) {
        return new MusicBoxItem(block, settings) {
            @Override
            public void initializeClient(Consumer<IItemRenderProperties> consumer) {
                super.initializeClient(consumer);
                consumer.accept(new IItemRenderProperties() {
                    private final BuiltinModelItemRenderer renderer = MusicBoxItemRenderer.create();

                    @Override
                    public BuiltinModelItemRenderer getItemStackRenderer() {
                        return renderer;
                    }
                });
            }
        };
    }
}
