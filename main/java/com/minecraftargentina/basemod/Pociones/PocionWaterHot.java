package com.minecraftargentina.basemod.Pociones;

import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class PocionWaterHot extends Potion{
	
    public PocionWaterHot(int par1, boolean par2, int par3) {
    	super(par1, par2, par3);
    }

    public Potion setIconIndex(int par1, int par2) {	
		//(3,2) is where I drew my texture in the "2D array" of textures in the inventory.png
		super.setIconIndex(par1, par2);
		return this;	
	}
	
    @Override
    public int getStatusIconIndex(){
    	ResourceLocation r = new ResourceLocation(BaseMod.modid + ":" + "textures/effects/waterHot.png");
    	ITextureObject texture = Minecraft.getMinecraft().renderEngine.getTexture(r);
    	Minecraft.getMinecraft().renderEngine.bindTexture(r);
    	return super.getStatusIconIndex();
	}
}
