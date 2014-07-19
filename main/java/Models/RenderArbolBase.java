package Models;

import org.lwjgl.opengl.GL11;

import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import Models.ArbolBase;

public class RenderArbolBase extends TileEntitySpecialRenderer {
	
	
	private static final ResourceLocation texture = new ResourceLocation(BaseMod.modid + ":" + "textures/model/ArbolBase.png");

	
	private ArbolBase model;
	
	public RenderArbolBase() {
		
		this.model = new ArbolBase();
		
		
		
		
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
	
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float) y + 1.5F,(float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 0F);
			
			this.bindTexture(texture);
			
			
			
		GL11.glPushMatrix();
			this.model.renderModel1(0.0625F);
		GL11.glPopMatrix();
	GL11.glPopMatrix();
			
		
		
		
		
		
	}

}
