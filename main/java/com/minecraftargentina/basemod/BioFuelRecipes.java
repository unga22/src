package com.minecraftargentina.basemod;



import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class BioFuelRecipes {
		
	//CAMBIAR!
		
		public BioFuelRecipes() {
			
		}
		public static int getMashingResult(Item item, Item item2, Item item3, int waterstatus) {
			return getOutput(item, item2, item3, waterstatus);
			
		}
		
		public static int getOutput(Item item, Item item2, Item item3, int waterstatus) {
			
			//Recipe 1
			if (item == Items.melon  && item2 == Items.melon  && item3 == Items.melon  && waterstatus >= 10) {
				TileEntityFuelMachine.waterStatus =- 10;
				return 10;
			}
			
			
			
			return 0;		
			

		}

	}
