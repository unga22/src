package Models;

import org.lwjgl.opengl.GL11;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon3;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import Models.ArbolBaseModel;


//Renderizado 3D importando ".obj" from Blender. 
	
	public class RenderToconBlock6 extends TileEntitySpecialRenderer{
		
	    private IModelCustom ArbolPlataformModel;  //El model
	    private ResourceLocation ArbolPlataformTexture; //La textura
	    private ResourceLocation ArbolPlataform;  //Nombre

	    
	    public RenderToconBlock6(){
	    	
	    	//Resource by Name
	    	ArbolPlataform = new ResourceLocation(BaseMod.modid + ":" + "textures/model/Rama2.obj");
	    	
	    	//Model From Name
	    	ArbolPlataformModel = AdvancedModelLoader.loadModel(ArbolPlataform);
	    	
	    	//Texture Resource
	    	ArbolPlataformTexture = new ResourceLocation(BaseMod.modid + ":" + "textures/model/ent.png");

	    }

	    public void renderModelAt(TileEntity tileEntity, double x, double y, double z, float f){
	        GL11.glPushMatrix();
	        	GL11.glTranslatef((float)x + 0.5F,(float) y + 1.5F,(float) z + 0.5F);
	        	
	        	bindTexture(ArbolPlataformTexture);  	
	        	
	        	GL11.glRotatef(0, 0.0F, 0.0F, 1F);
	        
	        	GL11.glPushMatrix();
	        		ArbolPlataformModel.renderAll();
	        	GL11.glPopMatrix();
	        
	        GL11.glPopMatrix();
	    }
	    
		@Override
		public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		

			renderModelAt((TileEntityArbolTocon6)tileentity, x, y, z, f);
			
			
			
			
		}
	}