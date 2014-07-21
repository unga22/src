
//PRUEBA DE RENDER CON DRAWING QUADS

package com.minecraftargentina.basemod.lib;

import org.lwjgl.opengl.GL11;

import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RENDERDIFERENTE extends TileEntitySpecialRenderer {

	private int textureWidth = 64;
	private int textureHeigth = 64;
	
	private static final ResourceLocation texture = new ResourceLocation(BaseMod.modid + ":" + "textures/model/ArbolBase.png");
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			GL11.glTranslated((float)x, (float)y, (float)z);		
			
			
			Tessellator tessellator = Tessellator.instance;
			
			this.bindTexture(texture);
			
			tessellator.startDrawingQuads();
			{
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				
			}			
			tessellator.draw();
			
			
			
		GL11.glPopMatrix();
		
		
		
	}

}
