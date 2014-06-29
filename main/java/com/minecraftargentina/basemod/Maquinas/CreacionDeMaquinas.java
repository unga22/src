package com.minecraftargentina.basemod.Maquinas;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.AlabasterOven;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.FuelMachine;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.IngotMasher;
import com.minecraftargentina.basemod.Maquinas.WorckSurface.WorkSurface;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class CreacionDeMaquinas {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Block blockAlabasterOvenIdle;
	public static Block blockAlabasterOvenActive;
	public static final int guiIDAlabasterOven = 0;

	public static Block blockIngotMasherIdle;
	public static Block blockIngotMasherActive;
	public static final int guiIDIngotMasher = 1;
	
	public static Block blockFuelMachineIdle;
	public static Block blockFuelMachineActive;
	public static final int guiIDFuelMachine = 2;

	public static Block blockWorkSurface;
	public static final int guiIDWorkSurface = 3;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeMaquinas(){
		blockFuelMachineIdle = new FuelMachine(false).setBlockName("FuelMachineEmpty").setCreativeTab(BaseMod.oblivion).setHardness(3.5F);
		blockFuelMachineActive = new FuelMachine(true).setBlockName("FuelMachineFull").setCreativeTab(BaseMod.oblivion).setHardness(3.5F);
		
		blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(BaseMod.oblivion).setHardness(3.5F);
		blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F).setHardness(3.5F);

		blockIngotMasherIdle = new IngotMasher(false).setBlockName("IngotMasherIdle").setCreativeTab(BaseMod.oblivion).setHardness(3.5F);
		blockIngotMasherActive = new IngotMasher(true).setBlockName("IngotMasherActive").setHardness(3.5F);

		blockWorkSurface = new WorkSurface().setBlockName("WorkSurface");	
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistraaciondeMaquinas(){
		GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
		GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
		
		GameRegistry.registerBlock(blockFuelMachineIdle, "FuelMachineIdle");
		GameRegistry.registerBlock(blockFuelMachineActive, "FuelMachineActive");

		GameRegistry.registerBlock(blockIngotMasherIdle, "IngotMasherIdle");
		GameRegistry.registerBlock(blockIngotMasherActive, "IngotMasherActive");

		GameRegistry.registerBlock(blockWorkSurface, "WorkSurface");
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
}
