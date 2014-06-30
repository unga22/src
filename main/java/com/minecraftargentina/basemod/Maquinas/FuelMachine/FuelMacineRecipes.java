package com.minecraftargentina.basemod.Maquinas.FuelMachine;



import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FuelMacineRecipes {
	
	public static int obtenerBioFuel(Item item, Item item2, Item item3, int waterstatus) {		
		
		int cantidadbiofuel = 0;
		
	
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (item == Items.apple){
				
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
			    }else{
			    	slot++;
				    return 0;
			    }
			}
			if (slot == 3) {
				if (item3 == Items.apple){
					
					cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else{
				    slot++;
				    return 0;
			    }				
			}						
			return cantidadbiofuel;	
		}

		return 0;				
	}
	
	
	//BLOCK RECIPES ----------------------------------------------------------------------------------------
	
	public static int obtenerBioFuel2(Block block, Block block2, Block block3, int waterstatus) {
		
		
		int cantidadbiofuel = 0;
		
	
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (block == Blocks.cactus){
				
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }
				slot++;

			}
			if (slot == 2) {
				if (block2 == Blocks.cactus){
					
					cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
				}		
				slot++;
			}
			if (slot == 3) {
				if (block3 == Blocks.cactus){
					
					cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
				}	
				slot++;
				
						
			}						
			return cantidadbiofuel;	
		}

		return 0;				
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	public static int ConsumirAgua(Item item, Item item2, Item item3, int waterstatus){
		//Recipe 1
		if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
			return 10;
		}
		return 0;
	}
}



