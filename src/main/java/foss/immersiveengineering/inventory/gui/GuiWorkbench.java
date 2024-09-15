package foss.immersiveengineering.inventory.gui;

import foss.immersiveengineering.Tags;
import foss.immersiveengineering.inventory.container.ContainerWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;

public class GuiWorkbench extends GuiContainer {

    protected static final ResourceLocation WORKBENCH_GUI = new ResourceLocation(Tags.MOD_ID, "textures/gui/workbench.png");

    public GuiWorkbench(EntityPlayer player, IItemHandler workbench) {
        super(new ContainerWorkbench(player, player.inventory, workbench));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();

        this.mc.getTextureManager().bindTexture(WORKBENCH_GUI);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(x + 79, y + 34, 0, 12, 176, 168);

        GlStateManager.popMatrix();
    }
}
