package com.minecraftargentina.basemod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlockWithMetadata {
	
	public static final String[] logs = new String[] {"Olvido", "Recuerdo"};

	public ItemLogBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
		
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= logs.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + logs[i];
	}
	
	@Override
	public int getMetadata (int meta) {
		return meta;
	}
	

}
