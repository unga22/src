package com.minecraftargentina.basemod.Semillas;

import com.minecraftargentina.basemod.DrugMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class CocaCrop extends BlockCrops{
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

    public CocaCrop(){
    	super();
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata){
    	if (metadata < 8){

    		
    		return iconArray[metadata >> 1];
    	}
    	return iconArray[8];
    }
    public Item func_149866_i(){
    	return CreacionDeSemillas.CocaSeeds;
    }
    
    public Item func_149865_P(){
    	return CreacionDeSemillas.CocaLeaf;
    }

    
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
    	this.iconArray = new IIcon[8];
    	
    	for(int i = 0; i < this.iconArray.length; i++){
    		this.iconArray[i] = iconRegister.registerIcon(DrugMod.modid + ":" + "stage" + i + "Coca");
    	}
    }
}
