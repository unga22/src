package com.minecraftargentina.basemod;

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
		if (item == BaseMod.itemManganeseIngot && item2 == Items.iron_ingot || item == Items.iron_ingot && item2 == BaseMod.itemManganeseIngot) {
			return new ItemStack(BaseMod.itemVanadiumIngot, 1);
		}
		
		//Recipe 2
		
		if (item == BaseMod.itemManganeseIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == BaseMod.itemManganeseIngot) {
			return new ItemStack(BaseMod.itemVanadiumIngot, 2);
		}
		
		//Recipe 3
		
		if (item == BaseMod.itemVanadiumIngot && item2 == Items.gold_ingot || item == Items.gold_ingot && item2 == BaseMod.itemVanadiumIngot) {
			return new ItemStack(BaseMod.itemTurmalineIngot, 1);
		}
		
		
		return null;		

		
	}

}