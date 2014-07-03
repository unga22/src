package com.minecraftargentina.basemod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlockWithMetadata{
	
	public static final String[] leaves = new String[] {"Olvido", "Recuerdo"};

	public ItemLeafBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
		
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= leaves.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + leaves[i];
	}
	
	@Override
	public int getMetadata (int meta) {
		return meta;
	}

}
