package tech.thatgravyboat.playdate.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import tech.thatgravyboat.playdate.common.menus.Basic5SlotMenu;
import tech.thatgravyboat.playdate.common.menus.ToyBenchMenu;

public class Basic5SlotScreen extends AbstractContainerScreen<Basic5SlotMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");

    public Basic5SlotScreen(Basic5SlotMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageHeight = 133;
        this.inventoryLabelY = this.imageHeight - 94;
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
        RenderSystem.setShaderTexture(0, TEXTURE);
        int k = this.leftPos;
        int l = (this.height - this.imageHeight) / 2;
        this.blit(stack, k, l, 0, 0, this.imageWidth, this.imageHeight);
    }
}

