package tech.thatgravyboat.playdate.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.menus.ToyBenchMenu;

public class ToyBenchScreen extends AbstractContainerScreen<ToyBenchMenu> {

    private static final ResourceLocation CRAFTING_TABLE_LOCATION = new ResourceLocation("textures/gui/container/crafting_table.png");
    private boolean widthTooNarrow;

    public ToyBenchScreen(ToyBenchMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    protected void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 29;
    }

    @Override
    public void render(@NotNull PoseStack stack, int i, int j, float f) {
        this.renderBackground(stack);
        this.renderBg(stack, f, i, j);
        super.render(stack, i, j, f);
        this.renderTooltip(stack, i, j);
    }

    @Override
    protected void renderBg(@NotNull PoseStack stack, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CRAFTING_TABLE_LOCATION);
        int k = this.leftPos;
        int l = (this.height - this.imageHeight) / 2;
        this.blit(stack, k, l, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected boolean isHovering(int i, int j, int k, int l, double d, double e) {
        return !this.widthTooNarrow && super.isHovering(i, j, k, l, d, e);
    }

    @Override
    public boolean mouseClicked(double d, double e, int i) {
        return this.widthTooNarrow || super.mouseClicked(d, e, i);
    }

    @Override
    protected boolean hasClickedOutside(double d, double e, int i, int j, int k) {
        return d < (double)i || e < (double)j || d >= (double)(i + this.imageWidth) || e >= (double)(j + this.imageHeight);
    }
}

