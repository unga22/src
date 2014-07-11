package com.minecraftargentina.basemod.Fluidos;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeFluidos {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Block BiofuelBlock;
	public static Block HotWaterBlock;
	public static Fluid BioFuelFluid = new Fluid("BioFuel");
	public static Fluid HotWaterFluid = new Fluid("hotwater").setTemperature(373).setViscosity(1200);
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeFluidos(){
		//BioFuel
		FluidRegistry.registerFluid(BioFuelFluid);
		BiofuelBlock = new BioFuel(BioFuelFluid, Material.water).setBlockName("BioFuel");
		GameRegistry.registerBlock(BiofuelBlock, "BioFuel");
		BioFuelFluid.setUnlocalizedName(BiofuelBlock.getUnlocalizedName());
		//HotWater
		FluidRegistry.registerFluid(HotWaterFluid);
		HotWaterBlock = new HotWater(HotWaterFluid, Material.water).setBlockName("HotWater");
		GameRegistry.registerBlock(HotWaterBlock, "HotWater");
		HotWaterFluid.setUnlocalizedName(HotWaterBlock.getUnlocalizedName());
		
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
}
