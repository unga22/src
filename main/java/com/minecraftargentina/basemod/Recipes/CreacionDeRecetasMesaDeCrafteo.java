package com.minecraftargentina.basemod.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;

import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeRecetasMesaDeCrafteo {
	public static void RecetasMesaDeCrafteo(){

		GameRegistry.addRecipe(new ItemStack(CreacionDeBloques.blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', CreacionDeItems.itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.itemTinCog, 4), new Object[]{" X ", "XFX", " X ", 'X', CreacionDeItems.itemTinIngot, 'F', Items.flint});
		GameRegistry.addRecipe(new ItemStack(Items.book), new Object[]{"XXX", "YYY", "XXX", 'X', Items.leather, 'Y', Items.paper});
		GameRegistry.addRecipe(new ItemStack(Blocks.furnace), new Object[]{"XXX", "X X", "XXX", 'X', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 2), new Object[]{"X", "X", "X", 'X', Blocks.planks});

		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.armorTopazHelm), new Object[]{"XXX", "X X", 'X', CreacionDeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.armorTopazChest), new Object[]{"X X", "XXX", "XXX", 'X', CreacionDeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.armorTopazLegs), new Object[]{"XXX", "X X", "X X", 'X', CreacionDeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.armorTopazBoots), new Object[]{"X X", "X X", 'X', CreacionDeItems.itemTopaz});

		GameRegistry.addRecipe(new ItemStack(CreacionDeBloques.blockPurpleLampOff), new Object[]{"CXC", "XEX", "CXC", 'C', Blocks.glass, 'X', Items.glowstone_dust, 'E', Items.redstone});

		GameRegistry.addShapelessRecipe(new ItemStack(CreacionDeBloques.oreCopperOre), new Object[]{CreacionDeItems.itemCopperIngot, Blocks.cobblestone});

		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(CreacionDeItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.itemIronWasher), new Object[]{"DP", 'D', CreacionDeItems.itemIronDisc, 'P', new ItemStack(CreacionDeItems.itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
		
		GameRegistry.addRecipe(new ItemStack(CreacionDeMaquinas.blockWorkSurface, 1), new Object[]{"XXX", "XXX", "XXX", 'X', CreacionDeBloques.blockMaderaRefinada});
		GameRegistry.addRecipe(new ItemStack(CreacionDeBloques.blockMaderaRefinada, 1), new Object[]{"IH", 'I', Blocks.log, 'H', new ItemStack(CreacionDeItems.itemLija, 1, OreDictionary.WILDCARD_VALUE)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(CreacionDeItems.itemLija, 1), new Object[]{CreacionDeItems.itemPolvoDeVidrio, Items.paper});
		GameRegistry.addRecipe(new ItemStack(CreacionDeItems.itemPolvoDeVidrio, 1), new Object[]{"IH", 'I', Blocks.glass, 'H', new ItemStack(CreacionDeItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
	}
}
