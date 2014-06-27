package com.minecraftargentina.basemod;


import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		if(fuel.getItem() == BaseMod.itemResiduos) return 800;

		return 0;
	}

}