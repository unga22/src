package com.minecraftargentina.basemod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class BioFuelBucket extends ItemBucket{

	public BioFuelBucket(Block block) {
		super(block);
		this.setCreativeTab(BaseMod.oblivion);
	}

}
