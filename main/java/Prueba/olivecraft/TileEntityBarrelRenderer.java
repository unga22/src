package Prueba.olivecraft;


import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileEntityBarrelRenderer extends TileEntitySpecialRenderer {
	
	private ModelBarrel modelBarrel;
	
	public TileEntityBarrelRenderer() {
		modelBarrel = new ModelBarrel();
	}

	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		renderModelAt((TileEntityBarrel) tileentity, d0, d1, d2, f);
	}
	
	public void renderModelAt(TileEntityBarrel tile, double d, double d1, double d2, float f) {
		ResourceLocation texture = new ResourceLocation("olivecraft", "textures/model/barrel.png");
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.renderModel(tile, d, d1, d2, f);
		this.renderOlives(tile, d, d1, d2, f);
		GL11.glPopMatrix();
	}
	
	private void renderModel(TileEntityBarrel tile, double d, double d1, double d2, float f) {
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		modelBarrel.renderAll(waterOffset(tile));
	}
	
	private void renderOlives(TileEntityBarrel tile, double d, double d1, double d2, float f) {
		GL11.glScalef(1F, -1F, -1F);
		GL11.glTranslatef(0F, -0.9F, 0F);
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		for (int i = 0; i < TileEntityBarrel.MAX_OLIVES; i++) {
			if (tile.getOlive(i) > 0) {
				RenderManager.instance.renderEntityWithPosYaw(tile.renderOliveRaw, tile.olivesX[i], 0, tile.olivesZ[i], 0, f);
			} else if (tile.getOlive(i) == 0) {
				RenderManager.instance.renderEntityWithPosYaw(tile.renderOliveEdible, tile.olivesX[i], 0, tile.olivesZ[i], 0, f);
			}
		}
	}
	
	
	private int waterOffset(TileEntityBarrel tile) {
		if (tile.hasFermenter()) {
			return 3;
		} else if (!tile.hasWater()) {
			return -1;
		} else {
			if (tile.hasMushroom() && !tile.hasSugar()) {
				return 1;
			} else if (!tile.hasMushroom() && tile.hasSugar()) {
				return 2;
			} else {
				return 0;
			}
		}
	}

}
