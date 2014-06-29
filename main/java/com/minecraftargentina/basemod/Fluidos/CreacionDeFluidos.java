package com.minecraftargentina.basemod.Fluidos;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeFluidos {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Block fluidblock;
	public static Fluid BioFuel = new Fluid("BioFuel");
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeFluidos(){
		FluidRegistry.registerFluid(BioFuel);
		fluidblock = new BioFuel(BioFuel, Material.water).setBlockName("BioFuel");
		GameRegistry.registerBlock(fluidblock, "BioFuel");
		BioFuel.setUnlocalizedName(fluidblock.getUnlocalizedName());
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
}
