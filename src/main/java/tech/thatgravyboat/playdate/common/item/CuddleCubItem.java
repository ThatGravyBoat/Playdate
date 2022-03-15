package tech.thatgravyboat.playdate.common.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.client.rendering.plushie.PlushieItemRenderer;
import tech.thatgravyboat.playdate.common.constants.CuddleCub;
import tech.thatgravyboat.playdate.common.constants.PlushieItem;

import java.util.function.Consumer;

public class CuddleCubItem extends PlushItem {

    private final CuddleCub cuddleCub;

    public CuddleCubItem(Block block, CuddleCub cub, Properties properties) {
        super(block, PlushieItem.CUDDLE_CUB, properties);
        this.cuddleCub = cub;
    }

    @Override
    public void initializeClient(@NotNull Consumer<IItemRenderProperties> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IItemRenderProperties() {
            private final BlockEntityWithoutLevelRenderer renderer = PlushieItemRenderer.createCuddleCub();

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return renderer;
            }
        });
    }

    public CuddleCub getCuddleCub() {
        return cuddleCub;
    }
}