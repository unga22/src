package com.minecraftargentina.basemod;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DmCocaLeaf extends Item{
	DrugMod m = new DrugMod();


	public DmCocaLeaf(String str){
		super();
		this.setMaxStackSize(64);
		this.setCreativeTab(DrugMod.drugTab);
		this.setUnlocalizedName(str);
		this.setTextureName(m.modid + ":" + str);

	}


}