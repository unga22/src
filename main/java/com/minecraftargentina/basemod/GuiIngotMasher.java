package com.minecraftargentina.basemod;



import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIngotMasher extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(BaseMod.modid + ":" + "/textures/gui/IngotMasherGui.png");
	private TileEntityIngotMasher ingotMasher;

	public GuiIngotMasher(InventoryPlayer invPlayer, TileEntityIngotMasher teIngotMasher) {
		super(new ContainerIngotMasher(invPlayer, teIngotMasher));
		ingotMasher = teIngotMasher;

		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.ingotMasher.hasCustomInventoryName() ? this.ingotMasher.getInventoryName() : I18n.format(this.ingotMasher.getInventoryName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(ingotMasher.hasPower()) {
			int i1 = ingotMasher.getPowerRemainingScaled(45);
			drawTexturedModalRect(guiLeft + 8, guiTop + 52 - i1, 176, 96 - i1, 16, i1);
		}
		
		int j1 = ingotMasher.getMasherProgressSclaed(48);
		drawTexturedModalRect(guiLeft + 59, guiTop + 15, 176, 0, j1 + 1, 51);

	}

}