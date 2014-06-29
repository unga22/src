package com.minecraftargentina.basemod.Maquinas.IngotMasher;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IngotMasherRecipes {
	
	public IngotMasherRecipes() {
		
	}
	public static ItemStack getMashingResult(Item item, Item item2) {
		return getOutput(item, item2);
		
	}
	
	public static ItemStack getOutput(Item item, Item item2) {
		
		//Recipe 1
		if (item == CreacionDeItems.itemManganeseIngot && item2 == Items.iron_ingot || item == Items.iron_ingot && item2 == CreacionDeItems.itemManganeseIngot) {
			return new ItemStack(CreacionDeItems.itemVanadiumIngot, 1);
		}
		
		//Recipe 2
		
		if (item == CreacionDeItems.itemManganeseIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == CreacionDeItems.itemManganeseIngot) {
			return new ItemStack(CreacionDeItems.itemVanadiumIngot, 2);
		}
		
		//Recipe 3
		
		if (item == CreacionDeItems.itemVanadiumIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == CreacionDeItems.itemVanadiumIngot) {
			return new ItemStack(CreacionDeItems.itemTurmalineIngot, 1);
		}
		
		
		return null;		

		
	}

}
