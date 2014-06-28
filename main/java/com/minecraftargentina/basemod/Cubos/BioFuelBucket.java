package com.minecraftargentina.basemod.Cubos;

import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class BioFuelBucket extends ItemBucket{

	public BioFuelBucket(Block block) {
		super(block);
		this.setCreativeTab(BaseMod.oblivion);
	}

}
