package com.minecraftargentina.basemod.IngotMasher;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Items.CreaciondeItems;

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
		if (item == CreaciondeItems.itemManganeseIngot && item2 == Items.iron_ingot || item == Items.iron_ingot && item2 == CreaciondeItems.itemManganeseIngot) {
			return new ItemStack(CreaciondeItems.itemVanadiumIngot, 1);
		}
		
		//Recipe 2
		
		if (item == CreaciondeItems.itemManganeseIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == CreaciondeItems.itemManganeseIngot) {
			return new ItemStack(CreaciondeItems.itemVanadiumIngot, 2);
		}
		
		//Recipe 3
		
		if (item == CreaciondeItems.itemVanadiumIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == CreaciondeItems.itemVanadiumIngot) {
			return new ItemStack(CreaciondeItems.itemTurmalineIngot, 1);
		}
		
		
		return null;		

		
	}

}
