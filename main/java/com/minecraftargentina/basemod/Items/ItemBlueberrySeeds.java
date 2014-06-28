package com.minecraftargentina.basemod.Items;

import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
 
public class ItemBlueberrySeeds extends ItemSeeds {
 
	// Constructors
	public ItemBlueberrySeeds() {
		
		super(BaseMod.blockBlueberry, Blocks.farmland);
		this.setUnlocalizedName("blueberry");
		this.setTextureName("basemod:blueberryseeds");
		this.setCreativeTab(BaseMod.oblivion);
		
 
	}
 
}