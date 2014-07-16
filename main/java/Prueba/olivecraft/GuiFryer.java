package Prueba.olivecraft;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFryer extends GuiContainer {
    private TileEntityFryer fryerInventory;

    public GuiFryer(InventoryPlayer inventory, TileEntityFryer tileEntity) {
        super(new ContainerFryer(tileEntity, inventory));
        fryerInventory = tileEntity;
    }
   
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    	fontRendererObj.drawString(StatCollector.translateToLocal("olivecraft.tile.fryer.name"), 6, 6, 0x404040);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0x404040);
    }
    
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        ResourceLocation texture = new ResourceLocation("olivecraft", "textures/gui/fryer.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        
        int scale;
        scale = fryerInventory.getFuelForDisplay(12);
        if (scale > 0) {
            this.drawTexturedModalRect(x + 38, y + 36 + 12 - scale, 176, 12 - scale, 14, scale + 2);
        }
        scale = fryerInventory.getProgressForDisplay(24);
        this.drawTexturedModalRect(x + 60, y + 35, 176, 14, scale + 1, 16);
    }
}
