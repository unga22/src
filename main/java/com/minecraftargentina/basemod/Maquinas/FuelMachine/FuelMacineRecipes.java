package com.minecraftargentina.basemod.Maquinas.FuelMachine;



import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FuelMacineRecipes {
	
	public static int obtenerBioFuel(Item item, Item item2, Item item3, int waterstatus) {		
		//Recipe 1
		if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
			return 10;
		}	
		return 0;				
	}
	public static int ConsumirAgua(Item item, Item item2, Item item3, int waterstatus){
		//Recipe 1
		if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
			return 10;
		}
		return 0;
	}
}
