package com.minecraftargentina.basemod;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fluids.Fluid;

public class Definer {
//prueba
	public static void addFluidDefinitions(){
		DrugMod m = new DrugMod();

	}

	public static void addBlockDefinitions(){
		DrugMod m = new DrugMod();

    	m.ChemicalExtractorIdle = new DmChemicalExtractor(false).setBlockName("extractorChemicalIdle").setHardness(3.5F).setCreativeTab(DrugMod.drugTab); 
		m.ChemicalExtractorActive = new DmChemicalExtractor(true).setBlockName("extractorChemicalActive").setHardness(3.5F).setLightLevel(0.9F);

	}

	public static void addItemDefinitions(){
		DrugMod m = new DrugMod();

    	

    	
	}

	public static void addPotionDefinitions(){
		DrugMod m = new DrugMod();

	}
}