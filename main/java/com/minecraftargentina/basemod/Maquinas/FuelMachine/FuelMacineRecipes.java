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
	public static int obtenerBioFuelDeItems(Item item1, Item item2, Item item3, Block block1, Block block2, Block block3) {		
		int cantidadbiofuel = 0;
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (item1 == Items.apple){
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else if(item1 == Items.bone){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block1 == Blocks.red_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block1 == Blocks.yellow_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block1 == Blocks.grass){ 
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block1 == Blocks.brown_mushroom){
			    	cantidadbiofuel = cantidadbiofuel +5;
			    	slot++;
			    }else if(block1 == Blocks.leaves){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block1 == Blocks.leaves2){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block1 == Blocks.cactus){
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
			    }else if(item2 == Items.bone){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block2 == Blocks.red_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block2 == Blocks.yellow_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block2 == Blocks.grass){ 
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block2 == Blocks.brown_mushroom){
			    	cantidadbiofuel = cantidadbiofuel +5;
			    	slot++;
			    }else if(block2 == Blocks.leaves){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block2 == Blocks.leaves2){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block2 == Blocks.cactus){
			    	cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
			}
			if (slot == 3) {
				if (item1 == Items.apple){
				    cantidadbiofuel = cantidadbiofuel + 5;
				    slot++;
			    }else if(item3 == Items.bone){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block3 == Blocks.red_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block3 == Blocks.yellow_flower){
			    	cantidadbiofuel = cantidadbiofuel + 1;
			    	slot++;
			    }else if(block3 == Blocks.grass){ 
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block3 == Blocks.brown_mushroom){
			    	cantidadbiofuel = cantidadbiofuel +5;
			    	slot++;
			    }else if(block3 == Blocks.leaves){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block3 == Blocks.leaves2){
			    	cantidadbiofuel = cantidadbiofuel +1;
			    	slot++;
			    }else if(block3 == Blocks.cactus){
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
	//Cantidad de Agua que Consumen ----------------------------------------------------------------------------------------
	public static int ConsumirAgua(Item item1, Item item2, Item item3, Block block1, Block block2, Block block3){
		int AguaQueConsumir = 0;
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (item1 == Items.apple){
					AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else if(item1 == Items.bone){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block1 == Blocks.red_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block1 == Blocks.yellow_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block1 == Blocks.grass){ 
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block1 == Blocks.brown_mushroom){
			    	AguaQueConsumir = AguaQueConsumir +5;
			    	slot++;
			    }else if(block1 == Blocks.leaves){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block1 == Blocks.leaves2){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block1 == Blocks.cactus){
			    	AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
			}
			if (slot == 2) {
				if (item2 == Items.apple){
					AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else if(item2 == Items.bone){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block2 == Blocks.red_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block2 == Blocks.yellow_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block2 == Blocks.grass){ 
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block2 == Blocks.brown_mushroom){
			    	AguaQueConsumir = AguaQueConsumir +5;
			    	slot++;
			    }else if(block2 == Blocks.leaves){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block2 == Blocks.leaves2){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block2 == Blocks.cactus){
			    	AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
			}
			if (slot == 3) {
				if (item1 == Items.apple){
					AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else if(item3 == Items.bone){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block3 == Blocks.red_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block3 == Blocks.yellow_flower){
			    	AguaQueConsumir = AguaQueConsumir + 1;
			    	slot++;
			    }else if(block3 == Blocks.grass){ 
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block3 == Blocks.brown_mushroom){
			    	AguaQueConsumir = AguaQueConsumir +5;
			    	slot++;
			    }else if(block3 == Blocks.leaves){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block3 == Blocks.leaves2){
			    	AguaQueConsumir = AguaQueConsumir +1;
			    	slot++;
			    }else if(block3 == Blocks.cactus){
			    	AguaQueConsumir = AguaQueConsumir + 5;
				    slot++;
			    }else{
			    	slot++;
			    	return 0;
			    }
				return AguaQueConsumir;	
			}						
		}
		return 0;
	}
	//Tiempo que quita cada item/bloque al tiempo de transformacion ----------------------------------------------------------------------------------------
	public static int TiempoDeTransformacion(Item item1, Item item2, Item item3, Block block1, Block block2, Block block3){
		int TiempoDeTransformacion = 1000;//Tiempo base y despues depende de los items va restando si quieres puedes cambiar el tiempo base y el tiempo que quita cada item
		for (int slot = 1; slot <= 3;){
			if (slot == 1) {
				if (item1 == Items.apple){
					TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else if(item1 == Items.bone){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 150;
			    	slot++;
			    }else if(block1 == Blocks.red_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block1 == Blocks.yellow_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block1 == Blocks.grass){ 
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block1 == Blocks.brown_mushroom){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 250;
			    	slot++;
			    }else if(block1 == Blocks.leaves){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block1 == Blocks.leaves2){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block1 == Blocks.cactus){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else{
			    	slot++;
			    }
			}
			if (slot == 2) {
				if (item2 == Items.apple){
					TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else if(item2 == Items.bone){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 150;
			    	slot++;
			    }else if(block2 == Blocks.red_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block2 == Blocks.yellow_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block2 == Blocks.grass){ 
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block2 == Blocks.brown_mushroom){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 250;
			    	slot++;
			    }else if(block2 == Blocks.leaves){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block2 == Blocks.leaves2){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block2 == Blocks.cactus){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else{
			    	slot++;
			    }
			}
			if (slot == 3) {
				if (item1 == Items.apple){
					TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else if(item3 == Items.bone){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 150;
			    	slot++;
			    }else if(block3 == Blocks.red_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block3 == Blocks.yellow_flower){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block3 == Blocks.grass){ 
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block3 == Blocks.brown_mushroom){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 250;
			    	slot++;
			    }else if(block3 == Blocks.leaves){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block3 == Blocks.leaves2){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 50;
			    	slot++;
			    }else if(block3 == Blocks.cactus){
			    	TiempoDeTransformacion = TiempoDeTransformacion - 100;
				    slot++;
			    }else{
			    	slot++;
			    }
				return TiempoDeTransformacion;	
			}						
		}
		return TiempoDeTransformacion;
	}
}



