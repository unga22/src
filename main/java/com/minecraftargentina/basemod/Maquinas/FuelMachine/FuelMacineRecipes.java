package com.minecraftargentina.basemod.Maquinas.FuelMachine;



import com.sun.scenario.effect.Crop;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.EnumPlantType;

public class FuelMacineRecipes {
	//Cantidad de BioFuel Obtenida ----------------------------------------------------------------------------------------
	public static int obtenerBioFuelDeItems(Item item, Item item2, Item item3, Block block, Block block2, Block block3, int waterstatus) {		
		int cantidadbiofuel = 0;
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (item == Items.apple){
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else if(item == Item.getItemById(37)){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(item == Item.getItemById(38)){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block == Blocks.brown_mushroom){
			    	cantidadbiofuel = cantidadbiofuel +5;
			    	slot++;
			    }else if(block == Blocks.cactus){
			    	cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
			}
			if (slot == 2) {
				if (item2 == Items.apple){
					cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else if (block2 == Blocks.cactus){
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
			}
			if (slot == 3) {
				if (item3 == Items.apple){
					cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    } else if (block3 == Blocks.cactus){
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else{
				    slot++;
				    return 0;
			    }
				return cantidadbiofuel;	
			}						
		}

		return 0;				
	}
	//Items Cantidad de Agua que Consumen ----------------------------------------------------------------------------------------
	public static int ConsumirAguaDeItems(Item item, Item item2, Item item3, int waterstatus){
		return 0;
	}
}



