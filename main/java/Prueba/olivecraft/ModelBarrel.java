package Prueba.olivecraft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelBarrel extends ModelBase {
    ModelRenderer BSide1, BSide2, LSide1, LSide2, Bottom;
    ModelRenderer Water[] = new ModelRenderer[4];
  
    public ModelBarrel() {
    	textureWidth = 128;
    	textureHeight = 32;
    	
    	BSide1 = new ModelRenderer(this, 38, 0);
    	BSide1.addBox(-8F, 0F, 6F, 16, 16, 2);
    	BSide1.setRotationPoint(0F, 8F, 0F);
    	BSide1.setTextureSize(128, 32);
    	BSide1.mirror = true;
    	setRotation(BSide1, 0F, 0F, 0F);
    	BSide2 = new ModelRenderer(this, 38, 0);
    	BSide2.addBox(-8F, 0F, -8F, 16, 16, 2);
    	BSide2.setRotationPoint(0F, 8F, 0F);
    	BSide2.setTextureSize(128, 32);
    	BSide2.mirror = true;
    	setRotation(BSide2, 0F, 0F, 0F);
    	LSide1 = new ModelRenderer(this, 12, 0);
    	LSide1.addBox(6F, 0F, -6F, 2, 16, 12);
    	LSide1.setRotationPoint(0F, 8F, 0F);
    	LSide1.setTextureSize(128, 32);
    	LSide1.mirror = true;
    	setRotation(LSide1, 0F, 0F, 0F);
    	LSide2 = new ModelRenderer(this, 12, 0);
    	LSide2.addBox(-8F, 0F, -6F, 2, 16, 12);
    	LSide2.setRotationPoint(0F, 8F, 0F);
    	LSide2.setTextureSize(128, 32);
    	LSide2.mirror = true;
    	setRotation(LSide2, 0F, 0F, 0F);
    	Bottom = new ModelRenderer(this, -12, 0);
    	Bottom.addBox(-6F, 12F, -6F, 12, 4, 12);
    	Bottom.setRotationPoint(0F, 8F, 0F);
    	Bottom.setTextureSize(128, 32);
    	Bottom.mirror = true;
    	setRotation(Bottom, 0F, 0F, 0F);
    	
        Water[0] = new ModelRenderer(this, 26, 18);
        Water[0].addBox(-6F, 4F, -6F, 12, 8, 12);
        Water[0].setRotationPoint(0F, 8F, 0F);
        Water[0].setTextureSize(128, 32);
        Water[0].mirror = true;
        setRotation(Water[0], 0F, 0F, 0F);
        Water[1] = new ModelRenderer(this, 38, 18);
        Water[1].addBox(-6F, 4F, -6F, 12, 8, 12);
        Water[1].setRotationPoint(0F, 8F, 0F);
        Water[1].setTextureSize(128, 32);
        Water[1].mirror = true;
        setRotation(Water[1], 0F, 0F, 0F);
        Water[2] = new ModelRenderer(this, 50, 18);
        Water[2].addBox(-6F, 4F, -6F, 12, 8, 12);
        Water[2].setRotationPoint(0F, 8F, 0F);
        Water[2].setTextureSize(128, 32);
        Water[2].mirror = true;
        setRotation(Water[2], 0F, 0F, 0F);
        Water[3] = new ModelRenderer(this, 62, 18);
        Water[3].addBox(-6F, 4F, -6F, 12, 8, 12);
        Water[3].setRotationPoint(0F, 8F, 0F);
        Water[3].setTextureSize(128, 32);
        Water[3].mirror = true;
        setRotation(Water[3], 0F, 0F, 0F);
    }
    
    public void renderAll(int water) {
        BSide1.render(0.0625F);
        BSide2.render(0.0625F);
        LSide1.render(0.0625F);
        LSide2.render(0.0625F);
        Bottom.render(0.0625F);
        if (water != -1)
        	Water[water].render(0.0625F);
    }
     
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }

}
