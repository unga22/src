package com.minecraftargentina.basemod;



import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class BioFuelRecipes {
		
	public static int obtenerBioFuel(Item item, Item item2, Item item3, int waterstatus) {		
		//Recipe 1
		if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
			return 10;
		}	
		return 0;				
	}
	public static void ConsumirAgua(Item item, Item item2, Item item3, int waterstatus){
		//Recipe 1
		if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
			TileEntityFuelMachine.waterStatus = TileEntityFuelMachine.waterStatus - 10;
		}
	}
}
