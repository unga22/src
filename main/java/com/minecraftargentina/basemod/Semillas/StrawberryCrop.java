
package com.minecraftargentina.basemod.Semillas;



import java.util.Random;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrawberryCrop extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconArray = new IIcon[4];

		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName().substring(5) + (i + 1));
		}
	}

	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7){
			if (metadata == 6) {
				metadata = 5;
			}

			return this.iconArray[metadata >> 1];
		}

		return this.iconArray[3];
	}

	public int quantityDropped (Random random) {
		return 1;
	}
	
	protected Item func_149866_i() {
		return CreacionDeSemillas.cropStrawberrySeeds;
	}

	protected Item func_149865_P() {
		return CreacionDeItems.cropStrawberry;

	}

}