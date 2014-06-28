package com.minecraftargentina.basemod.Items;


import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
 
public class ItemBlueberryFood extends ItemFood {

	public ItemBlueberryFood(int heal, float saturation, boolean wolfmeat) {
		super(heal, saturation, wolfmeat);
		
		this.setPotionEffect(8, 60, 1, 1F);
		this.setPotionEffect(10, 60, 1, 1F);
		this.setUnlocalizedName("Frutilla");
		this.setTextureName("basemod:Frutilla");
		this.setCreativeTab(BaseMod.oblivion);
	
	}




	

}