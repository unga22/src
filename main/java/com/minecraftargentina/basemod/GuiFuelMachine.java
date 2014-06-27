package com.minecraftargentina.basemod;



import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiFuelMachine extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(BaseMod.modid + ":" + "/textures/gui/GuiFuelMachine.png");
	private TileEntityFuelMachine fuelmashine;

	public GuiFuelMachine(InventoryPlayer invPlayer, TileEntityFuelMachine teBioFuelTransformer) {
		super(new ContainerFuelMachine(invPlayer, teBioFuelTransformer));
		fuelmashine = teBioFuelTransformer;

		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.fuelmashine.hasCustomInventoryName() ? this.fuelmashine.getInventoryName() : I18n.format(this.fuelmashine.getInventoryName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(fuelmashine.tieneCombustible()){
			int i = fuelmashine.getFuelTimeRemainingScaled(13);
			drawTexturedModalRect(guiLeft + 82, guiTop + 53 - i, 176, 12 - i, 0, i);
		}
		if(fuelmashine.waterStatus > 0 && fuelmashine.waterStatus <= fuelmashine.maxWater){
			int i = fuelmashine.getWaterRemainingScaled(45);
			drawTexturedModalRect(guiLeft + 8, guiTop + 53 - i, 176, 103 - i, 16, i);
		}
		if(fuelmashine.biofuelStatus >0 && fuelmashine.biofuelStatus <= fuelmashine.maxBioFuel){
			int i = fuelmashine.getBioFuelRemainingScaled(45);
			drawTexturedModalRect(guiLeft + 152, guiTop + 53 - i, 176, 57 -i, 16, i);
		}
		if(fuelmashine.estaTransformado()){
			int i = fuelmashine.getTransformedProgressSclaed(17);
			drawTexturedModalRect(guiLeft +30, guiTop + 26, 0, 167, i, 176);
		}
	}

}