package com.minecraftargentina.basemod.Items;




import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
 
public class ItemHojasDelRecuerdo extends ItemFood {


	public ItemHojasDelRecuerdo(int heal, float saturation, boolean wolfmeat) {
		super(heal, saturation, wolfmeat);		
		
		this.setPotionEffect(Potion.confusion.id, 5, 0, 0.9f);
		

	}
	

}