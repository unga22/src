package com.minecraftargentina.basemod.Recipes;

import net.minecraft.item.ItemStack;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeRecetasDelHorno {
	public static void RecetasDelHorno(){
		GameRegistry.addSmelting(CreacionDeBloques.oreCopperOre, new ItemStack(CreacionDeItems.itemCopperIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreTinOre, new ItemStack(CreacionDeItems.itemTinIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreZincOre, new ItemStack(CreacionDeItems.itemZincIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreNickelOre, new ItemStack(CreacionDeItems.itemNickelIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreManganeseOre, new ItemStack(CreacionDeItems.itemManganeseIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreVanadiumOre, new ItemStack(CreacionDeItems.itemVanadiumIngot), 0);

		GameRegistry.addSmelting(CreacionDeBloques.oreNetherCopperOre, new ItemStack(CreacionDeBloques.oreCopperOre, 2), 0);
	}
}
